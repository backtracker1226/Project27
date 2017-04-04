package org.zerock.listen;

public class RequestUtil {
	
	// 문자열을 int형으로 변환하여 리턴 시켜주는 메소드
	public int getInt(String value, int defaultValue){
		
		try{
			return Integer.parseInt(value);
		}catch(Exception e){
			return defaultValue;
		}
	}
}
