package app.services;

import app.entities.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<List<User>> getActiveUsers() {

        List<User> users = userRepository.findAll();
        List<User> actUsers = new ArrayList<>();
        for (User user : users) {
            if (user.isEnabled())
                actUsers.add(user);
        }
        return ResponseEntity.ok(actUsers);

    }
}
