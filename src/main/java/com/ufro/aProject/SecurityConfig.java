package com.ufro.aProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Esta clase se especifica y delimita los diferentes niveles de acceso que tienen los tipos de usuarios de la pagina empleando Spring Security.
 *
 * @author Amilcar Celis, Isidora Albayay
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    String[] resources = {"/style.css","/imagenes/**","/descarga/**"};

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsService userDetails;

    /**
     * En este método se sobreescribe y determina el proceso de autentificación de Moderador en base a su contraseña.
     */
    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetails)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     * Este método define las direcciones a las cuales los diferentes tipos de usuario tienen acceso,
     * siendo para el usuario común, todas menos las de moderación, y para un Moderador, las correspondientes a moderación e inicio de sesión.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(resources).permitAll()
                    .antMatchers("/","/faq", "/item**","/item/nuevo-comentario","/personaje/nuevo-comentario","/personaje**","/index","/items","/personajes","/sobre-nosotros","/buscar-elemento**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/moderador")
                    .loginProcessingUrl("/perform_login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
