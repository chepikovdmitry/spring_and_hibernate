package byy.service;

import byy.dao.UserDao;
import byy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
