//Binay Exponentiation - Iterative
/*
class Solution {
    public double myPow(double x, int n) {
        return binaryExponentiation(x,n);
    }
    private double binaryExponentiation(double x,int n){
        //as power will be modified we are using dummy variable
        double newPow=n;
        double ans=1.0;
        
        if(n < 0) newPow=(-1.0)*newPow; // convert negative power to positive power

        while(newPow > 0){
             //Case 1 : Even Power -> ans=x*x, n=n/2
            if(newPow % 2 == 0){
                x = x * x;
                newPow=newPow/2;
            }else{
             //Case 2 : Odd Power -> ans=ans*x, n=n-1
                ans = ans * x ;
                newPow=newPow-1;
            }
        }

        if(n < 0) return (double)1.0/ans; // for negative exponent(power) 2^-2= 1/2^2 
        return ans; 
    }
}
*/


// Binary Exponentiation - Recursive
class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            int newPower=-1*n;
            double ans=recursiveBinaryExponentiation(x,newPower);
            return (double)1.0/ans;
        }

        return recursiveBinaryExponentiation(x,n); 
    }
    private double recursiveBinaryExponentiation(double x,int n){
        if(n==0) return 1;

        double res=recursiveBinaryExponentiation(x,n/2);

        if(n%2==0){
            return res * res;
        }else{
            return x * res * res;
        }
    }
}

