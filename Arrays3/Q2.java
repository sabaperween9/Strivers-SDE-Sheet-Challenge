class Solution {
    public double myPow(double x, int n) {
        
        if(n < 0) 
            x = 1/x;
        return helper(x , n);

    }   

    double helper(double x , int n) {
        if(n == 0)
            return 1.0;
        if(n == 1)
            return x;
        double temp = helper(x , n/2);
        temp *= temp;
        if(n % 2 != 0)
            temp *= x;
        return temp;
    }   
}
