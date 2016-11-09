package com.windsing.myTest;

public class TestEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] a = {"1","2","3","4","5"};
		
		
		for(int i= 0;i<a.length;i++){
			if(a[i].equals("7")){
				System.out.println("if");
			}else if(i == a.length-1 && !a[i].equals("6") ){
				System.out.println("else if");
			}
		}

	}

}
