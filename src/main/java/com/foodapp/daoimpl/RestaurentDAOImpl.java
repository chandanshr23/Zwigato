package com.foodapp.daoimpl;

import java.util.*;
import java.sql.*;
import com.foodapp.dao.RestaurentDAO;
import com.foodapp.model.Restaurent;
public class RestaurentDAOImpl  implements RestaurentDAO
{
		Restaurent restaurent;
	    static Connection con;
	    private static PreparedStatement pstmt;
	    private static Statement stmt; 
	    private static ResultSet resultSet;
	    private static  final String INSERT_RESTAURENT="insert into restaurent(restaurent_id,restaurent_name,location,restaurent_mob,restaurent_rating,type) values(?,?,?,?,?,?)";
	    private static final String GET_ALL_RESTAURENT="select * from restaurent";
	    private static final String GET_RESTAURENT_BY_ID="select * from restaurent where restaurent_id=?";
	    private static final String DELETE_RESTAURENT_BY_ID="delete from restaurent where restaurent_id=?";
	    private static final String UPDATE_RESTAURENT_BY_ID="update restaurent set location=? where restaurent_id=?";

	    int x=-1;
	    static {
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery","root","Chandan@8073");
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
		@Override
		public int insertRestaurent(Restaurent restaurent) {
			int x=-1;
			try {
			    pstmt = con.prepareStatement(INSERT_RESTAURENT);
				pstmt.setInt(1,restaurent.getRestaurent_id());
				pstmt.setString(2,restaurent.getRestaurent_name());
				pstmt.setString(3,restaurent.getLocation());
				pstmt.setInt(4,restaurent.getRestaurent_mob());
				pstmt.setFloat(5,restaurent.getRestaurent_rating());
				pstmt.setString(6,restaurent.getType());
				
			    x=pstmt.executeUpdate();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			return x;
		}

		@Override
		public List<Restaurent> getAllRestaurent() {
			List<Restaurent> restaurentList=new ArrayList<>();
			try {
				stmt = con.createStatement();
				resultSet=stmt.executeQuery(GET_ALL_RESTAURENT);
				restaurentList= extractRestaurentListFromResultSet(resultSet);
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return restaurentList;
		}

		@Override
		public Restaurent getRestaurentById(int id) {
			Restaurent restaurent=null;
			try {
				pstmt=con.prepareStatement(GET_RESTAURENT_BY_ID);
				pstmt.setInt(1, id);
				resultSet=pstmt.executeQuery();
				List<Restaurent> restaurentList=extractRestaurentListFromResultSet(resultSet);
				restaurent=restaurentList.get(0);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return restaurent;
		}

		@Override
		public int deleteRestaurentById(int id) {
			try {
				pstmt=con.prepareStatement(DELETE_RESTAURENT_BY_ID);
				pstmt.setInt(1, id);
				x=pstmt.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return x;
		}

		@Override
		public int updateRestaurentById(int id, String location) {
			try {
				pstmt=con.prepareStatement(UPDATE_RESTAURENT_BY_ID);
				pstmt.setInt(2,id);
				pstmt.setString(1,location);
				x=pstmt.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return x;
		}

	List<Restaurent>extractRestaurentListFromResultSet(ResultSet resultSet){
		List<Restaurent> restaurentList=new ArrayList<>();
			try {
				while(resultSet.next())
				{
					restaurentList.add(new Restaurent(resultSet.getInt("restaurent_id"),resultSet.getString("restaurent_name"),
							resultSet.getString("location"),resultSet.getInt("restaurent_mob"),
							resultSet.getFloat("restaurent_rating"),resultSet.getString("type"),resultSet.getString("image")));
			    }
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return restaurentList;
	}
}
