package com.windsing.baseClass;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * ʵ����Զ�̶���
 * server����Ҫע��ӿڣ���ȡ��Ȼ���
 * @author FC
 *
 */
public class MyRMIServer {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��ʼע��Ͱ�Զ�̶���");
		MyRMI mr = new MyRMI();//step 1 ʵ��������
		LocateRegistry.createRegistry(8899); //step 2 ע��ӿڣ�javaĬ�϶˿�1099��
		Naming.bind("rmi://localhost:8899/myRMI", mr); //step 3 �󶨶���myRMI���������
		System.out.println("Զ�̶���ע������");
	}

}
