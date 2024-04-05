package org.example.mvc;

import java.util.List;

public class BankView {

    public void printStatements(List<UserModel> users) {
        for (var user : users) {
            System.out.println("User(" + user.getId() + "): $" + user.getAmount());
        }
        System.out.println();
    }

}
