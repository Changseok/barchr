package ka.gws.barchr.persistence.api.entity.user;

import ka.gws.barchr.persistence.api.entity.AnnotatedEntity;

public interface User extends AnnotatedEntity<Long> {

  Long getId();

  String getName();

  void setName(String userName);
}
