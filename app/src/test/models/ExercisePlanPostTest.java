package models;

import org.junit.jupiter.api.Test;

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
    assertEquals("경유지", exercisePlanPost.stopoverPoints());
    assertEquals("운동 거리", exercisePlanPost.exerciseDistance());
    assertEquals("상세 설명", exercisePlanPost.description());
  }

  @Test
  void creationWithParameters() {
    ExercisePlanPost exercisePlanPost = new ExercisePlanPost("제목 123", "운동한 날짜 123", "유산소 운동 종류 123",
        "운동한 시간 123", "경유지 1,경유지 2,경유지 3", "운동 거리 123", "상세 설명 123");

    assertFalse(exercisePlanPost.deleted());
    assertEquals("제목 123", exercisePlanPost.title());
    assertEquals("운동한 날짜 123", exercisePlanPost.date());
    assertEquals("유산소 운동 종류 123", exercisePlanPost.exerciseType());
    assertEquals("운동한 시간 123", exercisePlanPost.exerciseTime());
    assertEquals("경유지 1,경유지 2,경유지 3", exercisePlanPost.stopoverPoints());
    assertEquals("운동 거리 123", exercisePlanPost.exerciseDistance());
    assertEquals("상세 설명 123", exercisePlanPost.description());
  }

  @Test
  void creationWithParametersAndDeletedStatus() {
    ExercisePlanPost exercisePlanPost1 = new ExercisePlanPost(true, "제목 123", "운동한 날짜 123", "유산소 운동 종류 123",
        "운동한 시간 123", "경유지 1,경유지 2,경유지 3", "운동 거리 123", "상세 설명 123");

    assertTrue(exercisePlanPost1.deleted());
    assertEquals("제목 123", exercisePlanPost1.title());
    assertEquals("운동한 날짜 123", exercisePlanPost1.date());
    assertEquals("유산소 운동 종류 123", exercisePlanPost1.exerciseType());
    assertEquals("운동한 시간 123", exercisePlanPost1.exerciseTime());
    assertEquals("경유지 1,경유지 2,경유지 3", exercisePlanPost1.stopoverPoints());
    assertEquals("운동 거리 123", exercisePlanPost1.exerciseDistance());
    assertEquals("상세 설명 123", exercisePlanPost1.description());

    ExercisePlanPost exercisePlanPost2 = new ExercisePlanPost(false, "제목 123", "운동한 날짜 123", "유산소 운동 종류 123",
        "운동한 시간 123", "경유지 1,경유지 2,경유지 3", "운동 거리 123", "상세 설명 123");

    assertFalse(exercisePlanPost2.deleted());
  }
}
