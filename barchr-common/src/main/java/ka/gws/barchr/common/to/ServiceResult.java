package ka.gws.barchr.common.to;

public class ServiceResult<TO extends AbstractTO> extends AbstractBaseBean {

    private static final long serialVersionUID = 2626825062604846635L;

    private TO to;

    public TO getTO() {
        return to;
    }

    public ServiceResult<TO> setTO(final TO to) {
        this.to = to;
        return this;
    }
}
