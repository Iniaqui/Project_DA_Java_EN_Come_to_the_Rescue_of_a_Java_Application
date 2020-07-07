package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SymptomHandler {
	private List<String> listSymptom;
	HashMap<String, Integer> symptom = new HashMap<String, Integer>();
	//private String filepath;
	
	public SymptomHandler() {
		this.listSymptom= new ArrayList<String>();
		
	}
	
	public void setSymptomtList() {
		 ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		 this.listSymptom= reader.GetSymptoms();
	}
	public void updateSymptom() {
		for(String s: this.listSymptom) {
			if(symptom.containsKey(s)) {
				symptom.put(s,symptom.get(s)+1);
			}
			else {
				symptom.put(s, 1);
			}
		}
	}
	
	public void affiche() {
		for(String s:this.listSymptom) {
			System.out.println("\nSymptom: "+s +":" +symptom.get(s));
		}
	}
	
	public void toOrder() {
		
	}
	
}
	
