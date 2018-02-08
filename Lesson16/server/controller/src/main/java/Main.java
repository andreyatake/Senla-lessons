

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.User;
import com.service.ObjectConverter;
import com.service.TokenHandler;
import com.service.api.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

      ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
        IUserService userService = context.getBean(IUserService.class);
      //  IUserDataService userDataService = context.getBean(IUserDataService.class);
      //  IUserDAO userDao = context.getBean(IUserDAO.class);

       // userDataService.getUserDataByUserId(new Long(1));
        //System.out.print(userDataService.getUserDataByUserId(new Long(1)).getName());

      //  UserData userData=new UserData(user,"Fds","fds","fd",new Date());
       // userService.addUser(user);
      //  userDataService.addUserData(userData);

        String str2="{\"type\":\"User\",\"login\":\"cds\",\"password\":\"succes\",\"id\":null}";
        System.out.println(userService.checkUser(str2));
        TokenHandler tokenHandler=new TokenHandler();
        System.out.println(tokenHandler.createToken(userService.checkUser(str2)));
        System.out.println(tokenHandler.getUserIdByToken("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJTdXBlcldlYkFwcCIsImlkIjo2LCJleHAiOjE1MTgxMjIzNzh9.TUxI8uHpQg3pSR9SdzaqBCUkc8vpI5sb-LJuN4IbUXI"));
    }
}
