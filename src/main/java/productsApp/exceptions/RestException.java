package productsApp.exceptions;

/**
 * Error to return for SPA in JSON.
 */
public class RestException {

    private String message;
    private int code;


    public RestException(String message, int code) {
        this.message = message;
        this.code = code;

    }

    public RestException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }


}
