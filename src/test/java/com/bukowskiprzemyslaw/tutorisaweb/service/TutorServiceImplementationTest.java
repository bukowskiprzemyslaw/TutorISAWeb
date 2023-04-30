package com.bukowskiprzemyslaw.tutorisaweb.service;
import com.bukowskiprzemyslaw.tutorisaweb.entity.Tutor;
import com.bukowskiprzemyslaw.tutorisaweb.repository.TutorRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TutorServiceImplementationTest {

    @Mock
    private TutorRepository tutorRepository;

    @InjectMocks
    private TutorServiceImplementation tutorService;

    @Test
    public void testFetchTutorList() {
        List<Tutor> tutorList = new ArrayList<>();
        tutorList.add(new Tutor());
        tutorList.add(new Tutor());

        Mockito.when(tutorRepository.findAll()).thenReturn(tutorList);

        List<Tutor> fetchedTutors = tutorService.fetchTutorList();

        Assert.assertEquals(tutorList, fetchedTutors);
    }

    @Test
    public void testSaveTutor() {
        Tutor tutor = new Tutor();

        tutorService.saveTutor(tutor);

        Mockito.verify(tutorRepository, Mockito.times(1)).save(tutor);
    }

    @Test
    public void testFetchTutorById() {
        Tutor tutor = new Tutor();
        Mockito.when(tutorRepository.findById(1L)).thenReturn(Optional.of(tutor));

        Tutor fetchedTutor = tutorService.fetchTutorById(1L);

        Assert.assertEquals(tutor, fetchedTutor);
    }

    @Test(expected = RuntimeException.class)
    public void testFetchTutorByIdNotFound() {
        Mockito.when(tutorRepository.findById(1L)).thenReturn(Optional.empty());

        tutorService.fetchTutorById(1L);
    }

    @Test
    public void testDeleteTutorById() {
        tutorService.deleteTutorById(1L);

        Mockito.verify(tutorRepository, Mockito.times(1)).deleteById(1L);
    }
}