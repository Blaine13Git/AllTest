package com.windsing.baseClass;

import java.rmi.Naming;

/**
 * 在RMI服务的注册表中根据名字查找对象
 * @author FC
 *
 */
public class MyRMIClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MyRMI mr = (MyRMI) Naming.lookup("myRMI"); //直接获取的对象类型是Remote类型，需要强制转换成需要的对象类型
		mr.myMethod();

	}

}
