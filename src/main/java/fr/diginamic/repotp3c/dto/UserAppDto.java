package fr.diginamic.repotp3c.dto;

public class UserAppDto
{
    private Long id;
    private String username;
    private String role;
    
    public UserAppDto()
    {
    }
    
    public UserAppDto(Long id, String username, String role)
    {
        this.id = id;
        this.username = username;
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
     * @return role
     */
    public String getRole()
    {
        return role;
    }
    
    /**
     * Setter
     * @param role sets value
     */
    public void setRole(String role)
    {
        this.role = role;
    }
}
