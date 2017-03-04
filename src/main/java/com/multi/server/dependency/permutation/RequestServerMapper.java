package com.multi.server.dependency.permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class RequestServerMapper {

	public List<Map<String, String>> getAllPermutations(List<String> requests, List<String> servers){
		List<Map<String, String>> allPossiblePermutations=new ArrayList<>();
		
		if(requests.size()==1 && servers.size()==1){
			Map<String, String> permutation=new HashMap<>();
			permutation.put(requests.get(0), servers.get(0));
			allPossiblePermutations.add(permutation);
		}
		return allPossiblePermutations;
	}
}
