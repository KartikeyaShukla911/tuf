package com.tuf.binarySearch;

public class MediaOfSortedArrays {

    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(b, a);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
        /*
         * log(min(n1,n2))
         */
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + medianOfTwoSortedArray(a, b));
    }
    
    public static int findMedian(int[] a,int[] b)
    {
    	int n1=a.length,n2=b.length;
    	if(n1<n2)
    		return findMedian(b,a);
    	
    	int left = (n1+n2+1)/2;
    	int low=0, high =n1;
    	int n = n1+n2+1/2;
    	while(low<=high)
    	{
    		int mid1 = (low+high)/2;
    		int mid2 = high-left;
    		
    		int l1 = mid1>0 ? a[mid1-1] : Integer.MIN_VALUE;
    		int l2 = mid2>0 ? b[mid2-1] : Integer.MIN_VALUE;
    		int r1 = mid1<n1 ? a[mid1] : Integer.MAX_VALUE;
    		int  r2 = mid2<n2 ? a[mid2] : Integer.MAX_VALUE;
    		
    		if(l1<=r1 && l2<=r2)
    		{
    			if(n%2==1)
    				return (l1+l2)/2;
    			else
    				return (int)(Math.max(l1, l2) + Math.min(r1, r2))/2;
    		}
    		else if(l1>r2)
    			high = mid1-1;
    		else
    			low = mid1+1;
    	}
    	return 0;
    	
    }

    	public static int findMedianArr(int[] a,int[] b)
    	{
    		int n1=a.length,n2=b.length;
    		if(n1<n2)
    			return findMedianArr(b,a);
    		
    		int n = (n1+n2+1)/2;
    		int left = (n1+n2+1)/2;
    		int low=0,high=n1;
    		while(low<=high)
    		{
    			int mid1 = (low+high)/2;
    			int mid2 = high-left;
    			
    			int l1 = mid1>0 ? a[mid1-1] : Integer.MIN_VALUE;
    			int l2 = mid2>0 ? b[mid2-1]: Integer.MIN_VALUE;
    			int r1= mid1<n1 ? a[mid1]: Integer.MAX_VALUE;
    			int r2 = mid2<n2 ? b[mid2]: Integer.MAX_VALUE;
    			
    			
    			if(l1<=r2 && l2<=r1) {
    			if(n%2==1)
    			{
    				return Math.max(l1, l2);
    			}
    			else
    			{
    				return (Math.max(l1, l2) + Math.min(r1, r2))/2;
    			}
    			}else if(l1>r2)
    				high = mid1-1;
    			else
    				low = mid1+1;
    		}
    		return 0;
    	}
    	
    	public static int medianOfTwoSortedArray(int[] a,int[] b)
    	{
    		int n1=a.length,n2=b.length;
    		if(n1<n2)
    			return medianOfTwoSortedArray(b,a);
    		
    		int n = (n1+n2)>>1;
    		int low=0,high=n1;
    		int left=(n1+n2+1)>>1;
    			
    		while(low<=high)
    		{
    			int mid1 = (high+low)/2;
    			int mid2 = left-mid1;
    			
    			int l1 = mid1>0 ? a[mid1-1] : Integer.MIN_VALUE;
    			int l2 = mid2>0 ? b[mid2-1] : Integer.MIN_VALUE;
    			int r1 = mid1<n1 ? a[mid1] : Integer.MAX_VALUE;
    			int r2 = mid2<n2 ? a[mid2] : Integer.MAX_VALUE;
    			
    			if(l1<=r2 && l2<=r1)
    			{
    				if(n%2==1)
    					return Math.max(l1, l2);
    				else
    					return ((Math.max(l1, l2) + Math.min(r1, r2)))/2;
    			}
    			else if(l1>r2)
    				high = mid1-1;
    			else
    				low = mid1+1;
    		}
    		return -1;
    	}
}
