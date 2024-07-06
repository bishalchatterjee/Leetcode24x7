class Solution {
    public int passThePillow(int n, int time) {
        int resPosition=1;

        int passDirection=1; //1 -> for forward pass, -1 -> for backward pass

        for(int i = 0; i < time; i++){
            resPosition += passDirection;

            if(resPosition == n){
                passDirection = -1;
            }else if(resPosition == 1){
                passDirection = 1;
            }
        }
        return resPosition;
    }
}