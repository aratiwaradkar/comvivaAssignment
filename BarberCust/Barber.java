package com.accodigi.demo;

public class Barber implements Runnable {
	Shop shop;

	public Barber(Shop shop) {
		super();
		this.shop = shop;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// Barber is sleeping till no customer in list
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Barber started to haircut");
		while(0==0) {
			shop.cutHair();
		}
	}

}
