public class BinarySearch {

    // RECURSIVE IMPLEMENTATION
    public static int recursiveBinarySearch(int[] intArray, int lowPosition, int highPosition, int target) {
        if (lowPosition > highPosition) {
            /* base case: check to see if we have run out of elements by comparing
               low index and high index; we have "run out" when the two indices "cross over"
               and the value getting passed in for low index exceeds the value for high index */
            return -1;  // target was not found, return -1
        } else {
            // determine middle index
            int midPosition = (lowPosition + highPosition) / 2;

            if (intArray[midPosition] < target) {
                /* ------ COMPLETE ME! ------ */
                /* one missing line of code, should return the value from a recursive call:
                   if the value at the midPosition of intArray is LESS than target,
                   make a recursive call to search RIGHT half of remaining array by setting lowPosition
                   to one index right of midPosition but keeping highPosition unchanged */
                return recursiveBinarySearch(intArray, lowPosition+1, highPosition, target);
            } else if (intArray[midPosition] > target) {
                /* ------ COMPLETE ME! ------ */
                /* one missing line of code, should return the value from a recursive call:
                   if the value at the midPosition of intArray is MORE than target,
                   make a recursive call to search LEFT half of remaining array by keeping lowPosition
                   unchanged but setting highPosition to one index left of midPosition */
                return recursiveBinarySearch(intArray, lowPosition, highPosition-1, target);
            } else {
                // otherwise, we FOUND the target, so return that index
                return midPosition;
            }
        }
    }

    // ITERATIVE, NON-RECURSIVE IMPLEMENTATION -- FOR COMPARISON
    public static int iterativeNonRecursiveBinarySearch(int[] elements, int target) {
        // start "lowPosition" boundary at first index and "highPosition" boundary at last index
        int lowPosition = 0;
        int highPosition = elements.length - 1;

        /* we want to return as soon as we locate target,
           but we also want to repeat until there are no more values to check (i.e. target not found);
           this happens when the lowPosition index "crosses over" the right highPosition,
           which occurs when we check the final remaining element and it's not the target */
        while (lowPosition <= highPosition) {
            /* set index to check to the middle index; note that if there is an even
               number of elements (and two middle elements), this integer math truncates,
               resulting in the "left middle" value chosen as middle */
            int midPosition = (lowPosition + highPosition) / 2;

            if (target < elements[midPosition]) {
                /* if target is less than value at current index,
                   "eliminate" right half by setting the "highPosition" boundary index
                   to the "midPosition" index - 1 */
                highPosition = midPosition - 1;
            } else if (target > elements[midPosition]) {
                /* else, if target is greater than value at current index,
                   "eliminate" left half by setting the "lowPosition" boundary index
                   to the "midPosition" index + 1 */
                lowPosition = midPosition + 1;
            } else {
                // else, we found the value!  return the index
                return midPosition;
            }
        }
        // value not found, so -1
        return -1;


    }
}
