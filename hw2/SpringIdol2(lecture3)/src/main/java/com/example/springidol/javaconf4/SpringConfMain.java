package com.example.springidol.javaconf4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.springidol.Encore;
import com.example.springidol.Instrumentalist;
import com.example.springidol.OneManBand;
import com.example.springidol.Performer;
import com.example.springidol.PoeticJuggler;
import com.example.springidol.Singer;
import com.example.springidol.SpringIdol;

@Configuration
@Import(SpringConfSub.class)
public class SpringConfMain {
	@Autowired
	private PoeticJuggler duke;			// PoeticJuggler 타입 객체가 자동 주입됨
	@Autowired
	private Instrumentalist instr;		// Instrumentalist 타입 객체가 자동 주입됨
	@Autowired
	private OneManBand hank;			// OneManBand 타입 객체가 자동 주입됨
	@Autowired
	private Singer chris;			// OneManBand 타입 객체가 자동 주입됨
	@Autowired
	private Singer jain;			// OneManBand 타입 객체가 자동 주입됨
	
	@Bean
	public SpringIdol springIdol() {
		SpringIdol si = new SpringIdol();
		si.setPerformers(new Performer[]{duke, instr, hank, chris, jain});	// 위 필드를 통해 객체 참조
		return si;		
	}
	
	@Bean
	public Encore encore() {
		Encore encore = new Encore();
		Performer[] performers = springIdol().getPerformers();
		encore.setPerformer(performers[(int) (Math.random() * performers.length)]);		// 임의의 performer 선택으로 변경!
		return encore;		
	}
}