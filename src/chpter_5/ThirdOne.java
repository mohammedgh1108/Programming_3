/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author WH1108
 */
public class ThirdOne {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/chpter_5/smallFile");
//        FileWriter fileWriter = new FileWriter(file);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        printWriter.println("Hello this mohammed ghunaim and this java so mohammed do some assignments");
//        fileWriter.close();
//        printWriter.close();
        String result =""; 
        Scanner input = new Scanner(file);
        
        while (input.hasNextLine()) {
            if (input.hasNext()) {
                result=result+input.nextLine();
            }
        }
        Map<Character , Integer> hashMapOfLetters = new HashMap/*OR HashTable*/<Character, Integer>();
        Map<String , Integer> hashMapOfWords = new HashMap/*OR HashTable*/<String, Integer>();
        
        String[] arrayOfWords = result.split(" ");
        char[] arrayOfChar = result.toCharArray();

        for (String s :arrayOfWords) {
            if (hashMapOfWords.containsKey(s)) {
                hashMapOfWords.put(s, hashMapOfWords.get(s)+1);
            }else{
                hashMapOfWords.put(s, 1);
            }
        }
        
        for(char c : arrayOfChar){
            if (hashMapOfLetters.containsKey(c)) {
                hashMapOfLetters.put(c, hashMapOfLetters.get(c)+1);
            }else{
                hashMapOfLetters.put(c, 1);
            }
        }
        
        for (String key : hashMapOfWords.keySet()) {
            System.out.println(key + " : number of occurrences  is "+hashMapOfWords.get(key));
        }
        System.out.println("");
        for(Character key : hashMapOfLetters.keySet()){
            System.out.println(key+" : number of occurrences  "+hashMapOfLetters.get(key));
        }
        //System.out.println(arrayOfChar[5]);
        
        
    }
}
