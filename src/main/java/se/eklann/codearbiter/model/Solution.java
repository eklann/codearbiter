package se.eklann.codearbiter.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    @Column(name = "programminglanguage")
    private Language language;
    
    @Column
    private String sourceCode;
    
    @Column
    private EvaluationStatus status;
    
    @Column
    private boolean compilationSuccess;
    
    @Column
    private String compilationMessage;
    
    @Column 
    private boolean valid;
    
    @Column
    private int baseScore;
    
    @OneToMany
    @JoinColumn(name = "solutionId")
    private List<IOPairSolution> executionResults;

    public Solution(Problem problem, User user) {
        this.problem = problem;
        this.user = user;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(int baseScore) {
        this.baseScore = baseScore;
    }

    public List<IOPairSolution> getExecutionResults() {
        return executionResults;
    }

    public void setExecutionResults(List<IOPairSolution> executionResults) {
        this.executionResults = executionResults;
    }


}
