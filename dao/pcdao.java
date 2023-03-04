package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.pcbean;
import bean.phongbean;

public class pcdao {
	public ArrayList<pcbean> ds= new ArrayList<pcbean>();
	public ArrayList<pcbean> getpc() throws Exception{
		String sql="select * from pc";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String mapc=rs.getString("mamay");
			String tenpc=rs.getString("tenmay");
			String tenphong=rs.getString("tenphong");
			String main=rs.getString("main");
			String bxl=rs.getString("bxl");
			String carddh=rs.getString("carddh");
			int ram=rs.getInt("ram");
			int manhinh=rs.getInt("manhinh");
			Boolean ttmanhinh =rs.getBoolean("ttmanhinh");
			Boolean chuot =rs.getBoolean("chuot");
			Boolean banphim =rs.getBoolean("banphim");
			Boolean tainghe =rs.getBoolean("tainghe");
			pcbean tk= new pcbean(mapc, tenpc, tenphong, main, bxl, ram, manhinh, carddh, ttmanhinh, chuot, banphim, tainghe);
			ds.add(tk);
		}
		rs.close();
		return ds;
	}
	
	public int Them(String mapc, String tenpc, String tenphong, String main, String bxl, int ram, int manhinh,
			String carddh, boolean ttmanhinh, boolean chuot, boolean banphim, boolean tainghe) throws Exception{
		//b1
		String sql="INSERT pc (mamay, tenmay, tenphong,  main,  bxl,  ram,  manhinh,"
				+ "carddh,  ttmanhinh,  chuot,  banphim,  tainghe) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		cmd.setString(1,mapc);
		cmd.setString(2,tenpc);
		cmd.setString(3,tenphong);
		cmd.setString(4,main);
		cmd.setString(5,bxl);
		cmd.setInt(6,ram);
		cmd.setInt(7,manhinh);
		cmd.setString(8,carddh);
		cmd.setBoolean(9,ttmanhinh);
		cmd.setBoolean(10,chuot);
		cmd.setBoolean(11,banphim);
		cmd.setBoolean(12,tainghe);
		return cmd.executeUpdate();
	}
	public int Xoa(String mamay) throws Exception {
		//b1: Tao cau lenh sql
		String sql="delete from pc where mamay=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		cmd.setString(1,mamay);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}
	public int Sua(String mapc, String tenpc, String tenphong, String main, String bxl, int ram, int manhinh,
			String carddh, boolean ttmanhinh, boolean chuot, boolean banphim, boolean tainghe) 
			throws Exception {
		//b1: Tao cau lenh sql
		String sql="update pc set tenmay=?, tenphong=?, main=?, bxl=?, carddh=?, ram=?, manhinh=?, ttmanhinh=?, chuot=?, banphim=?, tainghe=? where mamay=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		cmd.setString(12,mapc);
		cmd.setString(1,tenpc);
		cmd.setString(2,tenphong);
		cmd.setString(3, main);
		cmd.setString(4,bxl);
		cmd.setInt(6,ram);
		cmd.setInt(7,manhinh);
		cmd.setString(5,carddh);
		cmd.setBoolean(8,ttmanhinh);
		cmd.setBoolean(9,chuot);
		cmd.setBoolean(10,banphim);
		cmd.setBoolean(11,tainghe);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}

}
