package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public void start() throws Exception{
		
		String filepath = "C:\\Formation openclassrooms\\Développeur d'applications JAVA\\FO_JAVA_P02\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\symptoms.txt";
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(filepath);
		List<String> symptoms = symptomReader.GetSymptoms();
		// déclarer la map treemap
		 TreeMap<String, Integer> map = new TreeMap<>();
		
		//faire la boucle de comptage
		 for (String symptom: symptoms) {
			
			 if(!map.containsKey(symptom)) {
				 map.merge(symptom,  1, Integer::sum);
				 //System.out.println(map);
			 }
			 else {
				 map.put(symptom, +1);
				 System.out.println(map);
			 }
		 }
				 
		 //si symptom = clé map
		 	//ajouter symptom en clé map
		 	//ajouter à la valeur valeur
		 		//OK
		//sinon
		 	// value map ++
		
		// generate file result.out
		FileWriter writer = new FileWriter("C:\\Formation openclassrooms\\Développeur d'applications JAVA\\FO_JAVA_P02\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\src\\\\com\\hemebiotech\\\\analytics\\result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
	
	public static void main(String args[]) throws Exception {
		AnalyticsCounter analyticsCouter = new AnalyticsCounter();
		analyticsCouter.start();
		
	}
}
