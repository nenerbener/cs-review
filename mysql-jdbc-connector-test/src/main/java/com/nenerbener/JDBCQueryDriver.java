/**
 * 
 */
package com.nenerbener;

import java.sql.*;

/**
 * A simple driver to connect to localhost:3306 school_records database and perform queries
 * @author mm
 * @version 0.01
 */
public class JDBCQueryDriver {

	/**c
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Connection con = null;

		//Register driver class
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} 
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} 

		//	create statement
		StringBuilder sb = new StringBuilder("SELECT students.student_id,"); 
		sb.append(" CONCAT(students.first_name, \" \", students.last_name) AS Name,");
		sb.append(" COUNT(absences.date) AS Absences");
		sb.append(" FROM students LEFT JOIN absences");
		sb.append(" ON students.student_id = absences.student_id");
		sb.append(" GROUP BY students.student_id;");
		String sbFinal = sb.toString();
		
		// create a connection
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_records?user=root&password=q");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// perform query and return result set
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sbFinal);

		// output
		while (rs.next()) {
			System.out.print("student_id: " + rs.getInt("students.student_id"));
			System.out.print("  student name: " + rs.getString("Name"));
			System.out.print("  absences: " + rs.getInt("Absences"));
			System.out.println();
		}
		
		System.exit(0);
		
	}
}
