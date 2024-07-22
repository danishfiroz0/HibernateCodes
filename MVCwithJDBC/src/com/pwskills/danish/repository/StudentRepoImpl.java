package com.pwskills.danish.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pwskills.danish.dto.StudentBo;
import com.pwskills.danish.utility.JDBCUtil;

public class StudentRepoImpl implements IStudentRepo {
	
	private static Connection connection = null;
	private static final String SQL_INSERT_QUERY = "insert into studenttt(`sname`, `sage`, `saddress`,`status`) values(?, ?, ?, ?)";
	private static final String SQL_SELECT_QUERY = "select sid, sname, sage, saddress from studenttt where sid = ?";
	private static final String SQL_DELETE_QUERY = "delete from studenttt where sid = ?";
	private static final String SQL_UPDATE_QUERY = "update studenttt set sid=?, sname=?, sage=? ,saddress=?, status = ? where sid=?";
	private static PreparedStatement insertPstmt = null;
	private static PreparedStatement selectPstmt = null;
	private static PreparedStatement deletePstmt = null;
	private static PreparedStatement updatePstmt = null;
	
	
	
	
	static {
		try {
			connection = JDBCUtil.getDBConnection();  //Logical connection
			if(connection!= null) {
				insertPstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			}
			
			if(connection != null) {
				selectPstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			}
			if(connection != null) {
				deletePstmt = connection.prepareStatement(SQL_DELETE_QUERY);
			}
			if(connection != null) {
				updatePstmt = connection.prepareStatement(SQL_UPDATE_QUERY);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String insertRecord(StudentBo stdBo) {
		
		String status = " ";
		
		try {
			if (insertPstmt != null) {
				insertPstmt.setString(1, stdBo.getSname());
				insertPstmt.setInt(2, stdBo.getSage());
				insertPstmt.setString(3, stdBo.getSaddress());
				insertPstmt.setString(4, stdBo.getStatus());
				
				System.out.println("*****USING BO TO PERFORM PERSISTENCE OPERATION****");
				int rowAffected = insertPstmt.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} 
			}
		} catch (SQLException se) {
			int errorCode = se.getErrorCode();
			if (errorCode == 1064) {
				status = "some error in db operation";
			} else if (errorCode == 2006) {
				status = "connection lost at dbside";
			} else if (errorCode == 1045) {
				status = "acess denied for the user wrong credentialsm";
			} else if (errorCode == 1044) {
				status = "access denied for the user to database";
			} else {
				status = "Some Error at database side";
			}
			System.out.println(se);
		} catch(Exception e) {
			System.out.println("some unknown exception");
		}
		return status;
		
	}

	@Override
	public StudentBo readRecord(int sid) {
		
		StudentBo stdBo = null;
			try {
				if(selectPstmt != null) {
					selectPstmt.setInt(1, sid);
					ResultSet resultSet = selectPstmt.executeQuery();	
					
					//convert resultSet to BO
					if(resultSet != null) {
						while(resultSet.next()) {
							stdBo = new StudentBo();
							stdBo.setSid(resultSet.getInt(1));
							stdBo.setSname(resultSet.getString(2));
							stdBo.setSage(resultSet.getInt(3));
							stdBo.setSaddress(resultSet.getString(4));
						}
					}
				}
			} catch (SQLException e) {
				System.out.println("Some unknown exception");
			}
			System.out.println(stdBo);
			return stdBo;
	}

	@Override
	public String delelteRecord(int sid)  {
		String status = "";
		
		StudentBo stdBo = readRecord(sid);
		if(stdBo != null) {
			try {
				deletePstmt.setInt(1, sid);
				deletePstmt.executeUpdate();
				status = "record deleted successfully";
			} catch (SQLException e) {
				status = "some unknown exception";
			}
		} else {
			status = "no record to delete";
		}
		return status;
	}

	@Override
	public String updateRecord(StudentBo studentBo) {
		
		String status = "";
		
		try {
			updatePstmt.setInt(1, studentBo.getSid());
			updatePstmt.setString(2, studentBo.getSname());
			updatePstmt.setInt(3, studentBo.getSage());
			updatePstmt.setString(4, studentBo.getSaddress());
			updatePstmt.setString(5, studentBo.getStatus());
			updatePstmt.setInt(6, studentBo.getSid());
			
			int rowAffected = updatePstmt.executeUpdate();
			if(rowAffected == 1) {
				status = "update successful";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			status = "some unknown exception";
		}
		return status;
	}
}
