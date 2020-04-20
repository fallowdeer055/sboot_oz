package com.example.webapp.demo;

public class CallbackDemo {


    static void doSomething1() {
        try {
            System.out.println("Begin");
            System.out.println("Middle1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("End");
        }
    }


    static void doSomething2() {
        try {
            System.out.println("Begin");
            System.out.println("Middle2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("End");
        }
    }

    static void doSomething3() {
        try {
            System.out.println("Begin");
            System.out.println("Middle3");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("End");
        }
    }


    /* static void doSomething1_3() {
        doSomethingCommon( new Different(){
            @Override
            void call() {
                System.out.println("Middle3");
            }
        });
    } */

    /*

    static void doSomethingCommon(Different different) {
        try {
            System.out.println("Begin");
            different.call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("End");
        }
    }

    */


    static void doSomethingCommon(Runnable different) {
        try {
            System.out.println("Begin");
            different.run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("End");
        }
    }

    /*
    static void doSomething2_3() {
        doSomethingCommon(new Runnable() {
            @Override
            public void run() {
                System.out.println("Middle3");
            }
        });
    }
    */


    static void doSomething2_3(int a, int b, int c) {
        doSomethingCommon(
                () -> {
                    System.out.println("Middle3"+a+b+c);
                });
    }

    public static void main(String[] args) {
        /*
        doSomething1();
        doSomething2();
        doSomething3();
        */

        doSomething2_3(5,6,7);
    }

}

/*
abstract class Different {
    abstract void call();
}
*/
