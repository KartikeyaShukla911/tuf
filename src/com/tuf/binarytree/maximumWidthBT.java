package com.tuf.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class maximumWidthBT {

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
        
        System.out.println("Max width: "+maxWidth(root));
	}
	
	public static int maxWidth(TreeNode root)
	{
		if(root==null)
			return 0;
		
		int max=0;
		
		Queue<Pair> q= new LinkedList();
		q.add(new Pair(root,1));
		while(!q.isEmpty())
		{
			TreeNode temp = q.peek().node;
			int first = q.peek().line;
			int last = first;
			
			int n = q.size();
			
			for(int i=0;i<n;i++)
			{
				Pair pair = q.poll();
				temp = pair.node;
				int index = pair.line;
				last = index;
				if(temp.left!=null)
				{
					q.add(new Pair(temp.left,2*index));
				}
				if(temp.right!=null)
				{
					q.add(new Pair(temp.right,2*index+1));
				}
				
			}
			max = Math.max(max, last-first+1);
		}
		return max;
	}
	static class NodeInfo {
        TreeNode node;
        int index;

        public NodeInfo(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
