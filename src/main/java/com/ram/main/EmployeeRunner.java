package com.ram.main;

import java.sql.SQLException;

import com.ram.dao.EmployeeDao;
import com.ram.dao.EmployeeDaoImpl;
import com.ram.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) throws SQLException {

		EmployeeDao edao = new EmployeeDaoImpl();

		// Persistant object
		Employee emp = new Employee(12, "ritul", "Male", 68000);

//		edao.saveEmp(emp);
//		edao.updateEmp(emp);
		edao.deleteEmpById(10);

		System.out.println("Query execute ..........");

	}

}
