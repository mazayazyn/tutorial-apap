package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getListUser();
    UserModel getUser(String username);
    void deleteUser(UserModel user);
    void updatePassword(UserModel user, String password);
    boolean passwordCheck(String password);
}
