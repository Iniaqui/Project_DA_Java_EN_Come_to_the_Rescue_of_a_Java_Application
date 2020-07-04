package com.hemebiotech.analytics;

public class Symptom {
	private String name; 
	private int countSymptom=1;
	
	public Symptom(String name) {
		this.name=name;
	}
	public void Counter() {
		countSymptom++;
	}
	public String getName() {
		return this.name;
	}
	public void Display() {
		System.out.println("\n\t Name  :  "+ this.name+"\n\t\t  Occurence : "+this.countSymptom);
	}
	public String Write() {
		return this.name+": "+this.countSymptom;
	}
}
