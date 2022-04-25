package com.example.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SpringIdol implements TalentCompetition {
	@Autowired
	private Performer[] performers;
	private int stageSize;
	@Autowired
	private Piano piano;
	
	public SpringIdol() {
	}
	
	public Performer[] getPerformers() {
		return performers;
	}

	public void setPerformers(Performer[] performers) {
		this.performers = performers;
	}
	
	public void setStageSize(int size) {
		stageSize = size;
		System.out.println("SpringIdol.setStageSize(): 무대 크기 = " + stageSize);
	}
	
	public void tunePiano() {
		System.out.println("SpringIdol.tunePiano(): 피아노 조율");
		piano.tune();
	}
	
	public void cleanPiano() {
		System.out.println("SpringIdol.cleanPiano(): 피아노 청소");
		piano.clean();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < performers.length; i++) {
			Performer performer = performers[i];
			System.out.println("<Performance #" + (i+1) + " by " + performer.getBeanName() + ">");
			performer.perform();
			System.out.println("-----------------------");
		}
	}
}
