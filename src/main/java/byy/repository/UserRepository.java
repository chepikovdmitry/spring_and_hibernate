package byy.repository;

import byy.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User,Integer> {
    User findOne(Integer id);

}
