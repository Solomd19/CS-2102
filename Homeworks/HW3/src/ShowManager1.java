import java.util.LinkedList;

/**
 * Includes functionality to manage a list of shows
 */

class ShowManager1 {
	
	ShowManager1() {}

	/**
	 * Takes a LinkedList of shows and organizes them
	 * by time in a ShowSummary instance, and excludes specials
	 *
	 * @param shows list of shows to organize
	 * @return ShowSummary of sorted shows which passed criteria
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary orgShows = new ShowSummary();

		for(Show currShow : shows){
			if(currShow.isSpecial == false){
				if(600 <= currShow.broadcastTime && currShow.broadcastTime < 1700){
					orgShows.daytime.add(currShow);
				}else if(1700 <= currShow.broadcastTime && currShow.broadcastTime < 2200){
					orgShows.primetime.add(currShow);
				}else if(2200 <= currShow.broadcastTime || currShow.broadcastTime < 100){
					orgShows.latenight.add(currShow);
				}
			}
		}
		return orgShows;
	}
	
}
