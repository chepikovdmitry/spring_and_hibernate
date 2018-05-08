package byy.dao.common;

import byy.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {
  void save(T entity);
  List<T> findAll();
}
