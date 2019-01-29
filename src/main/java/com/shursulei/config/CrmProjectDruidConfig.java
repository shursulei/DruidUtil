package com.shursulei.config;

/**
 * @auther shursulei
 * @Email 1368455669@qq.com
 */

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by lht on 2019/1/27.
 */

@Configuration
public class CrmProjectDruidConfig {

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${spring.datasource.logSlowSql}")
    private String logSlowSql;
    @Value("${crmProject.url}")
    private String infoDbUrl;

    @Value("${crmProject.username}")
    private String infoUsername;

    @Value("${crmProject.password}")
    private String infoPassword;

    @Value("${crmProject.driver.class}")
    private String infoDriverClassName;


    @Bean(name = "crmProjectJDBCTemplate")
    public DataSource crmProjectDataSourcePool() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(infoDbUrl);
        datasource.setUsername(infoUsername);
        datasource.setPassword(infoPassword);
        datasource.setDriverClassName(infoDriverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setValidationQuery(validationQuery);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
        }
        return datasource;
    }
    // @Bean( name = "crmProjectJDBCTemplate")
    public JdbcTemplate crmProjectJDBCTemplate(@Qualifier("crmProjectJDBCTemplate") DataSource crmProjectJDBCTemplate){
        return new JdbcTemplate(crmProjectJDBCTemplate);
    }

}
