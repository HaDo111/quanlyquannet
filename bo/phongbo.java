package bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.phongbean;
import dao.phongdao;


public class phongbo {
	phongdao phongdao = new phongdao();
	ArrayList<phongbean> ds;
	public ArrayList<phongbean> getphong() throws Exception{
		ds= phongdao.getphong();
		return ds;
	}
	public int Them(String maphong, String tenphong, int slmay,String tang) throws Exception {
		//Kiem tra trung ma
		for(phongbean tdn: ds)
			if(tdn.getMaphong().equals(maphong))
			{
				JOptionPane.showMessageDialog(null, "Phong Da Ton Tai");
				return 0;
			}
		ds.add(new phongbean(maphong,  tenphong,  slmay, tang));//Them vao bonho
		phongdao.Them(maphong,  tenphong,  slmay, tang);//Them vao csdl
		return 1;
	}
	public int Xoa(String maphong) throws Exception {
		int t = JOptionPane.showConfirmDialog(null, "Ban co chac chac muon xoa?");
		if(t==0) {
		for(phongbean dv: ds)
			if(dv.getMaphong().equals(maphong)) {
				//Xoa trong bo nho
				ds.remove(dv);
				//Xoa trong csdl
				phongdao.Xoa(maphong);
				return 1;
			}
		}
		return 0;		
	}
	public int Sua (String maphong, String tenphong,int slmay,String tang) throws Exception {
		int t = JOptionPane.showConfirmDialog(null, "Ban co chac chac muon sua?");
		if(t==0) {
		for(phongbean dv: ds)
			if(dv.getMaphong().equals(maphong)) {
				//Sua trong bo nho
				dv.setMaphong(maphong);
				dv.setTenphong(tenphong);
				dv.setSlmay(slmay);
				dv.setTang(tang);
				//Sua trong csdl
				phongdao.Sua(maphong, tenphong,slmay,tang);
				return 1;
			}
		}
		return 0;
	}
	public ArrayList<phongbean> timkiem(String key) throws Exception{
		ArrayList<phongbean> tam = new ArrayList<phongbean>();
		int n=ds.size();
		for(int i=0;i<n;i++)
		{
			phongbean h=ds.get(i);
			if(h.getMaphong().toLowerCase().contains(key.toLowerCase())||h.getTenphong().toLowerCase().contains(key.toLowerCase())) 
			{
				tam.add(h);
			}
			
		}
		return tam;
	}
}
