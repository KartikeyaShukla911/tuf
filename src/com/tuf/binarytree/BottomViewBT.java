package com.tuf.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomViewBT {

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
        
        bottomView(root);
	}

	public static void bottomView(TreeNode root)
	{
		if(root==null)
			return;
		
		int lvl=0;
		HashMap<Integer,TreeNode> hm = new HashMap();
		
		Queue<Pair> q = new LinkedList();
		q.add(new Pair(root,0));
		while(!q.isEmpty())
		{
			Pair temp = q.poll();
			hm.put(temp.line, temp.node);
			
			if(temp.node.left!=null)
			{
				q.add(new Pair(temp.node.left,temp.line-1));
			}
			if(temp.node.right!=null)
			{
				q.add(new Pair(temp.node.right,temp.line+1));
			}
		}
		
		for(Map.Entry<Integer,TreeNode> entry : hm.entrySet())
		{
			System.out.println(entry.getValue().val);
		}
	}
}
