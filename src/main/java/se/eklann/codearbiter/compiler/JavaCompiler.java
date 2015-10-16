package se.eklann.codearbiter.compiler;

import se.eklann.codearbiter.model.CompilationResult;

/**
 *
 * @author eklann
 */
public class JavaCompiler implements Compiler {
    @Override
    public String ExecutableExtension() {
        return ".class";
    }

    @Override
    public CompilationResult Compile(String sourceCode, String executablePath) {
        //TODO: Implement
        throw new UnsupportedOperationException();
    }
}
