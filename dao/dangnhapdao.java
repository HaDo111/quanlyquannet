package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.dangnhapbean;
public class dangnhapdao {
	public ArrayList<dangnhapbean> ds= new ArrayList<dangnhapbean>();
	//Viet 1 ham doc file vao mang: ds
	public ArrayList<dangnhapbean> gettk() throws Exception{
		String sql="select * from taikhoan";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String tendn=rs.getString("tk");
			String mk=rs.getString("mk");
			dangnhapbean tk= new dangnhapbean(tendn, mk);
			ds.add(tk);
		}
		rs.close();
		return ds;
	}
	public int Them(String tk, String mk) throws Exception {
		//b1: Tao cau lenh sql
		String sql="insert into taikhoan(tk,mk) values (?,?)";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);
		cmd.setString(1,tk);
		cmd.setString(2,mk);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}
	public static void main(String[] args) {
		try {
			dangnhapdao lhdao= new dangnhapdao();
			cosoo cs = new cosoo();
			cs.KetNoi();
			 for(dangnhapbean lh: lhdao.gettk())
				System.out.println( lh.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int Sua(String mkcu, String mkmoi) throws Exception {
		//b1: Tao cau lenh sql
		String sql="update taikhoan set mk=? where mk=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= cosoo.cn.prepareStatement(sql);	
		cmd.setString(1,mkmoi);
		cmd.setString(2,mkcu);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}
}
