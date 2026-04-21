package metier;

import dao.User;
import dao.UserDAO;
import dao.UserImpl;
import metier.UserMetier;

public class UserMetierImpl implements UserMetier {
    private UserDAO userDAO;

    public UserMetierImpl() {
        this.userDAO = new UserImpl();
    }

    @Override
    public User login(String email, String password) {
        User user = userDAO.finduser(email, password);
        return user;
    }

    @Override
    public User register(String name, String email, String password) {

        if (userDAO.checkifemailexist(email)) {
            return null;
        }

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        u.setRole("USER");

        userDAO.save(u);
        return u;
    }
}