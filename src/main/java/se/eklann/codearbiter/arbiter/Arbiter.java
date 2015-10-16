package se.eklann.codearbiter.arbiter;

import se.eklann.codearbiter.model.IOPair;
import se.eklann.codearbiter.model.Language;

/**
 *
 * @author eklann
 */
public interface Arbiter {
    /**
     * Decides if the actual output is a valid one when comparing to the 
     * expected output. Only solutions that has a valid output for all test 
     * cases are scored.
     * @param expectedOutput The expected output defined by the test case.
     * @param actualOutput The actual output produced by the solution.
     * @return True iff the output is valid.
     */
    public boolean IsValidOutput(String expectedOutput, String actualOutput);
    
    /**
     * Gives the solution a base score based on the source code.
     * @param language The language of the source code.
     * @param sourceCode The source code.
     * @return The score of the supplied code.
     */
    public int BaseScore(Language language, String sourceCode);
    
    /**
     * Gives the solution bonus point based on the result of specific test 
     * cases.
     * @param language The language of the solution.
     * @param testCase The test case.
     * @param actualOutput The output produced by the solution.
     * @param executionTimeMs The execution time consumed by the solution.
     * @return The bonus score for this test case.
     */
    public int TestCaseBonusScore(Language language, IOPair testCase, 
        String actualOutput, int executionTimeMs);
}
