package com.epam.task.seven.observer;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;

import java.util.ArrayList;
import java.util.List;

public class EllipseObservable extends Ellipse implements Observable {
    private int id;

    private List<Observer> observers = new ArrayList<>();

    public EllipseObservable(Point pointFirst, Point pointSecond, int id) {
        super(pointFirst, pointSecond);
        this.id = id;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public int getId() {
        return id;
    }
// TODO: 19.10.2020 equals hashCode toString
}
