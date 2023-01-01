package com.study.java8to11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
//        UnaryOperator<String> hi = (s) -> "hi " + s;
        UnaryOperator<String> hi = Greeting::hi;    // 메서드 레퍼런스, static 메서드
        hi.apply("test");   // UnaryOperator 의 apply를 해야 생성

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;    // 메서드 레퍼런스, 인스턴스 메서드
        hello.apply("test");   // UnaryOperator 의 apply를 해야 생성

        Supplier<Greeting> supplier = Greeting::new;    // 생성자
        Greeting greeting1 = supplier.get();    // 생성자 래퍼런스를 통해 생성


        Function<String, Greeting> function = Greeting::new;    // 파라미터가 있는 생성자
        Greeting test = function.apply("test"); // 이 시점에 생성
        String name = test.getName();
        System.out.println("name = " + name);

        String[] names = {"Hong", "Moon", "Amie"};
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
        Arrays.sort(names, String::compareToIgnoreCase);    // 임의 객체 메서드 참조
        System.out.println(Arrays.toString(names));
    }

}
