import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

    // method to set up a ballot and cast votes

    ElectionData Setup1() {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
        } catch (Exception e) {
        }
        // cast votes
        try {
            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "ziggy", "husky");
            ED.processVote("husky", "gompei", "ziggy");
        } catch (Exception e) {
        }
        return (ED);
    }

    ElectionData Setup2() { //Setup1 duplicate
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
        } catch (Exception e) {
        }
        // cast votes
        try {
            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "ziggy", "husky");
            ED.processVote("husky", "gompei", "ziggy");
        } catch (Exception e) {
        }
        return (ED);
    }

    ElectionData SetupHasSteve() {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
            ED.addCandidate("steve");
        } catch (Exception e) {
        }
        // cast votes
        try {
            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "ziggy", "husky");
            ED.processVote("husky", "gompei", "ziggy");
        } catch (Exception e) {
        }
        return (ED);
    }

    ElectionData TieScenario() {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
        } catch (Exception e) {
        }
        // cast votes
        try {
            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("ziggy", "gompei", "husky");
            ED.processVote("husky", "ziggy", "gompei");
        } catch (Exception e) {
        }
        return (ED);
    }

    ElectionData TieScenario2() {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
        } catch (Exception e) {
        }
        // cast votes
        try {
            ED.processVote("gompei", "ziggy", "husky");
            ED.processVote("ziggy", "gompei", "husky");
        } catch (Exception e) {
        }
        return (ED);
    }

    @Test
    public void testEquals() {
        assertTrue(Setup1().equals(Setup2()));
    }

    @Test
    public void testAddCandidate() throws CandidateExistsException {
        Setup1().addCandidate("steve");
        assertFalse(Setup1().equals(SetupHasSteve()));
    }

    //where sampleException is the exception that the method should throw in this example.
    @Test(expected = CandidateExistsException.class)
    public void testAddCandidateException() throws CandidateExistsException {
        Setup1().addCandidate("gompei");
    }

    @Test
    public void testMostFirstWinner() {
        assertEquals("gompei", Setup1().findWinnerMostFirstVotes());
    }

    @Test
    public void testMostFirstWinnerTie() {
        assertEquals("Runoff required", TieScenario().findWinnerMostFirstVotes());
    }

    @Test
    public void testFindWinnerMostPoints() {
        assertEquals("gompei", Setup1().findWinnerMostPoints());
    }

    @Test
    public void testFindWinnerMostPointsTie() {
        assertTrue(TieScenario2().findWinnerMostFirstVotes().equals("gompei") || TieScenario2().findWinnerMostFirstVotes().equals("ziggy"));
    }

    @Test(expected = UnknownCandidateException.class)
    public void testUnknownCandidate() throws UnknownCandidateException, DuplicateVotesException {
        Setup1().processVote("gompei", "steve", "husky");
    }

    @Test(expected = DuplicateVotesException.class)
    public void testDuplicateVotes() throws UnknownCandidateException, DuplicateVotesException {
        Setup1().processVote("gompei", "gompei", "husky");
    }

}
