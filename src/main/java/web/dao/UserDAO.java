package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    void delete(long id);
    User getUserById(long id);
    void update(User user);
    List<User> getAllUsers();
}
