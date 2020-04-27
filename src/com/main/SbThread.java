package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SbThread {
	
	private String[] strings = {"aaaa", "bb", "ccccccccccccc", "dddddd"};

	 List<String> threadOrder = Collections.synchronizedList(new ArrayList());

	public void generateFirstTurn()
	{		
		Random rand = new Random();
		List<Integer> lList = new ArrayList();

		for (int i = 0; i < strings.length; i++)
		{			
			while(true)
			{
				int generatedRand = rand.nextInt(strings.length);			
					if(!lList.contains(generatedRand))
					{
						lList.add(generatedRand);
						
						Thread t = new Thread(new Runnable() 
						{
							@Override
							public void run() 
							{
								// TODO Auto-generated method stub
								String choosenString = strings[generatedRand];
								synchronized(threadOrder) 
								{
										threadOrder.add(choosenString);
								}
								
								System.out.print(choosenString.charAt(0));
							}
						});
						t.start();
						
						try {
							t.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}						
			}
		}
	}
	
	public void printRest()
	{
		// FIND LONGEST WORD AND SET IT TO MAIN LOOP COUNTER
		int counterForLongestWord = threadOrder.get(0).length();
		
		for(int i = 1; i < threadOrder.size(); i++)
		{
			if (threadOrder.get(i).length() > counterForLongestWord)
			{
				counterForLongestWord = threadOrder.get(i).length();
			}
		}
//		System.out.println(counterForLongestWord);
		
		for(int i = 0; i < counterForLongestWord; i++)
		{
			for(int j = 0; j < threadOrder.size(); j++)
			{
				String choosenString = threadOrder.get(j);

				if(choosenString.length() - 1 > i)
				{
// WYPISYWANIE BEZ WATKÓW
										
					System.out.print(choosenString.charAt(i));

					
// MAM TUTAJ PONIZEJ FRAGMENT KODU DO WYPISYWANIA W WATKACH NIESTETY NIE UDALO MI SIE GO URUCHOMIC					
//					Thread t = new Thread(new Runnable() 
//					{
//						@Override
//						public void run() 
//						{
//							// TODO Auto-generated method stub
//							synchronized(threadOrder) 
//							{
//								System.out.print(choosenString.charAt(i));
//							}														
//						}
//					});
//					t.start();
//					
//					try {
//						t.join();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			
			}
		}
	}
}
