package com.tuf.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UniqueSubset {
	
	static List < List<Integer>> subsetUnique(int nums[])
	{
		List<List<Integer>> ans = new ArrayList();
		List<Integer> temp = new ArrayList();
		
		Arrays.sort(nums);
		helper(0,nums.length,ans,temp,nums);
		return ans;
	}
	
	static void helper(int idx,int n,List < List<Integer>> ans,List<Integer> temp,int[] nums)
	{
		if(idx==n)
		{
			Collections.sort(temp);
			ans.add(temp);
			return;
		}

		temp.add(nums[idx]);
		helper(idx+1,n,ans,temp,nums);
		temp.remove(temp.size()-1);
		helper(idx+1,n,ans,temp,nums);
	}
	
	static void printAns(List <List<Integer>>  ans) {
	    System.out.println("The unique subsets are ");
	    System.out.println(ans.toString().replace(","," "));
	}
	 public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
	        ansList.add(new ArrayList<>(ds)); 
	        for(int i = ind;i<nums.length;i++) {
	            if(i!=ind && nums[i] == nums[i-1]) continue; 
	            ds.add(nums[i]); 
	            findSubsets(i+1, nums, ds, ansList); 
	            ds.remove(ds.size() - 1);
	        }
	        
	    }
	    public static List<List<Integer>> subsetsWithDup(int[] nums) {
	        Arrays.sort(nums); 
	        List<List<Integer>> ansList = new ArrayList<>(); 
	        findSubsets(0, nums, new ArrayList<>(), ansList); 
	        return ansList; 
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={1,2,2,3};
		   
		   List < List<Integer>> ans = subsetUnique(nums);
		   System.out.println(ans);
	}

}
