package org.devhamzat.enrollment.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class DataSourceConfiguration
{
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
               // .driverClassName("org.postgresql.driver")
               // .driverClassName("org.hibernate.dialect.PostgreSQLDialect")
                .url("jdbc:postgresql://localhost:5433/school")
                .username("postgres")
                .password("password")
                .build();
    }
}
