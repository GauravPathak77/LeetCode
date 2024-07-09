class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currentTime = 0;
        long totalWaitingTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int prepTime = customer[1];
            
            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }
            
            currentTime += prepTime;
            totalWaitingTime += currentTime - arrivalTime;
        }
        
        return (double) totalWaitingTime / customers.length;
    }
}
