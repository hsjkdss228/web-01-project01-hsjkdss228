package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.util.List;

public class MainMenuPanel extends JPanel {
  public MainMenuPanel(List<ExercisePlanPost> exercisePlanPosts,
                       List<ExerciseRecordPost> exerciseRecordPosts) {
    JButton editExercisePlanPostButton = new JButton("운동 계획 작성");
    editExercisePlanPostButton.addActionListener(event -> {
      JPanel editExercisePlanPostPanel = new EditExercisePlanPostPanel(
          exercisePlanPosts, exerciseRecordPosts, EditExercisePlanPostPanel.CREATION
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(editExercisePlanPostPanel);
    });
    this.add(editExercisePlanPostButton);

    JButton seeExercisePlanPostsButton = new JButton("운동 계획 보기");
    seeExercisePlanPostsButton.addActionListener(event -> {
      JPanel seeExercisePlanPostsPanel = new SeeExercisePlanPostsPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(seeExercisePlanPostsPanel);
    });
    this.add(seeExercisePlanPostsButton);

    JButton seeExerciseRecordPostsButton = new JButton("운동 기록 보기");
    seeExerciseRecordPostsButton.addActionListener(event -> {
      JPanel seeExerciseRecordPostsPanel = new SeeExerciseRecordPostsPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(seeExerciseRecordPostsPanel);
    });
    this.add(seeExerciseRecordPostsButton);

//    JButton seeOtherExercisePlanPostsButton = new JButton("다른 사람의 운동 기록 보기");
//    seeOtherExercisePlanPostsButton.addActionListener(event -> {
//
//    });
//    buttonsPanel.add(seeOtherExercisePlanPostsButton);
  }
}
