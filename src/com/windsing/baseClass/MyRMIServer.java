package com.windsing.baseClass;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * 实例化远程对象
 * server端需要注册接口，并取名然后绑定
 * @author FC
 *
 */
public class MyRMIServer {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("开始注册和绑定远程对象");
		MyRMI mr = new MyRMI();//step 1 实例化对象
		LocateRegistry.createRegistry(8899); //step 2 注册接口（java默认端口1099）
		Naming.bind("rmi://localhost:8899/myRMI", mr); //step 3 绑定对象到myRMI这个名字上
		System.out.println("远程对象注册绑定完成");
	}

}
