package frames;

import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SeeExerciseRecordPostsFrame extends JFrame {
  public SeeExerciseRecordPostsFrame(
      List<ExerciseRecordPost> exerciseRecordPosts) {
    this.setSize(500, 500);
    this.setLocation(350, 200);
    this.setLayout(new GridLayout(0, 1));

    JPanel postTitlesPanel = new JPanel();
    postTitlesPanel.setLayout(new GridLayout(0, 1));

    for (ExerciseRecordPost exerciseRecordPost : exerciseRecordPosts) {
      if (!exerciseRecordPost.deleted()) {
        JLabel titleThumbnailLabel = new JLabel(exerciseRecordPost.exercisePlanPost().title() + " 운동 결과");
        titleThumbnailLabel.setHorizontalAlignment(JLabel.CENTER);
        titleThumbnailLabel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            JFrame exerciseRecordPostFrame = new ExerciseRecordPostFrame(
                exerciseRecordPosts, exerciseRecordPost
            );
          }
        });

        postTitlesPanel.add(titleThumbnailLabel);
      }
    }

    this.add(postTitlesPanel);

    this.setVisible(true);
  }
}
