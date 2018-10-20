package com.jack.aop;

import com.jack.aop.demoModel.HelloService;
import com.jack.aop.demoModel.HelloServiceImpl;
import com.jack.aop.demoModel.MyInterceptor;
import com.jack.aop.demoModel.ProxyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AopApplication.class, args);

		testMethodExecute("jack");
		testMethodExecute(null);

		System.out.println("-----aop example begin----------");
		UserAopTest test = ctx.getBean(UserAopTest.class);
		test.execute();
		System.out.println("-----aop end begin----------");
	}

	static void testMethodExecute(String name){
		System.out.println("-----testMethodExecute begin----------");
		HelloService helloService = new HelloServiceImpl();
		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
		proxy.sayHello(name);
		System.out.println("-----testMethodExecute end-----------");
	}
}
