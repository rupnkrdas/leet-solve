//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if (n > m) {
            return kthElement(arr2, arr1, m, n, k);
        }
        
        int start = Math.max(0, k - m);;
        int end = Math.min(n, k);
        
        while (start <= end) {
            int cut1 = start + (end - start)/2;
            int cut2 = k - cut1;
            
            long l1 = (cut1 == 0) ? Long.MIN_VALUE : arr1[cut1 - 1];
            long l2 = (cut2 == 0) ? Long.MIN_VALUE : arr2[cut2 - 1];
            long r1 = (cut1 == n) ? Long.MAX_VALUE : arr1[cut1];
            long r2 = (cut2 == m) ? Long.MAX_VALUE : arr2[cut2];
            
            if (l1 <= r2 && l2 <= r1) {
                long ans = Math.max(l1, l2);
                return ans;
            } else if (l1 > r2) {
                end = cut1 - 1;
            } else {
                start = cut1 + 1;
            }
        }
        
        return 1;
    }
}