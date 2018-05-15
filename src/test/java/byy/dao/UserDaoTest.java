package byy.dao;


import byy.entity.User;
import byy.repository.UserRepository;
import config.DataBaseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataBaseConfig.class)
public class UserDaoTest {
    @Autowired
    UserRepository userRepository;
    @Test
    public void notNullUserRepository(){
        assertThat(userRepository,notNullValue());
    }

    @Test
    public void findOne(){
        User byId = userRepository.findById(1L);
        System.out.println(byId);
        assertThat(byId,notNullValue());

    }
}
