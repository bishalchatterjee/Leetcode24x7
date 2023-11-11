class Solution {
    public int countGoodNumbers(long n) {
        //permutation and combination

        //Range - [0 1 2 3 4 5 6 7 8 9]
        //Even - [0 2 4 6 8] ie #even = 5 //can be used to fill the even indexes
        //Prime - [2 3 5 7] ie #prime = 4 //can be used to fill the odd indexes

         int mod = 1_000_000_007;

        long evenIndexesForNdigits = (n + 1) / 2;
        long oddIndexesForNdigits = n / 2;

        long evenAtEvenIndexNCR = myPow(5, evenIndexesForNdigits);
        long primeAtOddIndexNCR = myPow(4, oddIndexesForNdigits);

        return (int) ((evenAtEvenIndexNCR * primeAtOddIndexNCR) % mod);

    }
    public long myPow(int x, long n) {
        if(n<0){
            long newPower=-1*n;
            long ans=recursiveBinaryExponentiation(x,newPower);
            return (long)1/ans;
        }

        return (long)recursiveBinaryExponentiation(x,n); 
    }
    private long recursiveBinaryExponentiation(int x,long n){
         int mod = 1_000_000_007;
        if(n==0) return 1;

        long res=recursiveBinaryExponentiation(x,n/2);

        if(n%2==0){
            return (long)(res * res) % mod;
        }else{
            return (long)(x * res * res) % mod;
        }
    }
}