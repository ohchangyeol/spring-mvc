package json.test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONEncodingTestApp {
	// main Method
	public static void main(String[] args) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name","홍길동");
		jsonObj.put("age",new Integer(100));
		jsonObj.put("address","서울");
		
		System.out.println("json object 확인 ==> "+ jsonObj);
		
		System.out.println("==> json object data 추출");
		System.out.println(jsonObj.get("address"));
		System.out.println("\n\n");
		
		/////////////////////////////////////////////////////////////
		JSONObject innerJsonObj = new JSONObject();
		innerJsonObj.put("name","inner홍길동");
		innerJsonObj.put("age",new Integer(100));
		innerJsonObj.put("address","inner서울");
		jsonObj.put("innerJson", innerJsonObj);
		
		System.out.println("json object 확인 ==> "+ jsonObj);
		
		System.out.println("==> json object data 추출");
		System.out.println(jsonObj.get("address"));
		JSONObject returnJsonObj = (JSONObject)jsonObj.get("innerJson");
		System.out.println(returnJsonObj.get("address"));
		System.out.println("\n\n");
		/////////////////////////////////////////////////////////////
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("직급1", "사원");
		map.put("직급2", "대리");
		map.put("직급3", "과장");
		jsonObj.put("career", map);
		
		System.out.println("json object 확인 ==> "+ jsonObj);
		
		System.out.println("==> json object data 추출");
		System.out.println(jsonObj.get("career"));
		Map<String, String> returnMap = (Map)jsonObj.get("career");
		System.out.println(returnMap.get("직급1"));
		System.out.println("\n\n");
		///////////////////////////////////////////////////////////////
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(new Integer(1));
		jsonArray.add("2");
		jsonArray.add("3");
		jsonObj.put("number",jsonArray);
		
		System.out.println("json object 확인 ==> "+ jsonObj);
		
		System.out.println("==> json object data 추출");
		System.out.println(jsonObj.get("number"));
		JSONArray returnJsonArray = (JSONArray)jsonObj.get("number");
		System.out.println(returnJsonArray.get(0));
		
		
	}
	

}
