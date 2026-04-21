package metier;

import dao.User;

public interface UserMetier {
    User login(String email, String password);
    User register(String name,String email,String password);
}
