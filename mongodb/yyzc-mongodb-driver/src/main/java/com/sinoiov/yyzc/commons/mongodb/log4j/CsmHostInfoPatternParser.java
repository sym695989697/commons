package com.sinoiov.yyzc.commons.mongodb.log4j;

import java.lang.management.ManagementFactory;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Layout;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.helpers.Transform;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.RendererSupport;

import com.sinoiov.yyzc.commons.mongodb.util.JsonUtil;
/**
 *  log4j init parser class
 * @author malongqing
 * @version 1.0
 */
public class CsmHostInfoPatternParser extends PatternParser {

	static final char HOST_NAME = 'H';
	static final char VM_NAME = 'V';
	static final char IP_ADDRESS = 'I';
	static final char STACK_TRACE = 'T';
	static final char MY_MESSAGE = 'm';
	static final Map<String, PatternConverter> converters;

	public CsmHostInfoPatternParser(String pattern) {
		super(pattern);
	}


	@Override
	public void finalizeConverter(char formatChar){
		PatternConverter pc = null;
		switch (formatChar) {
		case 'H':
			pc = (PatternConverter)converters.get(String.valueOf('H'));
			this.currentLiteral.setLength(0);
			addConverter(pc);
			break;
		case 'V':
			pc = (PatternConverter)converters.get(String.valueOf('V'));
			this.currentLiteral.setLength(0);
			addConverter(pc);
			break;
		case 'I':
			pc = (PatternConverter)converters.get(String.valueOf('I'));
			this.currentLiteral.setLength(0);
			addConverter(pc);
			break;
		case 'T':
			pc = (PatternConverter)converters.get(String.valueOf('T'));
			this.currentLiteral.setLength(0);
			addConverter(pc);
			break;
		case 'm':
			pc = (PatternConverter)converters.get(String.valueOf('m'));
			this.currentLiteral.setLength(0);
			addConverter(pc);
			break;
		default:
			super.finalizeConverter(formatChar);
		}
	}

	static{
		Map<String, PatternConverter> tmp = new HashMap<String, PatternConverter>();
		tmp.put(String.valueOf('H'), new HostPatternConverter());
		tmp.put(String.valueOf('V'), new VMNamePatternConverter());
		tmp.put(String.valueOf('I'), new IPAddressPatternConverter());
		tmp.put(String.valueOf('T'), new StackTracePatternConverter());
		tmp.put(String.valueOf('m'), new MyMessage());

		converters = Collections.unmodifiableMap(tmp);
	}

	private static class MyMessage extends PatternConverter{
		private String message = " ";

		public String convert(LoggingEvent event) {
			this.message = this.getMessage(event);
			return this.message ;
		}

		private String getMessage(LoggingEvent event){
			StringBuilder sb = new StringBuilder();
			Object obj = event.getMessage();
			if(obj instanceof String){
				sb.append((String)obj);
			}else {
				LoggerRepository repository = event.getLogger()==null?null:event.getLogger().getLoggerRepository();
				if(repository instanceof RendererSupport) {
					RendererSupport rs = (RendererSupport) repository;
					sb.append(rs.getRendererMap().findAndRender(message));
				} else {
					sb.append(message.toString());
				}
			}
			
			return sb.toString().trim().length()>0? JsonUtil.jsonCharFormat(sb.toString().trim()):" ";
		}
	}

	private static class StackTracePatternConverter extends PatternConverter{
		private String stackTrace = "";

		StackTracePatternConverter(){
			String[] s = {" "};
			this.stackTrace = this.getThrowableAsString(s);     
		}

		public String convert(LoggingEvent event) {	 
			this.stackTrace = this.getThrowableAsString(event.getThrowableStrRep());
			return this.stackTrace;
		}
		// stack trace to string
		private String getThrowableAsString(String[] s) {   
			StringBuilder sb = new StringBuilder();			
			if (s != null) {     
				int len = s.length;     
				if (len == 0)     
					return" ";     
				sb.append(Transform.escapeTags(s[0]));     
				sb.append(Layout.LINE_SEP);     
				for (int i = 1; i < len; i++) {     
					sb.append(Transform.escapeTags(s[i]));     
					sb.append(Layout.LINE_SEP);     
				}     
			}
			return sb.toString().trim().length()>0? JsonUtil.jsonCharFormat(sb.toString().trim()):" ";
		}     

	}

	private static class IPAddressPatternConverter extends PatternConverter{
		private String ipaddress = "";

		IPAddressPatternConverter(){
			try{
				//this.ipaddress = InetAddress.getLocalHost().getHostAddress();
				this.ipaddress = getIP_Inet4Address();
			} catch (Exception e) {
				LogLog.warn(e.getMessage());
			}
		}

		public String convert(LoggingEvent event) {
			return this.ipaddress;
		}

		private static String getIP_Inet4Address(){
			String ip = "127.0.0.1";
			try {
				Enumeration<?> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
				InetAddress inetAddress = null;
				while (allNetInterfaces.hasMoreElements()){
					NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
					Enumeration<?> addresses = netInterface.getInetAddresses();
					while (addresses.hasMoreElements()){
						inetAddress = (InetAddress) addresses.nextElement();
						if (inetAddress != null && inetAddress instanceof Inet4Address && !inetAddress.getHostAddress().equals("127.0.0.1")){
							ip = inetAddress.getHostAddress();
						} 
					}
				}
			} catch (Exception e) {
				LogLog.warn(e.getMessage());
			}
			return ip;
		}

	}

	private static class VMNamePatternConverter extends PatternConverter{
		private String process = "";

		VMNamePatternConverter(){
			try{
					this.process = InetAddress.getLocalHost().getHostName()+"@"+ManagementFactory.getRuntimeMXBean().getName();
			} catch (Exception e) {
				LogLog.warn(e.getMessage());
			}
		}

		public String convert(LoggingEvent event) {
			return this.process;
		}
	}

	private static class HostPatternConverter extends PatternConverter{
		private String hostname = "";

		HostPatternConverter(){
			try{
				this.hostname = InetAddress.getLocalHost().getHostName();
			} catch (UnknownHostException e) {
				LogLog.warn(e.getMessage());
			}
		}

		public String convert(LoggingEvent event) {
			return this.hostname;
		}
	}

}
