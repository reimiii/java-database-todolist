package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig configuration = new HikariConfig();
        configuration.setDriverClassName("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://localhost:3306/java_todolist");
        configuration.setUsername("root");
        configuration.setPassword("password");

        // pool
        configuration.setMaximumPoolSize(10);
        configuration.setMinimumIdle(5);
        configuration.setIdleTimeout(60_000);
        configuration.setMaxLifetime(10 * 60_000);
        hikariDataSource = new HikariDataSource(configuration);
    }

    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }
}
