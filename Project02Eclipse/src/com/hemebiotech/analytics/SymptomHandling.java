package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomHandling {
	/**
	 * It contain every symptom with his occurence in the list
	 */
	private HashMap<String , Integer> symptom= new HashMap<String, Integer>();
	private List<String> listSymptoms=new ArrayList<String>();
	private ReadSymptomDataFromFile reader;
	private Map<String, Integer> order;
	
	public SymptomHandling(String filePath) {
		this.reader=new ReadSymptomDataFromFile(filePath);
		
	}
	public void setSymptomList() {
		this.listSymptoms = this.reader.GetSymptoms();
	}
	public void updateSymptom() {
		for(String symp:listSymptoms) {
			if(symptom.containsKey(symp)) {
				symptom.put(symp, symptom.get(symp)+1);
			}
			else {
				symptom.put(symp, 1);
			}
		}
	}
	
	public void toOrder() {
		 this.order = new TreeMap<String, Integer>(symptom);
		for(Map.Entry entry : order.entrySet()) {
			System.out.println(entry.getKey()+": "+ entry.getValue());
		}
	}
	public void writer(String filePath) throws IOException {
		FileWriter w = new FileWriter(filePath);
		for(Map.Entry entry : order.entrySet()) {
			w.write("\n"+entry.getKey()+": "+ entry.getValue());
		}
		w.close();
	}
}
