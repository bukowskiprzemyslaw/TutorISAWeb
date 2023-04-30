package com.bukowskiprzemyslaw.tracking.entity;

import java.time.LocalDateTime;
public class Event {

        private String ipAddress;
        private ActionType actionType;
        private Long tutorId;
        private String tutorLink;
        private LocalDateTime actionDate;

        public Event(String ipAddress, ActionType actionType, Long tutorId, String tutorLink, LocalDateTime actionDate) {
            this.ipAddress = ipAddress;
            this.actionType = actionType;
            this.tutorId = tutorId;
            this.tutorLink = tutorLink;
            this.actionDate = actionDate;
        }

        // getters and setters


        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public ActionType getActionType() {
            return actionType;
        }

        public void setActionType(ActionType actionType) {
            this.actionType = actionType;
        }

        public Long getTutorId() {
            return tutorId;
        }

        public void setTutorId(Long tutorId) {
            this.tutorId = tutorId;
        }

        public String getTutorLink() {
            return tutorLink;
        }

        public void setTutorLink(String tutorLink) {
            this.tutorLink = tutorLink;
        }

        public LocalDateTime getActionDate() {
            return actionDate;
        }

        public void setActionDate(LocalDateTime actionDate) {
            this.actionDate = actionDate;
        }
    }


