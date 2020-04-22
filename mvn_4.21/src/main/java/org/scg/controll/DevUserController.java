package org.scg.controll;


import org.scg.pojo.AppCategory;
import org.scg.pojo.DataDictionary;
import org.scg.pojo.DevUser;
import org.scg.service.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/dev")
public class DevUserController {

    //业务数据
    @Resource
    private DevUserService devUserService;


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/devlogin"; //直接跳转
    }

    @RequestMapping("/login" )
    public String login(ModelMap map, String devCode,String devPassword) {
        //业务方法
        DevUser devUser1 = devUserService.login(devCode,devPassword);

        if (devUser1 == null) {
            return "/devlogin";
        } else {
            //保存数据
            map.addAttribute("devUserSession", devUser1);
            //重定向
            return "/dev/main";  //直接跳转
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("devUserSession");
        session.invalidate();
        return "/index";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        List<DataDictionary> statusList = devUserService.statusList();

        List<DataDictionary> flatFormList = devUserService.flatFormList();

        List<AppCategory> categoryLevel1List = devUserService.categoryLevel1List();

        //保存数据
        map.addAttribute("statusList", statusList);
        map.addAttribute("flatFormList", flatFormList);
        map.addAttribute("categoryLevel1List", categoryLevel1List);


        return "/dev/appinfolist"; //直接跳转
    }

}
