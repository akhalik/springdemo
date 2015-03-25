package demo.spring.repository;

import demo.spring.model.User;





public class UserDaoImpl extends RepoBaseDaoImpl <User, String> implements UserDao{

	@Override
	public User getUserById(String name){
		User appUser = find(name);
		return appUser;
	}
	
	@Override
	public void saveUser(User appUser){
		add(appUser);
	}
	
	@Override
	public void deleteUser(User appUser){
		remove(appUser);
	}
}

