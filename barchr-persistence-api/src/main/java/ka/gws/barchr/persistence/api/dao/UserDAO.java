package ka.gws.barchr.persistence.api.dao;

import java.util.List;

import ka.gws.barchr.persistence.api.entity.user.User;


public interface UserDAO extends DAO<User, Long> {

  <T extends User> T find(Long key);

  List<User> findAll();

  <T extends User> T save(T user);

  <T extends User> void delete(T user);
}
