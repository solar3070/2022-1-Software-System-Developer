package com.example.springidol.javaconf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.springidol.TalentCompetition;

public class SpringIdolMain_javaconf {
	public static void main(String[] args) {
		System.out.println("SpringIdolMain_javaconf starts."); 
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringConfig.class);

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);
		competition.run();		
		ctx.close();
	}
}
