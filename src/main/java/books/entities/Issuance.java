package books.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

import static javax.persistence.TemporalType.DATE;

/**
 * Created by f on 10.08.16.
 */
@Entity
@Table(name = "issuances")
public class Issuance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Temporal(DATE)
    private Calendar issuance;
    @Temporal(DATE)
    @Column (name = "returnto")
    private Calendar returnTo;
    @Temporal(DATE)
    @Column (name = "returndate")
    private Calendar returnDate;

    protected Issuance() {
    }

    public Issuance(User user, Book book, Calendar issuance, Calendar returnTo) {
        this.user = user;
        this.book = book;
        this.issuance = issuance;
        this.returnTo = returnTo;
    }

    public Issuance(User user, Book book, Calendar issuance, Calendar returnTo, Calendar returnDate) {
        this.user = user;
        this.book = book;
        this.issuance = issuance;
        this.returnTo = returnTo;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Calendar getIssuance() {
        return issuance;
    }

    public Calendar getReturnTo() {
        return returnTo;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setIssuance(Calendar issuance) {
        this.issuance = issuance;
    }

    public void setReturnTo(Calendar returnTo) {
        this.returnTo = returnTo;
    }

    public void setReturnDate(Calendar returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issuance issuance = (Issuance) o;

        return id == issuance.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
