import java.lang.Math;

interface IBinTree {
    // determines whether element is in the tree
    boolean hasElt(int e);
    // returns number of nodes in the tree; counts duplicate elements as separate items
    int size();
    // returns depth of longest branch in the tree
    int height();

    //Helper functions to make interfacing easier:

    //Fetches data value of root
    int getRoot();

    //Fetches data value of right branch root
    IBinTree getRight();

    //Fetches data value of left branch root
    IBinTree getLeft();

    //Returns if the int provided is greater than the current root
    boolean isBigger(int branchRoot);

    //determines if current node and all branches make up a heap
    boolean isHeap();

    //counts number of time int elt shows up in binary tree
    int instancesOf(int elt);

    //returns smallest element in BST (-1 in error case)
    int smallestElt();

}