package bean;

public class dangnhapbean {
	private String tendn;
	private String mk;
	public dangnhapbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public dangnhapbean(String tendn, String mk) {
		super();
		this.tendn = tendn;
		this.mk = mk;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	@Override
	public String toString() {
		return "dangnhapbean [tendn=" + tendn + ", mk=" + mk + "]";
	}

	

}
