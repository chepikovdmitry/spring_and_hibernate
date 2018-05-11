package byy;

import byy.dao.UserDao;
import byy.dao.UserDaoImpl;
import byy.dao.config.DataBaseConfig;
import byy.entity.User;
import byy.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class main {

    public static void main(String[] args) {
        System.out.println("HI");
     //   ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("aplication-context.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataBaseConfig.class);
        SessionFactory sessionFactory = applicationContext.getBean(SessionFactory.class);
        System.out.println(sessionFactory);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.save(new User("test1","test"));
        userService.findAll().forEach(item-> System.out.println(item));

    }
}
