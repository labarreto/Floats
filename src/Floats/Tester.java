/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Floats;

public class Tester {
    
    public static double convertToDouble(Floats f) {
        double conversion = f.sign*Math.abs(f.significand)*Math.pow(10,f.exp);
        
        return conversion;
    }
    
    public static Floats createRandFloat() {
        Floats f;
        int s = 1;
        int sd = 1;
        int ex = Utility.randInt(1,9);
        
        if (Utility.coinToss()) {
            s = -1;
        } 
        
        if (Utility.coinToss()) {
            ex = Utility.randInt(-9, -1);
        }
        
        int rand = Utility.randInt(1, 499);
        if (rand%10 != 0) {
            sd = rand;
        }
        
        f = new Floats(s, sd, ex);
        return f;
        
    }

    
        public static void main(String[] args) {
        // both signs are the same

        Floats l0 = new Floats(1, 325, -2);
        Floats r0 = new Floats(1, 5, -3);

        Floats l1 = new Floats(-1, 325, -2);
        Floats r1 = new Floats(-1, 5, -3);

        // magnitudes cancel each other 
        Floats l2 = new Floats(-1, 325, -2);
        Floats r2 = new Floats(1, 325, -2);

       
        Floats l3 = new Floats(1, 325, -2);
        Floats r3 = new Floats(-1, 325, -2);

        // Answers should be negative
        Floats l4 = new Floats(1, 3255, -3);
        Floats r4 = new Floats(-1, 345, -2);

        Floats l5 = new Floats(-1, 325, -2);
        Floats r5 = new Floats(1, 5, -1);

        // Answers should be positive
        Floats l6 = new Floats(-1, 3255, -3);
        Floats r6 = new Floats(1, 345, -2);

        Floats l7 = new Floats(1, 325, -2);
        Floats r7 = new Floats(-1, 5, -1);
        
        Floats l8 = new Floats (1, 5, -1);
        Floats r8 = new Floats (-1, 4, 2);
        Floats l9 = new Floats (1, 2, 1);
        Floats r9 = new Floats (1, 5, -1);
        
        Floats zero = new Floats(1, 0, 1);

//        Floats lx = new Floats(-1, 375, -2);
//        Floats rx = new Floats(1, 25, -2);
//
//        Floats ly = new Floats(-1, 3755, -3);
//        Floats ry = new Floats(1, 25, -2);

        System.out.println("*~~~~~~~~~ Multiplication ~~~~~~~~~*");
        System.out.println("Case 1: Both signs are the same");
        System.out.println("Problem: " + l1 + " * " + l2);
        System.out.println("Result: " + l1.multiplication(l2));
        System.out.println();
        System.out.println("Problem: " + r2 + " * " + l3);
        System.out.println("Result: " + r2.multiplication(l3));
        System.out.println();
        System.out.println("Case 2: Signs are different");
        System.out.println("Problem: " + l8 + " * " + r8);
        System.out.println("Result: " + l8.multiplication(r8));
        System.out.println();
        System.out.println("Problem: " + r8 + " * " + l8);
        System.out.println("Result: " + r8.multiplication(l8));
        System.out.println();
        System.out.println("Case 3: Multiply by 0");
        System.out.println("Problem: " + l7 + " * " + zero);
        System.out.println("Result: " + l7.multiplication(zero));
        System.out.println();
        System.out.println("Problem: " + zero + " * " + l7);
        System.out.println("Result: " + zero.multiplication(l7));
        System.out.println();
        System.out.println("Case 4: Supporting Division");
        System.out.println("Problem: " + r8 + " * " + r9);
        System.out.println("Result: " + r8.multiplication(r9));
        System.out.println();


        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("*~~~~~~~~~ Addition ~~~~~~~~~*");
        System.out.println("Case 1: Both signs are the same");
        System.out.println("Result: " + l0.addition(r0));
        System.out.println();
        System.out.println("Result: " + l1.addition(r1));
        System.out.println();
        System.out.println("Case 2: Magnitudes cancel each other");
        System.out.println("Result: " + l2.addition(r2)); 
        System.out.println();
        System.out.println("Result: " + l3.addition(r3));
        System.out.println();
        
        System.out.println("Case 3: Answers should be negative");
        System.out.println("Result: " + l4.addition(r4));
        System.out.println();
        System.out.println("Result: " + l5.addition(r5));
        System.out.println();
        
        System.out.println("Case 4: Answers should be positive");
        System.out.println("Result: " + l6.addition(r6));
        System.out.println();
        System.out.println("Result: " + l7.addition(r7));
        System.out.println();
        
        System.out.println("Case 5: Adding by zero");
        
        System.out.println("Problem: " + l1 + " + " + zero);
        System.out.println("Result: " + l1.addition(zero));
        
        System.out.println();
        System.out.println("Problem: " + zero + " + " + l1);
        System.out.println("Result: " + zero.addition(l1));
        System.out.println();
        
//       // System.out.println(toString(add) + " " + toString(mult));
        System.out.println("*~~~~~~~~~ Initiating Random Addition Testing ~~~~~~~~~*");
        for (int i = 0; i < 50; i ++) {
            Floats f1 = createRandFloat();
            Floats f2 = createRandFloat();
            System.out.println();
            System.out.println("Problem " + i + ": " + f1 + " + " +f2);

            System.out.println("Result " + i + ": " + f1.addition(f2));
            
            System.out.println();
        }
        
        System.out.println("*~~~~~~~~~ Initiating Random Multiplication Testing ~~~~~~~~~*");
        for (int i = 0; i < 50; i ++) {
            Floats f1 = createRandFloat();
            Floats f2 = createRandFloat();
            System.out.println();
            System.out.println("Problem " + i + ": " + f1 + " * " +f2);
            System.out.println("Result " + i + ": " + f1.multiplication(f2));
            System.out.println();
        }

    }
    

    
    
}
