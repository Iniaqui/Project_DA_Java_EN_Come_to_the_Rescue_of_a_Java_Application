package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		String filepath ="symptoms.txt";
		//Generate an object 
		ReadSymptomDataFromFile readFile = new ReadSymptomDataFromFile(filepath);

		ArrayList<String> ListSymptoms = readFile.GetSymptoms();
		ArrayList<Symptom> Symptom = new ArrayList<Symptom>();
		if(ListSymptoms != null) {
			
			String premierSymp;
			premierSymp =ListSymptoms.get(0);
			Symptom.add(new Symptom(premierSymp));
			int i = 1, j=0;
			boolean exist;
			String Line;
			do {
				Line = ListSymptoms.get(i);
				
				do {
					
					if(Line.equals(Symptom.get(j).getName())) {
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
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		int s=0;
		do {
			
			writer.write("\n"+Symptom.get(s).Write());
			s++;
		}while(s< Symptom.size());
		
		writer.close();
	}
}
