package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExercisePlanPostTest {
  @Test
  void defaultCreation() {
    ExercisePlanPost exercisePlanPost = new ExercisePlanPost();

    assertFalse(exercisePlanPost.deleted());
    assertEquals("제목", exercisePlanPost.title());
    assertEquals("운동한 날짜", exercisePlanPost.date());
    assertEquals("유산소 운동 종류", exercisePlanPost.exerciseType());
    assertEquals("운동한 시간", exercisePlanPost.exerciseTime());
    assertEquals("운동 거리", exercisePlanPost.exerciseDistance());
    assertEquals("상세 설명", exercisePlanPost.description());
  }

  @Test
  void creationWithParameters() {
    List<String> stopovers = List.of(
        "경유지 1",
        "경유지 2",
        "경유지 3"
    );

    ExercisePlanPost exercisePlanPost = new ExercisePlanPost("제목 123", "운동한 날짜 123", "유산소 운동 종류 123",
        "운동한 시간 123", stopovers, "운동 거리 123", "상세 설명 123");

    assertFalse(exercisePlanPost.deleted());
    assertEquals("제목 123", exercisePlanPost.title());
    assertEquals("운동한 날짜 123", exercisePlanPost.date());
    assertEquals("유산소 운동 종류 123", exercisePlanPost.exerciseType());
    assertEquals("운동한 시간 123", exercisePlanPost.exerciseTime());

    for (int i = 0; i < exercisePlanPost.stopoverPoints().size(); i += 1) {
      assertEquals(stopovers.get(i), exercisePlanPost.stopoverPoints().get(i));
    }

    assertEquals("운동 거리 123", exercisePlanPost.exerciseDistance());
    assertEquals("상세 설명 123", exercisePlanPost.description());
  }

  @Test
  void creationWithParametersAndDeletedStatus() {
    List<String> stopovers = List.of(
        "경유지 1",
        "경유지 2",
        "경유지 3"
    );

    ExercisePlanPost exercisePlanPost1 = new ExercisePlanPost(
        5, true, "제목 123", "운동한 날짜 123", "유산소 운동 종류 123",
        "운동한 시간 123", stopovers, "운동 거리 123", "상세 설명 123"
    );

    assertEquals(5, exercisePlanPost1.uniqueNumber());
    assertTrue(exercisePlanPost1.deleted());
    assertEquals("제목 123", exercisePlanPost1.title());
    assertEquals("운동한 날짜 123", exercisePlanPost1.date());
    assertEquals("유산소 운동 종류 123", exercisePlanPost1.exerciseType());
    assertEquals("운동한 시간 123", exercisePlanPost1.exerciseTime());

    for (int i = 0; i < exercisePlanPost1.stopoverPoints().size(); i += 1) {
      assertEquals(stopovers.get(i), exercisePlanPost1.stopoverPoints().get(i));
    }

    assertEquals("운동 거리 123", exercisePlanPost1.exerciseDistance());
    assertEquals("상세 설명 123", exercisePlanPost1.description());

    ExercisePlanPost exercisePlanPost2 = new ExercisePlanPost(
        12, false, "제목 123", "운동한 날짜 123", "유산소 운동 종류 123",
        "운동한 시간 123", stopovers, "운동 거리 123", "상세 설명 123"
    );

    assertEquals(12, exercisePlanPost2.uniqueNumber());
    assertFalse(exercisePlanPost2.deleted());
  }
}
