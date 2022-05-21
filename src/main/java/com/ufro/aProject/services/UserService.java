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

/**
 * Esta gestor de servicios se emplea para dar funcionamiento al servicio de inicio de sesión y validación de Moderador.
 *
 * @author Amilcar Celis, Isidora Albayay
 */
@Service
public class UserService extends GenericServices<Moderador,Long> implements UserDetailsService{

    public UserService(ModeradorRepository repository) {
        super(repository);
    }

    /**
     * Metodo para validar y designar permisos a un Moderador en base a su nombre.
     * @param nombre El nombre del Moderador a ser validado.
     * @throws UsernameNotFoundException el nombre del Moderador no fue encontrado.
     * */
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

    /**
     * Metodo que retorna un Moderador resultado del llamado a una búsqueda por nombre.
     * @param nombre El nombre del Moderador a ser buscado.
     * @return Devuelve el Moderador coincidente con el nombre.
     * */
    public Moderador findByNombre(String nombre) {
        return ((ModeradorRepository) repository).findByNombre(nombre);
    }

}
