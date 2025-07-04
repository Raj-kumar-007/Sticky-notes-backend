package com.stciky.notes.config;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
@Slf4j
@AllArgsConstructor
public class DevDBConfig {

    @Bean
    public DataSource hsqlDataSource() {
        var ds = DataSourceBuilder.create()
                .url("jdbc:hsqldb:file:build/hsqldb/Notes;sql.syntax_ora=true")
                .username("sa")
                .password("")
                .build();

        return migrate(ds);
    }



    private DataSource migrate(final DataSource ds) {
        var flyway = Flyway.configure()
                .dataSource(ds)
                .cleanDisabled(false)
                .sqlMigrationSuffixes(".sql")
                .locations("classpath:db/migration/hsql", "classpath:testdata/")
                .load();
        flyway.clean();
        flyway.migrate();
        return ds;
    }

}
