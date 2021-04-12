package mizushio_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        String password=passwordEncoder.encode("123123");

        if(s.equals("user123")){
            return  new User(s,password, AuthorityUtils.commaSeparatedStringToAuthorityList("normal"));
        }
        if (s.equals("admin123")){
            return  new User(s,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
        }
        return null;
    }
}