import java.util.LinkedList;

public class LLGuests extends LinkedList<String> implements ISet{

//    LinkedList<String> guests;
//
//    LLGuests(LinkedList<String> guests) {
//        this.guests = guests;
//    }

    // returns the number of distinct elements in the BST
//    public int size() {
//        return guests.size();
//    }

    // returns BST containing all existing elements and the given element
    public ISet addElt (String elt) {
        this.add(elt);
        return this;
    }

    // determines whether the given element is in the BST
    public boolean hasElt (String elt) {
        for(String name : this){
            if(name.equals(elt)){
                return true;
            }
        }
        return false;
    }

}
