/**
 * #=== Created by Dazzler7Soft.Eng.Udg ===#
 * Date : 02-Aug-2023
 * Time : 12:04 PM
 * Project Name : Spring-Security-Legacy
 */
package lk.dazzler.devo.java.spring.security.legacy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //to define that this is a security configuration class
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //using in memory authentication for now
        auth.inMemoryAuthentication().
                withUser("Dazzler").
                password("dazzler7@Tec").
                roles("Admin");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
