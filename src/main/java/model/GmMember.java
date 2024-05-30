package model;

public class GmMember {
	private String id;
	private int trader;
	private String pass;
	private String name;
	private String tel;
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTrader() {
		return trader;
	}

	public void setTrader(int trader) {
		this.trader = trader;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "GmMember [id=" + id + ", trader=" + trader + ", pass=" + pass + ", name=" + name + ", tel=" + tel
				+ ", email=" + email + "]";
	}

}
