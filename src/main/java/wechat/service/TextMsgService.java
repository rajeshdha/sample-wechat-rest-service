package wechat.service;

public class TextMsgService {


	String xmlMessage;
	
	
	public TextMsgService(String requestBody) {
	
		xmlMessage = requestBody;
	}


	public String getXmlMessage() {
		return xmlMessage;
	}


	public void setXmlMessage(String xmlMessage) {
		this.xmlMessage = xmlMessage;
	}
	
	

}
