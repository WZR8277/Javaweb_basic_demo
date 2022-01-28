package cn.ron.test;


import cn.ron.dao.UserDao;
import cn.ron.domain.User;
import org.junit.Test;

public class UserDaoTest {



    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("ron");
        loginuser.setPassword("123");


        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}

