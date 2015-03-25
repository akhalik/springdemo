package demo.spring.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepoBaseDao<E, K>  {
    public void add(E entity);
    public void update(E entity);
    public void remove(E entity);
    public E find(K key);
    public List<E> list();
    public E findByAttribute(String attribName, K kay);
}
