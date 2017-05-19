/**
 * Created by sheshnath on 5/18/2017.
 * problem link : https://leetcode.com/problems/insert-delete-getrandom-o1/#/description
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class RandomizedSet {

    HashMap<Integer,Integer> locs;
    ArrayList<Integer> nums;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        locs = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(locs.containsKey(val)){
           return false;
        }
        locs.put(val, nums.size());
        nums.add(val);
        return true;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!locs.containsKey(val)){
            return false;
        }
        int loc = locs.get(val);
        if(loc<nums.size()-1){
            int lastone = nums.get(nums.size()-1);
            nums.add(loc,lastone);
            locs.put(lastone,loc);
        }
        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */