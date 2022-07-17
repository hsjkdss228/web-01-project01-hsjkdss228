package frames;

import models.ExercisePlanPost;

import javax.swing.*;
import java.util.List;

public class MainFrame extends JFrame {
  private JFrame editExercisePlanPostFrame;
  private JFrame seeExercisePlanPostsFrame;

  public MainFrame(List<ExercisePlanPost> exercisePlanPosts) {
    this.setTitle("우리 운동합시다!");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.setLocation(75, 70);

    JPanel buttonsPanel = new JPanel();
    this.add(buttonsPanel);

    JButton editExercisePlanPostButton = new JButton("운동 계획 작성");
    editExercisePlanPostButton.addActionListener(event -> {
      editExercisePlanPostFrame = new EditExercisePlanPostFrame(
          exercisePlanPosts, EditExercisePlanPostFrame.CREATION
      );
    });
    buttonsPanel.add(editExercisePlanPostButton);

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

    this.setVisible(true);
  }
}
