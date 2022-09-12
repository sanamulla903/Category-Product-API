package com.nimap.ProductSpringbootwithHibernet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int Pid;
	String Pname;
	float Pprice;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String pname, float pprice) {
		super();
		Pid = pid;
		Pname = pname;
		Pprice = pprice;
	}
	@Override
	public String toString() {
		return "Product [Pid=" + Pid + ", Pname=" + Pname + ", Pprice=" + Pprice + "]";
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public float getPprice() {
		return Pprice;
	}
	public void setPprice(float pprice) {
		Pprice = pprice;
	}
	
	

}
