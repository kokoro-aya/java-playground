package org.example.mvc;

import java.util.ArrayList;
import java.util.List;

public class BankModel {
    private List<UserModel> _users;

    public BankModel() {
        this._users = new ArrayList<>();
    }

    public List<UserModel> getUsers() {
        return _users;
    }

    public void setUsers(List<UserModel> users) {
        this._users = users;
    }
}
