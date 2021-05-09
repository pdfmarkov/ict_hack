package org.comrades.springtime.config;

import org.comrades.springtime.security.jwt.TokenHandler;
import org.comrades.springtime.security.jwt.filters.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String LOGIN_ENDPOINT = "/api/aunt/**";
    private final String REFRESH_ENDPOINT = "/api/refresh/**";
    private final String FILE = "/main/file/**";
    private final String CONTENT = "/dist/**";
    private final String MAIN = "/main/app/**";
    private final String SOCKET = "/gs-guide-websocket/**";

    private final TokenHandler jwtTokenHandler;

    @Autowired
    public WebSecurityConfig(TokenHandler jwtTokenHandler) {
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        firewall.setAllowSemicolon(true);
        return firewall;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println(http);
        http

                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers(LOGIN_ENDPOINT).permitAll()
                    .antMatchers(REFRESH_ENDPOINT).permitAll()
                    .antMatchers(CONTENT).permitAll()
                    .antMatchers(FILE).permitAll()
                    .antMatchers(SOCKET).permitAll()
                //TODO: убери main
                    .antMatchers(MAIN).permitAll()
                    .anyRequest().authenticated()
                .and()
                    .addFilterBefore(new JwtFilter(jwtTokenHandler), UsernamePasswordAuthenticationFilter.class);
        http.cors();
    }

    @Override
    public void configure(WebSecurity web){
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
        web
                .ignoring()
                .antMatchers("/api/refresh/**","/main/file/**", "api/aunt/**", "main/app/**", SOCKET);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}