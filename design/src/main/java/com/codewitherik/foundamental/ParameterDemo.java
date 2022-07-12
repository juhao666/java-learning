package com.codewitherik.foundamental;


public class ParameterDemo {
    public static void main(String[] args) {
        int n = 10;
        String s = "abc";
        System.out.println("BEFORE: n = "+ n + ";" + "s = " + s);
        //值传递，原值不变
        reset(n,s);
        System.out.println(" AFTER: n = "+ n + ";" + "s = " + s);

        Person p = new Person(1, "abc");
        System.out.println("BEFORE: record p = " + p);
        //引用传递（地址传递），原值发生改变
        renamePerson(p);
        System.out.println(" AFTER: record p = " + p);

    }

    private static void renamePerson(Person p) {
        p.name = "ABC";
    }

    private static void reset(int n, String s) {
        n = 20;
        s = "ABC";
    }

    private static class Person {
        int id;
        String name;
        public Person(int n, String s) {
            this.id= n;
            this.name = s;
        }

        @Override
        public String toString() {
            return this.id + "," +this.name;
        }
    }
}
