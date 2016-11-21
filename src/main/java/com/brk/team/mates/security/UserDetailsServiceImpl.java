package com.brk.team.mates.security;

import com.brk.team.mates.model.User;
import com.brk.team.mates.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("username " + username + " not found");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return customUserDetails;
    }

    public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

        private User user;

        public CustomUserDetails(final User user) {
            super(user.getUserName(), user.getPassword(), user.isEnabled(), true, true, true,
                    new ArrayList<GrantedAuthority>(){ { add(new SimpleGrantedAuthority(user.getRole().getAbbreviation())); } });

            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

}
