package fr.diginamic.repotp3c.dto;

public class CandidatureDto
{
    private Long id;
    private String lettreMotivation;
    private String candidatUsername;
    
    public CandidatureDto()
    {
    }
    
    public CandidatureDto(Long id, String lettreMotivation, String candidatUsername)
    {
        this.id = id;
        this.lettreMotivation = lettreMotivation;
        this.candidatUsername = candidatUsername;
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
     * @return candidatUsername
     */
    public String getCandidatUsername()
    {
        return candidatUsername;
    }
    
    /**
     * Setter
     * @param candidatUsername sets value
     */
    public void setCandidatUsername(String candidatUsername)
    {
        this.candidatUsername = candidatUsername;
    }
}
