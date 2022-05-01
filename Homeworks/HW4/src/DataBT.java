import java.lang.Math;

class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;
    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }
    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
    }
    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    /**
     * Fetches value of current node
     *
     * @return value of current node
     */
    public int getRoot(){
        return this.data;
    }

    /**
     * Fetches right branch of current node
     *
     * @return right branch of current node
     */
    public IBinTree getRight(){
        return this.right;
    }

    /**
     * Fetches left branch of current node
     *
     * @return left branch of current node
     */
    public IBinTree getLeft(){
        return this.left;
    }

    /**
     * compares current node data to parameter branchRoot to see which is greater
     *
     * @param branchRoot int to compare to current root
     * @return boolean indicating if branchroot is less than current node data
     */
    public boolean isBigger(int branchRoot){
        return this.data >= branchRoot;
    }

    /**
     * determines if current node and all branches make up a heap
     *
     * @return boolean indicating if current node and all branches are a heap
     */
    public boolean isHeap(){

        //Failure case: root is higher than root data from branches
        if(this.getLeft().isBigger(this.data) == false || this.getRight().isBigger(this.data) == false){
            return false;
        }else{
            return this.getLeft().isHeap() && this.getRight().isHeap();
        }
    }

    /**
     * counts number of time int elt shows up in binary tree
     *
     * @param elt number to look for
     * @return number of times elt was found within binary tree
     */
    public int instancesOf(int elt) {
        if(elt == this.data){
            return 1 + this.left.instancesOf(elt) + this.right.instancesOf(elt);
        }else{
            return this.left.instancesOf(elt) + this.right.instancesOf(elt);
        }
    }

    /**
     * returns smallest element in BST (-1 in error case)
     *
     * @return smallest element in BST
     */
    public int smallestElt() {
        if(this.left.smallestElt() <= this.right.smallestElt() && this.left.smallestElt() != -1){
            if(this.left.smallestElt() <= this.data){
                return this.left.smallestElt();
            }else{
                return this.data;
            }
        }else if(this.right.smallestElt() != -1){
            if(this.right.smallestElt() <= this.data){
                return this.right.smallestElt();
            }else{
                return this.data;
            }
        }else{
            return this.data;
        }
    }
}