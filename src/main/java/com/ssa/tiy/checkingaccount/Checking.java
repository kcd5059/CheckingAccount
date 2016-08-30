package com.ssa.tiy.checkingaccount;

public class Checking extends Account {
	
	private static int lastCheckNumber = 100;
	
	public Checking(double initialBalance) {
		super(initialBalance);
	}
	
	public double withdraw(double withdrawalAmount) {
		lastCheckNumber++;
		return super.withdraw(withdrawalAmount);
	}

	public static int getLastCheckNumber() {
		return lastCheckNumber;
	}

	public static void setLastCheckNumber(int lastCheckNumber) {
		Checking.lastCheckNumber = lastCheckNumber;
	}
	
	

}
