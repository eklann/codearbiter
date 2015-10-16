package se.eklann.codearbiter.compiler;

import se.eklann.codearbiter.model.Language;

/**
 *
 * @author eklann
 */
public class CompilerFactory {
    public static Compiler GetCompiler(Language language) {
        switch (language) {
            case Java:
                return new JavaCompiler();
            default:
                throw new IllegalArgumentException(
                "No known Compiler for language \"" + language + "\"");
        }
    }
}
