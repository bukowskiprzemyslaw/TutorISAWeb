package com.bukowskiprzemyslaw.tutorisaweb.service;

import com.bukowskiprzemyslaw.tutorisaweb.entity.Tutor;
import com.bukowskiprzemyslaw.tutorisaweb.repository.TutorRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TutorServiceImplementation implements TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public List < Tutor > fetchTutorList() {
        return (List<Tutor>) tutorRepository.findAll();
    }

    @Override
    public void saveTutor(Tutor tutor) {
        this.tutorRepository.save(tutor);
    }

    @Override
    public Tutor fetchTutorById(Long id) {
        Optional< Tutor > optional = tutorRepository.findById(id);
        Tutor tutor = null;
        if (optional.isPresent()) {
            tutor = optional.get();
        } else {
            throw new RuntimeException(" Nie znaleziono trenera przypidsanego do ID:: " + id);
        }
        return tutor;
    }

    @Override
    public void deleteTutorById(Long id) {
        this.tutorRepository.deleteById(id);
    }
}
