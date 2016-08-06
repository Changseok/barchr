package ka.gws.barchr.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ka.gws.barchr.persistence.api.dao.UserDAO;
import ka.gws.barchr.persistence.api.entity.user.User;
import ka.gws.barchr.persistence.jpa.entity.user.JPAUser;


@Repository
public class JPAUserDAO extends AbstractDAO<User, Long> implements UserDAO {

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T extends User> T find(Long key) {
		return (T) entityManager.find(JPAUser.class, key);
		// final Query query = entityManager
		// .createQuery("SELECT e FROM " + JPAUser.class.getSimpleName() + " e
		// WHERE e.id=:id");
		// query.setParameter("id", key);
		//
		// List<T> result = query.getResultList();
		// return result.isEmpty() ? null : result.iterator().next();
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		TypedQuery<User> query = entityManager.createQuery("SELECT e FROM " + JPAUser.class.getSimpleName() + " e",
				User.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public <T extends User> T save(T user) {
		return entityManager.merge(user);
	}

	@Override
	@Transactional
	public <T extends User> void delete(T user) {
		entityManager.remove(user);
	}
}
