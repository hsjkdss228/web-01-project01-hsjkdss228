package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ExercisePlanPostsBoardPanel extends JPanel {
  public ExercisePlanPostsBoardPanel(
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

    for (ExercisePlanPost exercisePlanPost : exercisePlanPosts) {
      if (!exercisePlanPost.deleted()) {
        JPanel postThumbnailPanel = new JPanel();

        postThumbnailPanel.add(new JLabel(exercisePlanPost.exerciseType()));

        JLabel titleLabel = new JLabel(exercisePlanPost.title());
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            JPanel exercisePlanPostPanel = new ExercisePlanPostPanel(
                exercisePlanPosts, exercisePlanPost, exerciseRecordPosts
            );
            AerobicExerciseRecords.mainFrame().replaceContentPanel(exercisePlanPostPanel);
          }
        });
        postThumbnailPanel.add(titleLabel);

        postThumbnailPanel.add(new JLabel(exercisePlanPost.date()));

        postThumbnailsPanel.add(postThumbnailPanel);
      }
    }

    this.add(postThumbnailsPanel);
  }
}
