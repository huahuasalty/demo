package com.xyh.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author huahua
 */
@Configuration
@MapperScan(basePackages = "com.xyh.demo.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    private static final String MAPPER_LOCAL = "classpath:mybatis/mapper/*.xml";

    @ConfigurationProperties("spring.datasource")
    @Primary
    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean
    public DataSourceTransactionManager mallTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Primary
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
        return sessionFactoryBean.getObject();
    }
}

