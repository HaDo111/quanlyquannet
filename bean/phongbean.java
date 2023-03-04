package bean;

public class phongbean {
	private String maphong;
	private String tenphong;
	private int slmay;
	private String tang;
	
	public String getTang() {
		return tang;
	}
	public void setTang(String tang) {
		this.tang = tang;
	}
	public String getMaphong() {
		return maphong;
	}
	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}
	public String getTenphong() {
		return tenphong;
	}
	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}
	public int getSlmay() {
		return slmay;
	}
	public void setSlmay(int slmay) {
		this.slmay = slmay;
	}
	public phongbean(String maphong, String tenphong, int slmay, String tang) {
		super();
		this.maphong = maphong;
		this.tenphong = tenphong;
		this.slmay = slmay;
		this.tang = tang;
	}
	public phongbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
