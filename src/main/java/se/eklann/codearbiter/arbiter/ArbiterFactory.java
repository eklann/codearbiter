package se.eklann.codearbiter.arbiter;

import se.eklann.codearbiter.model.ArbiterType;

/**
 *
 * @author eklann
 */
public class ArbiterFactory {
    public static Arbiter getArbiter(ArbiterType type) {
        switch (type) {
            case CodeGolf:
                return new CodeGolfArbiter();
            default:
                throw new IllegalArgumentException(
                "No known Arbiter \"" + type + "\"");
        }
    }
}
