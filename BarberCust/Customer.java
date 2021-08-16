package com.accodigi.demo;

import java.util.Date;

public class Customer implements Runnable {
	private String name;
	private Date inTime;//maintain in time of customer

	Shop shop;

	public Customer(Shop shop) {

		this.shop = shop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		getHairCut();
	}
	
	private synchronized void getHairCut() {
		shop.addCustomerInShop(this);
	}

}
