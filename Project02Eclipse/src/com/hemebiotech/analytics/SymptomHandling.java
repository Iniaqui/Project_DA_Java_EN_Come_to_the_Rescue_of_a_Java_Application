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
	/**
	 * It Contain the list of symptoms of file 
	 */
	private List<String> listSymptoms=new ArrayList<String>();
	/**
	 * the reader of file 
	 * @see #reader
	 */
	private ReadSymptomDataFromFile reader;
	/**
	 * A Map which contain the symptoms by alphabetical order
	 */
	private Map<String, Integer> order;
	
	public SymptomHandling(String filePath) {
		this.reader=new ReadSymptomDataFromFile(filePath);
		
	}
	/**
	 * It put the symptoms of file in the listSymptom, order is not here 
	 * @see #listSymptoms
	 */
	public void setSymptomList() {
		this.listSymptoms = this.reader.GetSymptoms();
	}
	/**
	 * Update symptom by put every symptom of listSymptom,every symptom such as key and occurence such as values 
	 */
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
	/**
	 * Classify the elements of symptom in the Map by alphabetical order
	 */
	public void toOrder() {
		 this.order = new TreeMap<String, Integer>(symptom);
		for(Map.Entry entry : order.entrySet()) {
			System.out.println(entry.getKey()+": "+ entry.getValue());
		}
	}
	/**
	 * Create a file and put all elements of the Map into thus file 
	 * @param filePath
	 * @throws IOException
	 */
	public void writer(String filePath) throws IOException {
		FileWriter w = new FileWriter(filePath);
		for(Map.Entry entry : order.entrySet()) {
			w.write("\n"+entry.getKey()+": "+ entry.getValue());
		}
		w.close();
	}
}
