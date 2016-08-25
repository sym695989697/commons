package com.sinoiov.yyzc.commons.kafka;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinoiov.yyzc.commons.kafka.util.EnvironmentUtil;
import com.sinoiov.yyzc.commons.kafka.util.JSONUtil;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.Message;
import kafka.message.MessageAndMetadata;

public class YyzcKafkaBasicConsumer {
	
	private final static Logger logger = LoggerFactory.getLogger(YyzcKafkaBasicConsumer.class);
	
	protected ConsumerConnector consumer;
	
	private static String default_path = "/opt/web_app/config/";
	
	private String location = "kafka-consumer.properties";// 配置文件位置
	
	private ExecutorService threadPool;
	
	private Charset charset = Charset.forName("utf8");
	
	public void init() throws Exception {
		File file = new File(default_path + location);
		location = file.isFile()?default_path + location : location;
		Properties properties = new EnvironmentUtil(location).getProperties();
		if (executor == null) {
			throw new RuntimeException("KafkaConsumer, exectuor cant be null!");
		}
		if (topic == null) {
			throw new RuntimeException("KafkaConsumer, topic cant be null!");
		}
		if(!StringUtils.isBlank(type) && type.equals("SUB")){//订阅模式，groupid为空，默认使用进程号+机器名，不为空，则使用之。
			String localGroupId = ManagementFactory.getRuntimeMXBean().getName().split("@")[1] + "_"
						+ YyzcKafkaBasicConsumer.class.getClassLoader().getResource("").getPath().replaceAll("/", "_");
			properties.put("group.id", StringUtils.isBlank(groupid) ? localGroupId : groupid);
		}
		
		logger.info("Starting initializate Kafka Consumer with topic [{}] and groupId [{}]......", topic, properties.getProperty("group.id"));
		
		ConsumerConfig config = new ConsumerConfig(properties);
		consumer = Consumer.createJavaConsumerConnector(config);
		
		Map<String, Integer> topics = new HashMap<String, Integer>();
		topics.put(topic, partitionsNum);
		Map<String, List<KafkaStream<byte[], byte[]>>> streams = consumer.createMessageStreams(topics);
		List<KafkaStream<byte[], byte[]>> partitions = streams.get(topic);
		threadPool = Executors.newFixedThreadPool(partitionsNum);

		// start
		int threadNum = 0;
		for (KafkaStream<byte[], byte[]> partition : partitions) {
			threadPool.execute(new MessageRunner(partition, threadNum++));
		}
	}

	public void close() {
		try {
			threadPool.shutdownNow();
		} catch (Exception e) {
			//
		} finally {
			consumer.shutdown();
		}

	}
	
	//inner class or interface
	class MessageRunner implements Runnable {
		private KafkaStream<byte[], byte[]> partition;
		private int threadNum;

		MessageRunner(KafkaStream<byte[], byte[]> partition, int threadNum) {
			this.partition = partition;
			this.threadNum = threadNum;
		}

		public void run() {
			ConsumerIterator<byte[], byte[]> it = partition.iterator();
			while (it.hasNext()) {
				// connector.commitOffsets();手动提交offset,当autocommit.enable=false时使用
				MessageAndMetadata<byte[], byte[]> item = it.next();
				final String json = new String(item.message(), charset);
				long time1 = System.currentTimeMillis();
				logger.info("Thread:[{}], receive：[{}], 处理业务开始【{}】.", this.threadNum, new String(json), time1);
				try {
					executor.execute(JSONUtil.json2Object(json, executor.transferToObjectClass()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error("ERROR", e);
					if(producer_client == null) {
						producer_client = new YyzcKafkaBasicProducer();
					}
					try {
						producer_client.send(topic + "_ERROR", json);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						logger.error("ERROR", e1);
					}
				}
				long time2 = System.currentTimeMillis();
				logger.info("Thread:[{}], receive：[{}], 处理业务结束【{}】，耗时【{}】.", this.threadNum, new String(json), time2, (time2 - time1));
			}
		}

		public String getContent(Message message) {
			ByteBuffer buffer = message.payload();
			if (buffer.remaining() == 0) {
				return null;
			}
			CharBuffer charBuffer = charset.decode(buffer);
			return charBuffer.toString();
		}
	}
	
	private YyzcKafkaBasicProducer producer_client = null;
	
	//spring 注入
	protected String topic;
	
	private String type;

	protected String groupid;

	private int partitionsNum = 1;

	private YyzcKafkaMessageExecutor<?> executor; // message listener
	
	public void setExecutor(YyzcKafkaMessageExecutor<?> executor) {
		this.executor = executor;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public void setPartitionsNum(int partitionsNum) {
		this.partitionsNum = partitionsNum;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static void main(String[] args) {
		Properties props = new Properties();
	    props.put("zookeeper.connect", "192.168.110.99:2181,192.168.110.171:2181,192.168.110.101:2181");
	    props.put("group.id", "huanghongwang");
	    props.put("zookeeper.session.timeout.ms", "60000");
	    props.put("zookeeper.sync.time.ms", "200");
	    props.put("auto.commit.interval.ms", "1000");
		ConsumerConfig config = new ConsumerConfig(props);
		ConsumerConnector consumer = Consumer.createJavaConsumerConnector(config);
		
		Map<String, Integer> topics = new HashMap<String, Integer>();
		topics.put("CRM-SERVICE-PERSONAUTH-EXAMINE", 12);
		Map<String, List<KafkaStream<byte[], byte[]>>> streams = consumer.createMessageStreams(topics);
		List<KafkaStream<byte[], byte[]>> partitions = streams.get("CRM-SERVICE-PERSONAUTH-EXAMINE");
		ExecutorService threadPool = Executors.newFixedThreadPool(12);

		// start
		for (final KafkaStream<byte[], byte[]> partition : partitions) {
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					ConsumerIterator<byte[], byte[]> it = partition.iterator();
					while (it.hasNext()) {
						// connector.commitOffsets();手动提交offset,当autocommit.enable=false时使用
						MessageAndMetadata<byte[], byte[]> item = it.next();
						String json = new String(item.message(), Charset.forName("utf8"));
						System.out.println("receive：" + new String(json));
					}
				}
			});
		}
	}
}
