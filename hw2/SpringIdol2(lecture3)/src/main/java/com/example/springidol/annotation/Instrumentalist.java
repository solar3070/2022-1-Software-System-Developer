package com.example.springidol.annotation;

import com.example.springidol.Instrument;
import com.example.springidol.PerformanceException;
import com.example.springidol.Performer;

public class Instrumentalist implements Performer {
	public Instrumentalist() {
	}
	
	private String song;

	public void setSong(String song) {
		this.song = song;
	}

	private Instrument instrument;

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.print("Playing " + song + " : ");
		instrument.play();
	}
}
