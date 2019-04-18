package io.ikatoo.cryptoassets.interfaces.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ikatoo.cryptoassets.core.entity.Users;
import io.ikatoo.cryptoassets.infra.repository.IUsersRepository;
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
@RequestMapping("users")
public class UsersController {

    private final IUsersRepository _usersRepo;

    @Autowired
    public UsersController(IUsersRepository usersRepo) {
        _usersRepo = usersRepo;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(_usersRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        verifyIfUserExists(id);
        Optional<Users> user = _usersRepo.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/username/{user}")
    public ResponseEntity<?> findByUsername(@PathVariable String user) {
        return new ResponseEntity<>(_usersRepo.findByNameIgnoreCaseContaining(user), HttpStatus.OK);
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(_usersRepo.findByEmailIgnoreCaseContaining(email), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@RequestBody Users user) {
        return new ResponseEntity<>(_usersRepo.save(user), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Users user) {
        verifyIfUserExists(user.getId());
        return new ResponseEntity<>(_usersRepo.save(user), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        verifyIfUserExists(id);
        _usersRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private void verifyIfUserExists(Integer id) {
        Optional<Users> user = _usersRepo.findById(id);
        if (!user.isPresent())
            throw new ResourceNotFoundException("User not found for ID: " + id);
    }
}