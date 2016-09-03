package ka.gws.barchr.persistence.jpa.entity;

import ka.gws.barchr.persistence.api.entity.Entity;
import ka.gws.barchr.persistence.api.entity.EntityFactory;
import ka.gws.barchr.persistence.api.entity.user.User;
import ka.gws.barchr.persistence.jpa.entity.user.JPAUser;
import org.springframework.stereotype.Component;


@Component public class JPAEntityFactory implements EntityFactory {

    @SuppressWarnings("unchecked") @Override
    public <KEY, T extends Entity<KEY>> T newEntity(final Class<T> reference) {
        T result;

        if (reference.equals(User.class)) {
            result = (T) new JPAUser();
        } else {
            throw new IllegalArgumentException(
                "Could not find a JPA implementation of " + reference.getName());
        }

        return result;
    }
}
