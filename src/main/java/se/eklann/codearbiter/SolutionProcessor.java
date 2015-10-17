package se.eklann.codearbiter;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.eklann.codearbiter.compiler.CompilerFactory;
import se.eklann.codearbiter.model.Solution;

/**
 *
 * @author eklann
 */
public class SolutionProcessor implements Runnable {
    private Queue<Solution> processingQueue;
    
    private static SolutionProcessor instance = null;
    
    public static SolutionProcessor getInstance() {
        if (null == instance) {
            instance = new SolutionProcessor();
        }
        
        return instance;
    }
    
    private SolutionProcessor() {
        processingQueue = new LinkedBlockingQueue<>();
        
        Thread processingThread = new Thread(this);
        processingThread.start();
    }
    
    @Override
    public void run() {
        for (;;) {
            Solution nextSolution = processingQueue.poll();
            
            if (null == nextSolution) {
                try {
                    Thread.sleep(1000); //TODO: Config?
                } catch (InterruptedException ex) {
                    Logger.getLogger(SolutionProcessor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                ProcessSolution(nextSolution);
            }
        }
    }

    private static void ProcessSolution(Solution solution) {
        //Create the context
        SolutionContext context = new SolutionContext(solution);
        
        try {
        //First compile
            se.eklann.codearbiter.compiler.Compiler compiler = 
                    CompilerFactory.GetCompiler(solution.getLanguage());
            compiler.Compile(solution.getSourceCode(), null);
        } finally {
            context.Cleanup();
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}