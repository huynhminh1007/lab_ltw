package service;

import bean.User;
import dao.UserDAO;

public class UserService {

    private static UserService instance;

    public static UserService getInstance() {
        if(instance == null) instance = new UserService();
        return instance;
    }

    public User checkLogin(String email, String password) {
        User user = UserDAO.getUserByEmail(email);

        if(user == null) return null;
        if(!user.getEmail().equals(email) || !user.getPassword().equals(password)) return null;

        return user;
    }
}
