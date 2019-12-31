package com.hbgc.loudbbs.loudbbs.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbgc.loudbbs.json.Json;
import com.hbgc.loudbbs.loudbbs.entity.TUsers;
import com.hbgc.loudbbs.loudbbs.mapper.TUsersMapper;
import com.hbgc.loudbbs.loudbbs.service.TUsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-06
 */
@RestController
@RequestMapping("t-users")
public class TUsersController {

    @Resource
    private TUsersService usersService;
    @Resource
    private TUsersMapper userMapper;

    /**
     * 登录时访问，登录成功后返回当前登陆的用户对象
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public Map<String, Object> login(String username, String password) {
        TUsers loginUser = null;
        QueryWrapper<TUsers> logWrapper = new QueryWrapper<>();
        logWrapper.eq("username", username);
        logWrapper.eq("password", password);

        try {
            loginUser = usersService.getOne(logWrapper, false);
            if (loginUser != null) {
                return Json.success(loginUser, "登陆成功");
            }
            return Json.fail("登录失败");
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("登录失败");
        }
    }

    /**
     * 查看当前的用户名有没有被注册过，如果有则返回有几个相同的用户名。
     *
     * @param username
     * @return
     */
    @GetMapping("/countusername")
    public Map<String, Object> login(String username) {
        int countUser = -1;
        QueryWrapper<TUsers> logWrapper = new QueryWrapper<>();
        logWrapper.eq("username", username);
        try {
            countUser = usersService.count(logWrapper);
            if (countUser != -1) {
                return Json.success(countUser, "查询成功");
            }
            return Json.fail("查询失败");
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("查询失败");
        }
    }

    /**
     * 返回所有用户对象。
     *
     * @return
     */
    @GetMapping("/")
    public Map<String, Object> queryAll() {
        List<TUsers> tUsersList = null;
        try {
            //这里可以不使用Mapper  违反了编码规范，利用service就可以完成List的任务。
            tUsersList = userMapper.selectList(null);
            if (tUsersList != null) {
                return Json.success(tUsersList, "loginSuccess");
            }
            return Json.fail("loginFailure");
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("loginFailure");
        }
    }

    /**
     * 注册新用户，成功后返回新注册的用户对象。
     *
     * @param regUser
     * @return
     */
    @PostMapping(value = "/reg")
    public Map<String, Object> regUser(@RequestBody TUsers regUser) {
        TUsers u = null;
        try {
            u = usersService.saveU(regUser);
            if (u != null) {
                return Json.success(u, "注册成功"); //注册成功
            } else {
                return Json.fail("注册失败"); //注册失败
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("注册失败"); //注册失败
        }
    }

    /**
     * 提升管理员权限。
     *
     * @param updateUser
     * @return
     */
    @PostMapping(value = "/update")
    public Map<String, Object> updateUser(@RequestBody TUsers updateUser) {
        //TUsers u = null;
        try {
            boolean u = usersService.updateById(updateUser);
            if (u) {
                return Json.success(null, "升级管理员成功"); //注册成功
            } else {
                return Json.fail("升级管理员失败"); //注册失败
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("升级管理员失败"); //注册失败
        }
    }


}

