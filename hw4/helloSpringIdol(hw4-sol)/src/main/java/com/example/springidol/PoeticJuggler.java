package com.example.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("duke")
public class PoeticJuggler extends Juggler {
	private Poem poem;

	@Autowired(required = false)
	public PoeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}

	@Autowired(required = false)
	public PoeticJuggler(@Value("5") int beanBags, Poem poem) {
		super(beanBags);
		this.poem = poem;
	}

	@Override
	public String perform() throws PerformanceException {
		String result = super.perform() + "<br>" 
				+ "While reciting..." + "<br>"
				+ poem.recite();
		System.out.println(result);	
		return result;
	}
	
	@Value("${duke.name}")	
	private String name;
	
	@Override
	public String getName() {
		return name;
	}
}
