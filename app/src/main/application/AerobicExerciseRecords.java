package application;

import frames.SeeExercisePlanPostsFrame;
import models.ExercisePlanPost;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AerobicExerciseRecords {
  private JFrame mainFrame;
  private JFrame seeExercisePlanPostsFrame;

  private List<ExercisePlanPost> exercisePlanPosts;

  public AerobicExerciseRecords() {
    exercisePlanPosts = new ArrayList<>(List.of(
        new ExercisePlanPost("작성자명 1", "제목 1", "운동한 날짜 1", "유산소 운동 종류 1",
            "운동한 시간 1", "운동 거리 1", "상세 설명 1"),
        new ExercisePlanPost("작성자명 2", "제목 2", "운동한 날짜 2", "유산소 운동 종류 2",
            "운동한 시간 2", "운동 거리 2", "상세 설명 2"),
        new ExercisePlanPost("작성자명 3", "제목 3", "운동한 날짜 3", "유산소 운동 종류 3",
            "운동한 시간 3", "운동 거리 3", "상세 설명 3")
    ));
  }

  public static void main(String[] args) {
    AerobicExerciseRecords application = new AerobicExerciseRecords();
    application.run();
  }

  public void run() {
    mainFrame = new JFrame("우리 운동합시다!");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(500, 500);
    mainFrame.setLocation(75, 70);

    JPanel buttonsPanel = new JPanel();

    JButton createExercisePlanPostButton = new JButton("운동 계획 작성");
    createExercisePlanPostButton.addActionListener(event -> {

    });
    buttonsPanel.add(createExercisePlanPostButton);

    JButton seeExercisePlanPostsButton = new JButton("운동 계획 보기");
    seeExercisePlanPostsButton.addActionListener(event -> {
      seeExercisePlanPostsFrame = new SeeExercisePlanPostsFrame(exercisePlanPosts);
    });
    buttonsPanel.add(seeExercisePlanPostsButton);

    JButton seeExerciseRecordPostsButton = new JButton("운동 기록 보기");
    seeExerciseRecordPostsButton.addActionListener(event -> {

    });
    buttonsPanel.add(seeExerciseRecordPostsButton);

    JButton seeOtherExercisePlanPostsButton = new JButton("다른 사람의 운동 기록 보기");
    seeOtherExercisePlanPostsButton.addActionListener(event -> {

    });
    buttonsPanel.add(seeOtherExercisePlanPostsButton);

    mainFrame.add(buttonsPanel);

    mainFrame.setVisible(true);
  }
}
