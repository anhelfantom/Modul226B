package controller;

import model.constants.Movement;

class Action {

    private Movement movement;
    private int element;
    private int repeater;

    Action(Movement movement, int element, int repeater) {

        this.movement = movement;
        this.element = element;
        this.repeater = repeater;
    }

    Movement getMovement() {
        return movement;
    }

    int getElement() {
        return element;
    }

    int getRepeater() {
        return repeater;
    }
}
