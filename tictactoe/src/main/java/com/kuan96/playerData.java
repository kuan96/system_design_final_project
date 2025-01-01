package com.kuan96;

public class playerData {
	private String ID;
	
	public playerData() {this.ID = null;}
	
	public void insert_ID(String id) {
		this.ID = id;
	}
	
	public String get_ID()
	{
		return this.ID;
	}
}
