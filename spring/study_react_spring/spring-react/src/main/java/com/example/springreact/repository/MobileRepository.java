package com.example.springreact.repository;

import com.example.springreact.domain.Mobile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends CrudRepository<Mobile, Long> {

    Mobile getById(Long id);
}

