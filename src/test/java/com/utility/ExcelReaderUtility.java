package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.Users;

public class ExcelReaderUtility {

	public static Iterator<Users> readExcelFile(String fileName) {
		
		File xlsxFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(xlsxFile);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		List<Users> userList = new ArrayList<Users>();
		Row rows;
		Cell firstcell;
		Cell secoundcell;
		Cell thirdcell;
		Users user;
		XSSFSheet sheet = workbook.getSheet("LoginTestData");
		Iterator<Row> row = sheet.iterator();
		row.next();
		while(row.hasNext()) {
			
			rows = row.next();
			firstcell = rows.getCell(0);
			secoundcell = rows.getCell(1);
			thirdcell = rows.getCell(2);
			user = new Users(firstcell.toString(),secoundcell.toString(),thirdcell.toString());
			userList.add(user);

		}
		try {
			workbook.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return userList.iterator();
	}
	

}
