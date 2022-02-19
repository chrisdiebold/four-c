package diebold.chris.code.http;

public enum StatusCodes {
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Resource Not Found"),
    OK(200, "OK"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    public final int STATUS_CODE;
    public final String MESSAGE;

    StatusCodes(int STATUS_CODE, String MESSAGE) {
        this.STATUS_CODE = STATUS_CODE;
        this.MESSAGE = MESSAGE;
    }
}
