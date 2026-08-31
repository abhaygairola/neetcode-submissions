class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {time, tweetId});
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (Integer following : followMap.get(userId)) {
            List<int[]> tweetList = tweetMap.get(following);
            if (tweetList != null) {
                int i = tweetList.size() - 1;
                int[] tweet = tweetList.get(i);
                q.offer(new int[] {tweet[0], tweet[1], following, i});
            }
        }
        List<Integer> res = new ArrayList<>();

        while (res.size() < 10 && !q.isEmpty()) {
            int[] tweet = q.poll();
            res.add(tweet[1]);
            if(tweet[3]>0){
                int[] newTweet = tweetMap.get(tweet[2]).get(tweet[3]-1);
                q.offer(new int[] {newTweet[0],newTweet[1],tweet[2],tweet[3]-1});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }
}
