package ka.gws.barchr.persistence.jpa.entity;

import java.beans.PropertyDescriptor;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import ka.gws.barchr.persistence.api.entity.Entity;


public abstract class AbstractEntity<KEY> implements Entity<KEY> {

  private static final long serialVersionUID = -9017214159540857901L;

  protected static final Logger LOG = LoggerFactory.getLogger(AbstractEntity.class);

  protected void checkType(final Object object, final Class<?> clazz) {
    if (object != null && !clazz.isInstance(object)) {
      throw new ClassCastException(
          "Expected " + clazz.getName() + ", got " + object.getClass().getName());
    }
  }

  /**
   * @param property the integer representing a boolean value
   * @return the boolean value corresponding to the property param
   */
  public final boolean isBooleanAsInteger(final Integer property) {
    return property != null && property == 1;
  }

  /**
   * @param value the boolean value to be represented as integer
   * @return the integer corresponding to the property param
   */
  public final Integer getBooleanAsInteger(final Boolean value) {
    return Boolean.TRUE.equals(value) ? 1 : 0;
  }

  /**
   * @return fields to be excluded when computing equals() or hashcode()
   */
  private String[] getExcludeFields() {
    Set<String> excludeFields = new HashSet<>();

    for (PropertyDescriptor propDesc : BeanUtils.getPropertyDescriptors(getClass())) {
      if (propDesc.getPropertyType().isInstance(Collections.emptySet())
          || propDesc.getPropertyType().isInstance(Collections.emptyList())) {

        excludeFields.add(propDesc.getName());
      }
    }

    return excludeFields.toArray(new String[] {});
  }

  @Override
  public boolean equals(final Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj, getExcludeFields());
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this, getExcludeFields());
  }

  @Override
  public String toString() {
    return new StringBuilder().append(getClass().getSimpleName()).append('[').append(getId())
        .append(']').toString();
  }
}
