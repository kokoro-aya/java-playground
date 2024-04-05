package org.example;

import org.example.mvc.BankController;
import org.example.mvc.BankRepository;
import org.example.mvc.BankView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    void demo1() {
        var executor = Executors.newFixedThreadPool(10);
        var time = System.currentTimeMillis();
        for (var i = 0; i < 100; i++) {
            var ii = i;
            executor.submit(() -> {
                try {
                    Thread.sleep(500);
                    System.out.print(ii + "\t");
                    System.out.println(System.currentTimeMillis() - time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
            });
        }
    }

    public static void main(String[] args) {

        var time = System.currentTimeMillis();

        var view = new BankView();

        var bank = new BankController(new BankRepository(), view);

        var executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> {
            while (System.currentTimeMillis() - time < 10000) {
                bank.printStatement();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        executor.submit(() -> {
            try {
                Thread.sleep(500);
                var user = bank.create();
                Thread.sleep(2000);
                bank.deposit(user, 500);
                Thread.sleep(1000);
                bank.withdraw(user, 200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.submit(() -> {
            try {
                Thread.sleep(1500);
                var user = bank.create();
                Thread.sleep(1000);
                bank.deposit(user, 500);
                Thread.sleep(3000);
                bank.withdraw(user, 400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.submit(() -> {
            try {
                Thread.sleep(2500);
                var user = bank.create();
                Thread.sleep(1000);
                bank.deposit(user, 500);
                Thread.sleep(2000);
                bank.withdraw(user, 900);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.shutdown();
    }
}