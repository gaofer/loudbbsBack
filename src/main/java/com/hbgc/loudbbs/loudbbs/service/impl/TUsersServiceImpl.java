package com.hbgc.loudbbs.loudbbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbgc.loudbbs.loudbbs.entity.TUsers;
import com.hbgc.loudbbs.loudbbs.mapper.TUsersMapper;
import com.hbgc.loudbbs.loudbbs.service.TUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-06
 */
@Service
@Transactional
public class TUsersServiceImpl extends ServiceImpl<TUsersMapper, TUsers> implements TUsersService {

    @Resource
    private TUsersService usersService;


    @Override
    public TUsers saveU(TUsers saveu) {
        TUsers tu=null;
        QueryWrapper<TUsers> logWrapper = new QueryWrapper<>();
        logWrapper.eq("username",saveu.getUsername());
        logWrapper.eq("password",saveu.getPassword());
        if(usersService.save(saveu)){
            tu=usersService.getOne(logWrapper,false);
            return tu;
        }else{
            return null;
        }
    }
}
