package se.eklann.codearbiter.model;

import java.util.List;
import se.eklann.codearbiter.arbiter.Arbiter;

/**
 *
 * @author eklann
 */
public class Problem {
    private String title;
    private String description;
    private List<IOPair> testCases;
    private Arbiter arbiter;
}
