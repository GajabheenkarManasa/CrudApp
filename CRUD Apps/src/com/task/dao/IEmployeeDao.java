package com.task.dao;

import java.sql.SQLException;

import com.task.bean.EmployeeBean;

public interface IEmployeeDao {
	public void insertEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException;

	public void updateEmployee(EmployeeBean bean) throws SQLException, ClassNotFoundException;

	public void selectEmployee(EmployeeBean bean) throws SQLException, ClassNotFoundException;

	void deleteEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException;
	
}
