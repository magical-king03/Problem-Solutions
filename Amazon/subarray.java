package Amazon;

import java.util.ArrayList;
import java.util.HashMap;

public class subarray {
    public static int sum(ArrayList<Integer> res) {
        int sum = 0;
        for (int i = 0; i < res.size(); i++) {
            sum += res.get(i);
        }
        return sum;
    }

    // normal code by getting all the subarrays
    // first three for loops for generating the subarrays
    // next searching for the subarray sum which is equal to k and returning the count
    public static int subarraysum(int arr[]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    ans.add(arr[k]);
                }
                res.add(new ArrayList<>(ans));
                ans.clear();
            }
        }
        int k = 3;
        int count = 0;
        for (int i = 0; i < res.size(); i++) {
            if (sum(res.get(i)) == k) {
                count++;
            }
        }
        return count;
    }

    // optimized code - using map
    public static int optimized(int arr[]){
        int count = 0, sum = 0, k = 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i : arr){
            sum += i;
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int count = optimized(arr);
        System.out.println(count);
    }
}

// optimized code - using map
