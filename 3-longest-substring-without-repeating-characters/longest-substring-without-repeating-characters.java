class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[255];
        for(int i=0; i<arr.length; i++){
            arr[i] = 0;
        }
        int max = 0;
        for(int i=0; i<s.length(); i++){
            String temp = "";
            for(int j=i; j<s.length(); j++){
                if(arr[(int)s.charAt(j)] == 1)
                {
                    setAll(arr);
                    break;
                }
                arr[(int)s.charAt(j)] = 1;
                temp += ""+s.charAt(j);
            }
            max = Math.max(max, temp.length());
        }
        return max;
    }
    public static void setAll(int arr[]){
        for(int i=0; i<arr.length; i++){
            arr[i] = 0;
        }
    }
}