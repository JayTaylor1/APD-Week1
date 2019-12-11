package searcher;

import java.util.Arrays;

/**
 * Implements the find (kth) element method by sorting and indexing, using the clever method of first creating a array of size k,
 * then copying k amount of elements into the new array, sorting the new array and then comparing the elements after the kth index
 * to see if its greater than the current smallest if so swap then resort the array.
 */

public class CleverSearcher extends Searcher {

    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    /**
     * Find the kth largest element in an array of ints
     *
     * <ul>
     *     <li> Create a smallArray of size k</li>
     *     <li> Copy the first k elements of the large array into the small array </li>
     *     <li> Sort the small array</li>
     *     <li> For every element after the kth index, check if its greater than index 0 in the small array, if so swap them</li>
     *     <li> Then resort the small array</li>
     * </ul>
     *
     * @return kth largest element of array, by outputting the first index of the smallArray
     */
    public int findElement() throws IndexingError {
        int[] array = getArray();
        int k = getIndex();
        if (k <= 0 || k > array.length) {
            throw new IndexingError();
        }

        int[] smallArray = new int[k];

        for(int i = 0; i < k; i++) {
            smallArray[i] = array[i];
        }
        Arrays.sort(smallArray); // sort the whole array
        for(int i = k; i < array.length; i++) {
            if (array[i] > smallArray[0]){
                smallArray[0] = array[i];
                Arrays.sort(smallArray); // sort the whole array
            }
        }
        
        return smallArray[0]; // desired element is the first index in the array
    } // end of clever solution method
}
