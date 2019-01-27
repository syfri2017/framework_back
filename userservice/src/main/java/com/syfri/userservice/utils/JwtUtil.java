package com.syfri.userservice.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.codec.digest.DigestUtils;

public class JwtUtil {

	private final static String SECRET= "SYXF";
	private final static String MD5_KEY= "SYXF";

	public  static  String encode(String issuer ){
		Algorithm algorithm = Algorithm.HMAC256(SECRET);
		return  JWT.create()
				.withIssuer(issuer)
				.sign(algorithm);
	}

	public static String md5(String text)  {
		//加密后的字符串
		String encodeStr= DigestUtils.md5Hex(text + MD5_KEY);
		System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
		return encodeStr;
	}

}
