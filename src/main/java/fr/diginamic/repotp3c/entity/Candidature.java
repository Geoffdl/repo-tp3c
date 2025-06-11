package fr.diginamic.repotp3c.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "candidature")
public class Candidature
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String lettreMotivation;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserApp userApp;
    @ManyToOne
    @JoinColumn(name = "id_annonce")
    private Annonce annonce;
    
    public Candidature()
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
     * @return lettreMotivation
     */
    public String getLettreMotivation()
    {
        return lettreMotivation;
    }
    
    /**
     * Setter
     * @param lettreMotivation sets value
     */
    public void setLettreMotivation(String lettreMotivation)
    {
        this.lettreMotivation = lettreMotivation;
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
     * @return annonce
     */
    public Annonce getAnnonce()
    {
        return annonce;
    }
    
    /**
     * Setter
     * @param annonce sets value
     */
    public void setAnnonce(Annonce annonce)
    {
        this.annonce = annonce;
    }
}
