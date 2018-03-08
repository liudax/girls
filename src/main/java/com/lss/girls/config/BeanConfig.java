package com.lss.girls.config;

import com.lss.girls.util.DFSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Magic
 * @date 10:59 2018/2/26
 * @description
 */
@Configuration
public class BeanConfig {

    @Bean
    public DFSClient dfsClient() throws Exception{
        return new DFSClient("/fdfs_client.conf");
    }
}
