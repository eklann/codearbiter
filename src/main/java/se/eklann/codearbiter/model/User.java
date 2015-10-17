package se.eklann.codearbiter.model;

import java.io.Serializable;
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
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "userId")
    private long id;
    
    @Column(unique = true)
    private String username;
    
    @Column
    private String password; //TODO: Store passwords in a better way than plaintext
    
    @OneToMany
    @JoinColumn(name = "userId")
    private List<Solution> solutions;

    public User() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}
