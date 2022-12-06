package com.bukowskiprzemyslaw.tutorisaweb.repository;

import com.bukowskiprzemyslaw.tutorisaweb.entity.Tutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends CrudRepository<Tutor, Long> {
}

