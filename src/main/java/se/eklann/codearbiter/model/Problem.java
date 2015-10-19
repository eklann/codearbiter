package se.eklann.codearbiter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eklann
 */
@Entity
@Table(name = "Problem")
public class Problem implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "problemId")
    private long id;
    
    @Column
    private String title;
    
    @Column
    private String description;
    
    @Column
    private int unsolvedScore;
    
    @OneToMany
    @JoinColumn(name = "problemId")
    private List<IOPair> testCases;

    @OneToMany
    @JoinColumn(name = "problemId")
    private List<Solution> solutions;
        
    public Problem() {
        testCases = new ArrayList<>();
        solutions = new ArrayList<>();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnsolvedScore() {
        return unsolvedScore;
    }

    public void setUnsolvedScore(int unsolvedScore) {
        this.unsolvedScore = unsolvedScore;
    }

    public List<IOPair> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<IOPair> testCases) {
        this.testCases = testCases;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}
