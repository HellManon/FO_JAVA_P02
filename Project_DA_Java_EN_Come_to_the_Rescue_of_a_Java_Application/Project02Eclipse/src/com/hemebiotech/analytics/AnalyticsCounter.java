package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * this class allows to count the data of a file and to write the result in a
 * file
 * 
 */

public class AnalyticsCounter {

	public void start() {

		String filePath = "Project02Eclipse\\src\\com\\hemebiotech\\analytics\\symptoms.txt";
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(filePath);
		List<String> symptoms = symptomReader.getSymptoms();

		Map<String, Integer> countSymptoms = countSymptoms(symptoms);
		writeResult(countSymptoms);
	}

	/**
	 * write the result to a file result.out
	 * 
	 * @param countSymptoms the map that contain the number of symptoms
	 * 
	 */
	private void writeResult(Map<String, Integer> countSymptoms) {
		try (FileWriter writer = new FileWriter("result.out")) {
			for (Entry<String, Integer> mapEntry : countSymptoms.entrySet()) {
				writer.write(mapEntry.getKey() + "=" + mapEntry.getValue() + "\n");
			}
		} catch (Exception e) {
			System.out.println("erreur lors de la creation du fichier result");
		}
	}

	/**
	 * count the number of symptoms of the list
	 * 
	 * @param symptoms the list of symptoms
	 * @return a map that contain the symptoms and their number
	 */
	private Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countSymptoms = new TreeMap<>();

		for (String symptom : symptoms) {
			if (!countSymptoms.containsKey(symptom)) {
				countSymptoms.put(symptom, 1);
			} else {
				int count = countSymptoms.get(symptom);
				countSymptoms.put(symptom, count + 1);
			}
		}
		System.out.println("end");
		return countSymptoms;
	}

	public static void main(String args[]) throws Exception {
		AnalyticsCounter analyticsCouter = new AnalyticsCounter();
		analyticsCouter.start();
	}
}
