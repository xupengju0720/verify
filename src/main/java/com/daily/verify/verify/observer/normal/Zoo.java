package com.daily.verify.verify.observer.normal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();
    private List<AnimalAddedListener> listeners = new ArrayList<>();

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        this.notifyAnimalAddedListeners(animal);
    }

    public void registerAnimalAddedListener(AnimalAddedListener listener) {
        this.listeners.add(listener);
    }

    public void unregisterAnimalAddedListener(AnimalAddedListener listener) {
        this.listeners.remove(listener);
    }

    protected void notifyAnimalAddedListeners(Animal animal) {
        this.listeners.forEach(listener -> listener.onAnimalAdded(animal));
    }
}
