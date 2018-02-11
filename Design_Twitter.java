//My owned version Too slowA
class Twitter1{

    /** Initialize your data structure here. */
    Map<Integer,User> map;
    List<Integer> allT;
    public Twitter1() {
        map = new HashMap<>();
        allT = new ArrayList<>();

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userExisted(userId)) map.put(userId,new User(userId));
        User user = map.get(userId);
        user.tweets.add(tweetId);
        user.oritweet.add(tweetId);
        allT.add(tweetId);
        if(user.followers.size() == 0) return;
        Iterator it = user.followers.iterator();
        while(it.hasNext()){
            User u = map.get((Integer)it.next());
            u.tweets.add(tweetId);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!userExisted(userId)){
            map.put(userId,new User(userId));
            return new LinkedList<>();
        }
        User user = map.get(userId);
        List<Integer> tenT = new ArrayList<>();
        for(int i = allT.size()-1;i>=0;i--){
            if(tenT.size() == 10) break;
            if(user.tweets.contains(allT.get(i))) tenT.add(allT.get(i));
        }
        return tenT;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userExisted(followeeId)) {
            map.put(followeeId,new User(followeeId));
        }
        if(!userExisted(followerId)) {
            map.put(followerId,new User(followerId));
        }
        if(followerId == followeeId || map.get(followerId).followees.contains(followeeId)) return;
        User follower = map.get(followerId);
        User followee = map.get(followeeId);
        follower.tweets.addAll(followee.oritweet);
        map.get(followerId).followees.add(followeeId);
        map.get(followeeId).followers.add(followerId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userExisted(followeeId)||!userExisted(followerId)) {
            return;
        }
        if(followerId == followeeId||!map.get(followerId).followees.contains(followeeId)) return;
        User follower = map.get(followerId);
        User followee = map.get(followeeId);
        follower.tweets.removeAll(followee.oritweet);
        follower.followees.remove(followeeId);
        followee.followers.remove(followerId);

    }
    private boolean userExisted(int userId){
        return map.containsKey(userId);
    }
    class User{
        int userId;
        HashSet<Integer> followees;
        HashSet<Integer> followers;
        LinkedHashSet<Integer> tweets;
        LinkedHashSet<Integer> oritweet;
        public User(int userId) {
            this.userId = userId;
            followees = new HashSet<>();
            tweets = new LinkedHashSet<>();
            followers = new HashSet<>();
            oritweet = new LinkedHashSet<>();
        }

    }
}
