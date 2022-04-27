package com.example.helloworld.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springidol.Performer;

@Service
public class HelloService {	
	@Autowired								// constructor 기반 DI 설정
	private Map<String, Performer> performers = new HashMap<String, Performer>();

	/*
	@Autowired								// constructor 기반 DI 설정
	HelloService(List<Performer> list) {	// 모든 Performer 타입 bean들의 리스트를 주입받아 이용	
		for (Performer performer : list) {
			performers.put(performer.getBeanName(), performer);
		}
	}
	*/
	public Performer getPerformer(String id) {
		return performers.get(id);
	}
	
	public String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour <= 10) {
			return "Good morning, ";
		} else if (hour >= 12 && hour <= 15) {
			return "Did you have lunch? ";
		} else if (hour >= 18 && hour <= 24) {
			return "Good evening, ";
		}
		return "Hello! ";
	}
}
