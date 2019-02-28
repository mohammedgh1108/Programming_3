/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_2;

/**
 *
 * @author WH1108
 */
public class Rethrowing {
    public static void someMethod(){
        someMethod2();
    }
    public static void someMethod2()  {
        throw new ArithmeticException("/ by zero");
    }
    
    public static void main(String[] args) {
        try{
            someMethod();
        }
        catch(ArithmeticException e){
            System.out.println("rethrow an exception");
            throw e;
        }
    }
}
