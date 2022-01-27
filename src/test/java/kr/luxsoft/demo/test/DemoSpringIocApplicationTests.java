package kr.luxsoft.demo.test;

import kr.luxsoft.demo.BeanFactoryDynamicAutowireService;
import kr.luxsoft.demo.CustomMapFromListDynamicAutowireService;
import kr.luxsoft.demo.RegionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(classes={TestConfig.class})
class DemoSpringIocApplicationTests {

	@Autowired
	BeanFactoryDynamicAutowireService service;

	@Autowired
	CustomMapFromListDynamicAutowireService customService;


	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		assertNotNull(service);
	}

	@Test
	void test(){
		assertTrue(service.isServerActive("US",10));
		assertFalse(service.isServerActive("GB",10));
		log.info("service.isServerActive(US) {}",service.isServerActive("US",10));
	}

	@Test
	void test01(){
		String[] beanNames= context.getBeanNamesForType(RegionService.class);
		log.info("beans  = {}",beanNames);
		for(String beanName:beanNames){
			RegionService bean = context.getAutowireCapableBeanFactory().getBean(beanName,RegionService.class);
			bean.isServerActive(10);
		}

	}

	@Test
	void test02(){
		Map<String, RegionService> beans = context.getBeansOfType(RegionService.class);
		log.info("beans  = {}",beans);
		for(RegionService bean:beans.values()){
			bean.isServerActive(10);
		}

	}


	@Test
	void test04(){
		assertTrue(customService.isServerActive("US",0));
	}
}
