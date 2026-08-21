class TimeMap {
    Map<String, List<String[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new String[] {Integer.toString(timestamp), value});
    }

    public String get(String key, int timestamp) {
        List<String[]> keyList = map.get(key);
        if (keyList == null || keyList.isEmpty()) {
            return "";
        }
        int l = 0, r = keyList.size() - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (Integer.parseInt(keyList.get(mid)[0]) <= timestamp) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res == -1 ? "" : keyList.get(res)[1];
    }
}
