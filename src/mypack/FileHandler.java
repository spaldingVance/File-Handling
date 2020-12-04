package mypack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

	static String fileName = "test.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(fileName);

		if (file.createNewFile()) {
			System.out.println("Creating file...");
		} else {
			System.out.println("File already exists!");
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

			writer.write("The quick brown fox jumped over the lazy dog. ");

			writer.append("This text is appeneded.");

			writer.close();

		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			
			String fileContents = reader.readLine();
			System.out.println(fileContents);
			reader.close();

		}

	}

}
