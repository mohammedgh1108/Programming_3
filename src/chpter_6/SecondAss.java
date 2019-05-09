/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author WH1108
 */
public class SecondAss {
    public static void main(String[] args) throws IOException {
        Long wordsCount = Files.lines(Paths.get("./src/chpter_6/text.txt"))
            .flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
            .filter(s->s.length()>0).count();
        System.out.println(wordsCount);
    }
}
