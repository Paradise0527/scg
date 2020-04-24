package org.scg.service;

import com.github.pagehelper.PageInfo;
import org.scg.pojo.*;

import java.util.List;

/**
 * 底层接口
 */
public interface DevUserService {

    public DevUser login(String devCode,String devPassword);

    public List<DataDictionary> statusList();

    public List<DataDictionary> flatFormList();

    public List<AppCategory> categoryLevel1List();

    public List<AppCategory> categoryLevelList(Integer parentId);

    public  List<AppInfo> appInfoList();

    //分页
    public PageInfo<AppInfo> getPageInfo(Parames parames);


    //分页根据条件查找
    public PageInfo<AppInfo>  findName(AppInfo appInfo,Parames parames);

}
