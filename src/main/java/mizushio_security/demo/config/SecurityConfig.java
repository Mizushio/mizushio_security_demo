package mizushio_security.demo.config;

import mizushio_security.demo.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.formLogin()
//                .loginProcessingUrl("/login")//interface
                .failureHandler(new MyAuthenticationFailureHandler())
                .successHandler(new MyAuthenticationSuccessHandler())
                .and().logout().logoutSuccessHandler(new MyLogoutSuccessHandler())
                .and().exceptionHandling().authenticationEntryPoint(new MyAuthenticationEnrtyPoint());
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/hello").hasAuthority("admin")
                .antMatchers("/hi").hasAuthority("normal")
                .antMatchers("/yaharo").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .anyRequest().authenticated();


        http.exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler());


    }
    @Bean
    public PasswordEncoder getPw()
    {
        return new BCryptPasswordEncoder();
    }
}
