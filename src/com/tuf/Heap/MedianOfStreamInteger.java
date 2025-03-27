package com.tuf.Heap;

public class MedianOfStreamInteger {
	
	// n log n
	  static ArrayList<Double> getMedian(int[] arr) {
	        
	        // Max heap to store the smaller half of numbers
	        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);
	        
	        // Min heap to store the greater half of numbers
	        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
	        
	        ArrayList<Double> res = new ArrayList<>();
	      
	        for (int i = 0; i < arr.length; i++) {
	            
	            // Insert new element into max heap
	            leftMaxHeap.add(arr[i]);
	            
	            // Move the top of max heap to min heap to maintain order
	            int temp = leftMaxHeap.poll();
	            rightMinHeap.add(temp);
	          
	            // Balance heaps if min heap has more elements
	            if (rightMinHeap.size() > leftMaxHeap.size()) {
	                temp = rightMinHeap.poll();
	                leftMaxHeap.add(temp);
	            }
	            
	            // Compute median based on heap sizes
	            double median;
	            if (leftMaxHeap.size() != rightMinHeap.size())
	                median = leftMaxHeap.peek();
	            else
	                median = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
	            
	            res.add(median);
	        }
	        
	        return res;
	    }
	
	public static int insertionSort(int arr[])
	{
		int i,j;
		for(i=1;i<n;i++)
		{
			j=i-1;
			int num = arr[i];
			while(j>=0 && arr[j]>num)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=num;
			int len = arr.length;
			if (len % 2 != 0) {
                median = arr[len / 2];
            } else {
                median = (arr[(len / 2) - 1] + arr[len / 2]) / 2.0;
            }
/*
 * O n2
 */
				
		}
	}
	
	// using heap priority queue
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
