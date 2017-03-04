package com.multi.server.dependency.permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestServerMapperTest {

	@Autowired
	RequestServerMapper requestServerMapper;
	
	@Test
	public void checkOneRequestOneServerMapping(){
		List<String> requests=new ArrayList<>();
		requests.add("r1");
		List<String> servers=new ArrayList<>();
		servers.add("s1");
		List<Map<String, String>> possiblePermutations=requestServerMapper.getAllPermutations(requests, servers);
		Assert.assertTrue(!possiblePermutations.isEmpty());
		Assert.assertTrue(possiblePermutations.size()==1);
	}
	
}
