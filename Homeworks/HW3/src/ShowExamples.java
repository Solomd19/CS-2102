import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();
	LinkedList<Show> shows = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();

	Show startrek = new Show("Star Trek", 1800, 45.0, false);
	Show futurama = new Show("Futurama", 1900, 23.0, false);
	Show animaniacs = new Show("Animaniacs", 1630, 7.0, false);
	Show sesamestreet = new Show("Sesame Street", 900, 60.0, false);

	public ShowExamples()
	{
		shows.add(startrek);
		report1.primetime.add(startrek);

		shows.add(futurama);
		report1.primetime.add(futurama);

		shows.add(animaniacs);
		report1.daytime.add(animaniacs);

		shows.add(sesamestreet);
		report1.daytime.add(sesamestreet);
	}
	
	@Test
	public void instructorTestShowSummary_EmptyReport() {
		ShowSummary report2 = new ShowSummary();
		assertFalse(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_BothEmpty() {
		ShowSummary report2 = new ShowSummary();
		ShowSummary report3 = new ShowSummary();
		assertTrue(report3.equals(report2));
	}


	@Test
	public void instructorTestShowSummary_WrongOrder() {
		ShowSummary report2 = new ShowSummary();

		report2.primetime.add(futurama);
		report2.primetime.add(startrek);
		report2.daytime.add(animaniacs);
		report2.daytime.add(sesamestreet);

		assertFalse(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_DiffSizes() {
		ShowSummary report2 = new ShowSummary();

		report2.primetime.add(futurama);
		report2.primetime.add(startrek);

		assertFalse(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_DifferentInstances() {
		ShowSummary report2 = new ShowSummary();

		Show startrek2 = new Show("Star Trek", 1800, 60.0, true);
		Show futurama2 = new Show("Futurama", 1900, 20.0, false);
		Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
		Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

		report2.primetime.add(startrek2);
		report2.primetime.add(futurama2);
		report2.daytime.add(animaniacs2);
		report2.daytime.add(sesamestreet2);

		assertTrue(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_SameInstances() {
		ShowSummary report2 = report1;
		assertTrue(report1.equals(report2));
	}


	@Test
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}

	@Test
	public void instructorTestOrganizeShowsExcludeSpecials()
	{
		LinkedList<Show> shows = new LinkedList<Show>();
		LinkedList<Show> myShows = new LinkedList<Show>();
		ShowSummary report3 = new ShowSummary();

		//Override above variables to have specials
		Show startrek = new Show("Star Trek", 1800, 45.0, false);
		Show futurama = new Show("Futurama", 1900, 23.0, true);
		Show animaniacs = new Show("Animaniacs", 1630, 7.0, false);
		Show sesamestreet = new Show("Sesame Street", 900, 60.0, true);

		shows.add(startrek);
		shows.add(futurama);
		shows.add(animaniacs);
		shows.add(sesamestreet);

		//Expected result of organization
		myShows.add(startrek);
		report3.primetime.add(startrek);

		myShows.add(animaniacs);
		report3.daytime.add(animaniacs);

		//Organization & comparison
		ShowSummary report4 = sm1.organizeShows(shows);
		assertEquals(report4, report3);
	}



}

/*
Subtasks:
Iterate through parameter show list
Check air time of each show
Add relevant data to list
Organize by air time
Ignore shows that are specials
 */
