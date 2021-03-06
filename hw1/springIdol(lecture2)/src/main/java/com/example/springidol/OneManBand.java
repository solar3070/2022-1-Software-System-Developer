package com.example.springidol;

import java.util.Map;

public class OneManBand implements Performer {
	private Map<String, Instrument> instruments;

	public OneManBand() {
	}

	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		for (String key : instruments.keySet()) {
			Instrument instrument = instruments.get(key);
			System.out.print(key + " : ");
			instrument.play();
		}
	}

}
