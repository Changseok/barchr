package ka.gws.barchr.persistence.api.dao;

import ka.gws.barchr.persistence.api.entity.Entity;

public interface DAO<E extends Entity<KEY>, KEY> {

  void refresh(E entity);

  void detach(E entity);

  void flush();

  void clear();
}
