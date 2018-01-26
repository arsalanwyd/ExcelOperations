package com.xl.main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.xl.dao.StudentDatabase;

public class App {
	public static void main(String[] args) throws IOException, SQLException {
		//StudentDatabase.createDummyDatabase();
		String current = System.getProperty("user.dir");
		String file = current+"\\Student Details.xlsx";
		System.out.println("File ="+file);
		ExcelFileOperation.databaseToExcel(new File(file));
		System.out.println("Succes");
	}
}
