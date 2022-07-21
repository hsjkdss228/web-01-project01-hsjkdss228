package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SeeExerciseRecordPostsPanel extends JPanel {
  public SeeExerciseRecordPostsPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    this.setLayout(new GridLayout(0, 1));

    JButton backButton = new JButton("뒤로가기");
    backButton.addActionListener(event -> {
      JPanel mainMenuPanel = new MainMenuPanel(exercisePlanPosts, exerciseRecordPosts);
      AerobicExerciseRecords.mainFrame().replaceContentPanel(mainMenuPanel);
    });
    this.add(backButton);

    JPanel postThumbnailsPanel = new JPanel();
    postThumbnailsPanel.setLayout(new GridLayout(0, 1));

    for (ExerciseRecordPost exerciseRecordPost : exerciseRecordPosts) {
      if (!exerciseRecordPost.deleted()) {
        JPanel postThumbnailPanel = new JPanel();

        postThumbnailPanel.add(new JLabel(exerciseRecordPost.exercisePlanPost().exerciseType()));

        JLabel titleLabel = new JLabel(exerciseRecordPost.exercisePlanPost().title() + " 운동 결과");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            JPanel exerciseRecordPostPanel = new ExerciseRecordPostPanel(
                exercisePlanPosts, exerciseRecordPosts, exerciseRecordPost
            );
            AerobicExerciseRecords.mainFrame().replaceContentPanel(exerciseRecordPostPanel);
          }
        });
        postThumbnailPanel.add(titleLabel);

        postThumbnailPanel.add(
            new JLabel(exerciseRecordPost.finalResult() ? "성공" : "실패")
        );

        postThumbnailPanel.add(new JLabel(exerciseRecordPost.exercisePlanPost().date()));

        postThumbnailsPanel.add(postThumbnailPanel);
      }
    }

    this.add(postThumbnailsPanel);
  }
}
