package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class AnalyticsCounter {
	/*
	 * private static int headacheCount = 0; private static int rashCount = 0;
	 * private static int pupilCount = 0;
	 */

	public void start() throws Exception {

		String filepath = "C:\\Formation openclassrooms\\Développeur d'applications JAVA\\FO_JAVA_P02\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\symptoms.txt";
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(filepath);
		List<String> symptoms = symptomReader.GetSymptoms();
		// déclarer la map treemap
		TreeMap<String, Integer> map = new TreeMap<>();

		// faire la boucle de comptage
		for (String symptom : symptoms) {

			if (!map.containsKey(symptom)) {
				map.merge(symptom, 1, Integer::sum);
				// System.out.println(map);
			} else {
				int count = map.containsKey(symptom) ? map.get(symptom) : 0;
				map.put(symptom, count + 1);
			}
		}
		System.out.println(map);


		// generate file result.out
		FileWriter writer = new FileWriter("result.out");
		// writer.write("headache: " + headacheCount + "\n");
		// writer.write("rash: " + rashCount + "\n");
		// writer.write("dialated pupils: " + pupilCount + "\n");
		/*
		 * for (int i = 0; i <map.size(); i++) { writer.write(map.ceilingKey(filepath));
		 * }
		 */
		for (Entry<String, Integer> mapentry : map.entrySet()) {
			System.out.println("clé: " + mapentry.getKey() + " | valeur: " + mapentry.getValue());
			writer.write(mapentry.getKey() +" " + mapentry.getValue() + "\n");
		}
		writer.close();
	}

	public static void main(String args[]) throws Exception {
		AnalyticsCounter analyticsCouter = new AnalyticsCounter();
		analyticsCouter.start();

	}
}
