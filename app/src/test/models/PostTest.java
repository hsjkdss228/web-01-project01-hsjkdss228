package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
  @Test
  void defaultCreation() {
    Post post = new Post();

    assertEquals("작성자명", post.writer());
    assertEquals("제목", post.title());
    assertEquals("운동한 날짜", post.date());
    assertEquals("유산소 운동 종류", post.exerciseType());
    assertEquals("운동한 시간", post.exerciseTime());
    assertEquals("운동 거리", post.exerciseDistance());
    assertEquals("상세 설명", post.description());
  }

  @Test
  void creationWithParameters() {
    Post post = new Post("작성자명 123", "제목 123", "운동한 날짜 123", "유산소 운동 종류 123",
        "운동한 시간 123", "운동 거리 123", "상세 설명 123");

    assertEquals("작성자명 123", post.writer());
    assertEquals("제목 123", post.title());
    assertEquals("운동한 날짜 123", post.date());
    assertEquals("유산소 운동 종류 123", post.exerciseType());
    assertEquals("운동한 시간 123", post.exerciseTime());
    assertEquals("운동 거리 123", post.exerciseDistance());
    assertEquals("상세 설명 123", post.description());
  }
}