package com.tuf.binarytree;


class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	
	
	public TreeNode(int val)
	{
		this.val=val;
		this.left=null;
		this.right=null;
	}
	
	public void inorder(TreeNode root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(" "+root.val);
		inorder(root.right);
	}
	
}

public class InorderTree {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
