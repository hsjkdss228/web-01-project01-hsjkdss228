package utils;

import models.ExercisePlanPost;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueNumberManagerTest {

  @Test
  void makeUniqueNumber() {
    ExercisePlanPost exercisePlanPost1 = new ExercisePlanPost();
    ExercisePlanPost exercisePlanPost2 = new ExercisePlanPost();

    assertEquals(
        exercisePlanPost2.uniqueNumber(), exercisePlanPost1.uniqueNumber() + 1
    );
  }
}