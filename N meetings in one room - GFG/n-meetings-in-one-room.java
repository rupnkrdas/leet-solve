//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{start[i], end[i]});
        }
        
        Collections.sort(list, new Comparator<int[]>() {
           public int compare(int[] p1, int[] p2) {
               return (p1[1] == p2[1]) ? p1[0]-p2[0] : p1[1]-p2[1];
           }
        });
        
        int count = 0;
        int[] pair = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int[] p : list) {
            int s = p[0], e = p[1];
            if (s > pair[1]) { // no merge
                count++;
                pair[0] = s;
                pair[1] = e;
            }
        }
        
        return count;
    }
}
