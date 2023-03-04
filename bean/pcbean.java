package bean;

public class pcbean {
	private String mapc;
	private String tenpc;
	private String tenphong;
	private String main;
	private String bxl;
	private int ram;
	private int manhinh;
	private String carddh;
	private boolean ttmanhinh,chuot,banphim,tainghe;
	public String getMapc() {
		return mapc;
	}
	public void setMapc(String mapc) {
		this.mapc = mapc;
	}
	public String getTenpc() {
		return tenpc;
	}
	public void setTenpc(String tenpc) {
		this.tenpc = tenpc;
	}
	public String getTenphong() {
		return tenphong;
	}
	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getBxl() {
		return bxl;
	}
	public void setBxl(String bxl) {
		this.bxl = bxl;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getManhinh() {
		return manhinh;
	}
	public void setManhinh(int manhinh) {
		this.manhinh = manhinh;
	}
	public String getCarddh() {
		return carddh;
	}
	public void setCarddh(String carddh) {
		this.carddh = carddh;
	}
	public boolean isTtmanhinh() {
		return ttmanhinh;
	}
	public void setTtmanhinh(boolean ttmanhinh) {
		this.ttmanhinh = ttmanhinh;
	}
	public boolean isChuot() {
		return chuot;
	}
	public void setChuot(boolean chuot) {
		this.chuot = chuot;
	}
	public boolean isBanphim() {
		return banphim;
	}
	public void setBanphim(boolean banphim) {
		this.banphim = banphim;
	}
	public boolean isTainghe() {
		return tainghe;
	}
	public void setTainghe(boolean tainghe) {
		this.tainghe = tainghe;
	}
	public pcbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public pcbean(String mapc, String tenpc, String tenphong, String main, String bxl, int ram, int manhinh,
			String carddh, boolean ttmanhinh, boolean chuot, boolean banphim, boolean tainghe) {
		super();
		this.mapc = mapc;
		this.tenpc = tenpc;
		this.tenphong = tenphong;
		this.main = main;
		this.bxl = bxl;
		this.ram = ram;
		this.manhinh = manhinh;
		this.carddh = carddh;
		this.ttmanhinh = ttmanhinh;
		this.chuot = chuot;
		this.banphim = banphim;
		this.tainghe = tainghe;
	}

	
}
