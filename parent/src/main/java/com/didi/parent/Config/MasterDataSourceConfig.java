package com.didi.parent.Config;/*
 * @Author zhangxinkun
 */

import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DataSourceConfig
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/6/20  3:08 PM
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = {"com.didi.db.mapper"},sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    @ConfigurationProperties(prefix = "datasrouce.test")
    @Primary
    @Bean(name = "masterDataSource")
    public DruidDataSource dataSourceConfig() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactoryBean testSqlSessionFactory(@Qualifier("masterDataSource") DruidDataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //测试如果父子模块有相同的路径的时候的问题
        factoryBean.setTypeAliasesPackage("com.didi.db.model");
        PathMatchingResourcePatternResolver path = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(path.getResources("classpath:/testMapper/*.xml"));
        factoryBean.setConfigLocation(path.getResource("classpath:/mybatis/mybatis-config.xml"));
        return factoryBean;
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager testDataSourceTransactionManager(@Qualifier("masterDataSource") DruidDataSource dataSource) throws Exception{
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
