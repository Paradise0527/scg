package org.scg.controll;


import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.scg.pojo.*;
import org.scg.service.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/dev")
public class DevUserController {
    Logger log4j = Logger.getLogger(DevUserController.class);

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
    public String list(ModelMap map, Parames parame){
        List<DataDictionary> statusList = devUserService.statusList();
        List<DataDictionary> flatFormList = devUserService.flatFormList();
        List<AppCategory> categoryLevel1List = devUserService.categoryLevel1List();
        List<AppInfo> appInfoList = devUserService.appInfoList();
        PageInfo<AppInfo> pageInfo = devUserService.getPageInfo(parame);
        //保存数据
        map.addAttribute("statusList", statusList);
        map.addAttribute("flatFormList", flatFormList);
        map.addAttribute("categoryLevel1List", categoryLevel1List);
        map.addAttribute("appInfoList", appInfoList);
        map.addAttribute("pages", pageInfo);

        System.out.println(pageInfo);
        return "/dev/appinfolist"; //直接跳转
    }

    @RequestMapping("/categoryLevelList")
    @ResponseBody
    public List<AppCategory> categoryLevel1List(ModelMap map,Integer parentId){

        List<AppCategory> list=devUserService.categoryLevelList(parentId);

        map.addAttribute("categoryLevelList1", list);

        return list;
    }

}
