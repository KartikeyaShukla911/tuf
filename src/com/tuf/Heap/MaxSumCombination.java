package com.tuf.Heap;

public class MaxSumCombination {
	
	vector<int> maxCombinations(int N, int K, vector<int> &A, vector<int> &B) {
        int n = A.size();
        sort(A.begin(), A.end());
        sort(B.begin(), B.end());
        priority_queue<pair<int, pair<int, int>>> pq;
        set<pair<int, int>> st;
        pq.push({A[n - 1] + B[n - 1], {n - 1, n - 1}});
        st.insert({n - 1, n - 1});
        vector<int> ans;
        while(K--){
            auto curr = pq.top();
            ans.push_back(curr.first);
            pq.pop();
            int i = curr.second.first;
            int j = curr.second.second;
            if(i - 1 >= 0 && st.find({i - 1, j}) == st.end()){
                pq.push({A[i - 1] + B[j], {i - 1, j}});
                st.insert({i - 1, j});
            }
            if(j - 1 >= 0 && st.find({i, j - 1}) == st.end()){
                pq.push({A[i] + B[j - 1], {i, j - 1}});
                st.insert({i, j - 1});
            }
        }
        return ans;
    }
	
	  static List<Integer> maxCombinations(int N, int K, int A[], int B[]) 
	    {
	        List<Integer> list=new ArrayList<>();
	        Arrays.sort(A);
	        Arrays.sort(B);
	        PriorityQueue<Integer> pq=new PriorityQueue<>();
	    
	    for(int i=N-1;i>N-1-K;i--)
	    {
	        for(int j=N-1;j>N-1-K;j--)
	        {
	            int sum=A[i]+B[j];
	            
	            if(pq.size()<K)
	            {
	                pq.add(sum);
	            }
	            else if(sum>pq.peek())
	            {
	                pq.poll();
	                pq.add(sum);
	            }
	            else
	            break;
	        }
	    }
	    
	    while(pq.size()>0&K>0)
	    {
	        list.add(0,pq.poll());
	    }
	    
	    return list;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
