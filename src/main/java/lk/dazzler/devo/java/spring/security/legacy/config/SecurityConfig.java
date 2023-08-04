/**
 * #=== Created by Dazzler7Soft.Eng.Udg ===#
 * Date : 02-Aug-2023
 * Time : 12:04 PM
 * Project Name : Spring-Security-Legacy
 */
package lk.dazzler.devo.java.spring.security.legacy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //to define that this is a security configuration class
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        //using in memory authentication for now
        builder.inMemoryAuthentication()
                .withUser("Admin")
                .password("dazzler7@Tec")
                .roles("Administrator")
                //we can add more roles (users) using the add() method
                .and()
                .withUser("Dazzler")
                .password("dazzler7@Tec")
                .roles("Customer");
    }

    /*
    How to set a password encoder?
    * Just expose a @Bean of type PasswordEncoder.
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        //NoOpPasswordEncoder is deprecated but
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //path matching authorization for users through wild cards
        http.authorizeRequests()
                //give permission to all with incoming path "/"
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("Administrator")
                .antMatchers("/customer").hasRole("Customer")
//                .antMatchers("/customer").hasAnyRole("Customer", "Admin") //can add more than one role
                .and().formLogin();
    }


}
