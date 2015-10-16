package se.eklann.codearbiter.executor;

import se.eklann.codearbiter.model.Language;

/**
 *
 * @author eklann
 */
public class ContainerBuilderFactory {
    public static ContainerBuilder GetContainerBuilder(Language language) {
        switch (language) {
            case Java:
                return new JavaContainerBuilder();
            default:
                throw new IllegalArgumentException(
                "No known ContainerBuilder for language \"" + language + "\"");
        }
    }
}
