package demo.spring.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Basic DAO operations dependent with Hibernate's specific classes
	 * @see SessionFactory
	 */
     
	public class RepoBaseDaoImpl<E, K extends Serializable> implements RepoBaseDao<E, K> {
            
	    private static SessionFactory sessionFactory;
	    protected Class<? extends E> daoType;
             static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = RepoUtil.getSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	    public RepoBaseDaoImpl() {
	        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	    }

	    @Autowired
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	    protected Session currentSession() {
	        return sessionFactory.getCurrentSession();
	    }

	    @Override
	    public void add(E entity) {
	    	currentSession().beginTransaction();
	    	currentSession().save(entity);
	    	currentSession().getTransaction().commit();
	    }

	    @Override
	    public void update(E entity) {
	        currentSession().saveOrUpdate(entity);
	    }

	    @Override
	    public void remove(E entity) {
	        currentSession().delete(entity);
	    }

	    @Override
	    public E find(K key) {
                currentSession().beginTransaction();
                Object object = currentSession().get(daoType, key);
                currentSession().getTransaction().commit();
	        return (E)object; 
	    }
             public E findByAttribute(String attribName, K val) {
                currentSession().beginTransaction();
                String objectName = daoType.getName();
                Query hqlQuery =currentSession().createQuery( "From "+objectName + " where  " + attribName +" = '"+val+"'");
                  List<E> list =hqlQuery.list();
                currentSession().getTransaction().commit();
	        if(list != null && (!list.isEmpty()) ){
                
                    return list.get(0);
                }else{
                    return null; 
                
                }
             }
            
	    @Override
	    public List<E> list() {
	        return currentSession().createCriteria(daoType).list();
	    }
	}
