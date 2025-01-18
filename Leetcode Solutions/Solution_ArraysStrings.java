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
    //     int count = 0;
    //     int len = Integer.toString(temp).length();
    //     if(temp == 1){
    //         count += 1;
    //     }else{
    //         count += len + 1;
    //     }
    //     return count;
    // }

    // public static int stringCompression(char[] chars) {
    //     int count = 0, i = 0, j = 1;
    //     while (i < chars.length) {
    //         if (j > chars.length - 1) {
    //             int temp = j - i;
    //             count += modifyCount(temp);
    //             break;
    //         }
    //         if (chars[i] == chars[j]) {
    //             j++;
    //         } else {
    //             int temp = j - i;
    //             count += modifyCount(temp);
    //             i = j;
    //         }
    //     }
    //     return count;
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
        for(int i = 0;i<gain.length;i++){
            x = x + gain[i];
            res = Math.max(res, x);
        }
        return res;
    }

    public static int pivotIndex(int[] nums){
        int sum = 0;
        for(int i : nums) sum += i;
        int leftSum = 0;
        for(int i = 0;i<nums.length;i++){
            if(leftSum == sum - leftSum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
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

        int[] gain_p10 = {-5,1,5,0,-7};
        System.out.println("Problem 10: " + largestAltitude(gain_p10));

        int[] nums_p11 = {1,7,3,6,5,6};
        System.out.println("Problem 11: " + pivotIndex(nums_p11));
    }
}