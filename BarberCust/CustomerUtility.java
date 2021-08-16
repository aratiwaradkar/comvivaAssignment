package com.accodigi.demo;

import java.util.Date;

public class CustomerUtility implements Runnable {
	Shop shop;
	

	public CustomerUtility(Shop shop) {
		super();
		this.shop = shop;
	}


	@Override
	public void run() {
		while (0 == 0) {
			// TODO Auto-generated method stub
			Customer cust = new Customer(shop);
			cust.setInTime(new Date());

			Thread custUtil = new Thread(cust);
			cust.setName("Cust"+custUtil.getId()  );// need to change
			custUtil.start();

			// sleep for 1 sec
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
