package com.operantic.ote.user.controller;

import com.operantic.ote.user.model.User;
import com.operantic.ote.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.operantic.ote.user.helper.ControllerHelper.getSaveEntity;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody User user) {
        User saved = userService.save(user);

        return getSaveEntity(saved);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User findById(@PathVariable int id) {
        Optional<User> found = userService.findById(id);

        return found.orElseThrow(() -> new RuntimeException("L'utilisateur avec l'identifiant " + id + " n'existe pas."));
    }

    @GetMapping
    @ResponseBody
    public List<User> findByAll() {
        return userService.findAll();
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody User user) {
        User saved = userService.update(user);

        return getSaveEntity(saved);
    }

    /*private ResponseEntity<Void> getSaveEntity(User saved) {
        return getVoidResponseEntity(saved == null, saved.getId(), saved);
    }*/
}
