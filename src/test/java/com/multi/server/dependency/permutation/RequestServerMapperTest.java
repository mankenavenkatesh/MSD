package com.multi.server.dependency.permutation;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
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
	public void checkOneRequestOneServerMapping() {
		List<String> requests = new ArrayList<>();
		requests.add("r1");
		List<String> servers = new ArrayList<>();
		servers.add("s1");
		List<Map<String, String>> possiblePermutations = requestServerMapper.getAllPermutations(requests, servers);
		Assert.assertTrue(!possiblePermutations.isEmpty());
		Assert.assertTrue(possiblePermutations.size() == 1);
		Assert.assertThat(possiblePermutations.get(0).get("r1"), is(("s1")));
	}

	@Test
	public void checkTwoRequestOneServerMapping() {
		List<String> requests = new ArrayList<>();
		requests.add("r1");
		requests.add("r2");
		List<String> servers = new ArrayList<>();
		servers.add("s1");
		List<Map<String, String>> possiblePermutations = requestServerMapper.getAllPermutations(requests, servers);
		Assert.assertTrue(!possiblePermutations.isEmpty());
		Assert.assertTrue(possiblePermutations.size() == 1);
		Assert.assertThat(possiblePermutations.get(0).get("r1"), is(("s1")));
		Assert.assertThat(possiblePermutations.get(0).get("r2"), is(("s1")));

	}

	@Test
	public void checkOneRequestTwoServerMapping() {
		List<String> requests = new ArrayList<>();
		requests.add("r1");
		List<String> servers = new ArrayList<>();
		servers.add("s1");
		servers.add("s2");
		List<Map<String, String>> possiblePermutations = requestServerMapper.getAllPermutations(requests, servers);
		Assert.assertTrue(!possiblePermutations.isEmpty());
		Assert.assertTrue(possiblePermutations.size() == 2);
		Assert.assertThat(possiblePermutations.get(0).get("r1"), is(("s1")));
		Assert.assertThat(possiblePermutations.get(1).get("r1"), is(("s2")));
	}

	@Test
	public void checkTwoRequestTwoServerMapping() {
		List<String> requests = new ArrayList<>();
		requests.add("r1");
		requests.add("r2");
		List<String> servers = new ArrayList<>();
		servers.add("s1");
		servers.add("s2");
		List<Map<String, String>> possiblePermutations = requestServerMapper.getAllPermutations(requests, servers);
		Assert.assertTrue(!possiblePermutations.isEmpty());
		Assert.assertTrue(possiblePermutations.size() == 4);
		// 1st permutation
		Assert.assertThat(possiblePermutations.get(0).get("r1"), is(("s1")));
		Assert.assertThat(possiblePermutations.get(0).get("r2"), is(("s1")));

		// second permutations
		Assert.assertThat(possiblePermutations.get(1).get("r1"), is(("s2")));
		Assert.assertThat(possiblePermutations.get(1).get("r2"), is(("s2")));

		// third permutation
		Assert.assertThat(possiblePermutations.get(1).get("r1"), is(("s1")));
		Assert.assertThat(possiblePermutations.get(1).get("r2"), is(("s2")));

		// Fourth Permutation
		Assert.assertThat(possiblePermutations.get(1).get("r1"), is(("s2")));
		Assert.assertThat(possiblePermutations.get(1).get("r2"), is(("s1")));

	}
}
