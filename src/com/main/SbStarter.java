package com.main;


public class SbStarter {
	
	public static void main(String[] args) 
	{
		SbThread t = new SbThread();
		t.generateFirstTurn();
		
		t.printRest();
	}
}
