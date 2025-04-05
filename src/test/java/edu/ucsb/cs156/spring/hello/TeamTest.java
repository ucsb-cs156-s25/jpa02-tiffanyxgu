package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_when_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_when_not_team() {
        Object notTeam = new Object();
        assertEquals(false, team.equals(notTeam));
    }

    @Test
    public void equals_returns_true_when_name_members_are_equal() {
        Team newTeam = new Team("test-team");
        assertEquals(true, team.equals(newTeam));
    }

    @Test
    public void equals_returns_false_when_name_same_but_not_members() {
        Team newTeam = new Team("test-team");
        newTeam.addMember("cgaucho");
        assertEquals(false, team.equals(newTeam));
    }

    @Test
    public void equals_returns_false_when_members_same_but_not_name() {
        Team newTeam = new Team("new-team");
        assertEquals(false, team.equals(newTeam));
    }

    @Test
    public void hashCode_returns_correct_hashCode() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
