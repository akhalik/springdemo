/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.services;


import demo.spring.repository.UserDao;
import demo.spring.repository.UserDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author akhalik
 */
public class UserAuthenticationServiceImpl implements UserDetailsService {

    
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        userDao = new UserDaoImpl();
        demo.spring.model.User user = userDao.findByAttribute("loginId", userName);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(
                "ROLE_USER");
        SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(
                "ROLE_ADMIN");
        authorities.add(adminAuthority);
        authorities.add(adminAuthority);
        UserDetails userDetail = null;
        if(user != null){
        userDetail = new org.springframework.security.core.userdetails.User(user.getLoginId(), user.getPassword(),
                true, true, true, true, authorities);
        }else{
         userDetail = new org.springframework.security.core.userdetails.User(" ", " ",
                true, true, true, true, authorities);
        }

        return userDetail;
    }

}
