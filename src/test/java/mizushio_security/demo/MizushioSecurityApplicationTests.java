package mizushio_security.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration
class MizushioSecurityApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    void contextLoads() {
//        String sql = "SELECT * from test where id='1'";
        String sql = "update test set password ='777' where  id = 1";
        int res = jdbcTemplate.update(sql);
        System.out.println(res);
    }

}
