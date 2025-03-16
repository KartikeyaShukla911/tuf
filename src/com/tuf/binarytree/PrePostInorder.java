package com.tuf.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrePostInorder {

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
        
        int flag=0;
		List<Integer> preOrder = new ArrayList();
		List<Integer> inOrder = new ArrayList();
		List<Integer> postOrder = new ArrayList();
		
        prePostInorder(root,flag,preOrder,inOrder,postOrder);
        
        System.out.println("pre");
        for(int x : preOrder)
        	System.out.println(x);
	}
	
	public static void prePostInorder(TreeNode root,int flag,List<Integer> preOrder,
			List<Integer> inOrder,List<Integer> postOrder)
	{
		if(root==null)
			return;
		
		Stack<Pair> st = new Stack();
		
	}

}
