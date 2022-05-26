class HitCounter {
    ArrayList<Integer> hits;

    public HitCounter() {
        hits = new ArrayList<>();
    }
    
    public void hit(int timestamp) {
        int l = 0, r = hits.size() - 1;
        hits.add(timestamp);
    }
    // find the index of the min hit that is larger than timestamp - 300
    public int getHits(int timestamp) {
        int l = 0, r = hits.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (hits.get(mid) <= timestamp - 300) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l < hits.size() && hits.get(l) > timestamp - 300)
            return hits.size() - l;
        return 0;
    }
}