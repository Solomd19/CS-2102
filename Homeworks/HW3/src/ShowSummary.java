import java.util.LinkedList;

class ShowSummary {
	
	LinkedList<Show> daytime;
	LinkedList<Show> primetime;
	LinkedList<Show> latenight;
	
	ShowSummary() 
	{
		this.daytime = new LinkedList<Show>();
		this.primetime = new LinkedList<Show>();
		this.latenight = new LinkedList<Show>();
	}
	
	ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime, LinkedList<Show> latenight)
	{
		this.daytime = daytime;
		this.primetime = primetime;
		this.latenight = latenight;
	}

	/**
	 * Determines if two ShowSummarys are equal:
	 * -Same show list size
	 * -Show list is in same order
	 * -Title and broadcast time of each show corresponds to its instance in the other list
	 * @param otherObj Other ShowSummary to compare to
	 * @return boolean representing if This and otherSum are equal
	 */
	@Override
	public boolean equals(Object otherObj){
		if(otherObj instanceof ShowSummary){
			ShowSummary otherSum = (ShowSummary) otherObj;
			if(this.daytime.size() == otherSum.daytime.size() && this.primetime.size() == otherSum.primetime.size() && this.latenight.size() == otherSum.latenight.size()){
				for(int i = 0; i < this.daytime.size(); i++){
					if(this.daytime.get(i).title.equals(otherSum.daytime.get(i).title) == false || this.daytime.get(i).broadcastTime != otherSum.daytime.get(i).broadcastTime){
						return false;
					}
				}
				for(int j = 0; j < this.primetime.size(); j++){
					if(this.primetime.get(j).title.equals(otherSum.primetime.get(j).title) == false || this.primetime.get(j).broadcastTime != otherSum.primetime.get(j).broadcastTime){
						return false;
					}
				}
				for(int k = 0; k < this.latenight.size(); k++){
					if(this.latenight.get(k).title.equals(otherSum.latenight.get(k).title) == false || this.latenight.get(k).broadcastTime != otherSum.latenight.get(k).broadcastTime){
						return false;
					}
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
		return true;
	}


}
