package fr.diginamic.repotp3c.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_app")
public class UserApp
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @OneToMany(mappedBy = "userApp")
    private List<Candidature> candidatures = new ArrayList<>();
    @OneToMany(mappedBy = "userApp")
    private List<Annonce> annonces = new ArrayList<>();
    
    public UserApp()
    {
    }
    
    public UserApp(String username, String password, Role role)
    {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    /**
     * Getter
     * @return id
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Setter
     * @param id sets value
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /**
     * Getter
     * @return username
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * Setter
     * @param username sets value
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * Getter
     * @return password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Setter
     * @param password sets value
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * Getter
     * @return role
     */
    public Role getRole()
    {
        return role;
    }
    
    /**
     * Setter
     * @param role sets value
     */
    public void setRole(Role role)
    {
        this.role = role;
    }
    
    /**
     * Getter
     * @return candidatures
     */
    public List<Candidature> getCandidatures()
    {
        return candidatures;
    }
    
    /**
     * Setter
     * @param candidatures sets value
     */
    public void setCandidatures(List<Candidature> candidatures)
    {
        this.candidatures = candidatures;
    }
    
    /**
     * Getter
     * @return annonces
     */
    public List<Annonce> getAnnonces()
    {
        return annonces;
    }
    
    /**
     * Setter
     * @param annonces sets value
     */
    public void setAnnonces(List<Annonce> annonces)
    {
        this.annonces = annonces;
    }
}
