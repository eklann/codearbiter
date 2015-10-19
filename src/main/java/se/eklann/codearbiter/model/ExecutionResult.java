package se.eklann.codearbiter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eklann
 */
@Entity
@Table(name = "IOPair")
public class ExecutionResult implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "executionResultId")
    private long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "solutionId")
    private Solution solution;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "iopairId")
    private IOPair ioPair;
    
    @Column
    private int executionTimeMs;
    
    @Column
    private boolean wasAborted;
    
    @Column
    private String ActualOutput;
    
    @Column
    private int exitCode;

    public ExecutionResult(Solution solution, IOPair ioPair) {
        this.solution = solution;
        this.ioPair = ioPair;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public IOPair getIoPair() {
        return ioPair;
    }

    public void setIoPair(IOPair ioPair) {
        this.ioPair = ioPair;
    }

    public int getExecutionTimeMs() {
        return executionTimeMs;
    }

    public void setExecutionTimeMs(int executionTimeMs) {
        this.executionTimeMs = executionTimeMs;
    }

    public boolean isWasAborted() {
        return wasAborted;
    }

    public void setWasAborted(boolean wasAborted) {
        this.wasAborted = wasAborted;
    }

    public String getActualOutput() {
        return ActualOutput;
    }

    public void setActualOutput(String ActualOutput) {
        this.ActualOutput = ActualOutput;
    }

    public int getExitCode() {
        return exitCode;
    }

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }
}
