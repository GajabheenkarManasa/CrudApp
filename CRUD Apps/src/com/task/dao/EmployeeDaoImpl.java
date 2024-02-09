package com.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.task.bean.EmployeeBean;
import com.task.util.DBUtil;

public class EmployeeDaoImpl implements IEmployeeDao{
	public static PreparedStatement pst = null;
	public static Connection connection = null;
	
	@Override
	public void insertEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		int empId = bean.getEmpId();
		String empName = bean.getEmpName();
		String empAddress = bean.getEmpAddress();
		connection= DBUtil.getDBConnection();
		pst=connection.prepareStatement("insert into employee values(?,?,?)");
		pst.setInt(1, empId);
		pst.setString(2, empName);
		pst.setString(3, empAddress);
		
		pst.execute();
		System.out.println("inserted one record successfully.");
	}
	@Override
	public void updateEmployee(EmployeeBean bean) throws SQLException, ClassNotFoundException {
		int empId = bean.getEmpId();
		String empName = bean.getEmpName();
		String empAddress = bean.getEmpAddress();
		connection = DBUtil.getDBConnection();
		pst = connection.prepareStatement("update employee set empName=?,empAddress=? where empId =?");
		pst.setInt(3, empId);
		pst.setString(1,empName);
		pst.setString(2, empAddress);
		System.out.println(bean);
		pst.executeUpdate();
		System.out.println("Updated Successfully.");
	}
	@Override
	public void selectEmployee(EmployeeBean bean) throws SQLException, ClassNotFoundException {
		int empId = bean.getEmpId();
		//String empName = bean.getEmpName();
		//String empAddress = bean.getEmpAddress();
		
			connection = DBUtil.getDBConnection();
			pst = connection.prepareStatement("select * from employee where empId=?");
			pst.setInt(1, empId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			pst.close();
			System.out.println("One record is selected successfully.");
		
			
	}
	@Override
	public void deleteEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		int empId = bean.getEmpId();
		
		connection = DBUtil.getDBConnection();
		pst = connection.prepareStatement("delete from employee where empId=?");
		pst.setInt(1, empId);
		int rs = pst.executeUpdate();
		if(rs > 0) {
			System.out.println(empId+" record deleted successfully.");
		}else {
			System.out.println("No record found.");
		}
		
		
	}
}
