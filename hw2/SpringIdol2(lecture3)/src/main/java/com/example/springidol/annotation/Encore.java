package com.example.springidol.annotation;

import com.example.springidol.Performer;

public class Encore {
	private Performer performer;

	public void setPerformer(Performer p) {
		this.performer = p;
	}

	public void execute() {
		System.out.println("<Encore Performance>");
		performer.perform();
	}
}
