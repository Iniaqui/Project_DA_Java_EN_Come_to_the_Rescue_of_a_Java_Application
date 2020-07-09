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
		
		SymptomHandling handler = new SymptomHandling("symptoms.txt");
		handler.setSymptomList();
		handler.updateSymptom();
		handler.toOrder();
		handler.writer("result.out");
		
		
	
	}
}
