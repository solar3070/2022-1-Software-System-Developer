package com.example.springidol;

public class Encore {
	private Performer encorePerformer;

	public Encore() {
		super();
	}

	public void setEncorePerformer(Performer encorePerformer) {
		this.encorePerformer = encorePerformer;
	}
	
	public void execute() {
		System.out.println("<Encore Performance>");
		encorePerformer.perform();
	}
}
