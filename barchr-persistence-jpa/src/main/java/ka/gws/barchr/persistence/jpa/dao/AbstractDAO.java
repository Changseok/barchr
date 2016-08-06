package ka.gws.barchr.persistence.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;

import ka.gws.barchr.persistence.api.dao.DAO;
import ka.gws.barchr.persistence.api.entity.Entity;


@Configurable
public abstract class AbstractDAO<E extends Entity<KEY>, KEY> implements DAO<E, KEY> {

  protected static final Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);

  @PersistenceContext(unitName = "rmmaster")
  protected EntityManager entityManager;

  @Override
  public void refresh(final E entity) {
    entityManager.refresh(entity);
  }

  @Override
  public void detach(final E entity) {
    entityManager.detach(entity);
  }

  @Override
  public void flush() {
    entityManager.flush();
  }

  @Override
  public void clear() {
    entityManager.clear();
  }
}
