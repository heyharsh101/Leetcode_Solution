class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Subset(1, n, k, temp, result);
        return result;
    }
    public void Subset(int i, int n, int k, List<Integer> temp, List<List<Integer>> result){
        if(temp.size()==k){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(i>n){
            return;
        }
        temp.add(i);
        Subset(i+1, n, k, temp, result);
        temp.remove(temp.size() - 1);
        Subset(i+1, n, k, temp, result);
    }
}