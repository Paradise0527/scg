package org.scg.dao;

import org.apache.ibatis.annotations.Param;
import org.scg.pojo.AppCategory;
import org.scg.pojo.AppInfo;
import org.scg.pojo.DataDictionary;
import org.scg.pojo.DevUser;

import java.util.List;

/**
 * 底层接口
 */
public interface DevUserDao {

    public DevUser login(@Param("devCode") String devCode,@Param("devPassword") String devPassword);

    public List<DataDictionary> statusList();

    public List<DataDictionary> flatFormList();

    public List<AppCategory> categoryLevel1List();

    public List<AppCategory> categoryLevelList(Integer parentId);

    public  List<AppInfo> appInfoList();

    public  List<AppInfo> find();


}
