package test;

import com.westos.domain.Module;
import com.westos.domain.Role;
import com.westos.service.RoleService;
import com.westos.service.impl.RoleServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleTest extends AbstractTest {

//    private RoleService roleService = new RoleServiceImpl();
   @Autowired
   RoleServiceImpl roleService;
    @Test
    public void testFind(){
        List<Role> all = roleService.findAll();
        for (Role role : all) {
            System.out.println(role.getId()+"  "+ role.getName());
            List<Module> modules = role.getModules();
            for (Module module : modules) {
                System.out.println("           "+module.getId()+"  "+module.getName());
            }
        }
    }

    @Test
    public  void testFindByUserId(){
        List<Role> roles = roleService.findByUserId(1);
        for (Role role : roles) {
            System.out.println(role.getId()+"  "+ role.getName());
            List<Module> modules = role.getModules();
            for (Module module : modules) {
                System.out.println("           "+module.getId()+"  "+module.getName());
            }
        }
    }

    @Test
    public  void testModefiy(){
        int[] a= {31,32,33};

        roleService.modifyRoleModule(5,a);
    }
}
