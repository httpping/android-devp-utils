package com.tp.jsonbean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *  json 
 * @author tp
 *
 */
public class JsonBean {
	
	static String content;
	public static void main(String[] args) throws IOException {
		
		// 
		
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));
		
		content ="";
		String s = null;
		while (!(s = bReader.readLine()).equals("end")) {
			content+=s;
		}
		
		JSONObject jsonObject2 = JSONObject.fromObject(content);
		System.out.println(content);
		
		parseJson(jsonObject2);
		
	}
	
	/**
	 * json
	 * @param json
	 */
	public static void parseJson(JSONObject json){
		
		System.out.println("======");
		Iterator it = json.keys();
		
		while ( it.hasNext()){
			String key = (String) it.next();
			
			Object value = json.get(key);
			if (value instanceof JSONObject) {
				//System.out.println("class "+key +" {");
				parseJson((JSONObject) value);
				//return ;
			}
			if (value instanceof JSONArray) {//数组
				JSONArray array = (JSONArray) value;
				if (array.size()>0) {
					if (array.get(0) instanceof JSONObject){
						parseJson((JSONObject) array.get(0));	
						//return;
					}
				}
			}
			
			createKey(key, json);
		}
		
	}
	
	/**
	 * create key
	 * @param key
	 * @param json
	 */
	public static void createKey(String key,JSONObject json){
		Object value = json.get(key);
		if (value instanceof JSONObject) {
			System.out.println("====");
			return ;
		}
		
		 String type = value.getClass().getName();
		 String[] arrs = type.split("\\.");
		System.out.println("public " + arrs[arrs.length-1]+ " " + key +" ; " );
	}

}
