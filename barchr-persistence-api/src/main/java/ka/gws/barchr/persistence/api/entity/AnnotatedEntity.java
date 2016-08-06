package ka.gws.barchr.persistence.api.entity;

import java.util.Date;

/**
 * Referenced Apache Syncope Project
 * 
 * @author Changseok Keum
 */
public interface AnnotatedEntity<KEY> extends Entity<KEY> {

  Date getCreationDate();

  String getCreator();

  Date getLastChangeDate();

  String getLastModifier();

  void setCreationDate(Date creationDate);

  void setCreator(String creator);

  void setLastChangeDate(Date lastChangeDate);

  void setLastModifier(String lastModifier);
}
