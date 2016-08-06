package ka.gws.barchr.persistence.jpa.entity;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ka.gws.barchr.persistence.api.entity.AnnotatedEntity;



public class AnnotatedEntityListener {

	private static final Logger LOG = LoggerFactory.getLogger(AnnotatedEntityListener.class);

	@PrePersist
	@PreUpdate
	public void setSysInfo(final AnnotatedEntity<?> entity) {
		String username = "admin";
		LOG.debug("Set system properties for '{}'", entity);

		Date now = new Date();

		if (entity.getCreationDate() == null) {
			LOG.debug("Set creation date '{}' and creator '{}' for '{}'", now, username, entity);
			entity.setCreationDate(now);
			entity.setCreator(username);
		}

		LOG.debug("Set last change date '{}' and modifier '{}' for '{}'", now, username, entity);
		entity.setLastModifier(username);
		entity.setLastChangeDate(now);
	}
}
