package more.controller;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DAA {

	private static final String DATA = "com.base64.demo";

	public static void main(String[] args) {
		try {
			// BASE64加密
			BASE64Encoder encoder = new BASE64Encoder();
			String data = encoder.encode(DATA.getBytes());
			System.out.println("BASE64加密：" + data);

			// BASE64解密
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes = decoder.decodeBuffer(data);
			System.out.println("BASE64解密：" + new String(bytes));

			// 结果
			// BASE64加密：Y29tLmJhc2U2NC5kZW1v
			// BASE64解密：com.base64.demo
		} catch (Exception e) {
			System.out.println("BASE64加解密异常");
			e.printStackTrace();
		}
	}

}
