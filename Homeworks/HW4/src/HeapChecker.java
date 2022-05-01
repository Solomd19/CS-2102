public class HeapChecker {

    /**
     * checks whether the binary tree is a valid result of performing addElt() on the original heap
     * @param hOrig the original heap before modification
     * @param elt the element added to the original heap
     * @param hAdded the original heap after modification
     * @return boolean indicating if the original heap with the element added is equivalent to the modified heap
     */
    boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {

    //...code to compare hOrig and hAdded around the addition of elt as appropriate...
        if(hAdded.size() == 0 || hAdded.size() != hOrig.size() + 1 || hAdded.equals(hOrig)){
            return false;
        }else{
            return hAdded.isHeap() && hAdded.hasElt(elt) && hAdded.instancesOf(elt) > hOrig.instancesOf(elt);
        }

    }

    /**
     *checks whether the binary tree is a valid result of performing remMinElt() on the original heap
     * @param hOrig the original heap before modification
     * @param hRemoved the original heap after modification
     * @return boolean indicating if the original heap with the smallest element removed is equivalent to the modified heap
     */
    boolean remMinEltTester(IHeap hOrig, IHeap hRemoved) {

    //...code to compare hOrig and hRemoved as appropriate...

        if(hOrig.size() == 0 || hRemoved.size() != hOrig.size() - 1 || hRemoved.equals(hOrig) || hRemoved.instancesOf(hOrig.smallestElt()) != hOrig.instancesOf(hOrig.smallestElt()) - 1){
            return false;
        }else{
            return hRemoved.isHeap();
        }
    }

}
