import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution_ArraysStrings {
    public static String mergeAlternateString(String str1, String str2) {
        String res = "";
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            res = res + str1.charAt(i);
            res = res + str2.charAt(j);
            i++;
            j++;
        }
        if (!(i == str1.length())) {
            res = res + str1.substring(i);
        }
        if (!(j == str2.length())) {
            res = res + str2.substring(j);
        }
        return res;
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }

    public static String gcdString(String str1, String str2) {
        if (!((str1 + str2).equals(str2 + str1))) {
            return "";
        }
        int len1 = str1.length(), len2 = str2.length();
        int gcd = findGCD(len1, len2);
        return str1.substring(0, gcd);
    }

    public static boolean[] kidsWithHigherCandies(int[] candies, int extraCandies) {
        boolean[] res = new boolean[candies.length];
        int max = -1;
        for (int i : candies) {
            max = Math.max(max, i);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                res[i] = true;
            } else {
                res[i] = false;
            }
        }
        return res;
    }

    public static boolean canPlaceFlowers(int[] flowerBed, int n) {
        int count = 0;
        for (int i = 0; i < flowerBed.length; i++) {
            if (flowerBed[i] == 0) {
                if ((i != 0 && flowerBed[i - 1] == 0) && (i != flowerBed.length - 1 && flowerBed[i + 1] == 0)) {
                    flowerBed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    public static boolean checkVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U') {
            return true;
        } else {
            return false;
        }
    }

    public static String reverseVowels(String str1) {
        char[] charArr = str1.toCharArray();
        int i = 0, j = charArr.length - 1;
        while (i <= j) {
            if (checkVowel(charArr[i]) && checkVowel(charArr[j])) {
                char temp = charArr[i];
                charArr[i] = charArr[j];
                charArr[j] = temp;
                i++;
                j--;
            }
            if (!(checkVowel(charArr[i]))) {
                i++;
            }
            if (!(checkVowel(charArr[j]))) {
                j--;
            }
        }
        return new String(charArr);
    }

    public static String reverseWordsInString(String str1) {
        String res = "", w = "";
        str1 = " " + str1;
        for (int i = str1.length() - 1; i >= 0; i--) {
            char ch = str1.charAt(i);
            if (ch != ' ') {
                w = ch + w;
            } else {
                res = res + w + " ";
                w = "";
            }
        }
        return res;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1, zeros = 0, idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                zeros++;
                idx = i;
            }
        }
        if (zeros >= 2) {
            return res;
        }
        if (zeros == 1) {
            res[idx] = product;
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = product / nums[i];
        }
        return res;
    }

    public static boolean increaingTriplet(int[] nums) {
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] < nums[i + 1] && nums[i + 1] < nums[i + 2]) {
                return true;
            }
        }
        return false;
    }

    // Only to find the length of the array rather than modifying the array itself
    // public static int modifyCount(int temp) {
    // int count = 0;
    // int len = Integer.toString(temp).length();
    // if(temp == 1){
    // count += 1;
    // }else{
    // count += len + 1;
    // }
    // return count;
    // }

    // public static int stringCompression(char[] chars) {
    // int count = 0, i = 0, j = 1;
    // while (i < chars.length) {
    // if (j > chars.length - 1) {
    // int temp = j - i;
    // count += modifyCount(temp);
    // break;
    // }
    // if (chars[i] == chars[j]) {
    // j++;
    // } else {
    // int temp = j - i;
    // count += modifyCount(temp);
    // i = j;
    // }
    // }
    // return count;
    // }

    public static int stringCompression(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }

    public static int largestAltitude(int[] gain) {
        int x = 0, res = 0;
        for (int i = 0; i < gain.length; i++) {
            x = x + gain[i];
            res = Math.max(res, x);
        }
        return res;
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            pq.add(i);
        }
        while (k-- > 1) {
            pq.poll();
        }
        return pq.poll();
    }

    public static int maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { nums1[i], nums2[i] };
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        int topKSum = 0;
        for (int i = 0; i < k; i++) {
            topKSum += pairs[i][0];
            pq.add(pairs[i][0]);
        }
        int answer = topKSum * pairs[k - 1][1];
        for (int i = k; i < n; i++) {
            topKSum += pairs[i][0] - pq.poll();
            pq.add(pairs[i][0]);
            answer = Math.max(answer, topKSum * pairs[i][1]);
        }
        return answer;
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            headWorkers.add(costs[i]);
        }
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            tailWorkers.add(costs[i]);
        }
        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;
        for (int i = 0; i < k; i++) {
            if (tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek()) {
                answer += headWorkers.poll();
                if (nextHead <= nextTail) {
                    headWorkers.add(costs[nextHead]);
                    nextHead++;
                }
            } else {
                answer += tailWorkers.poll();
                if (nextHead <= nextTail) {
                    tailWorkers.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }
        return answer;
    }

    public static int[] moveZeros(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        return nums;
    }

    public static boolean isSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        while (j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
            if (i == str1.length()) {
                return true;
            }
        }
        return false;
    }

    public static int containerWithMostWater(int[] height) {
        int left = 0, right = height.length - 1, answer = 0;
        while (left < right) {
            int width = right - left;
            answer = Math.max(answer, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }

    public static int maxOperations(int[] nums, int k) {
        // O(nlogn)
        // Arrays.sort(nums);
        // int left = 0, right = nums.length - 1, count = 0;
        // while (left < right) {
        // if(nums[left] + nums[right] == k){
        // left++;
        // right--;
        // count++;
        // }
        // else if(nums[left] + nums[right] < k){
        // left++;
        // }else{
        // right--;
        // }
        // }
        // return count;

        // O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int complement = k - cur;
            if (map.getOrDefault(complement, 0) > 0) {
                map.put(complement, map.get(complement) - 1);
                count++;
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return count;
    }

    public static ArrayList<ArrayList<Integer>> allDistinct(int[] nums1, int[] nums2) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> distinct1 = new ArrayList<>();
        ArrayList<Integer> distinct2 = new ArrayList<>();

        HashSet<Integer> exist1 = new HashSet<>();
        for (int i : nums1) {
            exist1.add(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (exist1.contains(nums2[i])) {
                exist1.remove(nums2[i]);
            }
        }

        HashSet<Integer> exist2 = new HashSet<>();
        for (int i : nums2) {
            exist2.add(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (exist2.contains(nums1[i])) {
                exist2.remove(nums1[i]);
            }
        }
        for (int i : exist1) {
            distinct1.add(i);
        }
        for (int i : exist2) {
            distinct2.add(i);
        }
        res.add(new ArrayList<>(distinct1));
        res.add(new ArrayList<>(distinct2));
        return res;
    }

    public static boolean uniqueOccurences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : map.values()) {
            if (set.contains(i)) {
                return false;
            }
            set.add(i);
        }
        return true;
    }

    public static boolean areStringsClose(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        ArrayList<Integer> list1 = new ArrayList<>(map1.values());
        ArrayList<Integer> list2 = new ArrayList<>(map2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    public static int equalRowAndCol(int[][] grid) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            String temp = "";
            for (int j = 0; j < grid.length; j++) {
                temp += Integer.toString(grid[i][j]);
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        for (int j = 0; j < grid.length; j++) {
            String col = "";
            for (int i = 0; i < grid.length; i++) {
                col += Integer.toString(grid[i][j]);
            }
            if (map.containsKey(col)) {
                count += map.get(col);
            }
        }
        return count;
    }

    public static double maxAvg(int[] nums, int k) {
        int sum = 0;
        double avg = 0.0, maxAvg = 0.0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        avg = (double) sum / k;
        maxAvg = avg;
        int j = 0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[j++];
            avg = (double) sum / k;
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static int maxVowel(String str, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(str.charAt(i))) {
                count++;
            }
        }
        int maxCount = count;
        int j = 0;
        for (int i = k; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                count += 1;
            }
            if (isVowel(str.charAt(j))) {
                count -= 1;
            }
            maxCount = Math.max(maxCount, count);
            j++;
        }
        return maxCount;
    }

    public static int maxOne3(int[] nums, int k) {
        int max = 0, left = 0, right = 0, numZeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                numZeros++;
            }
            while (numZeros > k) {
                if (nums[left] == 0) {
                    numZeros--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static int longestSubarray(int[] nums) {
        int zero = 0, longestWindow = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            zero += nums[i] == 0 ? 1 : 0;
            while (zero > 1) {
                zero -= nums[start] == 0 ? 1 : 0;
                start++;
            }
            longestWindow = Math.max(longestWindow, i - start);
        }
        return longestWindow;
    }

    public static String removeStars(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '*') {
                stack.add(str.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack.toString();
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean flag = true;
            while (!stack.isEmpty() && (stack.peek() > 0 && asteroids[i] < 0)) {
                if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
                    stack.pop();
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                    stack.pop();
                }
                flag = false;
                break;
            }
            if (flag) {
                stack.push(asteroids[i]);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.peek();
            stack.pop();
        }
        return answer;
    }

    public static String decodeString(String str) {
        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                stack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodeString = stringStack.pop();
                for (int i = stack.pop(); i > 0; i--) {
                    decodeString.append(currentString);
                }
                currentString = decodeString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static int[] successfulPairs(int[] spells, int[] potions, int success) {
        int[] ans = new int[spells.length];
        // for(int i = 0;i<spells.length;i++){
        // int count = 0;
        // for(int j = 0;j<potions.length;j++){
        // if(spells[i] * potions[j] >= success){
        // count++;
        // }
        // }
        // ans[i] = count;
        // }
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0, right = potions.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (potions[mid] * spells[i] >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = potions.length - left;
        }
        return ans;
    }

    public static int search(int[] nums, int left, int right) {
        if (left == right)
            return left;
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, left, mid);
        return search(nums, mid + 1, right);
    }

    public static int peakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public static int minEatingSpeed(int piles[], int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int middle = (left + right) / 2;
            int hrSpent = 0;
            for (int pile : piles) {
                hrSpent += Math.ceil((double) pile / middle);
            }
            if (hrSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    public static void solve(String digits, ArrayList<String> answers, StringBuilder current, int index,
            HashMap<Character, String> dial) {
        if (index == digits.length()) {
            answers.add(current.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = dial.get(digit);

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            solve(digits, answers, current, index + 1, dial);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static ArrayList<String> letterCombination(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        HashMap<Character, String> dial = new HashMap<>();
        dial.put('2', "abc");
        dial.put('3', "def");
        dial.put('4', "ghi");
        dial.put('5', "jkl");
        dial.put('6', "mno");
        dial.put('7', "pqrs");
        dial.put('8', "tuv");
        dial.put('9', "wxyz");
        solve(digits, ans, new StringBuilder(), 0, dial);
        return ans;
    }

    public static int[] binaryRepresentation(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; ++x) {
            ans[x] = ans[x & (x - 1)] + 1;
        }
        return ans;
    }

    public static int singleNumber(int[] nums) {
        int answer = 0;
        for (int i : nums) {
            answer = answer ^ i;
        }
        return answer;
    }

    public static int minFlips(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ((a | b) ^ c));
    }

    public static void solve(int n, int k, int index, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i <= n; i++) {
            ans.add(i);
            solve(n, k, index + 1, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinations(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        solve(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public static void solve(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans, int n, int k, int index) {
        if (n == 0 && ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i <= 9; i++) {
            ans.add(i);
            solve(res, ans, n - i, k, i + 1);
            ans.remove(ans.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        solve(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public static void solve(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans, int index, int[] nums){
        res.add(new ArrayList<>(ans));
        for(int i = index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            ans.add(nums[i]);
            solve(res, ans, i+1, nums);
            ans.remove(ans.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(int nums[]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        solve(res, new ArrayList<>(), 0, nums);
        return res;
    }

    public static void main(String[] args) {
        String str1_p1 = "abc", str2_p1 = "pqr";
        System.out.println("Problem 1: " + mergeAlternateString(str1_p1, str2_p1));

        String str1_p2 = "ABCABC", str2_p2 = "ABC";
        System.out.println("Problem 2: " + gcdString(str1_p2, str2_p2));

        int[] candies_p3 = { 2, 3, 5, 1, 3 };
        int extraCandies_p3 = 3;
        boolean[] answer_p3 = kidsWithHigherCandies(candies_p3, extraCandies_p3);
        System.out.print("Problem 3: ");
        for (boolean i : answer_p3) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] flowerBed_p4 = { 1, 0, 0, 0, 1 };
        int n_p4 = 1;
        System.out.println("Problem 4: " + canPlaceFlowers(flowerBed_p4, n_p4));

        String str1_p5 = "IceCreAm";
        System.out.println("Problem 5: " + reverseVowels(str1_p5));

        String str1_p6 = "the sky is blue";
        System.out.println("Problem 6: " + reverseWordsInString(str1_p6));

        int[] nums_p7 = { 1, 2, 3, 4 };
        int[] answer_p7 = productExceptSelf(nums_p7);
        System.out.print("Problem 7: ");
        for (int i : answer_p7) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] nums_p8 = { 1, 2, 3, 4, 5 };
        System.out.println("Problem 8: " + increaingTriplet(nums_p8));

        char[] chars_p9 = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println("Problem 9: " + stringCompression(chars_p9));

        int[] gain_p10 = { -5, 1, 5, 0, -7 };
        System.out.println("Problem 10: " + largestAltitude(gain_p10));

        int[] nums_p11 = { 1, 7, 3, 6, 5, 6 };
        System.out.println("Problem 11: " + pivotIndex(nums_p11));

        int[] nums_p16 = { 3, 2, 1, 5, 6, 4 };
        int k_p16 = 2;
        System.out.println("Problem 16: " + kthLargest(nums_p16, k_p16));

        int[] nums1_p17 = { 1, 3, 3, 2 };
        int[] nums2_p17 = { 2, 1, 3, 4 };
        int k_p17 = 3;
        System.out.println("Problem 17: " + maxScore(nums1_p17, nums2_p17, k_p17));

        int[] costs_p18 = { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
        int k_p18 = 3, candidates_p18 = 4;
        System.out.println("Problem 18: " + totalCost(costs_p18, k_p18, candidates_p18));

        int[] nums_p19 = { 0, 1, 0, 3, 12 };
        System.out.print("Problem 19: ");
        int answer_p19[] = moveZeros(nums_p19);
        for (int i : answer_p19) {
            System.out.print(i + " ");
        }
        System.out.println();

        String str1_p20 = "abc";
        String str2_p20 = "ahbgdc";
        System.out.println("Problem 20: " + isSubsequence(str1_p20, str2_p20));

        int[] height_p21 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Problem 21: " + containerWithMostWater(height_p21));

        int[] nums_p22 = { 1, 2, 3, 4 };
        int k_22 = 5;
        System.out.println("Problem 22: " + maxOperations(nums_p22, k_22));

        int[] nums1_p23 = { 1, 2, 3 };
        int[] nums2_p23 = { 2, 4, 6 };
        ArrayList<ArrayList<Integer>> answer_p23 = allDistinct(nums1_p23, nums2_p23);
        System.out.println("Problem 23: " + answer_p23);

        int[] arr_p24 = { 1, 2, 2, 3, 3, 3 };
        System.out.println("Problem 24: " + uniqueOccurences(arr_p24));

        String str1_p25 = "abc", str2_p25 = "bca";
        System.out.println("Problem 25: " + areStringsClose(str1_p25, str2_p25));

        int[][] grid_p26 = { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };
        System.out.println("Problem 26: " + equalRowAndCol(grid_p26));

        int[] nums_p27 = { 5 };
        int k_p27 = 1;
        System.out.println("Problem 27: " + maxAvg(nums_p27, k_p27));

        String str_p28 = "abciiidef";
        int k_p28 = 3;
        System.out.println("Problem 28: " + maxVowel(str_p28, k_p28));

        int[] nums_p29 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k_p29 = 2;
        System.out.println("Problem 29: " + maxOne3(nums_p29, k_p29));

        int[] nums_p30 = { 1, 1, 0, 1 };
        System.out.println("Problem 30: " + longestSubarray(nums_p30));

        String str_p31 = "leet**cod*e";
        System.out.println("Problem 31: " + removeStars(str_p31));

        int[] asteroids_p32 = { 10, 2, -5 };
        System.out.print("Problem 32: ");
        int[] answer_p32 = asteroidCollision(asteroids_p32);
        for (int i : answer_p32) {
            System.out.print(i + " ");
        }
        System.out.println();

        String str_p33 = "3[a]2[bc]";
        System.out.println("Problem 33: " + decodeString(str_p33));

        int[] spells_p34 = { 3, 1, 2 };
        int[] potions_p34 = { 8, 5, 8 };
        int success_p34 = 16;
        System.out.print("Problem 34: ");
        int[] anser_p34 = successfulPairs(spells_p34, potions_p34, success_p34);
        for (int i : anser_p34) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] nums_p25 = { 1, 2, 3, 1 };
        System.out.println("Problem 35: " + peakElement(nums_p25));

        int[] nums_p36 = { 3, 6, 7, 11 };
        int h_p36 = 8;
        System.out.println("Problem 36: " + minEatingSpeed(nums_p36, h_p36));

        String digits_p37 = "23";
        System.out.println("Problem 37: " + letterCombination(digits_p37));

        int n_p38 = 2;
        System.out.print("Problem 38: ");
        int[] anser_p38 = binaryRepresentation(n_p38);
        for (int i : anser_p38) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] nums_p39 = { 2, 2, 1 };
        System.out.println("Problem 39: " + singleNumber(nums_p39));

        int a_p40 = 2, b_p40 = 6, c_p40 = 5;
        System.out.println("Problem 40: " + minFlips(a_p40, b_p40, c_p40));

        int n_p41 = 4, k_p41 = 2;
        System.out.println("Problem 41: " + combinations(n_p41, k_p41));

        int k_p42 = 3, n_p42 = 7;
        System.out.println("Problem 42: " + combinationSum3(k_p42, n_p42));

        int[] nums_p43 = {3,1,2,3,2,1};
        System.out.println("Problem 43: " + subsets(nums_p43));
    }
}

// Problem 1: apbqcr
// Problem 2: ABC
// Problem 3: true true true false true
// Problem 4: true
// Problem 5: AceCreIm
// Problem 6: blue is sky the
// Problem 7: 24 12 8 6 
// Problem 8: true
// Problem 9: 6
// Problem 10: 1
// Problem 11: 3
// Problem 16: 5
// Problem 17: 12
// Problem 18: 11
// Problem 19: 1 3 12 0 0 
// Problem 20: true
// Problem 21: 49
// Problem 22: 2
// Problem 23: [[1, 3], [4, 6]]
// Problem 24: true
// Problem 25: true
// Problem 26: 1
// Problem 27: 5.0
// Problem 28: 3
// Problem 29: 6
// Problem 30: 3
// Problem 31: [l, e, c, o, e]
// Problem 32: 10
// Problem 33: aaabcbc
// Problem 34: 2 0 2
// Problem 35: 2
// Problem 36: 4
// Problem 37: [ad, ae, af, bd, be, bf, cd, ce, cf]
// Problem 38: 0 1 1
// Problem 39: 1
// Problem 40: 3
// Problem 41: [[1, 2], [1, 3], [1, 4], [2, 2], [2, 3], [2, 4], [3, 2], [3, 3], [3, 4], [4, 2], [4, 3], [4, 4]]
// Problem 42: [[1, 2, 4]]
// Problem 43: [[], [1], [1, 1], [1, 1, 2], [1, 1, 2, 2], [1, 1, 2, 2, 3], [1, 1, 2, 2, 3, 3], [1, 1, 2, 3], [1, 1, 2, 3, 3], [1, 1, 3], [1, 1, 3, 3], [1, 2], [1, 2, 2], [1, 2, 2, 3], [1, 2, 2, 3, 3], [1, 2, 3], [1, 2, 3, 3], [1, 3], [1, 3, 3], [2], [2, 2], [2, 2, 3], [2, 2, 3, 3], [2, 3], [2, 3, 3], [3], [3, 3]]