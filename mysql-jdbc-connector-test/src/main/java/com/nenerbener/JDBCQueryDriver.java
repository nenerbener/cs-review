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
		
//	create statement
	StringBuilder sb = new StringBuilder("SELECT students.student_id,"); 
	sb.append(" CONCAT(students.first_name, \" \", students.last_name) AS Name,");
	sb.append(" COUNT(absences.date) AS Absences");
	sb.append(" FROM students LEFT JOIN absences");
	sb.append(" ON students.student_id = absences.student_id");
	sb.append(" GROUP BY students.student_id;");
	String sbFinal = sb.toString();
//		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc.mysql://localhost:3306/school_records", "root", "q");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sbFinal);
		System.exit(0);
		
	}

}
