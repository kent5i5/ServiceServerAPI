package com.yinkin.yinkinelderservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yinkin.yinkinelderservice.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class accountService implements UserDetailsService  {
    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private EmployerRepository employerRepository;
    public Account findUserByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Set<String> role = new HashSet<>();
        role.add("USER");

        Account user = accountRepository.findByEmail(email);
       Employer firstname = employerRepository.findByFirstName(user.getName());
        if (firstname != null){role.add("EMPLOYER");}
        if(user != null) {
            
            List<GrantedAuthority> authorities = getUserAuthority(role);
            //System.out.println("hello user data "+user.getEmail() + " " + authorities.toString() );
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private UserDetails buildUserForAuthentication(Account user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
    private List<GrantedAuthority> getUserAuthority(Set<String> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }
   
    // public void saveUser(User user) {
    //     user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    //     user.setEnabled(true);
    //     Role userRole = roleRepository.findByRole("ADMIN");
    //     user.setRoles(new HashSet<>(Arrays.asList(userRole)));
    //     userRepository.save(user);
    // }
}
