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
      List<ExercisePlanPost> exercisePlanPosts, List<ExerciseRecordPost> exerciseRecordPosts) {
    this.setLayout(new GridLayout(0, 1));

    JPanel postTitlesPanel = new JPanel();
    postTitlesPanel.setLayout(new GridLayout(0, 1));

    JButton backButton = new JButton("뒤로가기");
    backButton.addActionListener(event -> {
      JPanel mainMenuPanel = new MainMenuPanel(exercisePlanPosts, exerciseRecordPosts);
      AerobicExerciseRecords.mainFrame().showContentPanel(mainMenuPanel);
    });
    postTitlesPanel.add(backButton);
    for (ExerciseRecordPost exerciseRecordPost : exerciseRecordPosts) {
      if (!exerciseRecordPost.deleted()) {
        JLabel titleThumbnailLabel = new JLabel(exerciseRecordPost.exercisePlanPost().title() + " 운동 결과");
        titleThumbnailLabel.setHorizontalAlignment(JLabel.CENTER);
        titleThumbnailLabel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            JPanel exerciseRecordPostPanel = new ExerciseRecordPostPanel(
                exercisePlanPosts, exerciseRecordPosts, exerciseRecordPost
            );
            AerobicExerciseRecords.mainFrame().showContentPanel(exerciseRecordPostPanel);
          }
        });

        postTitlesPanel.add(titleThumbnailLabel);
      }
    }

    this.add(postTitlesPanel);
  }
}
