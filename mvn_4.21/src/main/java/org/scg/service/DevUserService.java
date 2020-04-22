package org.scg.service;

import org.scg.pojo.AppCategory;
import org.scg.pojo.DataDictionary;
import org.scg.pojo.DevUser;

import java.util.List;

/**
 * 底层接口
 */
public interface DevUserService {

    public DevUser login(String devCode,String devPassword);

    public List<DataDictionary> statusList();

    public List<DataDictionary> flatFormList();

    public List<AppCategory> categoryLevel1List();


}
