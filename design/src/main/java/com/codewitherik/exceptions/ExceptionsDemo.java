package com.codewitherik.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ExceptionsDemo {

    public static void show() {
        FileReader reader = null;
        try {
            reader = new FileReader("demo.txt");
            var value = reader.read();
            System.out.println("file opened");
            new SimpleDateFormat().parse("");
        } catch (FileNotFoundException e) {
            System.out.println("File does not existed");
            //throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("could not read data" );
        } catch (ParseException e) {
            System.out.println("ExceptionsDemo.show");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ;

        //sayHello(null);
    }

    public static void sayHello(String name){
        System.out.println("name = " + name.toUpperCase(Locale.ROOT));
    }
}
