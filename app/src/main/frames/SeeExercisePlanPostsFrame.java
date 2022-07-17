package frames;

import models.ExercisePlanPost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SeeExercisePlanPostsFrame extends JFrame {
  public SeeExercisePlanPostsFrame(List<ExercisePlanPost> exercisePlanPosts) {
    this.setSize(500, 500);
    this.setLocation(350, 200);
    this.setLayout(new GridLayout(0, 1));

    JPanel postTitlesPanel = new JPanel();
    postTitlesPanel.setLayout(new GridLayout(0, 1));

    for (ExercisePlanPost exercisePlanPost : exercisePlanPosts) {
      JLabel titleThumbnailLabel = new JLabel(exercisePlanPost.title());
      titleThumbnailLabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          JFrame postFrame = new ExercisePlanPostsFrame(exercisePlanPost);

          postFrame.setVisible(true);
        }
      });

      postTitlesPanel.add(titleThumbnailLabel);
    }

    this.add(postTitlesPanel);

    this.setVisible(true);
  }
}
