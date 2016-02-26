package wechat.controller;

import wechat.model.Greeting;
import wechat.service.AuthService;
import wechat.service.TextMsgService;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/wechat")
public class WeChatAppController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    private final String token = "MyToken"; 


    @RequestMapping(method = {RequestMethod.GET,})
    public @ResponseBody
	String authGet(@RequestParam("signature") String signature,
			@RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce,
			@RequestParam("echostr") String echostr) {
    	System.out.println("Received authentication message from WeChat Server.");
    	
    	AuthService authService = new AuthService();
		if (authService.validateAuth(signature, timestamp, nonce, echostr, token)) {
			System.out.println("Successfully authenticated WeChat Server.");
			return echostr;
		}
		System.out.println("Authentication with WeChat Server Failed !!!.");
		return null;
	}

    /*This method accepts wechat message and puts it on console*/
    @RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	String post(@RequestBody String requestBody){
    	
    	TextMsgService messageService = new TextMsgService(requestBody);
		
    	System.out.println("received " + messageService.getXmlMessage() + " message.");
		//Sending response as it is right now...
		return messageService.getXmlMessage();
	}
    
}
