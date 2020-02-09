package com.example.springreact.service;

import com.example.springreact.domain.Mobile;
import com.example.springreact.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileService {

    @Autowired
    MobileRepository mobileRepository;

    public Mobile saveOrUpdateMobile (Mobile mobile) {
        if (mobile.getStatus() == null || mobile.getStatus() == "")
            mobile.setStatus("TO_DO");
        return mobileRepository.save(mobile);
    }

    public Iterable<Mobile> getAll () {
        return mobileRepository.findAll();
    }

    public Mobile getById (Long id) {
        return mobileRepository.getById(id);
    }

    public void deleteById (Long id) {
        mobileRepository.deleteById(id);
    }
}
