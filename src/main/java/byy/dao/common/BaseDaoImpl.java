package byy.dao.common;

import byy.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
    @Autowired
    private  SessionFactory sessionFactory;

    private Class<T> type;
    public BaseDaoImpl() {
        this.type =  (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);;
    }


    @Override
    public void save(T entity) {
       // sessionFactory.openSession().beginTransaction();

        Session session = sessionFactory.getCurrentSession();
        System.out.println("session = "+session);
        session.save(entity);
        findAll();
//        sessionFactory.getCurrentSession().getTransaction().commit();
//        sessionFactory.getCurrentSession().close();
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
       /* Transaction transaction = session.beginTransaction();
        System.out.println(type.getName());*/
        System.out.println("session = "+session);
        List<T> resultList = session.createQuery("from " + type.getName(), type).getResultList();
       /* transaction.commit();
        session.close();*/


        return resultList;
    }
}
