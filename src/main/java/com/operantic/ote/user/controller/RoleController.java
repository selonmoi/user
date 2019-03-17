package com.operantic.ote.user.controller;

import com.operantic.ote.user.model.Role;
import com.operantic.ote.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.operantic.ote.user.helper.ControllerHelper.getSaveEntity;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Role role) {
        Role saved = roleService.save(role);

        return getSaveEntity(saved);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Role findById(@PathVariable int id) {
        Optional<Role> found = roleService.findById(id);

        return found.orElseThrow(() -> new RuntimeException("Le role avec l'identifiant " + id + " n'existe pas."));
    }

    @GetMapping
    @ResponseBody
    public List<Role> findByAll() {
        return roleService.findAll();
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody Role role) {
        return getSaveEntity(roleService.update(role));
    }
}
