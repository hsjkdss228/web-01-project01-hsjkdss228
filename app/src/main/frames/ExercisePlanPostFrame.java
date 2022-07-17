package frames;

import models.ExercisePlanPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExercisePlanPostFrame extends JFrame {
  public ExercisePlanPostFrame(
      List<ExercisePlanPost> exercisePlanPosts, ExercisePlanPost exercisePlanPost) {
    this.setSize(500, 500);
    this.setLocation(700, 70);
    this.setLayout(new GridLayout(0, 1));

    JLabel titleLabel = new JLabel(exercisePlanPost.title());
    this.add(titleLabel);

    JLabel dateLabel = new JLabel(exercisePlanPost.date());
    this.add(dateLabel);

    JLabel exerciseTypeLabel = new JLabel(exercisePlanPost.exerciseType());
    this.add(exerciseTypeLabel);

    JLabel exerciseTimeLabel = new JLabel(exercisePlanPost.exerciseTime());
    this.add(exerciseTimeLabel);

    JLabel stopoverPointsLabel = new JLabel(exercisePlanPost.stopoverPoints());
    this.add(stopoverPointsLabel);

    JLabel exerciseDistanceLabel = new JLabel(exercisePlanPost.exerciseDistance());
    this.add(exerciseDistanceLabel);

    JTextArea descriptionTextArea = new JTextArea(exercisePlanPost.description());
    descriptionTextArea.setEditable(false);
    this.add(descriptionTextArea);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 3));
    JButton modifyButton = new JButton("수정하기");
    modifyButton.addActionListener(event -> {
      EditExercisePlanPostFrame editExercisePlanPostFrame = new EditExercisePlanPostFrame(
          exercisePlanPosts, exercisePlanPost, EditExercisePlanPostFrame.MODIFICATION
      );
    });
    buttonsPanel.add(modifyButton);
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.addActionListener(event -> {

    });
    buttonsPanel.add(deleteButton);
    JButton reviewButton = new JButton("결과 기록하기");
    reviewButton.addActionListener(event -> {

    });
    buttonsPanel.add(reviewButton);
    this.add(buttonsPanel);

    this.setVisible(true);
  }
}
