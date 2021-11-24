package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getListUser() {
        return userDb.findAll();
    }

    @Override
    public UserModel getUser(String username) { return userDb.findByUsername(username); }

    @Override
    public void deleteUser(UserModel user) {
        userDb.delete(user);
    }

    @Override
    public void updatePassword(UserModel user, String password) {
        String pass = encrypt(password);
        user.setPassword(pass);
        userDb.save(user);
    }

    @Override
    public boolean passwordCheck(String password) {
        // Mengecek apakah panjang password sama atau lebih dari 8 karakter
        boolean total = password.length() >= 8;
        boolean hurufbesar = false;
        boolean hurufkecil = false;
        boolean number = false;
        boolean simbol = false;
        for (char element : password.toCharArray()) {
            // Mengecek apakah terdapat huruf besar pada password baru
            if (Character.isAlphabetic(element) && Character.isUpperCase(element)){
                hurufbesar = true;
            }
            // Mengecek apakah terdapat huruf kecil pada password baru
            if (Character.isAlphabetic(element) && Character.isLowerCase(element)){
                hurufkecil = true;
            }
            // Mengecek apakah terdapat elemen angka pada password baru
            if (Character.isDigit(element)){
                number = true;
            }
            // Mengecek apakah terdapat simbol pada password baru
            if (!Character.isAlphabetic(element) && !Character.isDigit(element)){
                simbol = true;
            }
        }
        return total && hurufbesar && hurufkecil && number && simbol;
    }
}