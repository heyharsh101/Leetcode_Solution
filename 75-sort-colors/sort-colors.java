class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        quicksort(nums, low, high);
    }

    void quicksort(int[] nums, int low, int high){
        if(low < high){

            int pivot = partition(nums, low, high);
            quicksort(nums, low, pivot-1);
            quicksort(nums, pivot+1, high);
        }
    }
    int partition(int[] nums, int low, int high){
        int idx = low-1;
        int pivot = nums[high];

        for(int j=low; j<high; j++){
            if(nums[j] <= pivot){
                idx++;
                int temp = nums[j];
                nums[j] = nums[idx];
                nums[idx] = temp;
            }
        }

        idx++;
        int temp = nums[idx];
        nums[idx] = nums[high];
        nums[high] = temp;

        return idx;
    }
}