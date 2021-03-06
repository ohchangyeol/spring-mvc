package json.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import spring.domain.User;

public class JSONObjectMapperTestApp {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		User user= new User("user01","홍길동","1111",null,10);
		
		ObjectMapper om= new ObjectMapper();
		
		System.out.println("\n\n///////////////////////////////////////////////");
		System.out.println("1.domain Object => JSON Value(String)로 변환");
		String jsonOneValue = om.writeValueAsString(user);
		System.out.println(jsonOneValue);
		
		System.out.println();
		
		System.out.println("1.JSON Value(String) => domain Object로 변환 및 값 추출");
		User returnUser = om.readValue(jsonOneValue,User.class);
		System.out.println(returnUser);
		System.out.println("userId = "+ returnUser.getUserId());
		
		System.out.println();
		
		System.out.println("1.JSON Value(String) => JSON Object사용 및 값 추출");
		JSONObject jsonObj = (JSONObject)JSONValue.parse(jsonOneValue);
		System.out.println(jsonObj);
		System.out.println("userId = "+ jsonObj.get("userId"));
		
		System.out.println("\n\n///////////////////////////////////////////////");
		List<User> list = new ArrayList<User>(10);
		list.add(user);
		list.add(new User("user02","홍길동","2222",null,20));
		
		System.out.println("2.List<User> => JSON Value(String) 로 변환");
		String jsonManyValue = om.writeValueAsString(list);
		System.out.println(jsonManyValue);
		
		System.out.println();
		
		System.out.println("2.JSON Value(String)  => List<User>로 변환 및 값 추출");
		List<User> returnList = om.readValue(jsonManyValue, new TypeReference<List<User>>() {});
		System.out.println(returnList);
		System.out.println(returnList.get(0));
		System.out.println("userId = "+ returnList.get(0).getUserId());
		
		System.out.println();
		
		System.out.println("2.JSON Value(String) => JSON Object 로 사용 및 값 추출");
		JSONArray jsonArray = (JSONArray)JSONValue.parse(jsonManyValue);
		System.out.println((JSONObject)jsonArray.get(0));
		System.out.println("userId = "+ ((JSONObject)jsonArray.get(0)).get("userId"));
		
		System.out.println("\n\n///////////////////////////////////////////////");
		Map<String, User> map = new HashMap<String, User>();
		map.put("1", user);
		map.put("2", new User("user02","홍길동","2222",null,20));
		
		System.out.println("3. Map<User> => JSON Value 로 변환");
		jsonManyValue = om.writeValueAsString(map);
		System.out.println(jsonManyValue);
		
		System.out.println();
		
		System.out.println("3. JSON Value => Map<User> 로 변환 및 값 추출");
		Map<String, User> returnMap = om.readValue(jsonManyValue, new TypeReference<Map<String, User>>(){});
		System.out.println(returnMap);
		System.out.println(returnMap.get("1"));
		System.out.println(returnMap.get("1").getUserId());
		
		System.out.println();
		
		System.out.println("3. Map<User> => JSON Value 로 변환 및 값 추출");
		jsonObj = (JSONObject)JSONValue.parse(jsonManyValue);
		System.out.println(jsonObj);
		System.out.println((JSONObject)jsonObj.get("1"));
		System.out.println("userId = "+ ((JSONObject)jsonObj.get("1")).get("userId"));
		
	}

}
