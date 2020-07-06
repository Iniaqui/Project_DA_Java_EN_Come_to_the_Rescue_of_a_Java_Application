package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

/**
 * Contain the main , read and count the symptoms of file , classify and put the results on the file results
 * @author maure
 * @version 3
 *
 */

public class AnalyticsCounter {
			
	
	public static void main(String args[]) throws Exception {
		/**
		 * Contains the path of the file which the list of symptom
		 */
		//Set the path of File
		String filepath ="symptoms.txt";
		/**
		 * @see ReadSymptomDataFromFile
		 */
		ReadSymptomDataFromFile readFile = new ReadSymptomDataFromFile(filepath);
		
		ArrayList<String> ListSymptoms = readFile.GetSymptoms();
		/**
		 * List of the symptom with its characterize and methods
		 * @see Symptom
		 */
		ArrayList<Symptom> Symptom = new ArrayList<Symptom>();
		
		if(ListSymptoms != null) {//Verify if the list of symptom are not empty  
			/**
			 * We take the first symptom of the list of symptom in the Symptom for avoid the exception in order to have a arrayList Symptom not empty
			 */
			String premierSymp;
			premierSymp =ListSymptoms.get(0);
			Symptom.add(new Symptom(premierSymp));
			int i = 1, j=0;
			/**
			 * To verify if this symptom is already count or not
			 */
			boolean exist;
			/**
			 * Read every elements of ListSymptoms
			 */
			String Line;
			do {
				Line = ListSymptoms.get(i);
				
				do {
					
					if(Line.equals(Symptom.get(j).getName())) {//Verify the correpondance 
						Symptom.get(j).Counter();
						exist =true;
						break;
					}
					else {
						exist =false;
					}
					j++;
					
				}while(j< Symptom.size() && exist ==false);
				if(exist== false) {
					
					Symptom.add(new Symptom(Line));//add this symptom as new Symptom
				}
				i++;
				j=0;
			}while(i< ListSymptoms.size());
			
			/**
			 * Set up by alphabetical order the list of symptom and return the same array but classify in alphabetic order
			 * @param List , Comparator
			 * 
			 */
			Collections.sort(Symptom, new Comparator<Object>() {
				
				public int compare(Object s1, Object s2) {
					return((Symptom)s1).getName().compareTo(((Symptom)s2).getName());
				}
			});
			
			
			//Test of screen of symptoms
			int nb=0;
			
			if(Symptom != null) {
				do {
					Symptom.get(nb).Display();
					nb++;
				}while(nb<Symptom.size());
			}
			
		}
		else {
			System.out.println("Tableau vide");
		}
		
		/**
		 *  next generate output
		 */
		FileWriter writer = new FileWriter ("result.out");
		int s=0;
		do {
			
			writer.write("\n"+Symptom.get(s).Write());
			s++;
		}while(s< Symptom.size());
		
		writer.close();
	}
}
