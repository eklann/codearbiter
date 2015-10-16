package se.eklann.codearbiter.compiler;

import se.eklann.codearbiter.model.CompilationResult;

/**
 *
 * @author eklann
 */
public interface Compiler {
    /**
     * Gets the extension to use for an executable produced with this compiler.
     * @return The extension, including the dot.
     */
    public String ExecutableExtension();
    
    /**
     * Compiles the source code to an executable on the specified path.
     * @param sourceCode The source code to be compiled.
     * @param executablePath The path to store the executable.
     * @return The result of the compilation.
     */
    public CompilationResult Compile(String sourceCode, String executablePath);
}
