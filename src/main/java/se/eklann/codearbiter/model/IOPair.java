package se.eklann.codearbiter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eklann
 */
@Entity
@Table(name = "IOPair")
public class IOPair implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "iopairId")
    private long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "problemId")
    private Problem problem;
    
    @OneToMany
    @JoinColumn(name = "solutionId")
    private List<IOPairSolution> executionResults;
        
    @Column
    private String input;
    
    @Column
    private String expectedOutput;
    
    @Column
    private int maximumExecutionTimeMs;

    //TODO: Support special execution times for specific languages
    
    public IOPair(String input, String expectedOutput, int maximumExecutionTimeMs) {
        executionResults = new ArrayList<>();
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.maximumExecutionTimeMs = maximumExecutionTimeMs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public List<IOPairSolution> getExecutionResults() {
        return executionResults;
    }

    public void setExecutionResults(List<IOPairSolution> executionResults) {
        this.executionResults = executionResults;
    }

    public String getInput() {
        return input;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public int getMaximumExecutionTimeMs() {
        return maximumExecutionTimeMs;
    }
}
