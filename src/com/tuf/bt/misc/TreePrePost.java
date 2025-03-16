package com.tuf.bt.misc;

import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class TreePrePost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inOrder = {9,3,15,20,7};
		int[] preOrder = {3,9,20,15,7};
		int i;
		
		Node node = buildTree(inOrder,preOrder);
		
		printTree(node);
	}
	
	public static void printTree(Node  node)
	{
		if(node==null)
			return ;
		
		printTree(node.left);
		System.out.println(node.data);
		printTree(node.right);
	}

	public static Node buildTree(int[] inOrder,int[] preOrder)
	{
		int preEnd = preOrder.length;
		int inEnd = inOrder.length;
		
		int inStart=0,preStart=0;
		
		Map<Integer,Integer> hm = new HashMap();
		
		for(int i=0;i<preEnd;i++)
		{
			hm.put(preOrder[i], i);
		}
		
		return build(inOrder,preOrder,preStart,preEnd,inStart,inEnd,hm);
	}
	
	public static Node build(int[] inOrder,int[] preOrder,int preStart,int preEnd,int inStart,int inEnd,
			Map<Integer,Integer> hm)
	{
		if(preStart>=preEnd || inStart>=inEnd)
			return null;
		
		Node root = new Node(preOrder[preStart]);
		
		int inRoot = hm.get(root.data);
		
		int numLeft = inRoot - inStart;
		
		root.left = build(inOrder,preOrder,preStart+1,preStart+numLeft,inStart,inRoot-1,hm);
		root.right = build(inOrder,preOrder,preStart+numLeft+1,preEnd,inStart+1,inEnd,hm);
		
		return root;
	}
}
