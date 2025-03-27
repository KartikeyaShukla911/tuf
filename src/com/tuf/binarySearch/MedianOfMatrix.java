package com.tuf.binarySearch;

public class MedianOfMatrix {
	
	/*
	 * median of a row wise, sorted matrix
	 * 
	 * One of the ways is to traverse the whole matrix and count the numbers. But in that case, the time complexity will be high. So, we have to find other ways. It is given that the matrix is row-wise sorted. So, we can apply the concept of upper bound
For every particular row, we will find the upper bound of the current element ‘mid’. The index returned will be the number of smaller or equal elements in that row.
We will do it for each row and add them to get the total number for the whole matrix.
Mathematically, smaller_equal_in_row = upperBound(matrix[row], mid)
	 */
	public static int medianRow(int[][] mat,int n,int m)
	{
		/*
		 * brute is to store all elements to array, and then len of n+1/2;
		 	optimized
		 */ O M log N
	}

	 static int upperBound(int[] arr, int x, int n) {
	        int low = 0, high = n - 1;
	        int ans = n;

	        while (low <= high) {
	            int mid = (low + high) / 2;
	            // maybe an answer
	            if (arr[mid] > x) {
	                ans = mid;
	                // look for a smaller index on the left
	                high = mid - 1;
	            } else {
	                low = mid + 1; // look on the right
	            }
	        }
	        return ans;
	    }

	    static int countSmallEqual(int[][] matrix, int m, int n, int x) {
	        int cnt = 0;
	        for (int i = 0; i < m; i++) {
	            cnt += upperBound(matrix[i], x, n);
	        }
	        return cnt;
	    }

	    static int median(int[][] matrix, int m, int n) {
	        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

	        // point low and high to right elements
	        for (int i = 0; i < m; i++) {
	            low = Math.min(low, matrix[i][0]);
	            high = Math.max(high, matrix[i][n - 1]);
	        }

	        int req = (n * m) / 2;
	        while (low <= high) {
	            int mid = (low + high) / 2;
	            int smallEqual = countSmallEqual(matrix, m, n, mid);
	            if (smallEqual <= req) low = mid + 1;
	            else high = mid - 1;
	        }
	        return low;
	    }

	    public static void main(String[] args) {
	        int[][] matrix = {
	            {1, 2, 3, 4, 5},
	            {8, 9, 11, 12, 13},
	            {21, 23, 25, 27, 29}
	        };
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int ans = median(matrix, m, n);
	        System.out.println("The median element is: " + ans);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    /*
	     * find matrix median of row wise sorted;
	     */

	    /*
	     * take low as arr[i][0] and high as arr[0][i];
	     * ans = nxm /2, use loop, for low<=high
	     * check if mid == low + high /2;
	     * count Number of elements, smaller elements
	     * 
	     */
	    
	    public static int Median(int[][] mat,int n,int m)
	    {
	    	if(n==0 && m==0)
	    		return 0;
	    	if(n==1 && m==1)
	    		return 1;
	    	
	    	int low=0,high=0,i,j;
	    	for(i=0;i<n;i++)
	    	{
	    		low = Math.min(mat[i][0],low);
	    	}
	    	for(i=0;i<m;i++)
	    	{
	    		high = Math.max(mat[0][i],high);
	    	}
	    	
	    	int required = (n *m) /2;
	    	while(low<=high)
	    	{
	    		int mid = (low +high)/2;
	    		
	    		int cntSmall = countSmall(mid,mat,n,m);
	    		if(cntSmall <=required)
	    			low = mid+1;
	    		else
	    			high = mid-1;
	    	}
	    	return low;
	    }
	    
	    public static int countSmall(int mid,int[][] mat,int n,int m)
	    {
	    	int i;
	    	int ans=0;
	    	for(i=0;i<n;i++)
	    	{
	    		ans += upperBond(mat[i],mid,m);
	    	}
	    	return ans;
	    }
	    
	    public static int upperBond(int[] arr,int mid,int cols)
	    {
	    	int low=0,high =cols,ans=0;
	    	while(low<=high)
	    	{
	    		int midS = (low+high)>>1;
	    		if(midS==mid)
	    		{
	    			ans=mid;
	    			low=mid+1;
	    		}
	    		else if (midS>mid)
	    			high=mid;
	    		else
	    			low=mid+1;
	    	}
	    	return ans;
	    }
}
