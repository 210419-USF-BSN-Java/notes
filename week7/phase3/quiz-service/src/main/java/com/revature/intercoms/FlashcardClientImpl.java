package com.revature.intercoms;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.models.Flashcard;

@Component
public class FlashcardClientImpl implements FlashcardClient {

	@Override
	public List<Flashcard> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPort() {
		return "Unable to reach Flashcard service";
	}

}
