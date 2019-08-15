package test;

import com.sxzwp.util.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) // 让单元测试类 支持 spring
@ContextConfiguration("classpath:spring.xml") // 指定spring配置文件的位置, 让测试类运行时根据此文件创建 spring 容器
public class AbstractTest {

    @Test
    public  void test(){
        System.out.println(Md5Util.md5("123" ));
    }
}
