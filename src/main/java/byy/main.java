package byy;

import byy.dao.UserDao;
import byy.dao.UserDaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class main {

    public static void main(String[] args) {
        System.out.println("HI");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("aplication-context.xml");
        SessionFactory sessionFactory = classPathXmlApplicationContext.getBean(SessionFactory.class);
        System.out.println(sessionFactory);
        /*Session session = sessionFactory.openSession();
        Transaction transaction0 = session.beginTransaction();
        session.save(new User("test1","test"));
        transaction0.commit();
        Transaction transaction = session.beginTransaction();

        List<User> userList = session.createQuery("from byy.entity.User", User.class).getResultList();
        System.out.println(userList.size());
        userList.forEach(item-> System.out.println(item));
        transaction.commit();
        session.close();*/
        UserDao userDao = classPathXmlApplicationContext.getBean(UserDaoImpl.class);
        userDao.findAll().forEach(item-> System.out.println(item));
    }
}
