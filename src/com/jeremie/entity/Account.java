package com.jeremie.entity;

public class Account {

	private String ID;//ID�޶���Bank����
	private String name;
	protected double money = 0;

	public Account(String iD, String name,double money) {
		ID = iD;
		this.name = name;
		this.money = money;
	}

	//��Ǯ
	public void savemoney(double money) {
		this.money += money;
	}

	//ȡǮ
	public boolean takemoney(double money) {
		this.money -= money;
		return true;
	}

	//�����
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