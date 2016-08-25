package com.sinoiov.yyzc.commons.config.producer;

import com.sinoiov.yyzc.commons.config.ConfigHelper;
import com.sinoiov.yyzc.commons.config.entity.Parameter;
import com.sinoiov.yyzc.commons.kafka.YyzcKafkaBasicProducer;

public class MessageSendService {

	public static void sendToKafka(Parameter param) {
		YyzcKafkaBasicProducer client = new YyzcKafkaBasicProducer();
		try {
			
			//client.send(param.getSystem(), param);
			String topic = ConfigHelper.get("YYZC_CONFIG_TOPIC");
			client.send(topic, param);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
