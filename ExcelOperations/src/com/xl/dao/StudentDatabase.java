package com.xl.dao;

import java.sql.*;

public class StudentDatabase {

	public static void createDummyDatabase() throws SQLException {
		Connection con = null;
		Database db = new Database();
		try {
			con = db.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DROP TABLE IF EXISTS goldenelite.semester2");
			stmt.executeUpdate(
					"CREATE TABLE semester2(STUDENT_ID int,Maths INT, English INT, Electronics INT, JAVA INT,"
							+ " PHP INT,PRIMARY KEY(STUDENT_ID))");

			stmt.executeUpdate("insert into semester2 values (23567932,56,78,97,58,85)");
			stmt.executeUpdate("insert into semester2 values (47250001,96,34,75,68,12)");
			stmt.executeUpdate("insert into semester2 values (99568955,45,68,69,78,29)");
			stmt.executeUpdate("insert into semester2 values (89376473,75,23,56,89,47)");
			stmt.executeUpdate("insert into semester2 values (29917740,85,78,55,15,48)");
			stmt.executeUpdate("insert into semester2 values (85776649,23,56,78,25,69)");
			stmt.executeUpdate("insert into semester2 values (38846455,68,95,78,53,48)");
			stmt.executeUpdate("insert into semester2 values (40028826,63,56,48,59,75)");
			stmt.executeUpdate("insert into semester2 values (83947759,85,54,69,36,89)");
			stmt.executeUpdate("insert into semester2 values (92884775,78,59,25,48,69)");
			stmt.executeUpdate("insert into semester2 values (24947389,12,10,14,54,68)");
			stmt.executeUpdate("insert into semester2 values (77399465,44,33,26,88,77)");

			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}