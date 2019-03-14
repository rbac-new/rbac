package com.westos.interceptor;

import com.westos.domain.Module;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// interceptor1 以当前类名字首字母小写作为 bean 的id
@Component
public class Interceptor1 implements HandlerInterceptor {

    // 在控制器方法执行前被调用, 返回 true 放行请求， 如果返回 false 拦截请求（不会前进了）
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String addr = req.getRemoteAddr();
        if(!addr.equals("0:0:0:0:0:0:0:1")){
            resp.sendRedirect( "/filter.jsp");
            System.out.println("1111111");
            return false;
        }


        Object user = req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect( "/login.jsp?error=1");
            return false;
        }

        HttpSession session = req.getSession();
        Set<Integer> userModules=(HashSet<Integer>)session.getAttribute("userModules");
        List<Module> allModules = (List<Module>)session.getAttribute("allModules");
        List<String> list = new ArrayList<>();
        for (Module modules : allModules) {
            for (Module module : modules.getChildren()) {
                if(!userModules.contains(module.getId())){
                    list.add(module.getCode());
                }
            }
        }
        System.out.println("-------------------------------");
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        System.out.println(list);
        System.out.println((list.contains(requestURI)));
        if(!(list.contains(requestURI))){
            System.out.println("放行");
            return true;
        }else {
            System.out.println("拒绝访问");
            resp.sendRedirect("/index.jsp");
            return false;
        }
    }
    // 在控制器方法执行后被调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    // 在控制器和视图都完成后被调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
