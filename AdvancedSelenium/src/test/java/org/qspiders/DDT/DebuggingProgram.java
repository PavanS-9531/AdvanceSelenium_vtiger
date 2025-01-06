package org.qspiders.DDT;

public class DebuggingProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Program to debug push after modification
		//push again after modification
		int a = 10;
		int b = 20;
		int c = 30;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println("=============================================================");
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println(a);
		System.out.println(b);
		//code from branch1

	}

}
