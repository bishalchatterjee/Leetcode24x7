class Solution {
    public int countHomogenous(String s) {
        int res=0;
        int MOD = (int)1e9+7;
        int homogeneousSubstrLen=0;

        for(int i=0; i<s.length(); i++){
            if(i>0 && s.charAt(i) == s.charAt(i-1)){
                homogeneousSubstrLen+=1; //increment the homogeneous sub str length
            }else{
                homogeneousSubstrLen=1; //reset length
            }
            res= (res + homogeneousSubstrLen) % MOD;
        }

        return res;
    }
}
