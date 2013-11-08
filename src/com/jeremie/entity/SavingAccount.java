package com.jeremie.entity;

public class SavingAccount extends Account {
	
	public SavingAccount(String iD, String name,double money) {
		super(iD, name,money);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean takemoney(double money) {
		if (java.lang.Math.abs(this.money - money) < 0.001) {
			return false;
		}
		this.money -= money;
		return true;
	}
	
}
