class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int result[] = new int[k];

        List<Integer>[] freq = new List[nums.length + 1];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        Set<Integer> ky = cnt.keySet();
        for (Integer i : ky) {
            freq[cnt.get(i)].add(i);
        }
        int cur = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            for (int n : freq[i]) {
                result[cur++] = n;
                if (cur == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
