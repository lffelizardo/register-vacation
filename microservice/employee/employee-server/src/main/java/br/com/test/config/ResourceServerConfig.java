package br.com.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableOAuth2Client
@EnableResourceServer
@ComponentScan
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(ResourceServerConfig.class);

    public static final String RESOURCE_ID = "restService";

    public ResourceServerConfig(@Value("${register.public.key}") String publicKey){
        this.publicKey = publicKey;
    }

    @Autowired
    private TokenStore tokenStore;

    @Qualifier("jwtTokenEnhancer")
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    private String publicKey;

    @Bean
    @Qualifier("resource")
    public OAuth2ProtectedResourceDetails resource(){
        OAuth2ProtectedResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        return resourceDetails;
    }

    @Bean
    @Qualifier("tokenStore")
    public TokenStore tokenStore() {
        log.info("JwtTokenStore created");
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter =  new JwtAccessTokenConverter();
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.anonymous().and().authorizeRequests()
                .antMatchers("/**/v2/api-docs/**", "/**/configuration/**", "/**/swagger*/**", "/**/webjars/**").permitAll()
                .antMatchers("/health").permitAll()
                .antMatchers("/**").permitAll();
    }

}
