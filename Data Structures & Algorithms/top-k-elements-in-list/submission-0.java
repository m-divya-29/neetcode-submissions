class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Create map number -> count
        Map<Integer, Integer> ctMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int cnt = ctMap.getOrDefault(nums[i], 0);
            cnt++;
            ctMap.put(nums[i], cnt);
        }
        // Create array count -> number
        int[] cntNumArr = new int[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : ctMap.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            cntNumArr[cnt] = num;
        }
        // Find top k nums
        int [] res = new int[k];
        for(int i = cntNumArr.length - 1; i >= 0 && k > 0; i--) {
            int cnt = cntNumArr[i];
            if(cnt > 0) {
                res[k - 1] = cntNumArr[i];
                k--;
            }
        }
        // Return res
        return res;
    }
}
