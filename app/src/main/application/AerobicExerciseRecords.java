package application;

import frames.CreateExercisePlanPostFrame;
import frames.MainFrame;
import frames.SeeExercisePlanPostsFrame;
import models.ExercisePlanPost;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AerobicExerciseRecords {
  private JFrame mainFrame;

  private List<ExercisePlanPost> exercisePlanPosts;

  public AerobicExerciseRecords() {
    exercisePlanPosts = new ArrayList<>(List.of(
        new ExercisePlanPost("제목 1", "운동한 날짜 1", "유산소 운동 종류 1",
            "운동한 시간 1", "경유지 1,경유지 2,경유지 3", "운동 거리 1", "상세 설명 1"),
        new ExercisePlanPost("제목 2", "운동한 날짜 2", "유산소 운동 종류 2",
            "운동한 시간 2", "경유지 4,경유지 5,경유지 6", "운동 거리 2", "상세 설명 2"),
        new ExercisePlanPost("제목 3", "운동한 날짜 3", "유산소 운동 종류 3",
            "운동한 시간 3", "경유지 7,경유지 8,경유지 9", "운동 거리 3", "상세 설명 3")
    ));
  }

  public static void main(String[] args) {
    AerobicExerciseRecords application = new AerobicExerciseRecords();
    application.run();
  }

  public void run() {
    mainFrame = new MainFrame(exercisePlanPosts);
  }
}
