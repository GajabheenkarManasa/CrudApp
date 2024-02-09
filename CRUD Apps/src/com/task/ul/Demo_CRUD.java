package com.task.ul;

import java.sql.SQLException;
import java.util.Scanner;

import com.task.bean.EmployeeBean;
import com.task.service.EmployeeServiceImpl;

public class Demo_CRUD {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Insert employee data.");
		System.out.println("2. Update employee data.");
		System.out.println("3. Select employee data.");
		System.out.println("4. Delete employee data.");
		System.out.println("Select your option: ");
		int option = sc.nextInt();
		switch(option){
		case 1:{
			insertEmployee();
			break;
		}
		case 2:{
			updateEmployee();
			break;
		}
		case 3:{
			selectEmployee();
			break;
		}
		case 4:{
			deleteEmployee();
			break;
		}
		default:{
			System.out.println("Your entered option is wrong.");
		}
		}
}

	private static void deleteEmployee() throws ClassNotFoundException, SQLException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeeBean bean = new EmployeeBean();
		bean.setEmpId(1001);
		service.deleteEmployee(bean);
		
	}

	private static void selectEmployee() throws ClassNotFoundException, SQLException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeeBean bean = new EmployeeBean();
		bean.setEmpId(1001);
		System.out.println(bean);
		service.selectEmployee(bean);
		
	}

	private static void updateEmployee() throws ClassNotFoundException, SQLException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeeBean bean = new EmployeeBean();
		bean.setEmpId(1001);
		bean.setEmpName("Monu");
		bean.setEmpAddress("Siddipet");
		System.out.println(bean);
		service.updateEmployee(bean);
		
		
	}

	private static void insertEmployee() throws ClassNotFoundException, SQLException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeeBean bean = new EmployeeBean();
		bean.setEmpId(1005);
		bean.setEmpName("Sonu");
		bean.setEmpAddress("Kolkata");
		service.insertEmployee(bean);
		
	}
}
