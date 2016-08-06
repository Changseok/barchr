package ka.gws.barchr.common.rest.api;

/**
 * Preferences available to be specified during requests.
 *
 * @see RESTHeaders#PREFER
 * @see RESTHeaders#PREFERENCE_APPLIED
 */
public enum Preference {

  NONE(""), RETURN_CONTENT("return-content"), RETURN_NO_CONTENT("return-no-content");

  private final String literal;

  Preference(final String literal) {
    this.literal = literal;
  }

  @Override
  public String toString() {
    return literal;
  }

  public static Preference fromString(final String literal) {
    Preference result = null;

    for (Preference preference : values()) {
      if (preference.toString().equalsIgnoreCase(literal)) {
        result = preference;
      }
    }

    if (result == null) {
      result = NONE;
    }

    return result;
  }
}
