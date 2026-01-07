package com.ram.dao;

import java.sql.SQLException;
import java.util.List;

import com.ram.entity.Employee;

public interface EmployeeDao {

	public void saveEmp(Employee e);

	public void updateEmp(Employee e) throws SQLException;

	public void deleteEmpById(int id) throws SQLException;

	public Employee getEmpById(int id) throws SQLException;

	public Employee getEmpByName(String name) throws SQLException;

	public void printEmpByName(String name) throws SQLException;

	public List<Employee> getAllEmps() throws SQLException;

	public void printAllEmps() throws SQLException;

}
