class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            int a = target - cur;

            if(map.containsKey(a)){
                return new int[]{i, map.get(a)};
            }
            map.put(cur, i);
        }
        return null;
    }
}