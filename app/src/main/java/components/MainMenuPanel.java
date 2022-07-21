package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class MainMenuPanel extends JPanel {
  public MainMenuPanel(List<ExercisePlanPost> exercisePlanPosts,
                       List<ExerciseRecordPost> exerciseRecordPosts) {
    this.setLayout(new GridLayout(0, 3));

    JButton editExercisePlanPostButton = new JButton(
        "운동 계획 작성", new ImageIcon("data/images/running.jpeg")
    );

    editExercisePlanPostButton.setBorderPainted(false);
    editExercisePlanPostButton.setFocusPainted(false);
    editExercisePlanPostButton.setHorizontalTextPosition(JButton.CENTER);
    editExercisePlanPostButton.setFont(new Font("", Font.ITALIC, 30));
    editExercisePlanPostButton.setForeground(Color.WHITE);

    editExercisePlanPostButton.addActionListener(event -> {
      JPanel editExercisePlanPostPanel = new EditExercisePlanPostPanel(
          exercisePlanPosts, exerciseRecordPosts, EditExercisePlanPostPanel.CREATION
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(editExercisePlanPostPanel);
    });
    this.add(editExercisePlanPostButton);

    JButton seeExercisePlanPostsButton = new JButton(
        "운동 계획 보기", new ImageIcon("data/images/cycling.jpeg")
    );

    seeExercisePlanPostsButton.setBorderPainted(false);
    seeExercisePlanPostsButton.setFocusPainted(false);
    seeExercisePlanPostsButton.setHorizontalTextPosition(JButton.CENTER);
    seeExercisePlanPostsButton.setFont(new Font("", Font.ITALIC, 30));
    seeExercisePlanPostsButton.setForeground(Color.WHITE);

    seeExercisePlanPostsButton.addActionListener(event -> {
      JPanel seeExercisePlanPostsPanel = new SeeExercisePlanPostsPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(seeExercisePlanPostsPanel);
    });
    this.add(seeExercisePlanPostsButton);

    JButton seeExerciseRecordPostsButton = new JButton(
        "운동 기록 보기", new ImageIcon("data/images/hiking.jpeg")
    );

    seeExerciseRecordPostsButton.setBorderPainted(false);
    seeExerciseRecordPostsButton.setFocusPainted(false);
    seeExerciseRecordPostsButton.setHorizontalTextPosition(JButton.CENTER);
    seeExerciseRecordPostsButton.setFont(new Font("", Font.ITALIC, 30));
    seeExerciseRecordPostsButton.setForeground(Color.WHITE);

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
