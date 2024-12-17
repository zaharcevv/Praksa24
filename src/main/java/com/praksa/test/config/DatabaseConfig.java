package com.praksa.test.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    @Value("${url}")
    private String url;

    @Value("${usern}")
    private String user;

    @Value("${password}")
    private String password;

    @Value("${cache_prepared_statements}")
    private String cache_prepared_statements;

    @Value("${prepared_statement_cache_size}")
    private String prepared_statement_cache_size;

    @Value("${prepared_statement_cache_sql_limit}")
    private String prepared_statement_cache_sql_limit;

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts",cache_prepared_statements);
        config.addDataSourceProperty("prepStmtCacheSize", prepared_statement_cache_size);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", prepared_statement_cache_sql_limit);
        return new HikariDataSource(config);
    }
}
