class StoreItem {

    String name;
    String dept;
    int numDaysOnShelf;
    int expDate;

    public StoreItem(String name, String dept, int numDaysOnShelf, int expDate) {
        this.name = name;
        this.dept = dept;
        this.numDaysOnShelf = numDaysOnShelf;
        this.expDate = expDate;
    }

    public StoreItem(String name, String dept, int expDate) {
        this.name = name;
        this.dept = dept;
        this.numDaysOnShelf = 0; //used for items that were just put on the shelf
        this.expDate = expDate;
    }

    public StoreItem(String name, String dept) {
        this.name = name;
        this.dept = dept;
        this.numDaysOnShelf = 0;
        this.expDate = -1; //used for non-perishables like toilet paper, kitchen utensils, etc.
    }

    /**
     * Compares fields of two StoreItems to determine if all
     * fields except their names are the same
     *
     * @param otherObj StoreItem to compare
     * @return boolean indicating if objects are equal
     */
    @Override
    public boolean equals(Object otherObj){

        if(otherObj instanceof StoreItem){
            StoreItem otherItem = (StoreItem) otherObj;
            if(this.dept.equals(otherItem.dept) != true || this.numDaysOnShelf != otherItem.numDaysOnShelf || this.expDate != otherItem.expDate){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

}
