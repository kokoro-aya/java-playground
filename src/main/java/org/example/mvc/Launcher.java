package org.example.mvc;

public class Launcher {
    public static void main(String[] args) {
        var bank = new BankController(new BankRepository(), new BankView());

        try {
            var account1 = bank.create();
            var account2 = bank.create();
            var account3 = bank.create();

            bank.deposit(account1, 100);
            bank.deposit(account2, 500);
            bank.deposit(account3, 300);

            bank.printStatement();

            bank.withdraw(account1, 200);
            bank.withdraw(account2, 350);
            bank.withdraw(account3, 200);

            bank.printStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
