package com.bukowskiprzemyslaw.tracking.controller;

import com.bukowskiprzemyslaw.tracking.service.EventService;
import com.bukowskiprzemyslaw.tracking.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bukowskiprzemyslaw.tracking.entity.Event;
import com.bukowskiprzemyslaw.tracking.entity.ActionType;


import java.time.LocalDateTime;

    @RestController
    @RequestMapping("/api/events")

    public class EventController {
        private final EventService eventService;

        @Autowired
        public EventController(EventService eventService) {
            this.eventService = eventService;
        }

        @PostMapping("/tutor-list")
        public ResponseEntity<?> trackVisitTrainers(@RequestParam String ipAddress) {
            Event event = new Event(ipAddress, ActionType.VISIT_TUTORS, null, null, LocalDateTime.now());
            eventService.saveEvent(event);
            return ResponseEntity.ok().build();
        }

        @PostMapping("/addtutor")
        public ResponseEntity<?> trackAddTutor(@RequestParam String ipAddress) {
            Event event = new Event(ipAddress, ActionType.ADD_TUTOR, null, null, LocalDateTime.now());
            eventService.saveEvent(event);
            return ResponseEntity.ok().build();
        }

        @PostMapping("/update")
        public ResponseEntity<?> trackEditTrainer(@RequestParam String ipAddress, @RequestParam Long trainerId, @RequestParam String trainerLink) {
            Event event = new Event(ipAddress, ActionType.EDIT_TUTOR, trainerId, trainerLink, LocalDateTime.now());
            eventService.saveEvent(event);
            return ResponseEntity.ok().build();
        }

        @PostMapping("/delete-trainer")
        public ResponseEntity<?> trackDeleteTrainer(@RequestParam String ipAddress, @RequestParam Long trainerId) {
            Event event = new Event(ipAddress, ActionType.DELETE_TUTOR, trainerId, null, LocalDateTime.now());
            eventService.saveEvent(event);
            return ResponseEntity.ok().build();
        }
    }

