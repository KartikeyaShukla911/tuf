package com.tuf.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinHeapMaxHeap {
	
	class MinHeap {
	    private int[] heap;
	    private int size;
	    private int capacity;

	    public MinHeap(int capacity) {
	        this.capacity = capacity;
	        heap = new int[capacity];
	        size = 0;
	    }

	    public void insert(int value) {
	        if (size == capacity) {
	            System.out.println("Heap is full");
	            return;
	        }
	        int index = size;
	        heap[size++] = value;

	        // Heapify Up (Bubble Up)
	        while (index > 0) {
	            int parentIndex = (index - 1) / 2;
	            if (heap[parentIndex] <= heap[index]) {
	                break;
	            }
	            // Swap parent and child
	            int temp = heap[parentIndex];
	            heap[parentIndex] = heap[index];
	            heap[index] = temp;
	            index = parentIndex;
	        }
	    }

	    public int remove() {
	        if (size == 0) {
	            throw new IllegalStateException("Heap is empty");
	        }
	        int root = heap[0];
	        heap[0] = heap[--size];

	        // Heapify Down (Bubble Down)
	        int index = 0;
	        while (index < size) {
	            int leftChild = 2 * index + 1;
	            int rightChild = 2 * index + 2;
	            if (leftChild >= size) break;

	            int smallerChild = leftChild;
	            if (rightChild < size && heap[rightChild] < heap[leftChild]) {
	                smallerChild = rightChild;
	            }
	            if (heap[index] <= heap[smallerChild]) break;

	            // Swap
	            int temp = heap[index];
	            heap[index] = heap[smallerChild];
	            heap[smallerChild] = temp;

	            index = smallerChild;
	        }
	        return root;
	    }

	    public void printHeap() {
	        for (int i = 0; i < size; i++) {
	            System.out.print(heap[i] + " ");
	        }
	        System.out.println();
	    }
	}

	class MaxHeap {
	    private int[] heap;
	    private int size;
	    private int capacity;

	    public MaxHeap(int capacity) {
	        this.capacity = capacity;
	        heap = new int[capacity];
	        size = 0;
	    }

	    public void insert(int value) {
	        if (size == capacity) {
	            System.out.println("Heap is full");
	            return;
	        }
	        int index = size;
	        heap[size++] = value;

	        // Heapify Up (Bubble Up)
	        while (index > 0) {
	            int parentIndex = (index - 1) / 2;
	            if (heap[parentIndex] >= heap[index]) {
	                break;
	            }
	            // Swap
	            int temp = heap[parentIndex];
	            heap[parentIndex] = heap[index];
	            heap[index] = temp;
	            index = parentIndex;
	        }
	    }

	    public int remove() {
	        if (size == 0) {
	            throw new IllegalStateException("Heap is empty");
	        }
	        int root = heap[0];
	        heap[0] = heap[--size];

	        // Heapify Down (Bubble Down)
	        int index = 0;
	        while (index < size) {
	            int leftChild = 2 * index + 1;
	            int rightChild = 2 * index + 2;
	            if (leftChild >= size) break;

	            int largerChild = leftChild;
	            if (rightChild < size && heap[rightChild] > heap[leftChild]) {
	                largerChild = rightChild;
	            }
	            if (heap[index] >= heap[largerChild]) break;

	            // Swap
	            int temp = heap[index];
	            heap[index] = heap[largerChild];
	            heap[largerChild] = temp;

	            index = largerChild;
	        }
	        return root;
	    }

	    public void printHeap() {
	        for (int i = 0; i < size; i++) {
	            System.out.print(heap[i] + " ");
	        }
	        System.out.println();
	    }
	}

	public class HeapDemo {
	    public static void main(String[] args) {
	    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	        System.out.println("MinHeap:");
	        MinHeap minHeap = new MinHeap(10);
	        minHeap.insert(10);
	        minHeap.insert(5);
	        minHeap.insert(20);
	        minHeap.insert(2);
	        minHeap.printHeap();
	        System.out.println("Removed: " + minHeap.remove());
	        minHeap.printHeap();

	        System.out.println("\nMaxHeap:");
	        MaxHeap maxHeap = new MaxHeap(10);
	        maxHeap.insert(10);
	        maxHeap.insert(5);
	        maxHeap.insert(20);
	        maxHeap.insert(2);
	        maxHeap.printHeap();
	        System.out.println("Removed: " + maxHeap.remove());
	        maxHeap.printHeap();
	    }
	}

}
