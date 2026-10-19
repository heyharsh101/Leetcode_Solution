class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);
        int j=0; int cnt=0;
        for(int i=0;i <nums.length ;i++){
            if(nums[i] < target){
                j++;
            }
            if(nums[i] == target) cnt++;
            
        }
        while(cnt --> 0){
            res.add(j++);
        }
        return res;
    }
}