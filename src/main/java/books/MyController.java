package books;

import books.entities.Book;
import books.entities.Issuance;
import books.entities.User;
import books.services.BooksService;
import books.services.IssuancesService;
import books.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cIssu = Calendar.getInstance();
        try {
            cIssu.setTime(sdf.parse(issu));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cReturn = Calendar.getInstance();
        try {
            cReturn.setTime(sdf.parse(retTo));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Issuance issuance = new Issuance(users.findById(userId), books.findById(bookId), cIssu, cReturn);

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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cReturn = Calendar.getInstance();
        try {
            cReturn.setTime(sdf.parse(retTo));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Issuance issuance = issuances.findById(issuanceId);
        issuance.setReturnDate(cReturn);
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
