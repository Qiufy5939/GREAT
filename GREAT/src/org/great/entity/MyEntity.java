package org.great.entity;

import java.util.List;

public class MyEntity {
	private List<UntreatedInfo> untreatedInfos;
	private List<TreatedInfo> treatedInfos;
	
	
	
	
	public MyEntity() {
		super();
	}
	public MyEntity(List<UntreatedInfo> untreatedInfos, List<TreatedInfo> treatedInfos) {
		super();
		this.untreatedInfos = untreatedInfos;
		this.treatedInfos = treatedInfos;
	}
	public List<UntreatedInfo> getUntreatedInfos() {
		return untreatedInfos;
	}
	public void setUntreatedInfos(List<UntreatedInfo> untreatedInfos) {
		this.untreatedInfos = untreatedInfos;
	}
	public List<TreatedInfo> getTreatedInfos() {
		return treatedInfos;
	}
	public void setTreatedInfos(List<TreatedInfo> treatedInfos) {
		this.treatedInfos = treatedInfos;
	}
	
	
}
