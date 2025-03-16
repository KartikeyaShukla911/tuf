package com.tuf.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Pair
{
	TreeNode node;
	int line;
	
	public Pair(TreeNode node,int line)
	{
		this.node=node;
		this.line=line;
	}
}

public class TopViewBT {

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
        List<Integer> ans = topView(root);
        for(int x : ans)
        {
        	System.out.println(x);
        }
	}
	
	public static List<Integer> topView(TreeNode root)
	{
		List<Integer> ans = new ArrayList();
		if(root==null)
			return ans;
		
		HashMap<Integer,Integer> hm = new HashMap();
		
		Queue<Pair> q = new LinkedList();
		
		int lvl=0;
		q.add(new Pair(root,lvl));
		while(!q.isEmpty())
		{
			
			int n = q.size();
			int i;
			for(i=0;i<n;i++)
			{
				Pair temp = q.poll();
				
				if(!hm.containsKey(lvl))
				{
					hm.put(temp.line,temp.node.val);
				}
				
				if(temp.node.left!=null)
				{
					q.add(new Pair(temp.node.left,temp.line-1));
					lvl--;
				}
				if(temp.node.right!=null)
				{
					q.add(new Pair(temp.node.right,temp.line+1));
					lvl++;
				}
			}
		}
		
		for(int values : hm.values())
		{
			System.out.println("Values: "+values);
		}
		return ans;
	}
}
