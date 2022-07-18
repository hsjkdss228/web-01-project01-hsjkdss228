package utils;

public class UniqueNumberManager {
  private static int uniqueNumberCount;

  public UniqueNumberManager() {
    uniqueNumberCount = 0;
  }

  public static int makeUniqueNumber() {
    uniqueNumberCount += 1;
    return uniqueNumberCount;
  }
}
