import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> Set = new HashSet<>();
        for (int num:nums) {
            Set.add(num);
        }

        int longestStreak = 0;

        for (int num :Set) {
            if (!Set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
            
                while (Set.contains(currentNum+1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}