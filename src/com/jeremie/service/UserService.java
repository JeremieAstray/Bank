package com.jeremie.service;

import com.jeremie.client.Client;
import com.jeremie.entity.Account;
import com.jeremie.entity.CreditAccount;
import com.jeremie.entity.SavingAccount;

public class UserService {
	
	public boolean createAccount(String id, String name, double money,
			String type) {
		if (!checkUser(id) && checkMoney(money)) {
			switch (type) {
			case ("savingAccount"):
				Client._bank.createUser(new SavingAccount(id, name, money));
				return true;
			case ("creditAccount"):
				Client._bank.createUser(new CreditAccount(id, name, money));
				return true;
			}
		}
		return false;
	}

	private boolean checkUser(String id) {
		return Client._bank.checkUser(id);
	}

	private boolean checkMoney(double money) {
		if (money >= 0)
			return true;
		return false;
	}
	
	public boolean deleteAccount(String ID) {
		if(!Client._bank.checkUser(ID)){
			Client._bank.deleteUser(ID);
			return true;
		}
		return false;
	}
	
	public double SumBankMoney(){
		return Client._bank.sumBankMoney();
	}
	
	public double SumBankOverdraftMoney(){
		return Client._bank.sumBankOverdraftMoney();
	}
	public double getUserNum(){
		return Client._bank.getUserNum();
	}
	public double sumCreditAccountNum(){
		return Client._bank.sumCreditAccountNum();
	}
	public double sumSavingAccountNum(){
		return Client._bank.sumSavingAccountNum();
	}
	public Account getUser(String ID){
		return Client._bank.getUser(ID);
	}
}
