public class Solution {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int tank = 0;
    int minTank = gas[0];
    int minPosition = 0;
    for (int i = 0; i < gas.length; i++) {
      tank += gas[i];
      tank -= cost[i];
      if (tank < minTank) {
        minTank = tank;
        minPosition = i+1;
        if (minPosition == gas.length) minPosition = 0;
      }
    }

    tank = 0;
    boolean can = true;
    int i = minPosition;
    do {
      tank += gas[i];
      if (cost[i] > tank) {
        can = false;
        break;
      } else {
        tank -= cost[i];
      }

      i++;
      if (i == gas.length) i = 0;
    } while (i != minPosition);

    return can ? minPosition : -1;
  }
}
