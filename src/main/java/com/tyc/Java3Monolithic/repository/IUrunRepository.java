package com.tyc.Java3Monolithic.repository;

import com.tyc.Java3Monolithic.repository.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUrunRepository extends JpaRepository<Urun, Long> {
}
