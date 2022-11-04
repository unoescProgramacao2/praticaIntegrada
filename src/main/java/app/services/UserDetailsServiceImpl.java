package app.services;

import java.util.ArrayList;
import java.util.List;

import app.entities.Authority;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        app.entities.User appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Não existe usuario"));

        List grantList = new ArrayList();
        for (Authority authority : appUser.getAuthority()) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
        }

        UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
        return user;
    }
}