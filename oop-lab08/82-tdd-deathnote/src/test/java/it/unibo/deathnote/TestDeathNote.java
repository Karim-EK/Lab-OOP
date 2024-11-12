package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Executable;

import org.junit.jupiter.api.Test;

import it.unibo.deathnote.impl.DeathNoteImplementation;

class TestDeathNote {

    @Test
    public void testRuleIndex() {

        var deathNote = new DeathNoteImplementation();
        var exception = assertThrows(Exception.class, new org.junit.jupiter.api.function.Executable() {

            @Override
            public void execute() throws Throwable {
                deathNote.getRule(0);
            }
            
        });

        assertNotEquals(null, exception.getMessage());
        assertNotEquals("", exception.getMessage());

        exception = assertThrows(Exception.class, new org.junit.jupiter.api.function.Executable() {

            @Override
            public void execute() throws Throwable {
                deathNote.getRule(-5);
            }
            
        });

        assertNotEquals(null, exception.getMessage());
        assertNotEquals("", exception.getMessage());

        exception = assertThrows(Exception.class, new org.junit.jupiter.api.function.Executable() {

            @Override
            public void execute() throws Throwable {
                deathNote.getRule(1_000);
            }
            
        });

        assertNotEquals(null, exception.getMessage());
        assertNotEquals("", exception.getMessage());
    }

    @Test
    public void testRuleText() {
        var deathNote = new DeathNoteImplementation();

        for (int i = 1; i <= 13; i++) {
            assertNotEquals(null, deathNote.getRule(i));
            assertNotEquals("", deathNote.getRule(i));
        }
    }

    @Test
    public void testHumanDeath() {
        var deathNote = new DeathNoteImplementation();
        var human = "Donal Trump";
        assertEquals(false, deathNote.getWrittenNames().contains(human));
        deathNote.writeName(human);
        assertEquals(true, deathNote.getWrittenNames().contains(human));
        var human2 = "Vladimir Putin";
        assertEquals(false, deathNote.getWrittenNames().contains(human2));
        var emptyString = "";
        deathNote.writeName(emptyString);
        assertEquals(false, deathNote.getWrittenNames().contains(emptyString));
    }

   @Test 
   public void testTimePassed() throws InterruptedException {
        var deathNote = new DeathNoteImplementation();

        assertThrows(IllegalStateException.class, new org.junit.jupiter.api.function.Executable() {

            @Override
            public void execute() throws Throwable {
                deathNote.writeDeathCause("Tumor");
            }
            
        });
        
        deathNote.writeName("Donald Trump");
        assertEquals(true ,deathNote.writeDeathCause("Heart Attack"));
        assertEquals("Heart Attack", deathNote.getDeathCause("Donald Trump"));

        deathNote.writeName("Vladimir Putin");

        assertEquals(true, deathNote.writeDeathCause("karting accident"));
        assertEquals("karting accident", deathNote.getDeathCause("Vladimir Putin"));
    
        Thread.sleep(100);
        assertThrows(IllegalStateException.class, new org.junit.jupiter.api.function.Executable() {

            @Override
            public void execute() throws Throwable {
                deathNote.writeDeathCause("Chocking");
            }
            
        });
   } 
}