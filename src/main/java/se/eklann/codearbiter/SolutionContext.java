package se.eklann.codearbiter;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import se.eklann.codearbiter.arbiter.Arbiter;
import se.eklann.codearbiter.compiler.CompilerFactory;
import se.eklann.codearbiter.executor.ContainerBuilder;
import se.eklann.codearbiter.executor.ContainerBuilderFactory;
import se.eklann.codearbiter.executor.Executor;
import se.eklann.codearbiter.compiler.CompilationResult;
import se.eklann.codearbiter.executor.ExecutionResult;
import se.eklann.codearbiter.model.IOPairSolution;
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
        
        executableFilename = Config.getValue("ExecutableFilename", "solution") 
                + compiler.ExecutableExtension(); 
        
        containerName = Config.getValue("ContainerNamePrefix", "arbiter") + "/" 
                + solution.getProblem().getId() + "/" + solution.getId();
    }
    
    public void Compile() {
        CompilationResult result = compiler.Compile(
                solution.getSourceCode(), executableFilename);
        
        solution.setCompilationSuccess(result.isSuccess());
        solution.setCompilationMessage(result.getMessage());
    }
    
    public void Run(Arbiter arbiter) {
        containerBuilder.BuildContainer(contextDirectory, executableFilename, 
                contextDirectory);
        
        boolean executionSuccess = true;
        for (IOPair iop : solution.getProblem().getTestCases()) {
            ExecutionResult result = Executor.Execute(containerName, iop);
            
            IOPairSolution iops = new IOPairSolution(solution, iop);
            iops.setExecutionTimeMs(result.getExecutionTimeMs());
            iops.setWasAborted(result.wasAborted());
            iops.setExitCode(result.getExitCode());
            iops.setActualOutput(result.getActualOutput());
            iops.setBonusScore(arbiter.TestCaseBonusScore(
                    solution.getLanguage(), iop, result.getActualOutput(), 
                    result.getExecutionTimeMs()));
            
            executionSuccess &= arbiter.IsValidOutput(iop.getExpectedOutput(), 
                    result.getActualOutput());
        }
        
        solution.setValid(executionSuccess);
        solution.setBaseScore(arbiter.BaseScore(solution.getLanguage(), 
                solution.getSourceCode()));
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
