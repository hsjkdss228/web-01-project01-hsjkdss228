package utils;

public class UniqueNumberManager {
  private static int uniqueNumberCount = 0;

  public static void setUniqueNumberCount(int loadedUniqueNumberCount) {
    uniqueNumberCount = loadedUniqueNumberCount;
  }

  public static int makeUniqueNumber() {
    uniqueNumberCount += 1;
    return uniqueNumberCount;
  }
}
