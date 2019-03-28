class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j])
                    break;
                else if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}
