package com.windsing.baseClass;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * RMI,Զ�̷�������
 * 1����Ҫ�̳�UnicastRemoteObject������ʹ��JRMP����Զ�̶��󲢻�ȡ��Զ�̶���ͨ�ŵĴ����
 * 2����Ҫ��ӹ��췽��
 * 3����Ҫʵ��Remote�ӿ�
 * @author FC
 */
public class MyRMI extends UnicastRemoteObject implements Remote{

	/**
	 * ����UnicastRemoteObjectʵ����Serializable�ӿڣ�
	 * ��Ҫ��һ��static final long serialVersionUID
	 */
	public static final long serialVersionUID = 123L;
	
	protected MyRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void myMethod() throws RemoteException{
		System.out.println("����Զ�̶���MyRMI");
	}
}
