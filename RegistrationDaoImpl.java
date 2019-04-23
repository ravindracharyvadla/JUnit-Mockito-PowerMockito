package com.companyname.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.companyname.model.RegistrationModel;

public class RegistrationDaoImpl implements RegistrationDao{

	private static final String db_username="root";
	private static final String db_password="root";
	private static final String db_driverClass="com.mysql.jdbc.Driver";
	private static final String db_url="jdbc:mysql://localhost:3306/companydb";
	
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	
	@Override
	public void registration(RegistrationModel regmodel) {
		
		try{
			Class.forName(db_driverClass);
			connection=DriverManager.getConnection( db_url,db_username, db_password);
			
			String insertQuery="insert into registrationtable values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1, regmodel.getEmployeeId());
			preparedStatement.setString(2, regmodel.getUserName());
			preparedStatement.setString(3, regmodel.getPassword());
			preparedStatement.setString(4, regmodel.getEmailId());
			preparedStatement.setString(5, regmodel.getContactNumber());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Data has been successfully inserted.");
			
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
