package st.malike.elasticsearch.oauth2.plugin.exception;

/**
 * @author malike_st
 */
public class InsufficientPriviledgeException extends Exception{

    public InsufficientPriviledgeException() {
    }

    public InsufficientPriviledgeException(String message) {
        super(message);
    }

    public InsufficientPriviledgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientPriviledgeException(Throwable cause) {
        super(cause);
    }

    public InsufficientPriviledgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
