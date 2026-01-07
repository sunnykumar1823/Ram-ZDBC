package com.ram.main;

import java.sql.SQLException;
import java.util.List;

import com.ram.dao.EmployeeDao;
import com.ram.dao.EmployeeDaoImpl;
import com.ram.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) throws SQLException {

		EmployeeDao edao = new EmployeeDaoImpl();

		// Persistant object
//		Employee emp = new Employee(12, "ritul", "Male", 68000);

//		edao.printAllEmps();
//		
//		System.out.println(edao.getEmpById(12));
//		
//		System.out.println(edao.getEmpByName("ram"));
		// get all employees
		List<Employee> list = edao.getAllEmps();

		for (Employee e : list) {
			System.out.println("ID = " + e.getId() + ", NAME = " + e.getName() + ", GENDER = " + e.getGender()
					+ ", SALARY = " + e.getSalary());
		}

//		edao.printEmpByName("sunny");
//		edao.printEmpByName("sunny 'or' 1=1");

		System.out.println("Query execute ..........");

	}

}
