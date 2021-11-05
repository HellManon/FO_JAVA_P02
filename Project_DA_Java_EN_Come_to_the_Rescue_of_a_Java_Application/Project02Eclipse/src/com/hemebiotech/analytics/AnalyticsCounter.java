package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Everything that allows the program to be run The part that allows you to
 * count the occurrences and sort them in ascending order The part that allows
 * you to write the result to a file
 * 
 */

public class AnalyticsCounter {

	/**
	 * 
	 * @param start count the occurences write the result to a file
	 */

	public void start() throws Exception {

		String filepath = "C:\\Formation openclassrooms\\Développeur d'applications JAVA\\FO_JAVA_P02\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\symptoms.txt";
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(filepath);
		List<String> symptoms = symptomReader.GetSymptoms();

		// declaration de la map
		TreeMap<String, Integer> map = new TreeMap<>();
		try {
			// boucle de comptage
			for (String symptom : symptoms) {

				if (!map.containsKey(symptom)) {
					map.merge(symptom, 1, Integer::sum);
				} else {
					int count = map.containsKey(symptom) ? map.get(symptom) : 0;
					map.put(symptom, count + 1);
				}
			}
			System.out.println(map);
		} catch (Exception e) {
			System.out.println("Erreur d'execution de la boucle de comptage");
		}

		// generation du fichier result.out
		try {
			FileWriter writer = new FileWriter("result.out");
			for (Entry<String, Integer> mapentry : map.entrySet()) {
				System.out.println("clé: " + mapentry.getKey() + " | valeur: " + mapentry.getValue());
				writer.write(mapentry.getKey() + " " + mapentry.getValue() + "\n");
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("erreur lors de la creation du fichier result");
		}
	}

	public static void main(String args[]) throws Exception {
		AnalyticsCounter analyticsCouter = new AnalyticsCounter();
		analyticsCouter.start();

	}
}
