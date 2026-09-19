class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> alreadySeen = new HashSet<>();
        for(int num:nums){
            if(!alreadySeen.add(num)) return true;
        }
        return false;
    }
}