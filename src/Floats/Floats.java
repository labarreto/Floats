/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Floats;

import java.util.*;

//significand is always an integer value
//example 3.25. sign 1, significand 325, exponent -2
//sign 1  or -1
//.005 sign 1, significand 5, exponent -3
//3.255 sign 1, significand 3255, exponent -3
// go to lowest exponent in order to keep numbers as integers
// for each power of 10 that it's off by, multiply by 10
// now in order to add them,
// 
//multiplication, sign 1, significand 254 , exp -2
//                sign 1, significand 25, exp -1
// 6350, exp -3 --> 6350, exp -2
//
public class Floats {

    int sign;
    int exp;
    int significand;

    public Floats(int sign, int significand, int exp) {
        this.sign = sign;
        this.exp = exp;
        this.significand = significand;
    }



    public Floats addition(Floats fl) {
        Floats f;
        int s = 0;
        int sd = 0;
        int ex = 1;
//        System.out.println("#0: " + this + " | " + fl);

        // case where you add 0
        if (this.significand == 0) {
            return fl;
        } else if (fl.significand == 0) {
            return this;
        }

        // case where magnitudes cancel each other
        if ((this.significand == fl.significand) && (this.exp == fl.exp)
                && ((this.sign == -1 && fl.sign == 1) || (this.sign == 1 && fl.sign == -1))) {
            s = 1;
            sd = 0;
            
        }

        Floats big;
        Floats small;

        // assigning which number is numerically bigger. depends on exponent. 
        if (fl.exp > this.exp) {
            big = fl;
            small = this;
        } else {
            // in the case when the exp are equal, the next for loop
            // will not do anything since big - small = 0. 
            big = this;
            small = fl;
        }
        System.out.println("before loop: " + big + ", " + small);
        if (big.exp != small.exp) {
            
            System.out.println("1: " + big + " + " + small);
            
            for (int i = big.exp - small.exp; i > 0; i--) {
                
                System.out.println("2: " + big + " + " + small);
                
                big.exp--;
                big.significand = big.significand * 10;
            }
            
            System.out.println("3: " + big + " + " + small);
        }
        ex = big.exp;

        // if big.sign 
        if ((big.sign == -1 && small.sign == -1)
                || (big.sign == 1 && small.sign == 1)) {
            s = big.sign;
            sd = small.significand + big.significand;

        }

        if (big.sign == -1 && small.sign == 1) {
            if (big.significand > small.significand) { // magnitude of significand
                s = -1;
                //sd = small.significand + big.sign * big.significand;
                sd = big.significand + small.significand;

            } else if (big.significand < small.significand) {
                s = 1;
                sd = small.significand + big.sign * big.significand;
            }

        }
        if (big.sign == 1 && small.sign == -1) {
            if (small.significand > big.significand) {
                s = -1;
                sd = small.significand + small.sign * big.significand;

            } else if (small.significand < big.significand) {
                s = 1;
                sd = big.significand + small.sign * small.significand;

            }

        }
        f = new Floats(s, sd, ex);
        f = reduce(f);
        return f;

    }

    public Floats multiplication(Floats fl) {
        Floats f;
        int si = this.sign * fl.sign;
        int sig = this.significand * fl.significand;
        int ex = this.exp + fl.exp;
        f = new Floats(si, sig, ex);
        f = reduce(f);
        return f;

    }

    Floats reduce(Floats l) {
        int res = l.significand;
        int ex = l.exp;
        while (res % 10 == 0) {
            ex = l.exp--;
            res = res / 10;

        }
        return new Floats(l.sign, res, ex);
    }

    int intpower(int base, int exponent) {
        int aux = 1;
        for (int i = 0; i < exponent; i++) {
            aux *= base;
        }
        return aux;
    }

    public String toString() {
        Integer si = this.sign;
        Integer sig = this.significand;
        Integer ex = this.exp;
        String signS = si.toString();
        String significandS = sig.toString();
        String exponentS = ex.toString();
        String stringIt = "(" + signS + " " + significandS + " " + exponentS + ")";
        return stringIt;
    }

    public static void main(String[] args) {
        // both signs are the same

        Floats l0 = new Floats(1, 325, -2);
        Floats r0 = new Floats(1, 5, -3);

        Floats l1 = new Floats(-1, 325, -2);
        Floats r1 = new Floats(-1, 5, -3);

        // numbers cancel each other out
        // this case causes infinite loop!!!!
        Floats l2 = new Floats(-1, 325, -2);
        Floats r2 = new Floats(1, 325, -2);

        // answer should have pos sign
        Floats l3 = new Floats(1, 325, -2);
        Floats r3 = new Floats(-1, 5, -1);

        // answer should have neg sign
        Floats l4 = new Floats(1, 3255, -3);
        Floats r4 = new Floats(-1, 345, -2);

        // answer should have neg sign
        Floats l5 = new Floats(-1, 325, -2);
        Floats r5 = new Floats(1, 5, -1);

        // answer should have pos sign
        Floats l6 = new Floats(-1, 3255, -3);
        Floats r6 = new Floats(1, 345, -2);

        Floats zero = new Floats(1, 0, 1);

        Floats lx = new Floats(-1, 375, -2);
        Floats rx = new Floats(1, 25, -2);

        Floats ly = new Floats(-1, 3755, -3);
        Floats ry = new Floats(1, 25, -2);

        System.out.println("Result: " +l0.addition(r0).toString());
        System.out.println("Result: " +l1.addition(r1).toString());
        System.out.println("Result: " +l2.addition(r2).toString()); //<- this case causes infinite loop
        System.out.println(l3.addition(r3).toString());
        System.out.println(l4.addition(r4).toString());
        System.out.println(l5.addition(r5).toString());
        System.out.println(l6.addition(r6).toString());
        System.out.println(lx.addition(rx).toString());
        System.out.println(ly.addition(ry).toString());
        System.out.println(l1.addition(zero));
        System.out.println(zero.addition(l1));
//
//       // System.out.println(toString(add) + " " + toString(mult));

    }

}
