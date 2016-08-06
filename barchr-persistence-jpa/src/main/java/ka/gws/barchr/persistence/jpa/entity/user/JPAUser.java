package ka.gws.barchr.persistence.jpa.entity.user;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ka.gws.barchr.persistence.api.entity.user.User;
import ka.gws.barchr.persistence.jpa.entity.AbstractAnnotatedEntity;


@Entity
@Table(name = JPAUser.TABLE)
@Cacheable
public class JPAUser extends AbstractAnnotatedEntity<Long> implements User {

	private static final long serialVersionUID = -894767284775369372L;

	public static final String TABLE = "rmk_user_bs";

	@Id
	private Long id;

	@Column(nullable = false)
	private String userName;

	@Override
	public Long getKey() {
		return id;
	}

	@Override
	public String getName() {
		return userName;
	}

	@Override
	public void setName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "JPAUser [id=" + id + ", userName=" + userName + "]";
	}
}
