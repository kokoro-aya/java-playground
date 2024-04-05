package org.example.mvc;

import java.util.List;

public class BankController {
    BankRepository repository;
    BankView view;

    private int randomId;

    public BankController(BankRepository repository, BankView view) {
        this.repository = repository;
        this.view = view;
        this.randomId = 0;
    }

    public int create() {
        var newUser = new UserModel(randomId);
        this.repository.insertUser(newUser);
        return randomId++;
    }

    public void deposit(int id, int amount) {
        var user = this.repository.fetchUser(id);
        user.setAmount(amount);
        this.repository.updateUser(user);
    }

    public void withdraw(int id, int amount) {
        var user = this.repository.fetchUser(id);
        if (user.getAmount() > amount) {
            user.setAmount(user.getAmount() - amount);
            this.repository.updateUser(user);
        } else {
            System.out.println("Insufficient funds, operation cancelled");
        }
    }

    public void printStatement() {
        List<UserModel> users = this.repository.fetchAll();
        view.printStatements(users);
    }
}
