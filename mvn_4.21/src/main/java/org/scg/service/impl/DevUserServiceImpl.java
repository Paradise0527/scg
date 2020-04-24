package org.scg.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.scg.dao.DevUserDao;
import org.scg.pojo.*;
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<AppCategory> categoryLevelList(Integer parentId) {
        return devUserDao.categoryLevelList(parentId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<AppInfo> appInfoList() {
        return devUserDao.appInfoList();
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageInfo<AppInfo> getPageInfo(Parames parames) {

        //1>开始进行分页
        PageHelper.startPage(parames.getCurrentPageNo(),parames.getPageSize());

        //2>调用底层方法
        List<AppInfo> list = devUserDao.appInfoList();

        //3>分页包装
        PageInfo<AppInfo> pageInfo =new PageInfo<>(list);


        return pageInfo;
    }

    /**
     * 条件分页
     * @param appInfo
     * @param parames
     * @return
     */
    @Override
    public PageInfo<AppInfo> findName(AppInfo appInfo, Parames parames) {
        //1>开始进行分页
        PageHelper.startPage(parames.getCurrentPageNo(),parames.getPageSize());

        //2>调用底层方法
        List<AppInfo> list = devUserDao.find();

        //3>分页包装
        PageInfo<AppInfo> pageInfo =new PageInfo<>(list);

        return pageInfo;
    }

}
