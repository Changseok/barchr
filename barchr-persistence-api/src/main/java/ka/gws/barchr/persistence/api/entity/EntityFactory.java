package ka.gws.barchr.persistence.api.entity;

public interface EntityFactory {

  <KEY, T extends Entity<KEY>> T newEntity(Class<T> reference);
}
