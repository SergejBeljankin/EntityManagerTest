package hiber;

import hiber.config.AppConfig;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("User01", "Lastname01", "user1@mail.ru");
      User user2 = new User("User02", "Lastname02", "user2@mail.ru");
      User user3 = new User("User03", "Lastname03", "user3@mail.ru");
      User user4 = new User("User04", "Lastname04", "user4@mail.ru");

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());

         System.out.println();
      }



   }
}
