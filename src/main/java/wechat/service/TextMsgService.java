package wechat.service;

public class TextMsgService {

/*text message 1*/
	String xmlMessage;
	
	/*text message 2*/

	String xmlMessage;
	/*This is c2 checkin in testbranch*/
	
	public TextMsgService(String requestBody) {
	
		xmlMessage = requestBody;
	}
/*This is C4 checkin in test branch*/

	/*text message 3*/

	public String getXmlMessage() {
		return xmlMessage;
	}

/*This is C5 checkin in testbranch*/
	/*text message 4*/
	public void setXmlMessage(String xmlMessage) {
		this.xmlMessage = xmlMessage;
	}
	
	

}
