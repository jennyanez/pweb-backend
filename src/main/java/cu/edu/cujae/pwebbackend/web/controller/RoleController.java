package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.RoleDto;

import cu.edu.cujae.pwebbackend.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> getAll() {
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getById(@PathVariable("id") int code) {
        return new ResponseEntity<>(roleService.getById(code), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RoleDto> save(@RequestBody RoleDto role) {
        roleService.save(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<RoleDto> delete(@PathVariable("code") int code) {
        roleService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}