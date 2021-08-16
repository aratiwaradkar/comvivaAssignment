package com.accodigi.demo;

public class MainBarber {
public static void main(String[] ar) {
	
	Shop shop =new Shop(3);//initialize shop with 3 chairs
	Barber barber =new Barber(shop);
	
	CustomerUtility cust =new CustomerUtility(shop);
	Thread t1=new Thread(cust);
	Thread t2=new Thread (barber);
	t1.start();
	t2.start();
	
}
}
