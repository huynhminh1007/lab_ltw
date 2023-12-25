package dao;

import bean.User;
import db.JDBIConnector;

import java.util.Optional;

public class UserDAO {

    public static User getUserByEmail(final String email) {
        Optional<User> user = JDBIConnector.me().withHandle((handle ->
            handle.createQuery("SELECT * FROM users WHERE email = ?")
                    .bind(0, email)
                    .mapToBean(User.class)
                    .stream().findFirst()
        ));
        return user.isEmpty() ? null : user.get();
    }
}
