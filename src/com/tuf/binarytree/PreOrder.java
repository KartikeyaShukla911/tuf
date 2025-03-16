package com.tuf.binarytree;

import com.tuf.binarytree.InorderTree.TreeNode;

public class PreOrder {

	public void preorder(TreeNode node)
	{
		if(node==null)
				return;
		
		System.out.println(" "+node.val);
		preorder(node.left);
		preorder(node.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
