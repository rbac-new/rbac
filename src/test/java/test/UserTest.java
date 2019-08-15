package test;

import com.sxzwp.domain.Role;
import com.sxzwp.domain.User;
import com.sxzwp.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserTest extends AbstractTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void testFindByUsername(){
        User admin = userService.findByUsername("admin");
        System.out.println(admin);
    }
    @Test
    public  void testFindByUserID(){
        User byId = userService.findById(1);
        System.out.println(byId);
    }
    @Test
    public  void testFindAll(){
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user.getId()+"  "+user.getUsername());
            List<Role> roles = user.getRoles();
            for (Role role : roles) {
                System.out.println("\t\t"+role.getId()+"  "+role.getName());
            }
        }
    }
    @Test
    public  void testFindByPage(){
        List<User> byPage = userService.findByPage(2, 3);
        for (User user : byPage) {
            System.out.println(user);
        }
    }
    @Test
    public  void testFindCount(){
        System.out.println(userService.findCount());
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setPassword("123456");
        user.setUsername("aaaaa");
        userService.insert(user);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setPassword("123456");
        user.setUsername("bbbbb");
        user.setId(16);
        userService.update(user);
    }
    @Test
    public  void testdelete(){
        userService.delete(16);
    }
    @Test
    public  void testModifyRole(){
        int[] a= {2,3};
        userService.modifyRoles(3,a);
    }
}
