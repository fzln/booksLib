package books.services;

import books.entities.Issuance;

import java.util.List;

/**
 * Created by f on 11.08.16.
 */
public interface IssuancesService {
    public Issuance add(Issuance issuance);

    public void update(Issuance issuance);

    public void delete(Issuance issuance);
    //public void delete(long id);

    public void deleteAll();

    public Issuance findById(Long issuanceId);

    public List<Issuance> listOnHands();
    public List<Issuance> listByUser();
    public List<Issuance> listAll();

    public long count();
}
