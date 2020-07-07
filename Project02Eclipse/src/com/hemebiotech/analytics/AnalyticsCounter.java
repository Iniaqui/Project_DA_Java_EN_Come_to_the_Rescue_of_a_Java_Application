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
	//
		  
		 
		//Set the path of File
		
		/**
		 * @see ReadSymptomDataFromFile
		 */
		SymptomHandler handler=new SymptomHandler();
		
		handler.setSymptomtList();
		handler.updateSymptom();
		handler.affiche();
		/**
		 * List of the symptom with its characterize and methods
		 * @see Symptom
		 */

		
		
		
		/**
		 *  next generate output
		 */
	
	}
}
