package com.spring.colls;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		 ApplicationContext context = new FileSystemXmlApplicationContext(
					"src/main/java/com/spring/colls/applicationContext.xml");
		  ShapeCollection shapeCollection = (ShapeCollection) context.getBean("shap");
		  System.out.println(shapeCollection);

	}
}
