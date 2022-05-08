package com.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageInterceptor;
import com.handler.CartEnumTypeHandler;
import com.handler.OrderStateTypeHandler;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.dao")
@ComponentScan(basePackages = "com", excludeFilters = @ComponentScan.Filter(classes = Controller.class))
@EnableTransactionManagement
public class MyApplicationConfig {

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = null;
        try {
            Properties properties = new Properties();
            properties.load(MyApplicationConfig.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        return commonsMultipartResolver;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource,
                                                       CartEnumTypeHandler cartEnumTypeHandler,
                                                       OrderStateTypeHandler orderStateTypeHandler,
                                                       PageInterceptor pageInterceptor) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(StdOutImpl.class);
        ClassPathResource classPathResource = new ClassPathResource("mapper/AddressMapper.xml");
        ClassPathResource classPathResource2 = new ClassPathResource("mapper/CartMapper.xml");
        ClassPathResource classPathResource3 = new ClassPathResource("mapper/ClientUserMapper.xml");
        ClassPathResource classPathResource4 = new ClassPathResource("mapper/GoodsMapper.xml");
        ClassPathResource classPathResource5 = new ClassPathResource("mapper/OderDetialMapper.xml");
        ClassPathResource classPathResource6 = new ClassPathResource("mapper/OrderMapper.xml");
        sqlSessionFactoryBean.setMapperLocations(classPathResource,classPathResource2,classPathResource3,
                classPathResource4,classPathResource5,classPathResource6);
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);
        sqlSessionFactoryBean.setTypeHandlers(cartEnumTypeHandler,orderStateTypeHandler);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }


}
