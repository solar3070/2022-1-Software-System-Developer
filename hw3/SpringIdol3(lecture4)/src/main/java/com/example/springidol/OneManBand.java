package com.example.springidol;

import java.util.Properties;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("hank")
public class OneManBand implements Performer, BeanNameAware {
	private String beanName;
	
	public OneManBand() {
	}

	private Properties instruments;

	@Autowired
	@Qualifier("instruments")
	public void setInstruments(Properties instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		for (Object element : instruments.keySet()) {
			String key = (String) element;
			System.out.println(key + " : " + instruments.getProperty(key));
		}
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	@Override
	public String getBeanName() {
		return this.beanName;
	}

}
