//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int MOD = (int)(1e5);
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        Set<Integer> set = new HashSet<>();
        set.add(start);
        
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();
                // System.out.println("node : " + node);
                if (node == end) return steps;
                
                int temp = node;
                for (int num : arr) {
                    node *= num;
                    node %= MOD;
                    
                    if (!set.contains(node)) {
                        set.add(node);
                        q.offer(node);
                    }
                    
                    node = temp;
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}
