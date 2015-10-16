package se.eklann.codearbiter.arbiter;

import se.eklann.codearbiter.model.IOPair;
import se.eklann.codearbiter.model.Language;

/**
 *
 * @author eklann
 */
public class CodeGolfArbiter implements Arbiter {

    @Override
    public boolean IsValidOutput(String expectedOutput, String actualOutput) {
        return expectedOutput.equals(actualOutput);
    }

    @Override
    public int BaseScore(Language language, String sourceCode) {
        return sourceCode.length();
    }

    @Override
    public int TestCaseBonusScore(Language language, IOPair testCase, 
        String actualOutput, int executionTimeMs) {
        return 0;
    }
}
