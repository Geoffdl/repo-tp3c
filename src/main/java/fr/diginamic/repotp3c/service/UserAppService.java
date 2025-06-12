package fr.diginamic.repotp3c.service;

import fr.diginamic.repotp3c.dto.UserAppDto;
import fr.diginamic.repotp3c.entity.Role;
import fr.diginamic.repotp3c.entity.UserApp;
import fr.diginamic.repotp3c.exception.ProblemException;
import fr.diginamic.repotp3c.mapper.IUserAppMapper;
import fr.diginamic.repotp3c.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAppService implements IUserAppService
{
    @Autowired
    private UserAppRepository userAppRepository;
    @Autowired
    private IJwtAuthentificationService IJwtAuthentificationService;
    @Autowired
    private BCryptPasswordEncoder bcrypt;
    @Autowired
    private IUserAppMapper IUserAppMapper;
    
    @Override
    public void createUserApp(UserApp userApp, Role role) throws Exception
    {
        Optional<UserApp> userAppOptional = userAppRepository.findByUsername(userApp.getUsername());
        if (userAppOptional.isPresent())
        {
            throw new RuntimeException("L'utilisateur existe déjà");
        }
        UserApp newUserApp = new UserApp(userApp.getUsername(), bcrypt.encode(userApp.getPassword()), role);
        
        userAppRepository.save(newUserApp);
    }
    
    @Override
    public ResponseCookie logUserApp(UserApp userApp) throws Exception
    {
        Optional<UserApp> userAppOptional = userAppRepository.findByUsername(userApp.getUsername());
        if (userAppOptional.isPresent() && bcrypt.matches(userApp.getPassword(), userAppOptional.get().getPassword()))
        {
            return IJwtAuthentificationService.generateToken(userApp);
        }
        throw new Exception("L'identifiant ou le mot de passe est incorrect");
    }
    
    @Override
    public UserApp getUserApp(String username)
    {
        Optional<UserApp> userAppOptional = userAppRepository.findByUsername(username);
        if (userAppOptional.isPresent())
        {
            return userAppOptional.get();
        }
        throw new RuntimeException("Utilisateur non trouvé");
    }
    
    @Override
    public UserApp getUserAppById(Long userId) throws Exception
    {
        Optional<UserApp> userAppOptional = userAppRepository.findById(userId);
        if (userAppOptional.isPresent())
        {
            return userAppOptional.get();
        }
        throw new Exception("User not found");
    }
    
    @Override
    public List<UserAppDto> getAll()
    {
        return userAppRepository.findAll().stream().map(user -> IUserAppMapper.toUserAppDto(user)).toList();
    }
    
    @Override
    public void deleteUserById(Long userId) throws ProblemException
    {
        try
        {
            userAppRepository.deleteById(userId);
        }
        catch (Exception e)
        {
            throw new ProblemException("id non trouvé");
        }
    }
}
