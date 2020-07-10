package com.hemebiotech.analytics;



/**
 * Contain the main , read and count the symptoms of file , classify and put the results on the file results
 * @author maure
 * @version 3
 *
 */

public class AnalyticsCounter {
			
	
	public static void main(String args[]) throws Exception {
		
		if (args.length > 0)
		{
			
		    System.out.println("it's ok");
		    SymptomHandling handler = new SymptomHandling(args[0]);
			handler.setSymptomList();
			handler.updateSymptom();
			handler.toOrder();
			handler.writer("result.out");
		}
		
		
		
		
		
	
	}
}
