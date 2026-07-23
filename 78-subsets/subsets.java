class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        generate(nums, 0, ans, result);
        return result;
    }
    public void generate(int[] nums, int i, List<Integer> ans, List<List<Integer>> result){
        if(i == nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }

        int val = nums[i];
        ans.add(val);
        generate(nums, i+1, ans, result);

        ans.remove(ans.size()-1);
        generate(nums, i+1, ans, result);
    }
}