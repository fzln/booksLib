package books;

import books.entities.Book;
import books.entities.Issuance;
import books.entities.User;
import books.services.BooksService;
import books.services.IssuancesService;
import books.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by f on 10.08.16.
 */
@RestController
public class MyController {
    @Autowired
    UsersService users;

    @Autowired
    BooksService books;

    @Autowired
    IssuancesService issuances;

    @RequestMapping("/users")
    public List<User> listUsers() {
        return users.listAll();
    }

    @RequestMapping("/user/{id}")
    public User userById(@PathVariable("id") Long userId) {
        return users.findById(userId);
    }

    @RequestMapping("/books")
    public List<Book> listBooks() {
        return books.listAll();
    }

    @RequestMapping("/book/{id}")
    public Book bookById(@PathVariable("id") Long bookId) {
        return books.findById(bookId);
    }

    // New issuance
    @RequestMapping("/newissuance")
    public Issuance newIssu(
            @RequestParam("user") Long userId,
            @RequestParam("book") Long bookId,
            @RequestParam("issu") String issu,
            @RequestParam("return") String retTo) {

        User user=users.findById(userId);
        Book book=books.findById(bookId);
        if(user == null || book == null) return null;

        Issuance issuance = new Issuance(user, book,
                MyUtils.str2Calendar(issu), MyUtils.str2Calendar(retTo));

        return issuances.add(issuance);
    }

    @RequestMapping("/newissu")
    public Issuance newIssuances(@RequestBody Issuance issuance) {
        return issuances.add(issuance);
    }

    @RequestMapping("/return")
    public void returnBook(
            @RequestParam("issuance") Long issuanceId,
            @RequestParam("return") String retTo) {

        Issuance issuance = issuances.findById(issuanceId);
        if(issuance == null) return;

        issuance.setReturnDate(MyUtils.str2Calendar(retTo));
        issuances.update(issuance);
    }

    @RequestMapping("/issuances")
    public List<Issuance> listIssuances() {
        return issuances.listAll();
    }

    @RequestMapping("/onhands")
    public List<Issuance> listOnHands() {
        return issuances.listOnHands();
    }

    @RequestMapping("/byuser")
    public List<Issuance> listByUser() {
        return issuances.listByUser();
    }
}
