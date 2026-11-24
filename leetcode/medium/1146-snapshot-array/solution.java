import java.util.*;

class SnapshotArray {
    int snapId;
    List<TreeMap<Integer, Integer>> array; // Har index ke liye {snapId -> value}

    public SnapshotArray(int length) {
        snapId = 0;
        array = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            array.add(new TreeMap<>());
            // Initially value 0 hoti hai
            array.get(i).put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        array.get(index).put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        // TreeMap me current snap_id se chhota ya barabar wala latest value dhundho
        return array.get(index).floorEntry(snap_id).getValue();
    }
}