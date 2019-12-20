package com.hbgc.loudbbs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbgc.loudbbs.loudbbs.entity.TUsers;
import com.hbgc.loudbbs.loudbbs.mapper.TUsersMapper;
import com.hbgc.loudbbs.loudbbs.service.TUsersService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class LoudbbsApplicationTests {

    @Resource
	private TUsersMapper userMapper;
	@Resource
	private TUsersService usersService;

    @Test
	void contextLoads() {
	}


	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<TUsers> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

	@Test
    public void testLogin(){
        System.out.println("--------测试登录----------");
		QueryWrapper<TUsers> logWrapper = new QueryWrapper<>();
		logWrapper.eq("username","zhangs");
		logWrapper.eq("password","1234");
        TUsers t = usersService.getOne(logWrapper,false);
        System.out.println(t);
    }

	@Test
	public void testCount(){
		System.out.println("--------测试名称查重----------");
		int countUser = -1;
		QueryWrapper<TUsers> logWrapper = new QueryWrapper<>();
		logWrapper.eq("username","zhang");
		countUser = usersService.count(logWrapper);
		System.out.println(countUser);
	}

}
