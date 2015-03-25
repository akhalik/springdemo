package demo.spring.repository;

import demo.spring.repository.RepoBaseDao;
import demo.spring.model.User;

public interface UserDao extends RepoBaseDao<User, String>  {
	public User getUserById(String name);
	public void saveUser(User appUser);
	public void deleteUser(User appUser);
}
