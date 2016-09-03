package ka.gws.barchr.persistence.api.dao;

import ka.gws.barchr.persistence.api.entity.user.User;

import java.util.List;


public interface UserDAO extends DAO<User, Long> {

  <T extends User> T find(Long key);

  List<User> findAll();

  <T extends User> T save(T user);

  <T extends User> void delete(T user);
}
