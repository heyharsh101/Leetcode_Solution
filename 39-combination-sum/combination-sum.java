class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, target, res, new ArrayList<Integer>());
        return res;
    }
    public void backtrack(int i, int[] candidates, int target, List<List<Integer>> res, List<Integer> ans){
        if(target == 0){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        if(target < 0 || i == candidates.length){
            return;
        }
        ans.add(candidates[i]);
        backtrack(i, candidates, target-candidates[i], res, ans);
        ans.remove(ans.size()-1);
        backtrack(i+1, candidates, target, res, ans);

    }
}