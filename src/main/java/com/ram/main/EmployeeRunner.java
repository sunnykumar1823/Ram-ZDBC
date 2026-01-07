package com.ram.main;

import java.sql.SQLException;

import com.ram.dao.EmployeeDao;
import com.ram.dao.EmployeeDaoImpl;
import com.ram.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) throws SQLException {

		EmployeeDao edao = new EmployeeDaoImpl();

		Employee emp = new Employee(10, "sunny", "Male", 78000);

//		edao.saveEmpByPS(emp);

//		edao.updateEmpByPS(emp);

//		edao.deleteEmpByIdByPS(13);

//		System.out.println(edao.getEmpByIdByPS(10));

//		System.out.println(edao.getEmpByNameByPS("ram"));

//		edao.printEmpByNameByPS("ram");
//		edao.printEmpByNameByPS("sunny");

//		List<Employee> list = edao.getAllEmpsByPS();
//
//		for (Employee e : list) {
//			System.out.println("ID = " + e.getId() + "\t NAME = " + e.getName() + "\t GENDER = " + e.getGender()
//					+ "\t SALARY = " + e.getSalary());
//		}

//		edao.printAllEmpsByPS();

		edao.batchUpdates();

		System.out.println("Query execute ..........");

	}

}
