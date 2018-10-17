package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import profile.ProfileDemo;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
@Configuration
public class ProfileFunConfig {
    @Bean
    @Profile("dev")
    public ProfileDemo devProfileFun() {
        return new ProfileDemo("devProfile");
    }

    @Bean
    @Profile("prd")
    public ProfileDemo prdProfileFun() {
        return new ProfileDemo("prdProfile");
    }
}
