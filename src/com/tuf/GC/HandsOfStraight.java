package com.tuf.GC;

import java.util.TreeMap;

public class HandsOfStraight {
	
	/*
	 * given an array, find k groups such that they are unique and all cards are used
	 */
	
	public static boolean findSuch(int[] arr,int k)
	{
		int n = arr.length;
		if(n%k!=0)
			return false;
		
		TreeMap<Integer,Integer> tm = new TreeMap();
		int i;
		for(i=0;i<n;i++)
		{
			tm.put(arr[i], tm.getOrDefault(arr[i], 0)+1);
		}
		
		while(!tm.isEmpty())
		{
			int firstKey = tm.firstKey();
			for(i=0;i<k;i++)
			{
				int temp = firstKey + i;
				if(!tm.containsKey(temp))
				{
					return false;
				}
				
				tm.put(temp, tm.get(temp)-1);
				
				if(tm.get(temp)==0)
					tm.remove(temp);
			}
		}
		
		return tm.isEmpty()==true?true:false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * chtgpt
	 * 
	 * 
	 */
	public class HandOfStraights {
	    public boolean isNStraightHand(int[] hand, int groupSize) {
	        if (hand.length % groupSize != 0) return false; // If not divisible, can't form groups

	        // Count occurrences of each card
	        TreeMap<Integer, Integer> countMap = new TreeMap<>();
	        for (int card : hand) {
	            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
	        }

	        // Try forming groups
	        while (!countMap.isEmpty()) {
	            int first = countMap.firstKey(); // Get the smallest available card
	            for (int i = 0; i < groupSize; i++) {
	                int card = first + i;
	                if (!countMap.containsKey(card)) return false; // Missing number in sequence
	                
	                // Reduce count, and remove if depleted
	                countMap.put(card, countMap.get(card) - 1);
	                if (countMap.get(card) == 0) {
	                    countMap.remove(card);
	                }
	            }
	        }
	        return true;
	    }
}
