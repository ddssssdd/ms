package com.ruifu.pls.authjwt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier("authenticationManagerBean")
    AuthenticationManager authenticationManager;

/*
* https://github.com/talk2amareswaran/spring-boot2-oauth2-auth-server-jwt-mysql
* */

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TokenStore tokenStore;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private UserServiceDetail userDetailsService;

    @Autowired
    private ClientDetailsService clientDetailsService;

    static final Logger logger = LoggerFactory.getLogger(AuthorizationServerConfiguration.class);

    @Bean
    public TokenStore tokenStore(){
        TokenStore store= new JwtTokenStore(jwtAccessTokenConverter());
        return store;
    }
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("test-jwt.jks"), "test123".toCharArray());
        //JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        JwtAccessTokenConverter converter = new CustomTokenEnhancer();
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("test-jwt"));
        return converter;
    }

    @Bean
    public ClientDetailsService clientDetailsService(){
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单认证
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .tokenEnhancer(jwtAccessTokenConverter())
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
}
