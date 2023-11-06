class SeatManager {
    PriorityQueue<Integer> seats;
    public SeatManager(int n) {
        seats = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            seats.offer(i);
        }
    }
    
    public int reserve() {
        return seats.poll();
    }
    
    public void unreserve(int seatNumber) {
        seats.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
