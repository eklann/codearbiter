package se.eklann.codearbiter;

import java.io.File;
import java.nio.file.Paths;
import se.eklann.codearbiter.compiler.CompilerFactory;
import se.eklann.codearbiter.executor.ContainerBuilder;
import se.eklann.codearbiter.executor.ContainerBuilderFactory;
import se.eklann.codearbiter.executor.Executor;
import se.eklann.codearbiter.model.CompilationResult;
import se.eklann.codearbiter.model.ExecutionResult;
import se.eklann.codearbiter.model.IOPair;
import se.eklann.codearbiter.model.Solution;

/**
 *
 * @author eklann
 */
public class SolutionContext {
    private final Solution solution;
    
    private final se.eklann.codearbiter.compiler.Compiler compiler;
    private final ContainerBuilder containerBuilder;
    
    private final String contextDirectory;
    private final String executableFilename;
    private final String containerName;

    public SolutionContext(Solution solution) {
        this.solution = solution;
        
        compiler = CompilerFactory.GetCompiler(solution.getLanguage());
        containerBuilder = ContainerBuilderFactory.GetContainerBuilder(
                solution.getLanguage());
        
        contextDirectory = Paths.get(".", solution.getId() + "").toString();
        
        //TODO: Prefixes for these strings in config
        executableFilename = "solution" + compiler.ExecutableExtension(); 
        containerName = "arbiter/" + solution.getProblem().getId() + "/" + 
                solution.getId();
    }
    
    public void Compile() {
        CompilationResult result = compiler.Compile(
                solution.getSourceCode(), executableFilename);
        solution.setCompilationResult(result);
    }
    
    public void Run() {
        containerBuilder.BuildContainer(contextDirectory, executableFilename, 
                contextDirectory);
        
        for (IOPair iop : solution.getProblem().getTestCases()) {
            ExecutionResult result = Executor.Execute(containerName, iop);
            //TODO: save the result
        }
        
    }
    
    public void Cleanup() {
        deleteDir(new File(contextDirectory));
    }
    
    private void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDir(f);
            }
        }
        file.delete();
    }
}
