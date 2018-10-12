package com.hztest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.impl.protocol.util.Int2ObjectHashMap.KeySet;
import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * Hello world!
 *
 */
public class HzClient {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello World!");
		
		ClientConfig clientConfig = new ClientConfig();
		GroupConfig groupConfig =  new GroupConfig();
		groupConfig.setName("omps");
		groupConfig.setPassword("password");
		clientConfig.setGroupConfig(groupConfig);
		
//		clientConfig.addAddress("144.131.254.212:9210");
		clientConfig.addAddress("198.19.1.228:9210","198.19.1.229:9210","172.16.28.29:9210");
		
		
        HazelcastInstance instance = HazelcastClient.newHazelcastClient(clientConfig);
		
//		Thread.sleep(100);
		
		Map<Integer, String> clusterMap = instance.getMap("publishCardLock2");
		
		
		System.out.println("==========开始循环===========");
		for (Object key : clusterMap.keySet()) {
			
			System.out.println("hz Map: {Key = "+ String.valueOf(key) +",Value=" + clusterMap.get(key)+"}");
		}
//		clusterMap.clear();
		System.out.println("===========结束=============");
		System.out.println("cardtypeid 这里填要清理的id Map Value:" + clusterMap.get("cardtypeid 这里填要清理的id"));
		
	}
	
}
