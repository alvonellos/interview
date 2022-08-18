package com.alvonellos.interview.util.threading;

import java.util.ArrayList;
import java.util.List;

public class Foo {

    public static volatile List<Integer> order = new ArrayList<>();
    int flag=0;
    public Foo() {


    }

    synchronized public void first(Runnable printFirst) throws InterruptedException {
        while(flag!=0){
            wait();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        order.add(1);
        flag=1;
        notifyAll();
    }

    synchronized public void second(Runnable printSecond) throws InterruptedException {
        while(flag!=1){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        order.add(2);
        flag=2;
        notifyAll();
    }

    synchronized public void third(Runnable printThird) throws InterruptedException {
        while(flag!=2){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        order.add(3);
        flag=0;
        notifyAll();
    }
}