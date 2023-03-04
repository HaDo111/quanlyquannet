package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.dangnhapbean;
import bean.phongbean;

public class phongdao {
	public ArrayList<phongbean> ds= new ArrayList<phongbean>();
	public ArrayList<phongbean> getphong() throws Exception{
		String sql="select * from phongmay";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String maphong=rs.getString("maphong");
			String tenphong=rs.getString("tenphong");
			int slmay=rs.getInt("slmay");
			String tang=rs.getString("tang");
			phongbean tk= new phongbean(maphong, tenphong, slmay, tang);
			ds.add(tk);
		}
		rs.close();
		return ds;
	}
	
	public int Them(String maphong, String tenphong, int slmay,String tang) throws Exception{
		//b1
		String sql="INSERT phongmay (maphong, tenphong, slmay, tang) VALUES (?,?,?,?)";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		cmd.setString(1,maphong);
		cmd.setString(2,tenphong);
		cmd.setInt(3,slmay);
		cmd.setString(4, tang);
		return cmd.executeUpdate();
	}
	public int Xoa(String maphong) throws Exception {
		//b1: Tao cau lenh sql
		String sql="delete from phongmay where maphong=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		cmd.setString(1,maphong);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}
	public int Sua(String maphong, String tenphong, int slmay,String tang) throws Exception {
		//b1: Tao cau lenh sql
		String sql="update phongmay set tenphong=?, slmay=?, tang=? where maphong=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		cmd.setString(4,maphong);
		cmd.setString(1,tenphong);
		cmd.setInt(2,slmay);
		cmd.setString(3, tang);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}
}
