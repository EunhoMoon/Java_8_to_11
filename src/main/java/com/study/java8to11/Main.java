package com.study.java8to11;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        // 익명 함수 클래스
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//            }
//        };
        RunSomething runSomething = (num) -> {
            return num + 10;
        };
        int i = runSomething.doIt(10);
        int i2 = runSomething.doIt(10);
        int i3 = runSomething.doIt(10);
        System.out.println("i = " + i);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);

        Plus10 plusTen1 = new Plus10();
        System.out.println(plusTen1.apply(10));
        Function<Integer, Integer> plusTen2 = (n) -> n + 10;
        System.out.println(plusTen2.apply(10));
        // Function<T, R> : T를 입력 받아 M을 리턴하는 함수
        Function<Integer, Integer> multiply = (n) -> n * 2;
        System.out.println(plusTen2.compose(multiply).apply(2));
        // compose() : compose()의 매개변수로 들어간 함수를 먼저 실행한 후 해당 값을 함수의 매개변수로 사용하는 메서드
        System.out.println(plusTen2.andThen(multiply).apply(2));
        // andThen() : apply()를 먼저 실행한 후 결과값을 andThen()의 매개변수로 사용

        Supplier<Integer> getTen = () -> 10;
        System.out.println(getTen.get());

        Predicate<String> startsWithT = (str) -> str.startsWith("t");
        System.out.println(startsWithT.test("test"));

        UnaryOperator<Integer> plusTen3 = (n) -> n + 10;
        System.out.println(plusTen3.apply(10));
    }

}
