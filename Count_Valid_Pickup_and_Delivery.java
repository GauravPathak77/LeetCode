public class Count_Valid_Pickup_and_Delivery {
    public int countOrders(int n) {
    long MOD = 1000000007;
    long result = 1;

    for (int i = 1; i <= n; i++) {
        result = (result * (2 * i - 1) * i) % MOD;
    }

    return (int) result;
    }
}
