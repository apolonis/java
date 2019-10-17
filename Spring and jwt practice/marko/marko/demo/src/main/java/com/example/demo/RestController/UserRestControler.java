package com.example.demo.RestController;


import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.util.GeneratePDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.util.List;

/*Here we're creating function we needed and with post mapping we (sending api) creating and latter  
 * we call thouse function with java script, script we created in html document
 */
@RestController
@RequestMapping("/api")
public class UserRestControler {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> createUser(HttpServletRequest request) {
        try {

            if (request.getParameter("name").length() == 0 || request.getParameter("familyName").length() == 0 ||
                    request.getParameter("username").length() == 0 || request.getParameter("email").length() == 0 ||
                    request.getParameter("password").length() == 0 || request.getParameter("position").length() == 0
            || request.getParameter("phoneNumber").length() == 0 || request.getParameter("fb").length() == 0 || request.getParameter("linkedin").length() == 0
                    || request.getParameter("role").length() == 0
            ) {

                return ResponseEntity.badRequest().build();

            } else if (!userRepository.findByUsername(request.getParameter("username")).isEmpty()) {

                return ResponseEntity.badRequest().build();

            } else if (!userRepository.findByEmail(request.getParameter("email")).isEmpty()) {

                return ResponseEntity.badRequest().build();

            }
                User user = new User(request.getParameter("name"), request.getParameter("familyName"), request.getParameter("username"),
                        request.getParameter("email"), request.getParameter("password"), request.getParameter("position"),
                        request.getParameter("phoneNumber"), request.getParameter("fb"), request.getParameter("linkedin"), request.getParameter("role"));

                userRepository.save(user);

                return ResponseEntity.ok().body("User is created");


        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.badRequest().build();
        }


    }
    @PostMapping("/logUser")
    public ResponseEntity<String> logUser(HttpServletRequest request){
        try {
            if(userService.findUser(request.getParameter("username"), request.getParameter("password"))){
                return ResponseEntity.ok().body("User is loged");
            }else{
                return ResponseEntity.badRequest().build();
            }
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/editUser")
    public ResponseEntity<String> editUser(HttpServletRequest request) {
        try {
            if (request.getParameter("name").length() == 0 || request.getParameter("familyName").length() == 0 ||
                    request.getParameter("username").length() == 0 || request.getParameter("email").length() == 0
                    || request.getParameter("password").length() == 0 || request.getParameter("position").length() == 0
                    || request.getParameter("phoneNumber").length() == 0 || request.getParameter("fb").length() == 0 ||
                    request.getParameter("linkedin").length() == 0 || request.getParameter("role").length() == 0) {
                return ResponseEntity.badRequest().build();
            }

            if (!userRepository.findByUsername(request.getParameter("username")).isEmpty()) {
                User u = userService.findByUsername(request.getParameter("username"));
                if (u.getId() != Integer.parseInt(request.getParameter("id"))) {
                    return ResponseEntity.badRequest().build();
                } else {
                    System.out.println("id is match");
                }
            }
            if (!userRepository.findByEmail(request.getParameter("email")).isEmpty()) {
                User u = userService.findByMail(request.getParameter("email"));
                if (u.getId() != Integer.parseInt(request.getParameter("id"))) {
                    return ResponseEntity.badRequest().build();
                } else {
                    System.out.println("id is match");
                }
            }

            User user = new User(request.getParameter("id"), request.getParameter("name"),request.getParameter("familyName"),
                    request.getParameter("username"), request.getParameter("email"), request.getParameter("password"),
                    request.getParameter("position"), request.getParameter("phoneNumber"), request.getParameter("fb"),
                    request.getParameter("linkedin"), request.getParameter("role"));

            userRepository.save(user);

            return ResponseEntity.ok().body("User is changed.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
    @PostMapping("/deleteUser")
    public ResponseEntity<String> deleteStudent(HttpServletRequest request) {
        try {
            if (userService.findUser(request.getParameter("username"))) {
                userService.deleteUser(request.getParameter("username"));
                return ResponseEntity.ok().body("User is deleted");
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

    @RequestMapping(value = "/usersPDF", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)

    public ResponseEntity<InputStreamResource> citiesReport() {

        List<User> u = userService.findAll();

        ByteArrayInputStream bis = GeneratePDF.userReport(u);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=user management.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }

}