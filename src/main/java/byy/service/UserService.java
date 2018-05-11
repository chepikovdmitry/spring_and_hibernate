package byy.service;

import byy.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
}
