// Maths solution
// The task with the highest frequency determines the minimum needed structure of the schedule.
// If a task appears maxf times, these copies must be at least n units apart.
// This creates (maxf - 1) "gaps", and each gap must have a length of (n + 1) slots (the task itself
// + n cooldowns). If multiple tasks share this maximum frequency (maxCount tasks), they all occupy
// the final row of the structure. So the minimal time required to schedule all tasks without
// violating cooldown rules is: time = (maxf - 1) * (n + 1) + maxCount

// However, if the number of tasks is larger than this calculated time, then simply performing all
// tasks takes longer. Thus, the actual answer must be: max(len(tasks), (maxf - 1) * (n + 1) +
// maxCount)

// heapsolution
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> coolDown = new LinkedList<>();

        for (int i : freq) {
            if (i > 0) {
                maxheap.offer(i);
            }
        }

        int time = 0;
        while (!(maxheap.isEmpty() && coolDown.isEmpty())) {
            time++;
            if (!maxheap.isEmpty()) {
                int cnt = maxheap.poll() - 1;
                if (cnt > 0) {
                    coolDown.add(new int[] {cnt, time + n});
                }
            } else {
                time = coolDown.peek()[1];
            }

            while (!coolDown.isEmpty() && coolDown.peek()[1] <= time) {
                int[] stage = coolDown.poll();
                maxheap.offer(stage[0]);
            }
        }

        return time;
    }
}
