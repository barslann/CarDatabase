package com.coderman.cardatabase.service;

import com.coderman.cardatabase.domain.User;
import com.coderman.cardatabase.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Spring security uses this for user authentication and authorization.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = userRepository.findByUsername(username);

        if(currentUser == null)
            throw new UsernameNotFoundException("Invalid username.");

        UserDetails user = new org.springframework.security.core.userdetails.User(username,currentUser.getPassword(),true,true,true,true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}



    // another way to create get authority!
//    private List getAuthority() {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//}
