package byy;

import byy.repository.UserRepository;
import config.DataBaseConfig;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class main {


    public static void main(String[] args) {
        System.out.println("HI");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataBaseConfig.class);

        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        System.out.println(userRepository.findById(1L));




    }
}
