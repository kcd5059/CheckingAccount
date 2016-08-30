package com.ssa.tiy.checkingaccount;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckingAccountTests {
	
	Account account = new Account(111, 100);
	Account account2 = new Account(100);
	Checking checking = new Checking(500);
	Savings savings = new Savings(222, 1000);

	@Test
	public void test() {
		// Account tests
		//Check setDescription method
		account.setDescription("My account");
		assertTrue(account.getDescription().equals("My account"));
		//Test setBalance (constructor I used calls this private method)
		assertEquals(100, account.getBalance(), 0);
		//Test setId method (constructor I used calls this private method)
		assertEquals(111, account.getId());
		//Test withdraw method
		assertEquals(50, account.withdraw(50), 0);
		//Test deposit method
		assertEquals(100, account.deposit(50), 0);
		//Test transferFrom method
		account.transferFrom(account2, 100);
		assertEquals(200, account.getBalance(), 0);
		assertEquals(0, account2.getBalance(), 0);
		//Test withdrawal of negative numbers countermeasure
		assertEquals(200, account.withdraw(-100), 0);
		//Test depositing of negative numbers countermeasure
		assertEquals(200, account.deposit(-100), 0);
		//Test print method
		assertEquals("Account 111 balance is $200.00", account.print());
		
		// Checking tests
		//Test checkNumber initialization
		assertEquals(100, Checking.getLastCheckNumber());
		//Check initialBalance
		assertEquals(500, checking.getBalance(), 0);
		//check withdraw method and subsequent lastCheckNumber incrementing
		assertEquals(250, checking.withdraw(250), 0);
		assertEquals(101, Checking.getLastCheckNumber());
		//Test Checking setters
		Checking.setLastCheckNumber(1000);
		assertEquals(1000, Checking.getLastCheckNumber());
		
		//Savings tests
		//Test calcDepositInterest
		assertEquals(5, savings.calcDepositInterest(4), 0);
		assertEquals(1005, savings.getBalance(), 0);
		//Test setInterestRate
		savings.setInterestRate(30);
		assertEquals(.3, savings.getInterestRate(), 0);
		//Test calcDepositInterest with new interest rate
		assertEquals(150.75, savings.calcDepositInterest(6), 0);
		assertEquals(1155.75, savings.getBalance(), 0);
		//Test minimum balance restriction
		savings.setMinimumBalance(1155.76);
		assertEquals(0, savings.calcDepositInterest(2), 0);
		//Test totalInterestPaid tracking
		assertEquals(155.75, savings.getTotalInterestPaid(), 0);
		//Test print method
		assertEquals("Account 222 balance is $1155.75 (30.0% interest rate) Total to date: $155.75", savings.print());
		
		
		
	}

}
