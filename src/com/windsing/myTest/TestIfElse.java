package com.windsing.myTest;

public class TestIfElse {
	static int a = 6;
	static int b = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0;i <5;i++){
			if(a == i){
				System.out.println("if");
			}else if(a != i && i == 4){
				System.out.println("else");
			}
		}


	}

}
