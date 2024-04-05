package org.example.mvc;

public class BankDatabase {

    private BankModel _bankModel;

    public BankDatabase() {
        this._bankModel = new BankModel();
    }

    public BankModel getBankModel() {
        return _bankModel;
    }

    public void setBankModel(BankModel bankModel) {
        this._bankModel = bankModel;
    }

    public void createUser(UserModel user) {
        var lastUsers = this._bankModel.getUsers();
        for (UserModel lastUser : lastUsers) {
            if (lastUser.getId() == user.getId()) {
                throw new IllegalStateException("User exists!");
            }
        }
        lastUsers.add(user);
        this._bankModel.setUsers(lastUsers);
    }

    public UserModel findUserById(int id) {
        return this._bankModel.getUsers().stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public void setUserById(int id, UserModel user) {
        var lastUsers = this._bankModel.getUsers();
        var dirty = false;
        for (var i = 0; i < lastUsers.size(); i++) {
            if (lastUsers.get(i).getId() == id) {
                lastUsers.set(i, user);
                dirty = true;
            }
        }
        if (dirty) {
            this._bankModel.setUsers(lastUsers);
        }
    }

}
