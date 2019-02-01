class RandomizedSet {
    private Map<Integer, Integer> keyMap = new HashMap<>();
    private List<Integer> elementList = new ArrayList<>();
    private Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (keyMap.containsKey(val)) return false;
        keyMap.put(val, elementList.size());
        elementList.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!keyMap.containsKey(val)) return false;

        int index = keyMap.get(val);
        elementList.set(index, elementList.get(elementList.size() - 1));
        keyMap.put(elementList.get(index), index);
        elementList.remove(elementList.size() - 1);
        keyMap.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return elementList.get(random.nextInt(elementList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

