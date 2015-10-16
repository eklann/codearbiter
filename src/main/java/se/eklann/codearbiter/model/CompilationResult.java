package se.eklann.codearbiter.model;

/**
 *
 * @author eklann
 */
public class CompilationResult {
    private final boolean success;
    private final String message;

    public CompilationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
