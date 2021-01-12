import com.lym.ControllerBoot;
import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author LYM
 * @Description 用户测试
 * @Date 2021/1/2
 * @Version v1.0.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ControllerBoot.class)
@EnableAutoConfiguration
public class UserTest {

    @Reference
    private DubboUser dubboUser;

    @Test
    public void test(){
      //  dubboUser.saveUser();
    };
}
