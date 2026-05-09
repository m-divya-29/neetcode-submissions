class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n];
        climbRecursive(0, n, cache);
        int result = 0;
        for(int i = 0; i < cache.length; i++) {
            System.out.println(cache[i]);
            result += cache[i];
        }
        return result;
    }

    private int climbRecursive(int i, int n, int[] cache) {
        if(i == n) {
            return 1;
        }
        if(i > n) {
            return 0;
        }
        if(cache[i] != 0) {
            return cache[i];
        }
        cache[i] = Math.max(climbRecursive(i + 1, n, cache), climbRecursive(i + 2, n, cache));
        return cache[i];
    }
}
