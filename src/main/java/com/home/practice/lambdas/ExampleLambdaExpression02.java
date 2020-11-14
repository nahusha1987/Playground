package com.home.practice.lambdas;


import java.util.concurrent.*;

public class ExampleLambdaExpression02 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Runnable r = () -> System.out.println("Hello, Lambda");
        new ExampleLambdaExpression02().methodAcceptingRunnable(r);
        // 				OR
        //	create inline lambda expression
        new ExampleLambdaExpression02().methodAcceptingRunnable(() -> {
            System.out.println("Hello, Lambda");
            persist();
            email();
        });


        Callable<String> c = () -> "Hello world!";
        new ExampleLambdaExpression02().methodAcceptingCallable(c);
        //				OR
        //		create inline lambda expression
        new ExampleLambdaExpression02().methodAcceptingCallable(() -> {
            return "Hello World";
        });
    }

    private static void email() {
    }

    private static void persist() {
    }

    public void methodAcceptingRunnable(Runnable r) {
        new Thread(r).start();
    }

    public void methodAcceptingCallable(Callable<String> c) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future result = es.submit(c);
        System.out.println(result.get());
    }
}
