package com.tuf.bt.misc;


class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize
    // the node with a value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class MaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        int max[]=new int[1];
        System.out.println("Max path sum "+maxPath(root,max));
	}

	public static int maxPath(Node root,int max[])
	{
		if(root==null)
			return 0;
		
		int lh = Math.max(0, maxPath(root.left,max));
		int rh = Math.max(0, maxPath(root.right,max));
		
		max[0] = Math.max(max[0], lh+rh+root.data);
		
		return Math.max(lh, rh) + root.data;
	}
	/*
	 * O - N
	 */
}
