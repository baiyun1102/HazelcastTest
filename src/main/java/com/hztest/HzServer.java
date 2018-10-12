package com.hztest;

import java.util.Map;
import java.util.Queue;

import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * Hello world!
 *
 */
public class HzServer {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello World!");
		
		Config config = new Config();
		GroupConfig groupConfig =  new GroupConfig();
		groupConfig.setName("omps");
		groupConfig.setPassword("password");
		
		config.setGroupConfig(groupConfig);
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
		
		Thread.sleep(100);
		
		Map<Integer, String> clusterMap = instance.getMap("publishCardLock");
		for (Integer key : clusterMap.keySet()) {
			System.out.println("hz Map Value:" + clusterMap.get(key));
		}
		
		System.out.println("cardtypeid 这里填要清理的id Map Value:" + clusterMap.get("cardtypeid 这里填要清理的id"));
		
		clusterMap.clear();
		
		
		
		// 创建集群Map
        Map<Integer, String> clusterMap2 = instance.getMap("MyMap");
        clusterMap2.put(1, "Hello hazelcast map!");

        // 创建集群Queue
        Queue<String> clusterQueue = instance.getQueue("MyQueue");
        clusterQueue.offer("Hello hazelcast!");
        clusterQueue.offer("Hello hazelcast queue33333333333333!");
	}
}
