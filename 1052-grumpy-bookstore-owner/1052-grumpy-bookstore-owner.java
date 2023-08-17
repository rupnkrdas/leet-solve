class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int initialSatisfied = 0;
        
        // Calculate initial satisfied customers without applying the secret technique
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                initialSatisfied += customers[i];
            }
        }
        
        int maxAdditionalSatisfied = 0;
        int currentAdditionalSatisfied = 0;
        
        // Calculate additional satisfied customers using sliding window
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
            
            // Slide the window
            if (i >= minutes) {
                if (grumpy[i - minutes] == 1) {
                    currentAdditionalSatisfied -= customers[i - minutes];
                }
            }
            
            // Update the maximum additional satisfied customers
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, currentAdditionalSatisfied);
        }
        
        // Add the initial satisfied customers and the maximum additional satisfied customers
        return initialSatisfied + maxAdditionalSatisfied;
    }
}
