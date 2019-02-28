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
public class TestException {
    public static void main(String[] args){
        try{
            getExceptionB();
        }catch(ExceptionA ea){
            ea.printStackTrace();
        }
        try{
            getExceptionC();
        }catch(ExceptionA ea){
            ea.printStackTrace();
        }
    }

    public static void  getExceptionB() throws ExceptionB{
        throw new ExceptionB("Exception B");
    }

    public static void  getExceptionC() throws ExceptionC{
        throw new ExceptionC("Exception C");
    }
}
