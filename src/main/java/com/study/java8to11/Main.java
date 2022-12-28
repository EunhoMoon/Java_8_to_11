package com.study.java8to11;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // 익명 함수 클래스
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public int doIt(int num) {
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

        Main main = new Main();
        main.run();
    }

    public void run() {
        int baseNumber = 10;    // 변수 캡쳐, 사실상 final(effective final)

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                // 쉐도윙 : 해당 변수가 run()의 변수를 참조하지 않는다.(해당 클래스의 scope가 run의 scope를 가린다.) -> 같은 scope가 아니다.
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                // 쉐도윙 : run()의 변수를 참조하지 않는다.(해당 클래스의 scope가 run의 scope를 가린다.) -> 같은 scope가 아니다.
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println("Print Int" + (i + baseNumber)); // run()과 같은 scope, 따라서 '쉐도윙'하지 않는다.
        };

//        baseNumber++; baseNumber를 뒤에서 바꾸면 effective final이 아니기 때문에 컴파일 에러가 난다.
        printInt.accept(10);
    }

}
