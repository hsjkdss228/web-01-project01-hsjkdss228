package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseRecordPostTest {
  @Test
  void creation() {
    ExercisePlanPost exercisePlanPost = new ExercisePlanPost(
        10, false, "등산 계획 1", "7월 23일", "등산", "10시간",
        List.of("북악산", "청계산", "관악산", "도봉산"), "50km", "서울의 여러 산을 등산해보자."
    );

    ExerciseRecordPost exerciseRecordPost = new ExerciseRecordPost(
        exercisePlanPost, true, List.of(true, true, true, false),
        true, true, "시간이 부족해 도봉산을 못 가서 아쉽다."
    );

    assertEquals(exercisePlanPost, exerciseRecordPost.exercisePlanPost());
    assertEquals(exercisePlanPost.uniqueNumber(), exerciseRecordPost.uniqueNumber());
    assertFalse(exerciseRecordPost.deleted());
    assertTrue(exerciseRecordPost.achievedExerciseTime());

    assertTrue(exerciseRecordPost.visitedStopoverPoints().get(0));
    assertTrue(exerciseRecordPost.visitedStopoverPoints().get(1));
    assertTrue(exerciseRecordPost.visitedStopoverPoints().get(2));
    assertFalse(exerciseRecordPost.visitedStopoverPoints().get(3));

    assertTrue(exerciseRecordPost.achievedExerciseDistance());
    assertTrue(exerciseRecordPost.finalResult());

    assertEquals("시간이 부족해 도봉산을 못 가서 아쉽다.", exerciseRecordPost.description());
  }

  @Test
  void modify() {
    ExercisePlanPost exercisePlanPost = new ExercisePlanPost(
        10, false, "등산 계획 1", "7월 23일", "등산", "10시간",
        List.of("북악산", "청계산", "관악산", "도봉산"), "50km", "서울의 여러 산을 등산해보자."
    );

    ExerciseRecordPost exerciseRecordPost = new ExerciseRecordPost(
        exercisePlanPost, true, List.of(true, true, true, false),
        true, true, "시간이 부족해 도봉산을 못 가서 아쉽다."
    );

    exerciseRecordPost.modifyAchievedExerciseTime(false);
    assertFalse(exerciseRecordPost.achievedExerciseTime());

    List<Boolean> modifiedVisitedStopoverPoints = List.of(false, false, false, true);

    exerciseRecordPost.modifyVisitedStopoverPoints(
        modifiedVisitedStopoverPoints
    );
    assertFalse(exerciseRecordPost.visitedStopoverPoints().get(0));
    assertFalse(exerciseRecordPost.visitedStopoverPoints().get(1));
    assertFalse(exerciseRecordPost.visitedStopoverPoints().get(2));
    assertTrue(exerciseRecordPost.visitedStopoverPoints().get(3));

    exerciseRecordPost.modifyAchievedExerciseDistance(false);
    assertFalse(exerciseRecordPost.achievedExerciseDistance());

    exerciseRecordPost.modifyFinalResult(false);
    assertFalse(exerciseRecordPost.finalResult());

    exerciseRecordPost.modifyDescription(
        "무슨 일이 있었던 거지? 도봉산에만 올라갔다가 온 걸로 기억이 조작되었다..."
    );
    assertEquals(
        "무슨 일이 있었던 거지? 도봉산에만 올라갔다가 온 걸로 기억이 조작되었다...",
        exerciseRecordPost.description()
    );
  }
}
