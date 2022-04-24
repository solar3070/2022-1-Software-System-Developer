package com.example.springidol;

public class Singer implements Performer {
	private String name;
	private Song song;
	
	public Singer(String name, Song song) {
		super();
		this.name = name;
		this.song = song;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println(name + " is singing a song \"" + song.getTitle() + "\" by \"" + song.getArtist() + "\".");
	}
	
}
