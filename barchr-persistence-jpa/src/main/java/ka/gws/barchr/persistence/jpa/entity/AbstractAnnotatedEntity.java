package ka.gws.barchr.persistence.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ka.gws.barchr.persistence.api.entity.AnnotatedEntity;



/**
 * Abstract wrapper for common system information.
 *
 * @param <KEY> the type of the key of this entity
 */
@MappedSuperclass
@EntityListeners(value = AnnotatedEntityListener.class)
public abstract class AbstractAnnotatedEntity<KEY> extends AbstractEntity<KEY>
    implements AnnotatedEntity<KEY> {

  private static final long serialVersionUID = -4801685541488201219L;

  /**
   * Username of the user that has created this profile. Reference to existing user cannot be used:
   * the creator can either be <tt>admin</tt> or was deleted.
   */
  @Column(nullable = false)
  private String creator;

  /**
   * Creation date.
   */
  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  /**
   * Username of the user that has performed the last modification to this profile. This field
   * cannot be null: at creation time it needs to be initialized with the creator username. The
   * modifier can be the user itself if the last performed change was a self-modification. Reference
   * to existing user cannot be used: the creator can either be <tt>admin</tt> or was deleted.
   */
  @Column(nullable = false)
  private String lastModifier;

  /**
   * Last change date. This field cannot be null: at creation time it needs to be initialized with
   * <tt>creationDate</tt> field value.
   */
  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastChangeDate;

  @Override
  public String getCreator() {
    return creator;
  }

  @Override
  public void setCreator(final String creator) {
    this.creator = creator;
  }

  @Override
  public Date getCreationDate() {
    return creationDate == null ? null : new Date(creationDate.getTime());
  }

  @Override
  public void setCreationDate(final Date creationDate) {
    this.creationDate = creationDate == null ? null : new Date(creationDate.getTime());
  }

  @Override
  public String getLastModifier() {
    return lastModifier;
  }

  @Override
  public void setLastModifier(final String lastModifier) {
    this.lastModifier = lastModifier;
  }

  @Override
  public Date getLastChangeDate() {
    return lastChangeDate == null ? creationDate : lastChangeDate;
  }

  @Override
  public void setLastChangeDate(final Date lastChangeDate) {
    this.lastChangeDate = lastChangeDate == null ? null : new Date(lastChangeDate.getTime());
  }
}
