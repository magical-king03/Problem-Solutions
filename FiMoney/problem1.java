package FiMoney;

// 1. You have built a gaming platform where the scores of the players taking part in a tournament is stored in a very huge file, and you are only able to access it as a stream. The scores consist of key-value pairs of <player_id (string), score(int)>. The players are ranked based on decreasing order of their scores, I.e. greater the score, lower the rank. You need to find the id of the player whose rank is k (passed as input).

// Input: nums = [(a, 3), (b, 2), (c, 1), (d, 5) , (e, 6) , (f, 4)], k = 2
// Output: d

// Input: nums = [(a, 3) , (b, 2), (c, 3), (d, 1), (e, 2), (f, 4), (g, 5), (h, 5), (i, 6)], k = 4
// Output: f


import java.util.*;

public class problem1 {
    public static String findPlayerWithRankK(List<Pair> nums, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> {
            // not needed as per the question
            if (p1.score == p2.score) {
                return p1.id.compareTo(p2.id); 
            }
            return Integer.compare(p1.score, p2.score); 
        });

        for (Pair player : nums) {
            if (minHeap.size() < k) {
                minHeap.add(player);
            } else if (player.score > minHeap.peek().score ||
                       //The second condition is also not needed as per this question
                       (player.score == minHeap.peek().score && player.id.compareTo(minHeap.peek().id) < 0)) {
                minHeap.poll(); 
                minHeap.add(player); 
            }
        }

        return minHeap.peek().id;
    }

    public static void main(String[] args) {
        List<Pair> nums1 = Arrays.asList(
            new Pair("a", 3), new Pair("b", 2), new Pair("c", 1), 
            new Pair("d", 5), new Pair("e", 6), new Pair("f", 4)
        );
        int k1 = 2;
        System.out.println(findPlayerWithRankK(nums1, k1)); 

        List<Pair> nums2 = Arrays.asList(
            new Pair("a", 3), new Pair("b", 2), new Pair("c", 3), 
            new Pair("d", 1), new Pair("e", 2), new Pair("f", 4),
            new Pair("g", 5), new Pair("h", 5), new Pair("i", 6)
        );
        int k2 = 4;
        System.out.println(findPlayerWithRankK(nums2, k2)); 
    }
}

class Pair {
    String id;
    int score;

    public Pair(String id, int score) {
        this.id = id;
        this.score = score;
    }
}

