package com.windsing.baseClass;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * RMI,远程方法调用
 * 1、需要继承UnicastRemoteObject（用于使用JRMP导出远程对象并获取与远程对象通信的存根）
 * 2、需要添加构造方法
 * 3、需要实现Remote接口
 * @author FC
 */
public class MyRMI extends UnicastRemoteObject implements Remote{

	/**
	 * 由于UnicastRemoteObject实现了Serializable接口，
	 * 需要给一个static final long serialVersionUID
	 */
	public static final long serialVersionUID = 123L;
	
	protected MyRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void myMethod() throws RemoteException{
		System.out.println("我是远程对象，MyRMI");
	}
}
