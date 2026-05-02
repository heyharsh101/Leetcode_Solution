class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(result, new ArrayList<>(), used, nums);

        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> ans, boolean[] used, int[] nums){
        if(ans.size() == nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;

            used[i] = true;
            ans.add(nums[i]);

            backtrack(result, ans, used, nums);

            ans.remove(ans.size() - 1);
            used[i] = false;
        }
    }
}