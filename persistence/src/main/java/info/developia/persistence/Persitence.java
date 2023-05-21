package info.developia.persistence;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class Persitence {
    private SqlSessionFactory sqlSessionFactory;

    public Persitence(String packageName) {
        sqlSessionFactory = buildSqlSessionFactory(packageName);
    }

    private static SqlSessionFactory buildSqlSessionFactory(String mappersPackageName) {
        DataSource dataSource = new PooledDataSource(
                "org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "docker");
        Environment environment = new Environment("Default", new JdbcTransactionFactory(), dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMappers(mappersPackageName);
        return new SqlSessionFactoryBuilder().build(configuration);
    }

    public SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }
}
