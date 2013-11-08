package com.jeremie.entity;

public class Account {

	private String ID;//ID限定在Bank类里
	private String name;
	protected double money = 0;

	public Account(String iD, String name,double money) {
		ID = iD;
		this.name = name;
		this.money = money;
	}

	//存钱
	public void savemoney(double money) {
		this.money += money;
	}

	//取钱
	public boolean takemoney(double money) {
		this.money -= money;
		return true;
	}

	//看余额
	public double getmoney() {
		return this.money;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	//getter,setter
	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

}