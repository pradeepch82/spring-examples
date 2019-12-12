package com.app.simple;

public class TestBean {
	private String data;
	public TestBean() {
		System.out.println("in test bean constr "+data);
	}
	//init style method ---public void any method name no args
	//init method --- SC when --- after inst,D.I 
	public void myInit()
	{
		System.out.println("in init ...."+data);
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		System.out.println("in setter");
		this.data = data;
	}
	public void exec()
	{
		System.out.println("some B.L with data "+data);
	}
	//destroy style method ---public void any method name no args
	//invoked auto by SC -- before GC 
	public void myDestroy()
	{
		System.out.println("in destroy");
	}

}
