package com.xl.main;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xl.dao.Database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class ExcelFileOperation {

	private static String[] header = { "STUDENT_ID", "Maths", "English", "Electronics", "JAVA", "PHP", "TOTAL", "AVERAGE" };

	public static void databaseToExcel(File file) throws IOException, SQLException {
		Connection con = null;
		Database db = new Database();
		Workbook workbook = null;
		String filename = file.getName();
		try {
			if (filename.endsWith(".xls"))
				workbook = new HSSFWorkbook();
			else if (filename.endsWith(".xlsx"))
				workbook = new XSSFWorkbook();
			else {
				System.out.println("Invalid filename!");
				return;
			}
			Sheet sheet = workbook.createSheet();
			try {
				con = db.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM semester2");

				Row rr = sheet.createRow(0);
				for (int i = 0; i < header.length; i++) {
					createHeaderCell(rr, (short) i, header[i]);
				}

				int i = 1;
				while (rs.next()) {
					rr = sheet.createRow(i++);
					for (int j = 0; j < header.length - 2; j++) {
						createDataCell(rr, (short) j, rs.getLong(header[j]));
					}
				}
				rr = sheet.getRow(1);
				Cell total = rr.createCell(6);
				total.setCellType(CellType.FORMULA);
				total.setCellFormula("SUM(B2:F2)");
				Cell avg = rr.createCell(7);
				avg.setCellType(CellType.FORMULA);
				avg.setCellFormula("AVERAGE(B2:F2)");

				FileOutputStream outFile = new FileOutputStream(file);
				workbook.write(outFile);
				outFile.flush();
				outFile.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createHeaderCell(Row row, short col, String cellValue) {
		Cell c = row.createCell(col);
		c.setCellValue(cellValue);
	}

	private static void createDataCell(Row row, short col, Number cellValue) {
		Cell c = row.createCell(col);
		c.setCellType(CellType.NUMERIC);
		c.setCellValue(cellValue.doubleValue());
	}
}