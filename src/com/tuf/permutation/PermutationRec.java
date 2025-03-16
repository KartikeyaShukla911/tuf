package com.tuf.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PermutationRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter number to generate an array with all permutations");
		n=sc.nextInt();
		permutation(n);

	}
	
	public static void permutation(int n)
	{
		if (n<=0)
			return;
		
		List<Integer> arr = new ArrayList();
		List<List<Integer>> ans = new ArrayList();
		
		int i;
		for(i=1;i<=n;i++)
				arr.add(i);
	
		permutationUtil(ans,arr,0);
		
		for(List<Integer> x : ans)
			System.out.println(x);
	}
	
	/*
	 * O - N x N!
	 */
	public static void permutationUtil(List<List<Integer>> ans, List<Integer> arr, int start)
	{
		int n = arr.size();
		if(start==n)
		{
			ans.add(new ArrayList<>(arr));
			return;
		}
		
		int i;
		for(i=start;i<n;i++)
		{
			swapIt(arr, start, i);
			permutationUtil(ans,arr,start+1);
			swapIt(arr, start, i);
		}
	}
	
	public static void swapIt(List<Integer> arr,int i,int j)
	{
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
}
