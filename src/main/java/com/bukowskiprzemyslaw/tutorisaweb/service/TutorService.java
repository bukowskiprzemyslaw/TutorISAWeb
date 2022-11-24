package com.bukowskiprzemyslaw.tutorisaweb.service;

import com.bukowskiprzemyslaw.tutorisaweb.entity.Tutor;
import com.bukowskiprzemyslaw.tutorisaweb.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TutorService {

    private TutorRepository tutorRepository;

    @Autowired
    public TutorService (TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public Optional<Tutor> findByTutorId(Long tutorId) {
        return tutorRepository.findById(tutorId);
    }

    public Iterable<Tutor> findAllTutors() {
        return tutorRepository.findAll();
    }

    public Tutor saveTutor (Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public void deleteByTutorId (long tutorId) {
        tutorRepository.deleteById(tutorId);
    }

    //Filling database with examples
/*
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        saveTutor(new Tutor(1L,"Jan","Kowalski","kowalski@buziaczek.pl","700800900"));
        saveTutor(new Tutor(2L,"Bill","Gates","gates@windows.com","586666666"));
        saveTutor(new Tutor(3L,"Zenon","Martyniuk","whataboutit@ask.com","600111111"));
    }
*/
}
