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
public class IOPair implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "iopairId")
    private long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "problemId")
    private Problem problem;
    
    @Column
    private String input;
    
    @Column
    private String expectedOutput;
    
    @Column
    private int maximumExecutionTimeMs;

    //TODO: Support special execution times for specific languages
    
    public IOPair(String input, String expectedOutput, int maximumExecutionTimeMs) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.maximumExecutionTimeMs = maximumExecutionTimeMs;
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
