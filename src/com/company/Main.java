package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        int res = 0;
        File input = new File("Input.txt");

        try (Scanner scan = new Scanner(input)) {
            while (scan.hasNextLine()) {
                String buf = scan.nextLine();
                String[] words = buf.split("[\\s,.:!?()\"—]+");
                Pattern pattern = Pattern.compile("^[AEYUIOaeyuio].*[aeyuio]$");

                for (String word : words) {
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.find()) {
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
        catch (FileNotFoundException exp) {
            System.out.println("I don't see file, bro :C");
        }
    }
}