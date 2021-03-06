package byy.dao;

import byy.service.UserService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:aplication-context.xml")
public class UserDaoTest {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    UserService userService;
    @Test
    public void notNullSessionFactory(){
        assertThat(sessionFactory,notNullValue());
    }

    @Test
    public void test2(){

        assertThat(userService.findAll(),notNullValue());
    }
}
