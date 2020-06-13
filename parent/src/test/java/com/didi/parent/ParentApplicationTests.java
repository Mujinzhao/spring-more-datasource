package com.didi.parent;

import com.didi.db.Service.ServiceTest;
import com.didi.db.XinkunDao.UserDOMapper;
import com.didi.db.XinkunServiceImpl.RedisServiceImpl;
import com.didi.db.mapper.PayDOMapper;
import com.didi.parent.ApiResponse.ApiResponse;
import com.didi.parent.Entity.CityInfo;
//import com.didi.parent.Entity.UserInfo;
import com.didi.parent.Service.GetUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = ParentApplication.class)
public class ParentApplicationTests {

	@Autowired
	private PayDOMapper payDOMapper;

	@Autowired
	private UserDOMapper userDOMapper;

	@Autowired
	private CityInfo cityInfo;

	@Autowired
	RedisServiceImpl redisService;

//	@Autowired
//	private UserInfo userInfo;

	@Autowired
	List<ServiceTest> serviceTest;

	@Resource
	private GetUserInfoService getUserInfoService;

	@Test
	public void testRedis(){
		boolean reduslt = redisService.luaScript();
		int a = 0;
	}

	@Test
	public void testSqlmaster() {
		System.out.println(payDOMapper.selectByPrimaryKey(1));
	}

	@Test
	public void testSqlsecond() {
		System.out.println(userDOMapper.selectByPrimaryKey(1L));
	}

	@Test
	public void testService() {
//		System.out.println(ApiResponse.success(serviceTest.test()));
//		log.info("astewafsaf");
//		serviceTest.get(0).test();
//		serviceTest.get(1).test();
		int a =0 ;

	}

	public List<ServiceTest> getServiceTest() {
		return serviceTest;
	}

	@Autowired
	public void setServiceTest(List<ServiceTest> serviceTest) {
		this.serviceTest = serviceTest;
	}
}