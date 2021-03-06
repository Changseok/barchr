package ka.gws.barchr.common.to;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public abstract class AbstractTO extends AbstractBaseBean {

    private static final long serialVersionUID = -754311920679872084L;

    private long key;

    public long getKey() {
        return key;
    }

    public void setKey(final long key) {
        this.key = key;
    }
}
