package org.great.entity;

public class UntreatedInfo {
	private int id;
	private String type;
	private String administrator;
	private String time;
	private String operation;
	
	
	public UntreatedInfo() {
		super();
	}
	public UntreatedInfo(int id,String type, String administrator, String time, String operation) {
		super();
		this.id = id;
		this.type = type;
		this.administrator = administrator;
		this.time = time;
		this.operation = operation;
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
	public String getAdministrator() {
		return administrator;
	}
	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	@Override
	public String toString() {
		return "UntreatedInfo [id=" + id + ", type=" + type + ", administrator=" + administrator + ", time=" + time
				+ ", operation=" + operation + "]";
	}
	
	
	
}
