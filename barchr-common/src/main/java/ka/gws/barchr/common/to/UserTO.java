package ka.gws.barchr.common.to;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "user")
@XmlType
public class UserTO extends AbstractTO {

  private static final long serialVersionUID = 101121313941735477L;

  private String userName;
  private String userPassword;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  @Override
  public String toString() {
    return "UserTO [userName=" + userName + ", userPassword=" + userPassword + "]";
  }
}
