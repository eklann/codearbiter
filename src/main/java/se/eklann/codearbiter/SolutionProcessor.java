package se.eklann.codearbiter;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.eklann.codearbiter.model.EvaluationStatus;
import se.eklann.codearbiter.model.Solution;

/**
 *
 * @author eklann
 */
public class SolutionProcessor implements Runnable {
    private final Queue<Solution> processingQueue;
    
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
    
    public void QueueSolution(Solution solution) {
        processingQueue.add(solution);
    }
    
    @Override
    public void run() {
        for (;;) {
            Solution nextSolution = processingQueue.poll();
            
            if (null == nextSolution) {
                try {
                    Thread.sleep(Integer.parseInt(
                            Config.getValue("ProcessorSleepTime", "1000")));
                } catch (InterruptedException ex) {
                    Logger.getLogger(SolutionProcessor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                ProcessSolution(nextSolution);
            }
        }
    }

    private static void ProcessSolution(Solution solution) {
        SolutionContext context = new SolutionContext(solution);
        
        try {
            solution.setStatus(EvaluationStatus.Processing);

            context.Compile();
            
            if (solution.isCompilationSuccess()) {
                context.Run();
            }
            
            solution.setStatus(EvaluationStatus.Evaluated);
        } finally {
            context.Cleanup();
        }
    }
}
