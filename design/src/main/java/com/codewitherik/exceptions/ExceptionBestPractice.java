package com.codewitherik.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;


public class ExceptionBestPractice {
    private Logger log;

    // best practice 1
    public void automaticallyCloseResource() {
        File file = new File("./tmp.txt");
        try (FileInputStream inputStream = new FileInputStream(file);) {
            // use the inputStream to read a file
        } catch (FileNotFoundException e) {
//            log.error(e);
        } catch (IOException e) {
//            log.error(e);
        }
    }

    // best practice 2
    public void doNotDoThis() throws Exception {
        //
    }

    public void doThis() throws NumberFormatException {
        //
    }
    // best practice 3

    /**
     * This method does something extremely useful ... *
     *
     * @param input * @throws MyBusinessException if ... happens
     */
    public void doSomething(String input) throws MyBusinessException {
        //
    }

    // best practice 4
    public void wrapDescriptionException() {
        try {
            new Long("xyz");
        } catch (NumberFormatException e) {
            //log.error(e);// with description
            //17:17:26,386 ERROR TestExceptionHandling:52 - java.lang.NumberFormatException: For input string: "xyz"
        }
    }

    // best practice 5
    public void catchMostSpecificExceptionFirst() {
        try {
            //doSomething("A message");
        } catch (NumberFormatException e) {
            //log.error(e); //catch the specific exception first
        } catch (IllegalArgumentException e) {
            //log.error(e);
        }
    }

    // best practice 6
    public void doNotCatchThrowable() {
        try {
            // do something
        } catch (Throwable t) {
            // don't do this!
        }
    }

    // best practice 7
    public void logAnException() {
        try { // do something
        } catch (NumberFormatException e) {
            // this will never happen
            //log.error("This should never happen: " + e);
        }
    }

    // best practice 8
    public void dontLogAndThrowException(String input) {
        try {
            new Long("xyz");
        } catch (NumberFormatException e) {
            //don't throw and log the error at the same time
            //log.error(e);
            throw e;
        }
    }

    // best practice 9
    public void wrapException(String input) throws MyBusinessException {
        try {
            // do something
        } catch (NumberFormatException e) {       //catch标准异常 抛出和自己业务相关的具体自定义异常
            throw new MyBusinessException("A message that describes the error.", e);
        }
    }

    static class MyBusinessException extends Exception {
        public MyBusinessException(String s, NumberFormatException e) {
        }
    }
}
    


