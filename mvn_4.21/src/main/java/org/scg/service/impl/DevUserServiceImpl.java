package org.scg.service.impl;


import org.scg.dao.DevUserDao;
import org.scg.pojo.AppCategory;
import org.scg.pojo.DataDictionary;
import org.scg.pojo.DevUser;
import org.scg.service.DevUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service   //业务
@Transactional  //事务
public class DevUserServiceImpl implements DevUserService {

    //注入底层数据
    @Resource
    private DevUserDao devUserDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public DevUser login(String devCode,String devPassword) {
        return devUserDao.login(devCode,devPassword);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)

    public List<DataDictionary> statusList() {
        return devUserDao.statusList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<DataDictionary> flatFormList() {
        return devUserDao.flatFormList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<AppCategory> categoryLevel1List() {
        return devUserDao.categoryLevel1List();
    }


}
