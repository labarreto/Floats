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
        int ex = 0;
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
        System.out.println("Problem: " + big + " + " + small);
        if (big.exp != small.exp) {

            for (int i = big.exp - small.exp; i > 0; i--) {
                big.exp--;
                big.significand = big.significand * 10;
            }

            System.out.println("#1: " + big + " + " + small);
            ex = big.exp;
        }
        

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
                sd = big.significand + big.sign*small.significand;

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
        return f;

    }

    public Floats multiplication(Floats fl) {
        Floats f;
        int si = this.sign * fl.sign;
        int sig = this.significand * fl.significand;
        int ex = this.exp + fl.exp;
        if (this.significand == 0 || fl.significand == 0) {
            f = new Floats (1, 0, 0);
            return f;
        } else {
            f = new Floats(si, sig, ex);
            f = reduce(f);
            return f;
        }

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

}
