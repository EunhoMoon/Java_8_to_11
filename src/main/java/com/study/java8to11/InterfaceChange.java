package com.study.java8to11;

public class InterfaceChange {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("test");
        foo.printName();

        foo.printNameUpperCase();
    }
}
