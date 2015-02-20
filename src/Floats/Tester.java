/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Floats;

/**
 *
 * @author ldbruby95
 */
public class Tester {
    
    public double convertToDouble(Floats f) {
        double conversion = f.sign*Math.abs(f.significand)*Math.pow(10,f.exp);
        
        return conversion;
    }
    
    
}
