/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_6;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author WH1108
 */
public class firstOne {
    public static void main(String[] args) {
        firstOperation fPrint = (n) -> System.out.printf("%d ", n);
        fPrint.operation(3);
        
        UnaryOperator<String> secondOperation = String::toUpperCase;
        System.out.println(secondOperation.apply("Mohammed"));
        
        thirdOperation<String> s = () -> {
            return "Welcome to lambdas!";
        };

        UnaryOperator<Double> fourthOperation = Math::sqrt;

        UnaryOperator<Integer> fifthOperation = cube -> cube * 3;

    }
    interface firstOperation{
        void operation(int s);
    }
    
    interface thirdOperation<T> {
        T applay();
    }


}
