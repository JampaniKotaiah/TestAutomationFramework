package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVReaderUtility {
	
	public static void main(String[]args) {
		
		File csvFile = new File(System.getProperty("user.dir")+"\\testData\\loginData.csv");
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] data;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();  
			csvReader.readNext();
			data = csvReader.readNext();
			System.out.println(Arrays.toString(data));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
