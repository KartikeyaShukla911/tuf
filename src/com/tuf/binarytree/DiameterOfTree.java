package com.tuf.binarytree;

public class DiameterOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        int maxi[]=new int[1];
        maxi[0]=diameter(root,maxi);
        System.out.println("Max width: "+ maxi[0]);
	}

	public static int diameter(TreeNode root,int maxi[])
	{
		if(root==null)
			return 0;
		
		int[] lh = new int[1];
		int[] rh = new int[1];
		
		lh[0] = diameter(root.left,lh);
		rh[0]= diameter(root.right,rh);
		
		maxi[0] = Math.max(maxi[0], lh[0]+rh[0]+1);
		
		return 1+ Math.max(lh[0], rh[0]);
	}
	
	public static int height(TreeNode root)
	{
		if(root==null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
