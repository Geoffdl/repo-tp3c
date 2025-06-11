package fr.diginamic.repotp3c.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "annonce")
public class Annonce
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titre;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserApp userApp;
    
    @OneToMany(mappedBy = "annonce")
    private List<Candidature> candidatures;
    
    public Annonce()
    {
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
     * @return titre
     */
    public String getTitre()
    {
        return titre;
    }
    
    /**
     * Setter
     * @param titre sets value
     */
    public void setTitre(String titre)
    {
        this.titre = titre;
    }
    
    /**
     * Getter
     * @return description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Setter
     * @param description sets value
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * Getter
     * @return userApp
     */
    public UserApp getUserApp()
    {
        return userApp;
    }
    
    /**
     * Setter
     * @param userApp sets value
     */
    public void setUserApp(UserApp userApp)
    {
        this.userApp = userApp;
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
}
