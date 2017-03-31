package Exception;

public class CompliationError extends Error {
    String error;
    public CompliationError(String error) {
        this.error = error;
    }
    public CompliationError() {

    }

    public String getError() {
        return error;
    }
}
