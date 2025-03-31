package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.UserDAO;
import com.foodapp.model.User;

public class UserDAOImpl implements UserDAO
{
	User user=null;
    static Connection con;
    private static PreparedStatement pstmt;
    private static Statement stmt; 
    private static ResultSet resultSet;
    static ArrayList<User> userList=new ArrayList<User>();
    
    private static  final String INSERT_USER="insert into user(user_name,user_email,user_password,user_address) values(?,?,?,?)";
    private static final String GET_ALL_USERS="select * from user";
    private static final String GET_USER_BY_EMAILID="select * from user where user_email=?";
    private static final String GET_USER_BY_ID="select * from user where user_id=?";
    private static final String DELETE_USER_BY_ID="delete from user where user_id=?";
    private static final String UPDATE_USER_BY_ID="update user set  user_address=? where user_id=?";
    int x=-1;
    public UserDAOImpl() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery","root","Chandan@8073");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	@Override
	public int insertUser(User user) {
		int x=0;
		try {
		    pstmt = con.prepareStatement(INSERT_USER);
		    
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getAddress());
			
		    x=pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<User> getAllUser() {
		try {
			stmt = con.createStatement();
			resultSet=stmt.executeQuery(GET_ALL_USERS);
			userList=(ArrayList<User>) extractUserListFromResultSet(resultSet);
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserById(int id) {
		try {
			pstmt=con.prepareStatement(GET_USER_BY_ID);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			userList=(ArrayList<User>) extractUserListFromResultSet(resultSet);
			user=userList.get(0);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deleteUserById(int id) {
		try {
			pstmt=con.prepareStatement(DELETE_USER_BY_ID);
			pstmt.setInt(1, id);
			x=pstmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int updateUserById(int id, String address) {
		try {
			pstmt=con.prepareStatement(UPDATE_USER_BY_ID);
			pstmt.setInt(2,id);
			pstmt.setString(1,address);
			x=pstmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return x;
	}

List<User>extractUserListFromResultSet(ResultSet resultSet){
	userList.clear();
		try {
			while(resultSet.next())
			{
				userList.add(new User(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5),resultSet.getString(6)));
		    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
}

@Override
public User getUserByEmailId(String email) {
	try {
		pstmt=con.prepareStatement(GET_USER_BY_EMAILID);
		pstmt.setString(1,email);
		resultSet=pstmt.executeQuery();
		
		while(resultSet.next()) {
		user=new User(resultSet.getInt("user_id"),resultSet.getString("user_name"),
				resultSet.getString("user_email"),resultSet.getString("user_password"),
				resultSet.getString("user_address"),resultSet.getString("role"));
		}
		} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally {
		try {
			if(resultSet!=null) resultSet.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null)con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return user;
}


}

