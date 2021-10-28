package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) throws Exception {

		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Formation openclassrooms\\Développeur d'applications JAVA\\FO_JAVA_P02\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\symptoms.txt"));
		String line = reader.readLine();
		// loop to count symptoms
		int i = 0;
		while (line != null) {
			i++;

			if (line.equals("headache")) {
				headacheCount++;
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.equals("dialated pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
		System.out.println("number of headaches: " + headacheCount);
		System.out.println("number of rash: " + rashCount);
		System.out.println("number of pupils: " + pupilCount);

		// generate file result.out
		FileWriter writer = new FileWriter("C:\\Formation openclassrooms\\Développeur d'applications JAVA\\FO_JAVA_P02\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\src\\\\com\\hemebiotech\\\\analytics\\result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
