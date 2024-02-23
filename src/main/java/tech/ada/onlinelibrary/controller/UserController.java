package tech.ada.onlinelibrary.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.onlinelibrary.domain.User;
import tech.ada.onlinelibrary.dto.UserPostRequest;
import tech.ada.onlinelibrary.repository.UserRepository;

import java.util.Optional;


@RestController
public class UserController {


    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("users/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username){
        return userRepository.findByUsername(username).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/users/register")
        public ResponseEntity<User> createUser (@RequestBody UserPostRequest userRequest){
            User user = modelMapper.map(userRequest, User.class);
            User newUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }

    @DeleteMapping("users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return  ResponseEntity.notFound().build();
        }
    }
}


