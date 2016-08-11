package books.services.impl;

import books.entities.User;
import books.repository.UsersRepository;
import books.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by f on 10.08.16.
 */
@Service("userService")
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User add(User user) {
        return usersRepository.saveAndFlush(user);
    }

    @Override
    public void update(User user) {
        usersRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        usersRepository.delete(user);
    }

    @Override
    public void deleteAll() {
        usersRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long userId) {
        return usersRepository.findOne(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listAll() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return usersRepository.count();
    }
}
