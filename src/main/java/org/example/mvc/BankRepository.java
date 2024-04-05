package org.example.mvc;

import java.util.List;

public class BankRepository {

    BankDatabase bankDatabase;

    public BankRepository() {
        this.bankDatabase = new BankDatabase();
    }

    public UserModel fetchUser(int id) {
        return this.bankDatabase.findUserById(id);
    }

    public void insertUser(UserModel user) {
        if (this.bankDatabase.findUserById(user.getId()) == null) {
            this.bankDatabase.createUser(user);
        } else {
            // Report that user exists already...
            System.out.println("User exists already...");
        }
    }

    public void updateUser(UserModel user) {
        if (this.bankDatabase.findUserById(user.getId()) != null) {
            this.bankDatabase.setUserById(user.getId(), user);
        } else {
            this.bankDatabase.createUser(user);
        }
    }

    public List<UserModel> fetchAll() {
        return this.bankDatabase.getBankModel().getUsers();
    }

}
