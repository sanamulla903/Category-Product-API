package com.nimap.CategorySpringbootwithHibernet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		int Cid;
		String Cname;
		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Category(int cid, String cname) {
			super();
			Cid = cid;
			Cname = cname;
		}
		public int getCid() {
			return Cid;
		}
		public void setCid(int cid) {
			Cid = cid;
		}
		public String getCname() {
			return Cname;
		}
		public void setCname(String cname) {
			Cname = cname;
		}
		@Override
		public String toString() {
			return "Category [Cid=" + Cid + ", Cname=" + Cname + "]";
		}
		
		

}
