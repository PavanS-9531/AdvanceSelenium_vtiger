package org.qspiders.DDT;

public class DebuggingProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Program to debug push after modification
		int a = 10;
		int b = 20;
		System.out.println(a);
		System.out.println(b);
		System.out.println("=============================================================");
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println(a);
		System.out.println(b);

	}

}
