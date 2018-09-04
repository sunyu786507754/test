package com.redis.demo.LockDemo.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ConcurrentTest1 {
	public static void main(String[] args) {
		Map<String,String> m=new HashMap<String, String>();
		for(int i=0;i<20;i++){
			m.put(i+"",i+"");
		}
		for(Entry<String,String> entry:m.entrySet()){
			String key=entry.getKey();
//			String value=entry.getValue();
			
			if(Integer.valueOf(key)<10){
				m.remove(key);
			}
		}
		System.out.println(m.size());
//		for(Entry<Integer,String> entry:m.entrySet()){
//			System.out.println(entry.getKey() + "  " + entry.getValue());
//		}
	}
}
