package com.tyc.Java3Monolithic.repository;


import com.tyc.Java3Monolithic.repository.entity.Satis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISatisRepository extends JpaRepository<Satis,Long> {
}
