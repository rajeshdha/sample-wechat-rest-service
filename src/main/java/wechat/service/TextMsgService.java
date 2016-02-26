package wechat.service;

public class TextMsgService {

/*text message 1*/
	String xmlMessage;
	
	/*text message 2*/
	public TextMsgService(String requestBody) {
	
		xmlMessage = requestBody;
	}

	/*text message 3*/

	public String getXmlMessage() {
		return xmlMessage;
	}


	/*text message 4*/
	public void setXmlMessage(String xmlMessage) {
		this.xmlMessage = xmlMessage;
	}
	
	

}
