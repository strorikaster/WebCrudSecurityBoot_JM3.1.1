package com.webcrudsecurityboot.webcrudsecurityboot;

import com.webcrudsecurityboot.webcrudsecurityboot.model.Role;
import com.webcrudsecurityboot.webcrudsecurityboot.model.User;
import com.webcrudsecurityboot.webcrudsecurityboot.service.RoleService;
import com.webcrudsecurityboot.webcrudsecurityboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.Set;

@Component
    public class DataLoader{

        private UserService userService;
        private RoleService roleService;
        private PasswordEncoder passwordEncoder;




        @Autowired
        public DataLoader (UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
            this.userService = userService;
            this.roleService = roleService;
            this.passwordEncoder = passwordEncoder;
        }

        @PostConstruct
        public void fillDataBase() {
            Role roleAdmin = new Role();
            roleAdmin.setRole("ADMIN");
            roleService.save(roleAdmin);

            Role roleUser = new Role();
            roleUser.setRole("USER");
            roleService.save(roleUser);


            User user1  = new User();
            user1.setName("Alex");
            user1.setPassword(passwordEncoder.encode("root"));
            user1.setSurName("Zotov");
            user1.setEmail("zotov@mail.ru");
            user1.setAge(40);
            user1.setRoles(Set.of (roleAdmin));

            userService.save(user1);


            User user2 = new User();
            user2.setName("Ivan");
            user2.setPassword(passwordEncoder.encode("root"));
            user2.setSurName("Petrov");
            user2.setEmail("petrov@mail.ru");
            user2.setAge(25);
            user2.setRoles(Set.of (roleUser));

            userService.save(user2);

            User user3 = new User();
            user3.setName("Egor");
            user3.setPassword(passwordEncoder.encode("root"));
            user3.setSurName("Egorov");
            user3.setEmail("egorov@mail.ru");
            user3.setAge(27);
            user3.setRoles(Set.of (roleUser, roleAdmin));

            userService.save(user3);

        }
    }
