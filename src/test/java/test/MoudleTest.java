package test;

import com.westos.dao.ModuleDao;
import com.westos.domain.Module;
import com.westos.service.ModuleService;
import com.westos.service.impl.ModuleServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MoudleTest extends AbstractTest{


//    private ModuleServiceImpl moduleService=new ModuleServiceImpl();

    @Autowired
    private static ModuleDao moduleDao;
    @Autowired
    ModuleServiceImpl moduleService;
    @Test
    public  void  testFindAll(){
        List<Module> all = moduleService.findAll();
        for (Module module : all) {
            System.out.println(module.getId()+" "+module.getName());
            List<Module> children = module.getChildren();
            for (Module child : children) {
                System.out.println("      "+child.getId()+child.getName());
            }
        }
    }

    @Test
    public  void testByRoleId(){
        List<Module> byRoleId = moduleService.findByRoleId(1);
        for (Module module : byRoleId) {
            System.out.println(module.getId()+" "+module.getName());
        }
    }
}
