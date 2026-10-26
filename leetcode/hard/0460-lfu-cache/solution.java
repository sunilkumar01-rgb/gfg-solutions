class LFUCache {
    HashMap<Integer, int[]> cache; // key -> [value, freq]
    HashMap<Integer, LinkedHashSet<Integer>> freqMap; // freq -> keys
    int capacity, minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        updateFreq(key);
        return cache.get(key)[0];
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            cache.get(key)[0] = value;
            updateFreq(key);
        } else {
            if (cache.size() >= capacity) {
                int evict = freqMap.get(minFreq).iterator().next();
                freqMap.get(minFreq).remove(evict);
                cache.remove(evict);
            }
            cache.put(key, new int[]{value, 1});
            freqMap.putIfAbsent(1, new LinkedHashSet<>());
            freqMap.get(1).add(key);
            minFreq = 1;
        }
    }
    
    private void updateFreq(int key) {
        int[] info = cache.get(key);
        int f = info[1];
        info[1]++;
        
        freqMap.get(f).remove(key);
        if (freqMap.get(f).isEmpty()) {
            freqMap.remove(f);
            if (minFreq == f) minFreq++;
        }
        
        freqMap.putIfAbsent(f + 1, new LinkedHashSet<>());
        freqMap.get(f + 1).add(key);
    }
}