// algo -- 1st we create an array for mapping that contains all the nos. of that range, basically a length, if we find no. we will update the index value, if any index > 1, we find the no.

class Solution {
    public int findDuplicate(int[] nums) {
        int l;
        l=nums.length;
        // range - 1 to l-1
        int ar1[]=new int[l];
        for(int i=0;i<l;i++)
        {
            int t=nums[i];
            ar1[t]++;
            if(ar1[t]>1)
            {
                return t;
            }
        }
        return 0;
    }
}