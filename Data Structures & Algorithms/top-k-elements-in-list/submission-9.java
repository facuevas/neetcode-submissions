class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer, Integer> kv : frequency.entrySet()) {
            int[] pair = new int[]{kv.getKey(), kv.getValue()};
            minHeap.add(pair);
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] res = minHeap.stream().mapToInt(arr -> arr[0]).toArray();

        return res;
    }
}
