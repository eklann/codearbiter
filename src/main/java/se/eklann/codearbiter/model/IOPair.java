package se.eklann.codearbiter.model;

/**
 *
 * @author eklann
 */
public class IOPair {
    private final String input;
    private final String expectedOutput;
    private final int maximumExecutionTimeMs;

    //TODO: Support special execution times for specific languages
    
    public IOPair(String input, String expectedOutput, int maximumExecutionTimeMs) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.maximumExecutionTimeMs = maximumExecutionTimeMs;
    }

    public String getInput() {
        return input;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public int getMaximumExecutionTimeMs() {
        return maximumExecutionTimeMs;
    }
}
