package com.tuf.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class nextPermute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> A = Arrays.asList(new Integer[] {2, 1, 5, 4, 3, 0, 0});
	        List<Integer> ans = nextGreaterPermutation(A);

	        System.out.print("The next permutation is: [");
	        for (int i = 0; i < ans.size(); i++) {
	            System.out.print(ans.get(i) + " ");
	        }
	        System.out.println("]");
	}
	
	public static List<Integer> nextGreaterPermutation(List<Integer> arr)
	{
		int flag=-1;
		int i,j,n=arr.size();
		for(i=n-2;i>=0;i--)
		{
			if(arr.get(i)< arr.get(i+1))
			{
				flag=i;
				break;
			}
		}
		
		if(flag==-1)
		{
			Collections.reverse(arr);
			return arr;
		}
		else
		{
			for(i=n-1;i>flag;i--)
			{
				if(arr.get(i)>arr.get(flag))
				{
					//Collections.swap(arr, i, flag);
					int tmp = arr.get(i);
					arr.set(i, arr.get(i));
					arr.set(i, tmp);
	                break;
				}
			}
			
			List<Integer> sublist1 = new ArrayList(arr.subList(i + 1, n));
			List<Integer> sublist2 = new ArrayList(arr.subList(0, i+1));
	        Collections.reverse(sublist1);
	        sublist2.addAll(sublist1);
	        return sublist2;
		}
	}

}
