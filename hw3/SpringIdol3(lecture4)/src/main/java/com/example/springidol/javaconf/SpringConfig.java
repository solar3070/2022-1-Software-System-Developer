package com.example.springidol.javaconf;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.example.springidol.Instrumentalist;
import com.example.springidol.Saxophone;
import com.example.springidol.Singer;
import com.example.springidol.Song;
import com.example.springidol.SpringIdol;

@Configuration
@PropertySource({"classpath:app.properties"})
@ComponentScan(basePackageClasses= {SpringIdol.class})
public class SpringConfig {
	@Autowired
	private Environment env;	
	
	@Value("${springIdol.stage.size}")
	private int stageSize;
	
	@Value("${favSong.title}")
	private String favSongTitle;
	
	@Value("${favSong.artist}")
	private String favSongArtist;
	
	@Bean(initMethod="tunePiano", destroyMethod="cleanPiano")
	public SpringIdol springIdol() {
		SpringIdol si = new SpringIdol();
		si.setStageSize(this.stageSize);
		// si.setPerformers(new Performer[]{...});	// by auto-wiring
		return si;		
	}
	
	@Bean(name="kenny")				// name 속성을 통해 bean ID 지정 가능 
	public Instrumentalist instr() {
		Instrumentalist instr = new Instrumentalist();
		instr.setSong("Jingle Bells");	
		instr.setInstrument(saxophone());		// Setter-based DI
		return instr;
	} 
	
	@Bean
	public Saxophone saxophone() {	  	// method 이름을 bean의 ID로 사용 ("saxophone") 
		return new Saxophone();			// Saxophone type bean 생성  
	}
	
	@Bean
	public Singer chris() {
		return new Singer(env.getProperty("chris.name"), favorateSong());	
	}
	
	@Bean
	public Song favorateSong() {
		Song song = new Song();
//		song.setTitle("Someone Like You");
//		song.setArtist("Adele");
		song.setTitle(this.favSongTitle);
		song.setArtist(this.favSongArtist);
		return song;
	}
	
	@Bean
	public Properties instruments() {
		Properties props = new Properties();
		props.setProperty("GUITAR", env.getProperty("guitar.sound"));
		props.setProperty("CYMBAL", env.getProperty("cymbal.sound"));
		props.setProperty("HARMONICA", env.getProperty("harmonica.sound"));
		return props;
	}				
	
	/*		
	 * use component-scan
	 * 
	@Bean
	public Guitar guitar() {	    
		return new Guitar();		
	}
		
	@Bean
	public Poem sonnet29() {
		return new Sonnet29();
	}

	@Bean
	public PoeticJuggler duke() {
		return new PoeticJuggler(5, sonnet29());
	}
	
	@Bean		
	public OneManBand hank() {
		OneManBand omb = new OneManBand();		
		omb.setInstruments(instruments());
		return omb;
	}		
	*/

}