package com.bukowskiprzemyslaw.tracking.entity;

public enum ActionType {

        VISIT_TUTORS("Visit tutors list"),
        ADD_TUTOR("Add tutor to database"),
        EDIT_TUTOR("Edit tutor"),
        DELETE_TUTOR("Delete trainer");

        private final String actionName;

        ActionType(String actionName) {
            this.actionName = actionName;
        }

        public String getActionName() {
            return actionName;
        }
    }

