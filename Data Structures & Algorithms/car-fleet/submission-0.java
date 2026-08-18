class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<int[]> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new int[] {position[i], speed[i]});
        }
        cars.sort((a, b) -> Integer.compare(a[0], b[0]) * -1);
        Deque<Double> stackTime = new ArrayDeque<>();
        for (int[] car : cars) {
            Double time = (double) (target - car[0]) / (car[1]);
            if (!stackTime.isEmpty() && stackTime.peek() >= time) {
                continue;
            }
            stackTime.push(time);
        }
        return stackTime.size();
    }
}
