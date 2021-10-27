import com.slums.hands.mapper.UserMapper;
import com.slums.hands.model.UserModel;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/19 16:58
 * @version: 1.0
 */
public class MybatisTest {
    private SqlSessionFactory sqlSessionFactory;

    @SneakyThrows
    @Before
    public void before() {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
    }

    @Test
    public void test() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserMapper mapper = session.getMapper(UserMapper.class);
//            List<UserModel> all = mapper.selectAll();
//            System.out.println(all);
            System.out.println(mapper.selectById(1));

        }
    }


}
