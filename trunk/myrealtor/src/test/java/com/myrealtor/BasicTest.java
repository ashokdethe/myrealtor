package com.myrealtor;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;

import com.myrealtor.domain.BaseEntity;
import com.myrealtor.domain.SecurityQuestionTest;
import com.myrealtor.domain.UserTest;

public class BasicTest {

	static EntityManager em;

	public static int getRandomInt() {
		Random random = new Random();
		return Math.abs(random.nextInt()) % 999999;
	}

	public void testAppContext() {
		// Just to avoid error because no test was defined!
	}

	public static ApplicationContext getApplicationContext() {
		// TODO Remove hardcode drive letter
		// ApplicationContext ctx = new
		// FileSystemXmlApplicationContext("D:/workspace-simple-eclipse-jee-ganymede/RMS/war/WEB-INF/rms-servlet.xml");
		// ApplicationContext ctx = new
		// FileSystemXmlApplicationContext("D:/workspace-simple-eclipse-jee-ganymede/RMS/war/WEB-INF/spring-dataaccess-config.xml");

		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/config/data-access-config.xml");
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("RMS/war/WEB-INF/spring-dataaccess-config.xml");

		File f = new File(".");
		System.out.println(f.getAbsolutePath());

		return ctx;
	}

	public static synchronized EntityManager getEntityManager() {
		if (em == null) {
			ApplicationContext ctx = getApplicationContext();
			JpaTransactionManager mgr = (JpaTransactionManager) ctx.getBean("transactionManager");
			em = mgr.getEntityManagerFactory().createEntityManager();
		}
		return em;
	}

	public static BaseEntity insert(BaseEntity obj) {
		EntityManager em = BasicTest.getEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		return obj;
	}
	
	public static List<? extends BaseEntity> insert(List<? extends BaseEntity> list) {		
		EntityManager em = BasicTest.getEntityManager();
		em.getTransaction().begin();		
		
		for (BaseEntity u: list) {			
			em.persist(u);
		}
		
		em.flush();
		em.getTransaction().commit();				
		return list;
	}
	

	public static void prepareForTest() {
		dropAndCreateDB();
		//Authority a = AuthorityTest.insert();		
		UserTest.insert(  );
		SecurityQuestionTest.insertDefault();		 
	}

	public static void dropAndCreateDBHibernate() { // Uses hibernate.cfg.xml
		// Ejb3Configuration cfg = new Ejb3Configuration();
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		// System.out.println(cfg.getProperties());

		SchemaExport s = new SchemaExport(cfg);
		// s.drop(true, true);
		s.create(true, true);
	}
	
	@SuppressWarnings("unchecked")
	public static void dropAndCreateDB() { //Uses persistence.xml
		System.out.println("dropAndCreateDB.....");
		//EntityManagerFactory factory = (EntityManagerFactory) getApplicationContext().getBean("entityManagerFactory");
		
		
		Map map = createHSQLDBMap();
		//Map map = createMySQLDBMap();
		map.put("hibernate.current_session_context_class", "thread");
		map.put("hibernate.hbm2ddl.auto", "create-drop");
		//map.put("hibernate.hbm2ddl.auto", "update");
		//map.put("hibernate.show_sql", "true");
		//map.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		
		
		Persistence.createEntityManagerFactory("myrealtorDatabase", map);		
	}


	@SuppressWarnings("unchecked")
	protected static Map createHSQLDBMap() {
		Map map = new HashMap();				
		map.put("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
		map.put("hibernate.connection.username", "sa");
		map.put("hibernate.connection.password", "");
		map.put("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost/myrealtor");
		map.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		map.put("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider");
		return map;
	}	
	
	@SuppressWarnings("unchecked")
	protected static Map createMySQLDBMap() {
		Map map = new HashMap();				
		map.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		map.put("hibernate.connection.username", "myrealtor");
		map.put("hibernate.connection.password", "myrealtor");
		map.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/myrealtor");
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");		
		return map;
	}	
	

	public static void main(String[] args) {
		// dropAndCreateDB();
		prepareForTest();
		System.out.println("Finished!");
	}

}
