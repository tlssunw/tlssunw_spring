package com.springStudy1.DTO;

public class TestA {
	private TestB tb;
	private TestC tc;
	
	public void makeObject2(TestC tc) {
		//약한결합
		this.tc
	}
	
	public void makeObject1() {
		//강한결합
		this.tb = new TestB();
	}
	public void makeObject1(int num, String name) {
		this.tb=new TestB(num, name);
	}
	public void makeObject1(int num) {
		this.tb=new TestB(num, name);
	}
}
