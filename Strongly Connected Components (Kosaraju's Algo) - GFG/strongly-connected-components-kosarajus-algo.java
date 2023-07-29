//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    private void toposort(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        
        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] != 1) {
                toposort(adjNode, st, adj, vis);
            }
        }
        
        st.push(node);
    }
    
    private ArrayList<ArrayList<Integer>> reverse_graph(ArrayList<ArrayList<Integer>> adj, int n) {
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverse.add(new ArrayList<>());
        }
        for (int u = 0; u < n; u++) {
            for (int v : adj.get(u)) {
                reverse.get(v).add(u);
            }
        }
        
        return reverse;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        
        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] != 1) {
                dfs(adjNode, adj, vis);
            }
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                toposort(i, st, adj, vis);
            }
        }
        adj = reverse_graph(adj, V);
        
        int count = 0;
        Arrays.fill(vis, 0);
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == 0) {
                count++;
                dfs(node, adj, vis);
            }
        }
        
        return count;
    }
}
