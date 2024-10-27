package com.HibernateGetVSLoad;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;




public class App 
{
    public static void main( String[] args )
    {
        
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  

        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory sf=meta.getSessionFactoryBuilder().build();  
        
        Session session=sf.openSession();
        session.beginTransaction();
        //get
      Laptop lap1= session.get(Laptop.class,1);
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        System.out.println(lap1);
        //load
      Laptop lap2= session.load(Laptop.class,2);
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        System.out.println(lap2);
        //get without the particular column
     Laptop lap3= session.get(Laptop.class,40);
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        System.out.println(lap3);
        //load  without the particular column
      Laptop lap4= session.load(Laptop.class,40);
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        System.out.println(lap4);
        session.getTransaction().commit();
      
        
        session.close();
    }
}
