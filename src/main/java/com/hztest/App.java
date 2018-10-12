package com.hztest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hazelcast.client.impl.protocol.util.Int2ObjectHashMap.KeySet;
import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello World!");
		
		Config config = new Config();
		GroupConfig groupConfig =  new GroupConfig();
		groupConfig.setName("omps");
		groupConfig.setPassword("password");
		
		
		config.setGroupConfig(groupConfig);
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
		
		Thread.sleep(10);
		
		Map<Integer, String> clusterMap = instance.getMap("publishCardLock");
		for (Integer key : clusterMap.keySet()) {
			
			System.out.println("hz Map Value:" + clusterMap.get(key));
		}
		
		System.out.println("cardtypeid 这里填要清理的id Map Value:" + clusterMap.get("cardtypeid 这里填要清理的id"));
		
		clusterMap.clear();
		
		
		HashMap<String,String> fa =  new HashMap<String,String>();
		fa.put("ffa", "11111111");
		System.out.println("Map Value:" + fa.get(fa.keySet().iterator().next()));
		fa.clear();
		
		fa.put("fds", "333");
		System.out.println("Map Value:" + fa.get(fa.keySet().iterator().next()));
		
		
	}
}
