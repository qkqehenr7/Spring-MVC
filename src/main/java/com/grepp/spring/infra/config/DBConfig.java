package com.grepp.spring.infra.config;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PreDestroy;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // annotation 을 활용하여 transection 사용가능
public class DBConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver}")
    private String driver;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int poolSize;

    @Value("${schema.script.name:empty-schema.sql}")
    private String schema;

    @Value("${data.script.name:empty-data.sql}")
    private String data;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setDriverClassName(driver);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(poolSize);
        config.setAutoCommit(false);

        return new HikariDataSource(config);
    }

    @PreDestroy
    public void cleanup() {
        // connection 이 정상적으로 종료되었는지 확인해주는 스레드
        AbandonedConnectionCleanupThread.checkedShutdown();
    }

    // JDBC 에서 transection 을 관리해줌
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

    @Bean
    public ResourceDatabasePopulator databasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        Resource schemaResource = new ClassPathResource("init/" + schema);
        Resource dataResource = new ClassPathResource("init/" + data);

        populator.addScripts(schemaResource, dataResource);
        populator.setContinueOnError(false);
        return populator;
    }

    @Bean
    public DataSourceInitializer databasePopulatorInitializer(
        DataSource dataSource, ResourceDatabasePopulator databasePopulator) {

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator);
        return initializer;
    }
}
