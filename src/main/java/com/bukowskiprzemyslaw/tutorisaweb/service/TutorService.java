package com.bukowskiprzemyslaw.tutorisaweb.service;


import com.bukowskiprzemyslaw.tutorisaweb.entity.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;
public interface TutorService {

    void saveTutor(Tutor tutor);

    List< Tutor > fetchTutorList();

    Tutor fetchTutorById(Long id);

    void deleteTutorById(Long id);

}
