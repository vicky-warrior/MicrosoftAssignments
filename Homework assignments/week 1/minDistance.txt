class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hash=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            hash.add(nums[i]);
        }
        int i=1;
        while(true)
        {
            if(!hash.contains(i))
            {
                return i;
            }
            i++;
        }
    }
}