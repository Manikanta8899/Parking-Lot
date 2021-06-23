package com.vikmanik.model.parking.strategy;

import com.vikmanik.exception.NoFreeSlotAvailableException;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class NaturalOrderingParkingStrategy implements ParkingStrategy{
    TreeSet<Integer> slotTreeSet;
    Queue<Integer> priorityQueue = new PriorityQueue<>();
    public NaturalOrderingParkingStrategy() {
        this.slotTreeSet = new TreeSet<>();
    }

    @Override
    public void addSlot(Integer slotNumber) {

        this.slotTreeSet.add(slotNumber);
        this.priorityQueue.add(slotNumber);
    }

    @Override
    public void removeSlot(Integer slotNumber) {
        this.slotTreeSet.remove(slotNumber);
        this.priorityQueue.add(slotNumber);
    }

    @Override
    public Integer getNextSlot() {
        if (slotTreeSet.isEmpty()) {
            throw new NoFreeSlotAvailableException();
        }
        return this.priorityQueue.poll();
    }
}
