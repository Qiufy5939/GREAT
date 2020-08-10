package org.great.entity;

public class TreatedInfo {
	private int id;
	private String type;
	private String content;
	private String applicant;
	private String application_date;
	private String checker;
	private String check_date;
	private String result;
	
	
	public TreatedInfo() {
		super();
	}
	
	public TreatedInfo(int id, String type, String content, String applicant, String application_date, String checker,
			String check_date, String result) {
		super();
		this.id = id;
		this.type = type;
		this.content = content;
		this.applicant = applicant;
		this.application_date = application_date;
		this.checker = checker;
		this.check_date = check_date;
		this.result = result;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getApplication_date() {
		return application_date;
	}
	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getCheck_date() {
		return check_date;
	}
	public void setCheck_date(String check_date) {
		this.check_date = check_date;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
