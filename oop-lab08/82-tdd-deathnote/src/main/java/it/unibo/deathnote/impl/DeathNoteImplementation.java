package it.unibo.deathnote.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImplementation implements DeathNote {

    private Map<String, String> deathCouses;
    private Map<String, String> deathDetails;
    private Set<String> writtenNames;

    private String toBeKilled;
    private long startTimer;
    private long timePassed;

<<<<<<< HEAD
    private static long TIME_LIMIT_FOR_CAUSE_OF_DEATH = -40;//-40
    private static long TIME_LIMIT_FOR_DETAILS_OF_DEATH = -6040; //-6040
=======
    private static long TIME_LIMIT_FOR_CAUSE_OF_DEATH = 40;
    private static long TIME_LIMIT_FOR_DETAILS_OF_DEATH = 6040;
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76

    public DeathNoteImplementation() {
        this.writtenNames = new HashSet<>();
        this.deathCouses = new HashMap<>();
        this.deathDetails = new HashMap<>();
        this.toBeKilled = null;
    }
    /**
     * {@inheritdoc}
     */
    @Override
    public String getRule(int ruleNumber) {
        return RULES.get(ruleNumber - 1);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void writeName(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.writtenNames.add(name);
        this.toBeKilled = name;
        this.startTimer = System.currentTimeMillis();
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean writeDeathCause(String cause) {
        try {
            this.correctActualTarget(TIME_LIMIT_FOR_CAUSE_OF_DEATH);
            if (toBeKilled == null || cause == null) {
                throw new IllegalStateException();
            }
            this.timePassed = timePassing(startTimer);
<<<<<<< HEAD
            if (this.timePassed <= TIME_LIMIT_FOR_CAUSE_OF_DEATH) {
=======
            if (this.timePassed >= TIME_LIMIT_FOR_CAUSE_OF_DEATH) {
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
                toBeKilled = null;
                return false;
            } else {
                this.deathCouses.put(this.toBeKilled, cause);
                this.timePassed = timePassing(this.startTimer);
                return true;
            }
        } finally {
            this.startTimer = System.currentTimeMillis();
        }
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean writeDetails(String details) {
        this.correctActualTarget(TIME_LIMIT_FOR_DETAILS_OF_DEATH);
        if (toBeKilled == null || details == null) {
            throw new IllegalStateException();
        }
        this.timePassed = timePassing(startTimer);
<<<<<<< HEAD
        if (this.timePassed <= TIME_LIMIT_FOR_DETAILS_OF_DEATH) {
=======
        if (this.timePassed >= TIME_LIMIT_FOR_DETAILS_OF_DEATH) {
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
            this.toBeKilled = null;
            return false;
        } else {
            this.deathDetails.put(toBeKilled, details);
            this.timePassed = timePassing(startTimer);
            return true;
        }
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public String getDeathCause(String name) {
        if (!this.deathCouses.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        return this.deathCouses.get(name);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public String getDeathDetails(String name) {
        if (this.deathDetails.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        return this.deathDetails.get(name);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean isNameWritten(String name) {
        return this.writtenNames.contains(name);
    }

    private long timePassing(long startingTime) {
        return startingTime - System.currentTimeMillis();
    }

    private void correctActualTarget(long timeLimit) {
<<<<<<< HEAD
        if (timePassing(startTimer) <= timeLimit) {
=======
        if (timePassing(startTimer) >= timeLimit) {
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
            this.toBeKilled = null;
        }
    }

    public Set<String> getWrittenNames() {
        return writtenNames;
    }
}