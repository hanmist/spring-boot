import com.hmx.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author hanmingxiang 2018-05-03 18:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class DBTest {

    @Resource
    private DataSource dataSource;
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private Environment environment;

    @Test
    public void testData() throws SQLException {
        System.out.println(dataSource.getConnection());
        System.out.println(environment.getProperty("spring.datasource.url"));
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * from pg_tables where SCHEMANAME='public' ");
        maps.forEach(System.out::println);
    }
}
