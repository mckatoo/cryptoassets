package io.ikatoo.cryptoassets.interfaces.controllers;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

import io.ikatoo.cryptoassets.core.entity.UsersTypes;
import io.ikatoo.cryptoassets.infra.repository.IUsersTypesRepository;
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
@RequestMapping("users-types")
public class UsersTypesController {

    private final IUsersTypesRepository _usersTypesRepo;

    @Autowired
    public UsersTypesController(IUsersTypesRepository usersTypesRepo) {
        _usersTypesRepo = usersTypesRepo;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(_usersTypesRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTypeById(@PathVariable("id") Integer id) {
        Optional<UsersTypes> type = verifyIfExists(id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @GetMapping(path = "/type/{type}")
    public ResponseEntity<?> findByType(@PathVariable String type) {
        return new ResponseEntity<>(_usersTypesRepo.findByTypeIgnoreCaseContaining(type), HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<?> save(@Valid @RequestBody UsersTypes type) {
        verifyIfExists(type.getId());
        return new ResponseEntity<>(_usersTypesRepo.save(type), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UsersTypes type) {
        verifyIfExists(type.getId());
        return new ResponseEntity<>(_usersTypesRepo.save(type), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        verifyIfExists(id);
        _usersTypesRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Optional<UsersTypes> verifyIfExists(Integer integer) {
        Optional<UsersTypes> type = _usersTypesRepo.findById(integer);
        if (!type.isPresent())
            throw new ResourceNotFoundException("Type not found for ID: " + integer);
        return type;
    }

}