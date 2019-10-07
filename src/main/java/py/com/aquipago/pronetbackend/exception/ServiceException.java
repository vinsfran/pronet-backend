package py.com.aquipago.pronetbackend.exception;

public class ServiceException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 533370718473525952L;
    private String errorCode;

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(getErrorCode()).append("=").append(this.getMessage()).append("\n");
        return sb.toString();
    }

    public ServiceException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ServiceException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServiceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ServiceException(String errorCode, Throwable cause, String message, Object... args) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServiceException(String errorCode, String message, Object... args) {
        super(message);
        this.errorCode = errorCode;
    }
}
