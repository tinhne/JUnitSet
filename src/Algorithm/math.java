package Algorithm;

public class math {
    public boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int multiplication(int a, int b) {
        return a*b;
    }

    public int add(int a, int b) {return a+b; }

}
