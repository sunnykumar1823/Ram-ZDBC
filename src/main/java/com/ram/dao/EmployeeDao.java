package com.ram.dao;

import java.sql.SQLException;
import java.util.List;

import com.ram.entity.Employee;

public interface EmployeeDao {

	public void saveEmpByPS(Employee e);

	public void updateEmpByPS(Employee e) throws SQLException;

	public void deleteEmpByIdByPS(int id) throws SQLException;

	public Employee getEmpByIdByPS(int id) throws SQLException;

	public Employee getEmpByNameByPS(String name) throws SQLException;

	public void printEmpByNameByPS(String name) throws SQLException;

	public List<Employee> getAllEmpsByPS() throws SQLException;

	public void printAllEmpsByPS() throws SQLException;

	public void batchUpdates() throws SQLException;

}
