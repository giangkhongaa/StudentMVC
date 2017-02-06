package com.giang.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class StudentDAO {

	// get string connect with mysql
	public Connection getConnecttion() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudent", "root",
					"giangkhong");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<Student> getListStudent() {
		Connection con=getConnecttion();
		String sql = "SELECT * FROM Student";
		ArrayList<Student> list = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("ID"));
				student.setName(rs.getString("Name"));
				student.setAddress(rs.getString("Address"));
				student.setAge(rs.getInt("Age"));
				list.add(student);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// public static void main(String[] args) throws ClassNotFoundException,
	// SQLException {
	// ArrayList<Student> a = getListStudent();
	// System.out.print(a.get(0).getAddress());
	// }

}
