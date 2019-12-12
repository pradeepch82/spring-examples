package com.app.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		System.out.println("started ctx...");
		((ClassPathXmlApplicationContext)ctx).registerShutdownHook();
		TestBean ref=ctx.getBean(TestBean.class);
	
		ref.exec();
		ref=ctx.getBean(TestBean.class);
		
		ref.exec();
		ref=ctx.getBean(TestBean.class);
		
		ref.exec();



	}

}
