package se.eklann.codearbiter.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author eklann
 */
@Entity
@Table(name = "Solution")
public class Solution implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "solutionId")
    private long id;
        
    @ManyToOne(optional = false)
    @JoinColumn(name = "problemId")
    private Problem problem;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private User user;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionTime;
    
    @Column
    private Language programmingLanguage;
    
    @Column
    private String sourceCode;
    
    @Column
    private EvaluationStatus status;
    
    @Column
    private boolean compilationSuccess;
    
    @Column
    private String compilationMessage;
    
    @Column
    private int executionTimeMs;

    @Column
    private boolean executionAborted;
    
    @Column
    private String executionOutput;
    
    @Column
    private int executionExitCode;

    public Solution() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public Language getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(Language programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public EvaluationStatus getStatus() {
        return status;
    }

    public void setStatus(EvaluationStatus status) {
        this.status = status;
    }

    public CompilationResult getCompilationResult() {
        return new CompilationResult(compilationSuccess, compilationMessage);
    }
    
    public boolean isCompilationSuccess() {
        return compilationSuccess;
    }

    public void setCompilationSuccess(boolean compilationSuccess) {
        this.compilationSuccess = compilationSuccess;
    }

    public String getCompilationMessage() {
        return compilationMessage;
    }

    public void setCompilationMessage(String compilationMessage) {
        this.compilationMessage = compilationMessage;
    }

    public ExecutionResult getExecutionResult() {
        return new ExecutionResult(executionTimeMs, executionAborted, 
                executionOutput, executionExitCode);
    }
    
    public int getExecutionTimeMs() {
        return executionTimeMs;
    }

    public void setExecutionTimeMs(int executionTimeMs) {
        this.executionTimeMs = executionTimeMs;
    }

    public boolean isExecutionAborted() {
        return executionAborted;
    }

    public void setExecutionAborted(boolean executionAborted) {
        this.executionAborted = executionAborted;
    }

    public String getExecutionOutput() {
        return executionOutput;
    }

    public void setExecutionOutput(String executionOutput) {
        this.executionOutput = executionOutput;
    }

    public int getExecutionExitCode() {
        return executionExitCode;
    }

    public void setExecutionExitCode(int executionExitCode) {
        this.executionExitCode = executionExitCode;
    }
}
