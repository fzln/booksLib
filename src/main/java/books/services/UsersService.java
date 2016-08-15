package books.services;

import books.entities.User;

import java.util.List;

/**
 * Created by f on 10.08.16.
 */
public interface UsersService {
    public User add(User user);

    public void update(User user);

    public void delete(User user);
    //public void delete(long id);

    public void deleteAll();

    public User findById(Long userId);

    public User findByName(String name);

    public List<User> listAll();

    public long count();
}
