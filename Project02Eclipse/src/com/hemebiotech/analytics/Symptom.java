package com.hemebiotech.analytics;

/**
 * It characterizes every Symptom and the number of occurence it have if the list 
 * @author maure
 *@version 1.0
 */
public class Symptom {
	/**
	 * The name of Symptom
	 * @see Symptom#getName()
	 * @see Symptom#Symptom(String)
	 */
	private String name; 
	
	/**
	 * The occurrence of symptom in the list
	 * @see Symptom#Counter() 
	 */
	private int countSymptom=1;
	
	/**
	 * The constructor , it attribute the variable to the name 
	 * @param name
	 * 			the name of symptom 
	 */
	public Symptom(String name) {
		this.name=name;
	}
	
	/**
	 * Count the occurence of the symptom and set up the {@link #countSymptom}
	 */
	public void Counter() {//To increments the occurrence of symptoms
		countSymptom++;
	}
	
	/**
	 * It get the name of the symptom
	 * @return {@link Symptom#name}
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Display the characterizes of Symptom 
	 */
	public void Display() {
		System.out.println("\n\t Name  :  "+ this.name+"\n\t\t  Occurence : "+this.countSymptom);
	}
	/**
	 * Write in the file the name and occurrence of symptom 
	 * @return {@link #name} and {@link #countSymptom}
	 */
	public String Write() {
		return this.name+": "+this.countSymptom;
	}
}
