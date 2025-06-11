package fr.diginamic.repotp3c.dto;

import java.util.List;

public class AnnonceDto
{
    private Long id;
    private String titre;
    private String description;
    private String recruteurUsername;
    private List<CandidatureDto> candidatures;
    
    public AnnonceDto()
    {
    }
    
    public AnnonceDto(Long id, String titre, String description, String recruteurUsername,
          List<CandidatureDto> candidatures)
    {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.recruteurUsername = recruteurUsername;
        this.candidatures = candidatures;
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
     * @return recruteurUsername
     */
    public String getRecruteurUsername()
    {
        return recruteurUsername;
    }
    
    /**
     * Setter
     * @param recruteurUsername sets value
     */
    public void setRecruteurUsername(String recruteurUsername)
    {
        this.recruteurUsername = recruteurUsername;
    }
    
    /**
     * Getter
     * @return candidatures
     */
    public List<CandidatureDto> getCandidatures()
    {
        return candidatures;
    }
    
    /**
     * Setter
     * @param candidatures sets value
     */
    public void setCandidatures(List<CandidatureDto> candidatures)
    {
        this.candidatures = candidatures;
    }
}
