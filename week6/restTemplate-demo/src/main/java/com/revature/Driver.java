package com.revature;

import org.springframework.web.client.RestTemplate;

import com.revature.models.Pokemon;

public class Driver {

	public static void main(String[] args) {
		
		RestTemplate rt = new RestTemplate();
		// String url = "http://localhost:8080/users";
		Pokemon p = rt.getForObject("https://pokeapi.co/api/v2/pokemon/1", Pokemon.class);
		System.out.println(p);

//		rt.postForObject("url", objectToBePosted, ClassName.class);
	}

}
