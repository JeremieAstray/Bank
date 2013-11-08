package com.jeremie.entity;

public class CreditAccount extends Account {

	private double overdraft = 1000;

	public CreditAccount(String iD, String name, double money) {
		super(iD, name, money);
		// TODO Auto-generated constructor stub
	}

	@Override
	// ȡǮ
	public boolean takemoney(double money) {
		if (java.lang.Math.abs(this.money + overdraft - money) < 0.001) {
			return false;
		}
		this.money -= money;
		return true;
	}
}
