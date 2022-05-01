class MtBT implements IBinTree {
    MtBT(){}
    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }
    // returns 0 since empty tree has no elements
    public int size() {
        return 0;
    }
    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }

    /**
     * Fetches value of current node
     *
     * @return value of current node
     */
    public int getRoot(){
        return 0;
    }

    /**
     * Fetches right branch of current node
     *
     * @return right branch of current node
     */
    public IBinTree getRight(){
        return null;
    }

    /**
     * Fetches left branch of current node
     *
     * @return left branch of current node
     */
    public IBinTree getLeft(){
        return null;
    }

    /**
     * returns true since an empty branch is always valid
     *
     * @param branchRoot int to compare to current root
     * @return always returns true since there is no data at this node
     */
    public boolean isBigger(int branchRoot){
        return true;
    }

    /**
     * determines if current node and all branches make up a heap
     *
     * @return always returns true since there is no data at this node
     */
    public boolean isHeap(){
        return true;
    }

    /**
     * counts number of time int elt shows up in binary tree
     *
     * @param elt number to look for
     * @return number of times elt was found within binary tree
     */
    public int instancesOf(int elt){
        return 0;
    }

    /**
     * returns smallest element in BST (-1 in error case)
     *
     * @return smallest element in BST
     */
    public int smallestElt(){
        return -1;
    }
}