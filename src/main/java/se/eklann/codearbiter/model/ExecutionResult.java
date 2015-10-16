package se.eklann.codearbiter.model;

/**
 *
 * @author eklann
 */
public class ExecutionResult {
    private final int executionTimeMs;
    private final boolean wasAborted;
    private final String ActualOutput;
    private final int exitCode;

    public ExecutionResult(int executionTimeMs, boolean wasAborted, String ActualOutput, int exitCode) {
        this.executionTimeMs = executionTimeMs;
        this.wasAborted = wasAborted;
        this.ActualOutput = ActualOutput;
        this.exitCode = exitCode;
    }
    
    public int getExecutionTimeMs() {
        return executionTimeMs;
    }

    public boolean isWasAborted() {
        return wasAborted;
    }

    public String getActualOutput() {
        return ActualOutput;
    }

    public int getExitCode() {
        return exitCode;
    }
}
