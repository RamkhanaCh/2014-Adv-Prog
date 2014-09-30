package com.lab01.HW;

public class Animal {
	
	private String name;
	private int x;
	private int height;
	
	public Animal(){
		this.name="";
		this.x=0;
		this.height=0;
	}
	
	public Animal(String name,int x,int height){
		this.name=name;
		this.x=x;
		this.height=height;
	}
	
	public String getName(){
		return name;
	}
	public int getX(){
		return x;
	}
	public int getHeight(){
		return height;
	}
	
	
	public void setName(String s){
		this.name=s;
	}
	public void setX(int x){
		this.x=x;
	}
	public void setHeight(int h){
		this.height=h;
	}
	
	public void setInfo(Animal a){
		this.name=a.name;
		this.x=a.x;
		this.height=a.height;
	}
	



	

}
