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
	
	//����ʮ������
	public static void addUser() {
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			int s = java.lang.Math.abs(random.nextInt()%10);
			String iD = "10000000000" + s;
			if(checkID(iD)){
				System.out.println("id��ȷ");
			}else{
				System.out.println("id����");
			}
			String name = iD;
			if (random.nextBoolean()){
				if(_userservice.createAccount(iD,name,0,"savingAccount"))
					System.out.println("����savingAccount�˺�" + iD );
				else
					System.out.println("�����˺�" + iD + "ʧ��");
			}
			else{
				if(_userservice.createAccount(iD,name,0,"creditAccount"))
					System.out.println("����creditAccount�˺�" + iD );
				else
					System.out.println("�����˺�" + iD + "ʧ��");
			}
				
		}
	}
	
	private static boolean checkID(String id) {
		return id.matches("\\d{12}");
	}
	
	//ɾ��,�����û�
	public static void deleteUser() {
		_userservice.deleteAccount("100000000002");
		_userservice.deleteAccount("100000000005");
		_userservice.deleteAccount("100000000009");
		_userservice.createAccount("100000000010","����",0,"creditAccount");
		_userservice.createAccount("100000000011","����",0,"creditAccount");
		_userservice.createAccount("100000000012","����",100,"savingAccount");
	}
	
	//���û����в���
	public static void User1() {
		String id = "100000000011";
		Account user = _userservice.getUser(id);
		System.out.println(user.getName() + "���˺�");
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
		System.out.println(user.getName() + "���˺�");
		user.takemoney(500);
		System.out.println(user.getmoney());
		user.takemoney(213);
		System.out.println(user.getmoney());
	}
	
	//��ӡ��Ϣ
	public static void print() {
		System.out.println();
		System.out.println("���˻�����" + _userservice.getUserNum());
		System.out.println("����" + _userservice.SumBankMoney());
		System.out.println("��͸֧����" + _userservice.SumBankOverdraftMoney());
		System.out.println("���ÿ��˻�����" + _userservice.sumCreditAccountNum());
		System.out.println("�����˻�����" + _userservice.sumSavingAccountNum());
	}
}
