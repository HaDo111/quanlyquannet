package bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.pcbean;
import dao.pcdao;


public class pcbo {

	pcdao pcdao = new pcdao();
	ArrayList<pcbean> ds;
	public ArrayList<pcbean> getpc() throws Exception{
		ds= pcdao.getpc();
		return ds;
	}
	public int Them(String mapc, String tenpc, String tenphong, String main, String bxl, int ram, int manhinh,
			String carddh, boolean ttmanhinh, boolean chuot, boolean banphim, boolean tainghe) throws Exception {
		//Kiem tra trung ma
		for(pcbean tdn: ds)
			if(tdn.getMapc().equals(mapc))
			{
				JOptionPane.showMessageDialog(null, "May Da Ton Tai");
				return 0;
			}
		ds.add(new pcbean(mapc, tenpc, tenphong, main, bxl, ram, manhinh, carddh, ttmanhinh, chuot, banphim, tainghe));//Them vao bonho
		pcdao.Them(mapc, tenpc, tenphong, main, bxl, ram, manhinh, carddh, ttmanhinh, chuot, banphim, tainghe);//Them vao csdl
		return 1;
	}
	public int Xoa(String mapc) throws Exception {
		int t = JOptionPane.showConfirmDialog(null, "Ban co chac chac muon xoa?");
		if(t==0) {
		for(pcbean dv: ds)
			if(dv.getMapc().equals(mapc)) {
				//Xoa trong bo nho
				ds.remove(dv);
				//Xoa trong csdl
				pcdao.Xoa(mapc);
				return 1;
			}
		}
		return 0;		
	}
	public int Sua (String mapc, String tenpc, String tenphong, String main, String bxl, int ram, int manhinh,
			String carddh, boolean ttmanhinh, boolean chuot, boolean banphim, boolean tainghe) throws Exception {
		int t = JOptionPane.showConfirmDialog(null, "Ban co chac chac muon sua?");
		if(t==0) {
		for(pcbean dv: ds)
			if(dv.getMapc().equals(mapc)) {
				//Sua trong bo nho
				dv.setMapc(mapc);
				dv.setTenpc(tenpc);
				dv.setTenphong(tenphong);
				dv.setMain(main);
				dv.setBxl(bxl);
				dv.setRam(ram);
				dv.setManhinh(manhinh);
				dv.setCarddh(carddh);
				dv.setTtmanhinh(ttmanhinh);
				dv.setChuot(chuot);
				dv.setBanphim(banphim);
				dv.setTainghe(tainghe);
				//Sua trong csdl
				pcdao.Sua(mapc, tenpc, tenphong, main, bxl, ram, manhinh, carddh, ttmanhinh, chuot, banphim, tainghe);
				return 1;
			}
			}
		return 0;
	}
	public ArrayList<pcbean> timkiem(String key) throws Exception{
		ArrayList<pcbean> tam = new ArrayList<pcbean>();
		int n=ds.size();
		for(int i=0;i<n;i++)
		{
			pcbean h=ds.get(i);
			if(h.getMapc().toLowerCase().contains(key.toLowerCase())||h.getTenpc().toLowerCase().contains(key.toLowerCase()) ) 
			{
				tam.add(h);
			}
			
		}
		return tam;
	}
	public ArrayList<pcbean> timmaphong(String manganh) throws Exception{
		ArrayList<pcbean> tam = new ArrayList<pcbean>();
		int d=0;
		for (pcbean nv:ds)
		{
			if(nv.getTenphong().equalsIgnoreCase(manganh))
			{
				tam.add(nv);
			}
			else d++;
		}
		if(d==ds.size()) JOptionPane.showMessageDialog(null,"Phong Chua Co May");
		return tam;
	}
	public ArrayList<pcbean> mayhong() throws Exception{
		ArrayList<pcbean> tam = new ArrayList<pcbean>();
		for (pcbean nv:ds)
		{
			if(nv.isTtmanhinh()==false||nv.isBanphim()==false||nv.isChuot()==false||nv.isTainghe()==false)
			{
				tam.add(nv);
			}
		}
		return tam;
	}
}
