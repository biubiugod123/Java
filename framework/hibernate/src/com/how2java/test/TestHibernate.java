package com.how2java.test;
 
import org.hibernate.Session;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
import com.how2java.pojo.Product;
import com.how2java.pojo.User;
import com.how2java.pojo.Category;
 
public class TestHibernate {
	 public static void main(String[] args) {
	        SessionFactory sf = new Configuration().configure().buildSessionFactory();
	   
	        Session s = sf.openSession();
	        s.beginTransaction();
	        System.out.println("log1");
	        Category c1 = (Category)s.get(Category.class, 1);
	        System.out.println("log2");
	        Category c2= (Category)s.get(Category.class, 1);
	        System.out.println("log3");       
	 
	        s.getTransaction().commit();
	        s.close();
	        sf.close();
	    }
	}