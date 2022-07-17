package panels;

import models.ExercisePlanPost;

import javax.swing.*;
import java.awt.*;

public class ExercisePlanPostsFrame extends JFrame {
  public ExercisePlanPostsFrame(ExercisePlanPost exercisePlanPost) {
    this.setSize(500, 500);
    this.setLocation(700, 70);
    this.setLayout(new GridLayout(0, 1));

    JLabel writerTextField = new JLabel(exercisePlanPost.writer());
    this.add(writerTextField);

    JLabel titleLabel = new JLabel(exercisePlanPost.title());
    this.add(titleLabel);

    JLabel dateLabel = new JLabel(exercisePlanPost.date());
    this.add(dateLabel);

    JLabel exerciseTypeLabel = new JLabel(exercisePlanPost.exerciseType());
    this.add(exerciseTypeLabel);

    JLabel exerciseTimeLabel = new JLabel(exercisePlanPost.exerciseTime());
    this.add(exerciseTimeLabel);

    JLabel exerciseDistanceLabel = new JLabel(exercisePlanPost.exerciseDistance());
    this.add(exerciseDistanceLabel);

    JTextArea descriptionTextArea = new JTextArea(exercisePlanPost.description());
    descriptionTextArea.setEditable(false);
    this.add(descriptionTextArea);
  }
}
