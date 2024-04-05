package org.example.mvc;

public class UserModel {
    private int _id;
    private int _amount;

    public UserModel(int _id) {
        this._id = _id;
        this._amount = 0;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public int getAmount() {
        return _amount;
    }

    public void setAmount(int amount) {
        this._amount = amount;
    }
}
