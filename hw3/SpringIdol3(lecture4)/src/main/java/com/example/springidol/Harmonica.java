package com.example.springidol;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Harmonica implements Instrument {
	@Value("${harmonica}")
	String sound;
	
	public Harmonica() {
	}

	public void play() {
		System.out.println(sound);
	}
}
