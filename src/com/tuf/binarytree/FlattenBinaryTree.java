package com.tuf.binarytree;

public class FlattenBinaryTree {

	private static TreeNode prev=null;
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
        
        flatten(root);
        while(root!=null)
        {
        	System.out.println(root.val);
        	root=root.right;
        }
	}

	public static void flatten(TreeNode root)
	{
		if(root==null)
			return;
		
		flatten(root.right);
		flatten(root.left);
		
		root.right=prev;
		root.left=null;
		
		prev = root;
	}
}
