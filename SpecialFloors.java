/* Alice manages a company and has rented some floors of a building as office space. Alice has decided some of 
these floors should be special floors, used for relaxation only. You are given two integers bottom and top, which 
denote that Alice has rented all the floors from bottom to top (inclusive). You are also given the integer array 
special, where special[i] denotes a special floor that Alice has designated for relaxation. Return the maximum 
number of consecutive floors without a special floor.
* Eg 1 : bottom = 2     top = 9    special = [4,6]               Output = 3
* Eg 2 : bottom = 6     top = 8    special = [7,6,8]             Output = 0
*/
import java.util.*;
public class SpecialFloors
{
      public int ConsecutiveNonSpecialFloors(int bottom, int top, int special[])
      {
            PriorityQueue<Integer> MinHeap = new PriorityQueue<Integer>();    //* Min Heap -> O(N)
            for(int i = 0; i < special.length; i++)    //! Storing -> O(N)
                  MinHeap.add(special[i]);
            int difference = MinHeap.peek() - bottom;    // Evaluating difference...
            while(MinHeap.size() != 1)    //! Comparison -> O(N)
                  difference = Math.max(difference, Math.abs(MinHeap.poll() - MinHeap.peek()));
            difference = Math.max(difference, (top - MinHeap.poll()));   // Extracting the maximum difference...
            return difference;    // Returning the maximum difference between floors...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int t, b;
            System.out.print("Enter bottom floor : ");
            b = sc.nextInt();
            System.out.print("Enter top floor : ");
            t = sc.nextInt();
            int x;
            System.out.print("Enter the number of Special Floors : ");
            x = sc.nextInt();
            int floors[] = new int[x];
            for(int i = 0; i < floors.length; i++)
            {
                  System.out.print("Enter floor number : ");
                  floors[i] = sc.nextInt();
            }
            SpecialFloors specialfloors = new SpecialFloors();            // Object creation...
            System.out.println("The Maximum Continous Non Special Floors : "+specialfloors.ConsecutiveNonSpecialFloors(b, t, floors));
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(N)

/** //? DEDUCTIONS -
 * ? Use a Min Heap, to get the floors in ascending order...
 * ? Then we extract the maximum difference from adjacent values in Min Heap...
 */