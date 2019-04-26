/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_5;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author WH1108
 */
public class FirstOne {
    public static void main(String[] args) {
        LinkedList<Integer> randomNumbers = new LinkedList<Integer>();
        Random r = new Random();
        int low = 0;
        int high = 101;
        int result =0;int sum = 0 ;int count=0;double avg ;
        for (int i = 0; i < 25; i++) {
            result = r.nextInt(high-low) + low;
            randomNumbers.add(result);
        }
        for (int i = 0; i < randomNumbers.size(); i++) {
            sum+=randomNumbers.get(i);
            count++;
        }
        avg = sum/count;
        System.out.println("Sum of Numbers : "+sum);
        System.out.println("AVG of Numbers : "+avg);
    }
}
