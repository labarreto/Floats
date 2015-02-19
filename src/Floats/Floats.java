/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Floats;

/**
 *
 * @author ldbruby95
 *
 */
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
  
    public Floats(int sign, int significand, int exp){
        this.sign = sign;
        this.exp = exp;
        this.significand = significand;
    }
    
    
    public Floats addition(Floats fl) {
        Floats f1 = new Floats (fl.sign, fl.significand, fl.exp);
        Floats f2;
        while (! (fl.exp > this.exp)){
            f1 = new Floats(fl.sign, fl.significand*10, fl.exp--);
        } 
        if (f1.significand > this.significand && fl.sign != this.sign){
            
        }
        return f1;
    }
    
    public Floats multiplication(Floats fl){ 
        // this has problems with reduction 
        
       Floats f;
       int si = this.sign * this.sign;
       int sig = this.significand * fl.significand;
       int ex = this.exp + fl.exp;
       f = new Floats(si, sig, ex);
       return f;
       
    }
    
    Floats reduce(Floats l) {
        int res = (int) l.significand/10;
        int exp = (int) l.exp;
        while (res * 10 == l.significand) {
            res = l.significand;
            exp = l.exp--;
            
            res = (int) l.significand/10;
            
        } 
        return new Floats(l.sign, res, exp);        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
