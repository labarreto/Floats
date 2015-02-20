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

    public Floats addition(Floats right) {
        //make exp that's numerical higher match the lower one. 
        Floats r;
        Floats l;
        if (this.significand == 0) {
            return right;
        } else if (right.significand == 0) {
            return this;
        }
        if (this.exp < right.exp) {
            r = new Floats(right.sign, right.significand, right.exp);
            l = new Floats(this.sign, this.significand, this.exp);
        } else {
            r = new Floats(this.sign, this.significand, this.exp);
            l = new Floats(right.sign, right.significand, right.exp);
        }
        if (l.sign < 0) {

        }
        int diff_exp = r.exp - l.exp;
        l.exp = l.exp - diff_exp;
        l.significand = l.sign * l.significand + r.sign * r.significand;

        l.sign = (l.significand / l.significand);
        l.significand = Math.abs(l.significand);
        // l = reduce(l);
        return l;
    }

    public Floats addition2(Floats fl) {
        Floats f;
        int s = 0;
        int sd = 0;
        int ex;
        if (this.significand == 0) {
            return fl;
        } else if (fl.significand == 0) {
            return this;
        }
        //int nexp = fl.exp;
        Floats big;
        Floats small;
        if (fl.exp > this.exp) {
            big = fl;
            small = this;
        } else { // in the case when the exp are equal, the next for loop
            // will not do anything since big - small = 0. 
            big = this;
            small = fl;
        }
        for (int i = big.exp - small.exp; i > 0; i--) {
            big.exp--;
            big.significand = big.significand * 10;
        }
        ex = big.exp;
        if ((big.sign == -1 && small.sign == -1)
                || (big.sign == 1 && small.sign == 1)) {
            s = big.sign;
            sd = small.significand + big.significand;
        }
        if (big.sign == -1 && small.sign == 1) {
            if (big.significand > small.significand) { // magnitude of significand
                s = -1;
                sd = small.significand + big.sign * big.significand;
               
            } else if (big.significand < small.significand) {
                s = 1;
                sd = small.significand + big.sign * big.significand;
              
            }

        }
        if (big.sign == 1 && small.sign == -1) {
            if (small.significand > big.significand) {
                s = -1;
                sd = big.significand + small.sign * small.significand;
               
            } else if (small.significand < big.significand) {
                s = 1;
                sd = big.significand + small.sign * small.significand;
                
            }

        }
        return new Floats(s, sd, ex);

    }

    public Floats multiplication(Floats fl) {
        Floats f;
        if (fl.significand == 0 || this.significand == 0) {
            f = new Floats(1, 0, 1);
        }
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

    static String stringIt(Floats f) {
        Integer si = f.sign;
        Integer sig = f.significand;
        Integer ex = f.exp;
        String signS = si.toString();
        String significandS = sig.toString();
        String exponentS = ex.toString();
        String stringIt = "(" + signS + " " + significandS + " " + exponentS + ")";
        return stringIt;
    }

    public static void main(String[] args) {
        Floats lf = new Floats(1, 325, -2);
        Floats rf = new Floats(1, 5, -3);

        Floats add = lf.addition2(rf);

        Floats mult = lf.multiplication(rf);

        System.out.println(stringIt(add) + " " + stringIt(mult));

    }

}
