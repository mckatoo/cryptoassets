package io.ikatoo.cryptoassets.interfaces.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ikatoo.cryptoassets.core.entity.UsersType;
import io.ikatoo.cryptoassets.infra.repository.IUsersTypeRepository;
import io.ikatoo.cryptoassets.interfaces.error.ResourceNotFoundException;

/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-01-30 17:54:42
 * @modify date 2019-01-30 17:54:42
 * @desc [description]
 */
/**
 * UsersController
 */

@RestController
@RequestMapping("userstype")
public class UsersTypeController {

    private final IUsersTypeRepository _usersTypeRepo;

    @Autowired
    public UsersTypeController(IUsersTypeRepository usersTypeRepo) {
        _usersTypeRepo = usersTypeRepo;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(_usersTypeRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTypeById(@PathVariable("id") Long id) {
        Optional<UsersType> type = verifyIfExists(id);
        return new ResponseEntity<>(type, HttpStatus.OK);

    }

    @GetMapping(path = "/type/{type}")
    public ResponseEntity<?> findByType(@PathVariable String type) {
        return new ResponseEntity<>(_usersTypeRepo.findByTypeIgnoreCaseContaining(type), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UsersType type) {
        verifyIfExists(type.getId());
        return new ResponseEntity<>(_usersTypeRepo.save(type), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UsersType type) {
        verifyIfExists(type.getId());
        return new ResponseEntity<>(_usersTypeRepo.save(type), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfExists(id);
        _usersTypeRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Optional<UsersType> verifyIfExists(Long id) {
        Optional<UsersType> type = _usersTypeRepo.findById(id);
        if (!type.isPresent())
            throw new ResourceNotFoundException("Type not found for ID: " + id);
        return type;
    }

}