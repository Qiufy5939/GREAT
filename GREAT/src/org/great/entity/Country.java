package org.great.entity;

public class Country {
	//private int id;
	private String en_name;
	private String cn_name;
	private String capital;
	private String flag;
	private String introduction;
	
	
	public Country() {
		super();
	}


	public Country(String en_name, String cn_name, String capital,String introduction) {
		super();
		this.en_name = en_name;
		this.cn_name = cn_name;
		this.capital = capital;
		this.introduction = introduction;
	}


	public Country(String en_name, String cn_name, String capital, String flag,String introduction) {
		super();
		this.en_name = en_name;
		this.cn_name = cn_name;
		this.capital = capital;
		this.flag = flag;
		this.introduction = introduction;
	}



	public String getEn_name() {
		return en_name;
	}


	public void setEn_name(String en_name) {
		this.en_name = en_name;
	}


	public String getCn_name() {
		return cn_name;
	}


	public void setCn_name(String cn_name) {
		this.cn_name = cn_name;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	public String getIntroduction() {
		return introduction;
	}


	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


	@Override
	public String toString() {
		return "Country [en_name=" + en_name + ", cn_name=" + cn_name + ", capital=" + capital + ", flag=" + flag
				+ ", introduction=" + introduction + "]";
	}


	
	
	
}
