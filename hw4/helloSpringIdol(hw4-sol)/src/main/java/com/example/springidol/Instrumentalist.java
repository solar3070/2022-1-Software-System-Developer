package com.example.springidol;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("kenny")
public class Instrumentalist implements Performer, BeanNameAware {
	public Instrumentalist() {}

	@Value("${kenny.name}")	
	private String name;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Value("${kenny.song}")	
	private String song;

	public void setSong(String song) {
		this.song = song;
	}

	public String getSong() {
		return this.song;
	}

	@Autowired 
	@Qualifier("saxophone")
	private Instrument instrument;

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public String perform() throws PerformanceException {
		String result = "Playing " + song + " : " + instrument.play();
		System.out.println(result);
		return result;
	}
	
	private String beanName;

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	@Override
	public String getBeanName() {
		return beanName;
	}
}
