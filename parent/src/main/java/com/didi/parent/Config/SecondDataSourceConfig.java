package com.didi.parent.Config;/*
 * @Author zhangxinkun
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName SecondDataSourceConfig
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/6/20  4:08 PM
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = {"com.didi.db.XinkunDao"},sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDataSourceConfig {

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "datasrouce.xinkun")
    public DruidDataSource xinkunDataSource() throws Exception{
        return new DruidDataSource();
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactoryBean xinkunSqlSessionFactoryBean(@Qualifier("secondDataSource") DruidDataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.didi.db.XinkunModel");
        PathMatchingResourcePatternResolver path = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(path.getResources("classpath:/xinkunMapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(path.getResource("classpath:/mybatis/mybatis-config.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean(name = "secondTransaction")
    public DataSourceTransactionManager secondDataSourceTransactionManager(@Qualifier("secondDataSource") DruidDataSource dataSource) throws Exception{
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondSqlTemplate")
    public SqlSessionTemplate secondSqlSessionTemplate(@Qualifier("secondSqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
