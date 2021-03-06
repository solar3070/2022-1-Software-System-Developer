package com.example.springidol.javaconf4;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springidol.Cymbal;
import com.example.springidol.Guitar;
import com.example.springidol.Harmonica;
import com.example.springidol.Instrumentalist;
import com.example.springidol.OneManBand;
import com.example.springidol.Piano;
import com.example.springidol.Poem;
import com.example.springidol.PoeticJuggler;
import com.example.springidol.Saxophone;
import com.example.springidol.Singer;
import com.example.springidol.Song;
import com.example.springidol.Sonnet29;

@Configuration
public class SpringConfSub {
	
	@Bean
	public Saxophone saxophone() {	  	// method 이름을 bean의 ID로 사용 ("saxophone") 
		return new Saxophone();			// Saxophone type bean 생성  
	}
	
	@Bean
	public Guitar guitar() {	    
		return new Guitar();		
	}
	
	@Bean
	public Harmonica harmonica() {	    
		return new Harmonica();		
	}
	
	@Bean
	public Cymbal cymbal() {	    
		return new Cymbal();		
	}
	
	@Bean
	public Piano piano() {	    
		return new Piano();		
	}
		
	@Bean
	public Poem sonnet29() {
		return new Sonnet29();
	}
	
	@Bean
	public PoeticJuggler duke() {
		return new PoeticJuggler(5, sonnet29());
	}
	
	@Bean(name="kenny")				// name 속성을 통해 bean ID 지정 가능 
	public Instrumentalist instr() {
		Instrumentalist instr = new Instrumentalist();
		instr.setSong("Jingle Bells");	
		instr.setInstrument(guitar());		// Setter-based DI
		return instr;
	} 
	
	@Bean		
	public OneManBand hank() {
		Properties props = new Properties();
		props.setProperty("GUITAR", "STRUM STRUM STRUM");
		props.setProperty("CYMBAL", "CRASH CRASH CRASH");
		props.setProperty("HARMONICA", "HUM HUM HUM");
		OneManBand omb = new OneManBand();		
		omb.setInstruments(props);
		return omb;
	}	
	
	@Bean
	public Singer chris() {
		return new Singer("Chris Kim", bohemian());
	}
	
	@Bean
	public Singer jain() {
		return new Singer("Jain Lee", chris().getSong());
	}
	
	@Bean
	public Song bohemian() {
		Song song = new Song();
		song.setTitle("Bohemian Rhapsody");
		song.setArtist("Queen");
		return song;
	}
	
	@Bean
	public Song someone() {
		Song song = new Song();
		song.setTitle("Someone Like You");
		song.setArtist("Adele");
		return song;
	}

}