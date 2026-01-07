package com.ram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ram.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final String INSERT_QUERY = "INSERT INTO EMPLOYEE (ID,NAME,GENDER,SALARY) VALUES(?, ?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE EMPLOYEE SET NAME = ?,GENDER = ?,SALARY = ? WHERE ID = ?";
	private static final String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE ID = ?";
	private static final String SELECT_BY_ID = "SELECT * FROM EMPLOYEE WHERE ID = ?";
	private static final String SELECT_BY_NAME = "SELECT * FROM EMPLOYEE WHERE NAME = ?";
	private static final String SELECT_QUERY = "SELECT * FROM EMPLOYEE";

	static Connection connection = null;
	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "sunny@123");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveEmpByPS(Employee e) {
		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO EMPLOYEE (ID,NAME,GENDER,SALARY) VALUES(?, ?,?,?)")) {

			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getGender());
			ps.setInt(4, e.getSalary());

			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void updateEmpByPS(Employee e) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
		ps.setString(1, e.getName());
		ps.setString(2, e.getGender());
		ps.setInt(3, e.getSalary());
		ps.setInt(4, e.getId());

		ps.executeUpdate();

	}

	@Override
	public void deleteEmpByIdByPS(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);

		ps.setInt(1, id);

		// execute delete
		int count = ps.executeUpdate();

		if (count > 0) {
			System.out.println("Employee deleted successfully, ID = " + id);
		} else {
			System.out.println("Employee not found, ID = " + id);
		}

	}

	@Override
	public Employee getEmpByIdByPS(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();

		Employee e = new Employee();

		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setGender(rs.getString(3));
		e.setSalary(rs.getInt(4));

		System.err.println(String.format(SELECT_BY_ID, id));

		return e;
	}

	@Override
	public Employee getEmpByNameByPS(String name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_NAME);
		ps.setString(1, name);
		ResultSet resultSet = ps.executeQuery();
		Employee e = null;
		if (resultSet.next()) {

			e = new Employee();

			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setGender(resultSet.getString(3));
			e.setSalary(resultSet.getInt(4));
		}

		System.err.println(String.format(SELECT_BY_NAME, name));

		return e;
	}

	@Override
	public void printEmpByNameByPS(String name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(SELECT_BY_NAME);
		ps.setString(1, name);

		ResultSet resultSet = ps.executeQuery();

		while (resultSet.next()) {
			System.out.println("ID = " + resultSet.getInt(1) + "\t NAME = " + resultSet.getString(2) + "\t GENDER = "
					+ resultSet.getString(3) + "\t SALARY = " + resultSet.getInt(4));
		}
		System.err.println(String.format(SELECT_BY_NAME, name));

	}

	@Override
	public List<Employee> getAllEmpsByPS() throws SQLException {
		List<Employee> list = new ArrayList<Employee>();

		PreparedStatement pr = connection.prepareStatement(SELECT_QUERY);
		ResultSet resultSet = pr.executeQuery();

		while (resultSet.next()) {
			Employee e = new Employee();

			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setGender(resultSet.getString(3));
			e.setSalary(resultSet.getInt(4));

			list.add(e);
		}
		return list;
	}

	@Override
	public void printAllEmpsByPS() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
//		statement.executeQuery(SELECT_QUERY);
		ResultSet resultSet = ps.executeQuery();

		while (resultSet.next()) {
			System.out.println("ID = " + resultSet.getInt(1) + "\t NAME = " + resultSet.getString(2) + "\t GENDER = "
					+ resultSet.getString(3) + "\t SALARY = " + resultSet.getInt(4));
		}

		System.err.println(SELECT_QUERY);

	}

}
