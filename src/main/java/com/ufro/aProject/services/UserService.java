package com.ufro.aProject.services;

import com.ufro.aProject.model.Moderador;
import com.ufro.aProject.repository.ModeradorRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends GenericServices<Moderador,Long> implements UserDetailsService{

    public UserService(ModeradorRepository repository) {
        super(repository);
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Moderador moderador = findByNombre(nombre);

        if(moderador != null){
            // Aqui implementar lógica de obtener permisos de la base de datos (Esto es harcode)
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("MODERADOR"));

            return new org.springframework.security.core.userdetails.User(
                    moderador.getNombre(),
                    moderador.getConstrasena(),
                    authorities
            );
        }else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    public Moderador findByNombre(String nombre) {
        return ((ModeradorRepository) repository).findByNombre(nombre);
    }

}
