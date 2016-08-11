package books.services;

import books.entities.User;

import java.util.List;

/**
 * Created by f on 10.08.16.
 */
public interface UsersService {
    public User add(User person);

    public void update(User person);

    public void delete(User person);
    //public void delete(long id);

    public void deleteAll();

    public User findById(Long userId);

    public User findByName(String name);

    public List<User> listAll();

    public long count();
}
