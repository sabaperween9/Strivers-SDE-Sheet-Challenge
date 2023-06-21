import java.util.* ;
import java.io.*;
import java.util.ArrayList;

 // ============================Approach 1 ===== TC = O(n) , SC =O(n) ===================================================
public class Solution {
   
    public static int[] missingAndRepeating(ArrayList<Integer> A, int n) {

        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[A.get(i)]++;
        }

        int missing = -1;
        int repeat = -1;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0)
                missing = i;
            if (arr[i] == 2)
                repeat = i;
            if (repeat != -1 && missing != -1)
                break;
        }

        int[] al = new int[2];
        al[0] = missing;
        al[1] = repeat;
        return al;
    }
}

//  =============================Approach-2 =========TC = O(n) , SC = O(1) ==============================================================
public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> A, int n) {
        int xor = 0;
        for(int i = 0; i < n; i++) {
            xor ^= A.get(i);
            xor ^= i + 1;
        }
        int mask = xor & ~(xor - 1);
        int setBit = 0 , notSetBit = 0;
        for(int i = 0; i < n; i++) {   
            if((A.get(i) & mask) != 0) 
                setBit ^= A.get(i);
            else 
                notSetBit ^= A.get(i);

            if(((i + 1) & mask) != 0)
                setBit ^= (i + 1);
            else 
                notSetBit ^= (i + 1);
        }

        int missing = 0;
        int repeat = 0;
        for(int x : A) {
            if(x == setBit) {
                repeat = x;
                missing = notSetBit;
                break;
            }else if(x == notSetBit) {
                repeat = x;
                missing = setBit;
                break;
            }
        }

        return new int[]{missing , repeat};

    }
}
