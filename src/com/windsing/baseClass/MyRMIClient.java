package com.windsing.baseClass;

import java.rmi.Naming;

/**
 * ��RMI�����ע����и������ֲ��Ҷ���
 * @author FC
 *
 */
public class MyRMIClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MyRMI mr = (MyRMI) Naming.lookup("myRMI"); //ֱ�ӻ�ȡ�Ķ���������Remote���ͣ���Ҫǿ��ת������Ҫ�Ķ�������
		mr.myMethod();

	}

}
