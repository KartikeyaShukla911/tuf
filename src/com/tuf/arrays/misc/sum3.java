package com.tuf.arrays.misc;

import java.util.Arrays;

public class sum3 {
	
	 public List<List<Integer>> threeSum(int[] nums) {
	        
	        int n = nums.length,i,j,k;

	        Arrays.sort(nums);
	        List<List<Integer>> ans = new ArrayList();
	        for(i=0;i<n-2;i++)
	        {
	            if(i>0 && nums[i]==nums[i-1])
	                continue;
	            
	            j=i+1;k=n-1;
	            while(j<k)
	            {
	                if(nums[j]+nums[i]+nums[k]<0)
	                    j++;
	                
	                else if(nums[i]+nums[j]+nums[k]>0)
	                    k--;
	                
	                else{
	                    
	                        List<Integer> temp = new ArrayList();
	                        temp.add(nums[i]);
	                        temp.add(nums[j]);
	                        temp.add(nums[k]);
	                        j++;
	                        k--;
	                        ans.add(temp);
	                   
	                    while(j<k && nums[j]==nums[j-1])j++;
	                    while(k>j && nums[k]==nums[k+1])k--;
	                }
	            }
	        }
	        return ans;
	    }
	
	public static int countsum3(int arr[])
	{
		int i,j,n=arr.length,cnt=0;
		if(n<3)
			return 0;
		Arrays.sort(arr);
		
		int low=0,high=n-1;
		for(i=0;i<n;i++)
		{
			low = i+1;
			high=n-1;
			while(low<high)
			{
				int temp = arr[i]+arr[low]+arr[high];
				if(temp==0)
					cnt++;
				
				else if(temp<0)
				{
					low++;
				}
				else
					high--;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
