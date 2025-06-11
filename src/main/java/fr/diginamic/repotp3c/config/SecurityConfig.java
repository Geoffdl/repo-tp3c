package fr.diginamic.repotp3c.config;

import fr.diginamic.repotp3c.entity.Role;
import fr.diginamic.repotp3c.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig
{
    
    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter filter) throws Exception
    {
        http
              .csrf(AbstractHttpConfigurer::disable)
              .authorizeHttpRequests(auth -> auth
                                           .requestMatchers("/h2-console/**", "/auth/login").permitAll()
                                           .requestMatchers("/annonce/get-all", "/auth/create-candidat", "/auth/create-recruteur").permitAll()
                                           .requestMatchers("/annonce/candidate-by-id/**").permitAll()
                                           .requestMatchers("/annonce/create", "/annonce/get-candidature-list-by-id/")
                                           .hasRole(Role.RECRUTEUR.toString())
                                           .requestMatchers("/annonce/delete-by-id/", "/candidature/get-all").hasRole(Role.ADMIN.toString())
                                           .requestMatchers("/auth/create-admin", "/auth/delete-admin-by-id", "/user/get-all")
                                           .hasRole(Role.SUPER_ADMIN.toString())
                                           .requestMatchers("/annonce/get-my-annonce-list")
                                           .hasAnyRole(Role.CANDIDAT.toString(), Role.RECRUTEUR.toString())
                                           .anyRequest().authenticated()
                                    )
              .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
              .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
}
