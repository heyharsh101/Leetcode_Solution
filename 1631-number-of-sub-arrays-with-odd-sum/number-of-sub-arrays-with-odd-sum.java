class Solution {
    public int numOfSubarrays(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int mod = 1_000_000_007;
        map.put(0, 1);
        map.put(1, 0);
        int sum=0;
        int ans =0;
        for(int i = 0; i<n; i++){
            sum += arr[i];

            if(sum % 2 == 0){
                
                if(map.containsKey(1)){
                    ans = (int)((ans % mod + map.get(1) % mod) % mod);
                }
                map.put(0, map.get(0) + 1);
            } else {
                if(map.containsKey(0)){
                    ans = (int)((ans % mod + map.get(0) % mod) % mod);
                }
                map.put(1, map.get(1) + 1);
            }
        }
        return ans;
    }
}