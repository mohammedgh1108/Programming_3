/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_6;

import java.util.function.Predicate;

/**
 *
 * @author WH1108
 */
public class firstOne {
    public static void main(String[] args) {
        firstOperation fPrint = (n) -> System.out.printf("%d ", n);
        fPrint.operation(3);
        

    }
    interface firstOperation<T>{
        void operation(T s);
    }
    
    interface Square{ 
        int calculate(int x); 
    }
    interface toUpperCase<T>{
        String upper(T s);
    }
}
