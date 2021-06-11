package com.revature.intercoms;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.models.Flashcard;

// name refers to the service we want to make requests to
@FeignClient(name="flashcard", fallback=FlashcardClientImpl.class)
public interface FlashcardClient {

	@GetMapping
	List<Flashcard> findAll();
	
	@GetMapping("/port")
	String getPort();
}
