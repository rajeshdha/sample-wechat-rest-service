package wechat.service;

import java.security.MessageDigest;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.security.NoSuchAlgorithmException;

public class AuthService {
/* This is C1 Checkin */
/* This is C11 checkin */
	public boolean validateAuth(String signature, String timestamp, String nonce, String echostr, String token) {

		String createdSignature = hash(getStringToHash(timestamp, nonce, token));

		if (signature == null || !signature.equals(createdSignature)) {
			System.out.println("Authentication failed! Accepted echostr ->" + createdSignature);
			System.out.println("                                 actual ->" + signature);
			return false;
		}

		return true;
	}
/*This is C3 checkin*/

	protected static String getStringToHash(String timestamp, String nonce,
			String token) {
		List<String> list = new ArrayList<String>();
		list.add(timestamp);
		list.add(nonce);
		list.add(token);

		String result = "";
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			result += list.get(i);
		}
		return result;
	}

	protected static String hash(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] b = md.digest(str.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < b.length; i++) {
				sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// never happens
		}
		return null;
	}
}

