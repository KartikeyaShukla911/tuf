package com.tuf.binarySearch;

public class SearchInBinary {
	
	public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int n = arr.size(); // Size of the array.

        // Edge cases:
        if (n == 1)
            return arr.get(0);
        if (!arr.get(0).equals(arr.get(1)))
            return arr.get(0);
        if (!arr.get(n - 1).equals(arr.get(n - 2)))
            return arr.get(n - 1);

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the single element:
            if (!arr.get(mid).equals(arr.get(mid + 1)) && !arr.get(mid).equals(arr.get(mid - 1))) {
                return arr.get(mid);
            }

            // We are in the left:
            if ((mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1)))
                    || (mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))) {
                // Eliminate the left half:
                low = mid + 1;
            }
            // We are in the right:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
        }

        // Dummy return statement:
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	 * Search unique ele, in sorted array
	 * concept is, search the edge cases at 0th and last index
	 * after that, from 1 to n-2, search 
	 * if the mid, mid-1 and mid +1 is not same,
	 * if(mid%2==1, check in mid-1, left OR if mid%2==0, check in mid+1, right;
	 * if true, update low = mid+1;
	 * else update high  = mid=1;
	 * 	 */

}
