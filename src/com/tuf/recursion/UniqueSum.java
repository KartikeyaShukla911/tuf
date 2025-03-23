package com.tuf.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueSum {

	public static void findComb(int[] arr,int tar,int idx,List<Integer> temp,
			Set<List<Integer>> ans,int n)
	{
		if(idx==n)
		{
			if(tar==0)
			{
				Collections.sort(temp);
				ans.add(new ArrayList(temp));
			}
			return;
		}
		
		
		if(arr[idx]<=tar)
		{
			temp.add(arr[idx]);
			findComb(arr,tar-arr[idx],idx+1,temp,ans,n);
			temp.remove(temp.size()-1);
		}
		findComb(arr,tar,idx+1,temp,ans,n);
	}
	
	/*
	 * O 2^n^k
	 * S k*x
	 */
	static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,1,2,7,6,1,5}; 
        int target = 8;
        Set < List < Integer >> ls = new HashSet();
        List<Integer> temp = new ArrayList();
        findComb(arr,target,0,temp,ls,arr.length);
        System.out.println(ls);
	}

}
