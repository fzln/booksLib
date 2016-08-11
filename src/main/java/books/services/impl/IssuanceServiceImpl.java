package books.services.impl;

import books.entities.Issuance;
import books.repository.IssuancesRepository;
import books.services.IssuancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by f on 11.08.16.
 */
@Service("issuanceService")
@Transactional
public class IssuanceServiceImpl implements IssuancesService {
    @Autowired
    private IssuancesRepository issuancesRepository;

    @Override
    public Issuance add(Issuance issuance) {
        return issuancesRepository.saveAndFlush(issuance);
    }

    @Override
    public void update(Issuance issuance) {
        issuancesRepository.saveAndFlush(issuance);
    }

    @Override
    public void delete(Issuance issuance) {
        issuancesRepository.delete(issuance);
    }

    @Override
    public void deleteAll() {
        issuancesRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Issuance findById(Long issuanceId) {
        return issuancesRepository.findOne(issuanceId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Issuance> listOnHands() {
        return issuancesRepository.findByReturnDateIsNull();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Issuance> listByUser() {
        return issuancesRepository.findByOrderByUser();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Issuance> listAll() {
        return issuancesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return issuancesRepository.count();
    }
}
