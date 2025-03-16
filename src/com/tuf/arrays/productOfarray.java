package com.tuf.arrays;

public class productOfarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * worst case
	 * 
	 * for(i=0;i<n;i++)
	 * {
	 * for(j=0;j<m;j++)
	 * {
	 * 	if(i!=j)
	 * 		tmp.add(arr[i]*arr[j]);
	 * }
	 * }
	 */
	
	static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] prefProduct = new int[n];
        int[] suffProduct = new int[n];
        int[] res = new int[n];

        // Construct the prefProduct array
        prefProduct[0] = 1;
        for (int i = 1; i < n; i++)
            prefProduct[i] = arr[i - 1] * prefProduct[i - 1];

        // Construct the suffProduct array
        suffProduct[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--)
            suffProduct[j] = arr[j + 1] * suffProduct[j + 1];

        // Construct the result array using
        // prefProduct[] and suffProduct[]
        for (int i = 0; i < n; i++)
            res[i] = prefProduct[i] * suffProduct[i];

        return res;
    }

}
