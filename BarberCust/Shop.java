package com.accodigi.demo;

import java.util.LinkedList;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Shop {
	int chairs;
	List custList = new LinkedList<Customer>();

	public Shop(int chairs) {

		this.chairs = chairs;
		this.custList = custList;
	}

	// Get Customer and add to waiting list of Barber shop
	public void addCustomerInShop(Customer cust) {
		System.out.println("Customer " + cust.getName() + " enters in the shop at " + cust.getInTime());
		synchronized (custList) {
			if (custList.size() == chairs) {
				System.out.println("*********No chairs in waiting room for customer " + cust.getName());
				System.out.println("Customer "+cust.getName() + " Exits");
				return;// customer exits
			}
			((LinkedList<Customer>) custList).offer(cust);
			System.out.println("Customer "+cust.getName()+" got the chair.");
			// notify Barber if list has customer
			if (custList.size() > 0)
				custList.notify();
		}
	}

//barber starts to cut hair for customers
	public void cutHair()  {
		Customer currCustomer;
		synchronized (custList) {
			
		
		if (custList.size() == 0) {
			System.out.println("Barber waiting for customer.");
			try {
				custList.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		//pull current customer to cut hair from list
		currCustomer=((LinkedList<Customer>) custList).poll();
		}
		
		long duration=0;
        try
        {    
            System.out.println("Cuting hair of Customer : "+currCustomer.getName());
            duration =1000;//duration for each customer to cut hair
            Thread.sleep(duration);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("***Completed Cuting hair of Customer : "+currCustomer.getName() + " in 1 second.***");
   
		
	}

}
