package com.tuf.arrays.misc;

public class findMissAndReap {
	
	/*
	 * limitations
	 * the n and m
	 * 0<=arr[i]<= nxm+1
	 */
	
public static int[]  findMissingAndRepeatedValues(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[] count = new int[n*m+1];

        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                count[grid[i][j]]++;
            }
        }

        int miss=1,reap=-1;

        for(i=0;i<n*m+1;i++)
        {
            if(count[i]==0)
            {
                miss=i;
            }
            else if(count[i]==2)
                reap = i;
        }

        return new int[]{reap,miss};
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{10,11,12},{13,14,15},{15,16,18}};
		int[] ans = findMissingAndRepeatedValues(arr);
		System.out.println("miss: "+ans[0] + "reap "+ans[1]);
	}

}
