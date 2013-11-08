package com.jeremie.client;

import java.util.Random;

import com.jeremie.dao.Bank;
import com.jeremie.entity.Account;
import com.jeremie.service.UserService;

public class Client {

	public final static Bank _bank = new Bank();
	public static UserService _userservice = new UserService();
	
	public static void main(String[] args) {
		addUser();
		deleteUser();
		User1();
		User2();
		print();
		
	}
	
	//创建十个对象
	public static void addUser() {
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			int s = java.lang.Math.abs(random.nextInt()%10);
			String iD = "10000000000" + s;
			if(checkID(iD)){
				System.out.println("id正确");
			}else{
				System.out.println("id错误");
			}
			String name = iD;
			if (random.nextBoolean()){
				if(_userservice.createAccount(iD,name,0,"savingAccount"))
					System.out.println("创建savingAccount账号" + iD );
				else
					System.out.println("创建账号" + iD + "失败");
			}
			else{
				if(_userservice.createAccount(iD,name,0,"creditAccount"))
					System.out.println("创建creditAccount账号" + iD );
				else
					System.out.println("创建账号" + iD + "失败");
			}
				
		}
	}
	
	private static boolean checkID(String id) {
		return id.matches("\\d{12}");
	}
	
	//删除,增添用户
	public static void deleteUser() {
		_userservice.deleteAccount("100000000002");
		_userservice.deleteAccount("100000000005");
		_userservice.deleteAccount("100000000009");
		_userservice.createAccount("100000000010","张三",0,"creditAccount");
		_userservice.createAccount("100000000011","李四",0,"creditAccount");
		_userservice.createAccount("100000000012","王五",100,"savingAccount");
	}
	
	//对用户进行操作
	public static void User1() {
		String id = "100000000011";
		Account user = _userservice.getUser(id);
		System.out.println(user.getName() + "的账号");
		user.savemoney(100);
		System.out.println(user.getmoney());
		user.savemoney(213);
		System.out.println(user.getmoney());
		user.savemoney(4564);
		System.out.println(user.getmoney());
		user.savemoney(123.22);
		System.out.println(user.getmoney());
		user.takemoney(500);
		System.out.println(user.getmoney());
		user.takemoney(213);
		System.out.println(user.getmoney());
		user.takemoney(245);
		System.out.println(user.getmoney());
		
	}
	
	public static void User2() {
		Account user = _userservice.getUser("100000000010");
		System.out.println(user.getName() + "的账号");
		user.takemoney(500);
		System.out.println(user.getmoney());
		user.takemoney(213);
		System.out.println(user.getmoney());
	}
	
	//打印信息
	public static void print() {
		System.out.println();
		System.out.println("总账户数：" + _userservice.getUserNum());
		System.out.println("总余额：" + _userservice.SumBankMoney());
		System.out.println("总透支数：" + _userservice.SumBankOverdraftMoney());
		System.out.println("信用卡账户数：" + _userservice.sumCreditAccountNum());
		System.out.println("储蓄账户数：" + _userservice.sumSavingAccountNum());
	}
}
