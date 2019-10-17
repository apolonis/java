package example.example.UserController;


import example.example.Model.User;
import example.example.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAll")
    public List<User> getAll() {

        return userRepository.findAll();

    }

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user) {
        user.setName(user.getName());
        user.setLastname(user.getLastname());
        user.setEmail(user.getEmail());
        user.setPassword(user.encode(user.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public String deleteUser(@PathVariable String uuid){
            userRepository.deleteByUuid(uuid);
            return "User with uniqe id: "+uuid+" has been deleted";
    }

//   @PutMapping("/update/{uuid}")
//   public User updateUser(@PathVariable String uuid){
//        User updatedUser = userRepository.findByUuid(uuid);
//        updatedUser.setName("Hugo");
//        updatedUser.setId(8);
//        userRepository.save(updatedUser);
//        return  updatedUser;
//
//   }
    @PutMapping("/updateByUuid/{uuid}")
    public User updateUser(@PathVariable String uuid, @RequestBody User user){
        User updatedUser = userRepository.findByUuid(uuid);

        updatedUser.setName(user.getName());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.encode(user.getPassword()));

        userRepository.save(updatedUser);
        return  updatedUser;

    }
    @PostMapping("/login")
    public User loginUser(@RequestBody User data) {
        User data1 = userRepository.findByEmail(data.getEmail());

        if(data1.getEmail().equals(data.getEmail())
                && data1.getPassword().equals(data.encode(data.getPassword()))) {

          return data1;
       }
        return null;
    }




}