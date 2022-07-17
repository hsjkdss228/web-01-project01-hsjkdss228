package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExercisePlanPostTest {
  @Test
  void defaultCreation() {
    ExercisePlanPost exercisePlanPost = new ExercisePlanPost();

    assertEquals("작성자명", exercisePlanPost.writer());
    assertEquals("제목", exercisePlanPost.title());
    assertEquals("운동한 날짜", exercisePlanPost.date());
    assertEquals("유산소 운동 종류", exercisePlanPost.exerciseType());
    assertEquals("운동한 시간", exercisePlanPost.exerciseTime());
    assertEquals("운동 거리", exercisePlanPost.exerciseDistance());
    assertEquals("상세 설명", exercisePlanPost.description());
  }

  @Test
  void creationWithParameters() {
    ExercisePlanPost exercisePlanPost = new ExercisePlanPost("작성자명 123", "제목 123", "운동한 날짜 123", "유산소 운동 종류 123",
        "운동한 시간 123", "운동 거리 123", "상세 설명 123");

    assertEquals("작성자명 123", exercisePlanPost.writer());
    assertEquals("제목 123", exercisePlanPost.title());
    assertEquals("운동한 날짜 123", exercisePlanPost.date());
    assertEquals("유산소 운동 종류 123", exercisePlanPost.exerciseType());
    assertEquals("운동한 시간 123", exercisePlanPost.exerciseTime());
    assertEquals("운동 거리 123", exercisePlanPost.exerciseDistance());
    assertEquals("상세 설명 123", exercisePlanPost.description());
  }
}