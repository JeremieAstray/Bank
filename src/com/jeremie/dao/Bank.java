package com.jeremie.dao;

import java.util.Map;
import java.util.TreeMap;

import com.jeremie.entity.Account;
import com.jeremie.entity.CreditAccount;
import com.jeremie.entity.SavingAccount;

public class Bank {

	private Map<String, Account> users;
	
	public Bank() {
		this.users = new TreeMap<String, Account>();
	}

	//type=savingAccountΪsavingAccount,type=creditAccountΪcreditAcount
	public void createUser(Account user){
		users.put(user.getID(), user);
	}

	public boolean checkUser(String ID) {
		return users.containsKey(ID);
	}
	
	public void deleteUser(String ID) {
		users.remove(ID);
	}
	
	public double sumBankMoney() {
		double sum = 0;
		for (Account entry : users.values()) {
			sum += entry.getmoney();
		}
		return sum;
	}

	public double sumBankOverdraftMoney() {
		double sum = 0;
		for (Account entry : users.values()) {
			if (entry.getmoney() < 0.001)
				sum += entry.getmoney();
		}
		return sum;
	}

	public int getUserNum() {
		return users.size();
	}

	public int sumCreditAccountNum() {
		int sum = 0;
		for (Account entry : users.values()) {
			if (entry instanceof CreditAccount)
				sum++;
		}
		return sum;
	}

	public int sumSavingAccountNum() {
		int sum = 0;
		for (Account entry : users.values()) {
			if (entry instanceof SavingAccount)
				sum++;
		}
		return sum;
	}

	public Account getUser(String ID) {
		return users.get(ID);
	}
}
