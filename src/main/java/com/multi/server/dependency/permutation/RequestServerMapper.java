package com.multi.server.dependency.permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class RequestServerMapper {

	public List<Map<String, String>> getAllPermutations(List<String> requests, List<String> servers) {
		List<Map<String, String>> allPossiblePermutations = new ArrayList<>();
		allPossiblePermutations = findAllPermutations(requests, servers, 0);
		return allPossiblePermutations;
	}

	public List<Map<String, String>> findAllPermutations(List<String> requests, List<String> servers, int pos) {
		List<Map<String, String>> allPossiblePermutations = new ArrayList<>();

		// If it is last element in requests, map it to all the servers and
		// return permutations
		if (pos == requests.size() - 1) {
			for (int i = 0; i < servers.size(); i++) {
				Map<String, String> permutation = new HashMap<>();
				permutation.put(requests.get(pos), servers.get(i));
				allPossiblePermutations.add(permutation);
			}
			return allPossiblePermutations;
		}

		// Find all the permutations for next position
		List<Map<String, String>> restOfPermutations = findAllPermutations(requests, servers, pos + 1);

		// find all permutations for current position. map current pos request
		// for all servers with restOfPermutations
		for (int i = 0; i < restOfPermutations.size(); i++) {
			Map<String, String> permutation = restOfPermutations.get(i);
			for (int j = 0; j < servers.size(); j++) {
				Map<String, String> newpermutation = new HashMap<>();
				newpermutation.putAll(permutation);
				newpermutation.put(requests.get(pos), servers.get(j));
				allPossiblePermutations.add(newpermutation);
			}
		}
		return allPossiblePermutations;
	}

	public static void main(String[] args) {
		RequestServerMapper requestServerMapper = new RequestServerMapper();
		List<String> requests = new ArrayList<>();
		requests.add("r1");
		requests.add("r2");
		List<String> servers = new ArrayList<>();
		servers.add("s1");
		servers.add("s2");
		servers.add("s3");
		List<Map<String, String>> allPossiblePermutations = requestServerMapper.getAllPermutations(requests, servers);
		System.out.println("Total no of permutations- " + allPossiblePermutations.size());
		for (int i = 0; i < allPossiblePermutations.size(); i++) {
			System.out.println(allPossiblePermutations.get(i));
		}
	}

}
