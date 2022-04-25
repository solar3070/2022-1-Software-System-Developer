package com.example.springidol.annotation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.springidol.Instrument;
import com.example.springidol.PerformanceException;
import com.example.springidol.Performer;

public class OneManBand implements Performer {
  public OneManBand() {}
  
  private Collection<Instrument> instruments;
  
  public void setInstruments(Collection<Instrument> instruments) {
	  this.instruments = instruments;
  }
  
  public void perform() throws PerformanceException {
	  for(Instrument instrument : instruments) {
		  instrument.play();
	  }
  } 
}
