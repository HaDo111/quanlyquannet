package bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.dangnhapbean;
import bean.phongbean;
import dao.dangnhapdao;
import view.frmmenu;

public class dangnhapbo {
	dangnhapbean dnbean =new dangnhapbean();
	dangnhapdao dndao = new dangnhapdao();
	ArrayList<dangnhapbean> ds;
	public ArrayList<dangnhapbean> getdn() throws Exception{
		ds= dndao.gettk();
		return ds;
	}
	public int Them(String tk, String mk1, String mk2) throws Exception {
		//Kiem tra trung ma
		for(dangnhapbean tdn: ds)
			if(tdn.getTendn().equals(tk))
			{
				JOptionPane.showMessageDialog(null, "Tai Khoan Da Ton Tai");
				return 0;
			}
			else if(mk1.equals(mk2))
			{
				ds.add(new dangnhapbean(tk, mk1));//Them vao bonho
				dndao.Them(tk, mk1);//Them vao csdl
				JOptionPane.showMessageDialog(null, "Tao Tai Khoan Thanh Cong");
				return 1;
			}
		return 0;
	}
	public int Sua (String mkcu, String mkmoi,String mkmoi2) throws Exception {
		for(dangnhapbean dv: ds)
			if(dv.getMk().equals(mkcu)) {
				//Sua trong bo nho
				if(mkmoi.equals(mkmoi2))
				{
					dv.setMk(mkmoi);
					dndao.Sua(mkcu, mkmoi);
					JOptionPane.showMessageDialog(null, "Doi Mat Khau Thanh Cong");
					
					return 1;
				}
				else
				JOptionPane.showMessageDialog(null, "Doi Mat Khau That Bai");
				
				//Sua trong csdl
				
				return 0;
			}
			else JOptionPane.showMessageDialog(null, "Mat Khau Cu Sai");
		return 0;
	}
	public int kt(String tk, String mk) throws Exception {
	//Kiem tra trung ma
	for(dangnhapbean tdn: ds)
		if(tdn.getTendn().equals(tk)&&tdn.getMk().equals(mk))
		{
			return 1;
		}
	 JOptionPane.showMessageDialog(null, "Username Hoac Mat Khau Khong Chinh Xac");
	 return 0;
	
}
	
}
