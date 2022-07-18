package frames;

import models.ExercisePlanPost;
import models.ExerciseRecordPost;
import utils.FileLoader;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

public class MainFrame extends JFrame {
  private JFrame editExercisePlanPostFrame;
  private JFrame seeExercisePlanPostsFrame;
  private JFrame seeExerciseRecordPostsFrame;

  public MainFrame(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts, FileLoader fileLoader) {
    this.setTitle("유산소 운동 계획 및 기록 프로그램");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.setLocation(75, 70);

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          fileLoader.saveExercisePlanPosts(exercisePlanPosts);
          fileLoader.saveCurrentUniqueNumberCount();
        } catch (IOException exception) {
          throw new RuntimeException(exception);
        }
      }
    });

    JPanel buttonsPanel = new JPanel();

    JButton editExercisePlanPostButton = new JButton("운동 계획 작성");
    editExercisePlanPostButton.addActionListener(event -> {
      editExercisePlanPostFrame = new EditExercisePlanPostFrame(
          exercisePlanPosts, EditExercisePlanPostFrame.CREATION
      );
    });
    buttonsPanel.add(editExercisePlanPostButton);

    JButton seeExercisePlanPostsButton = new JButton("운동 계획 보기");
    seeExercisePlanPostsButton.addActionListener(event -> {
      seeExercisePlanPostsFrame = new SeeExercisePlanPostsFrame(
          exercisePlanPosts, exerciseRecordPosts
      );
    });
    buttonsPanel.add(seeExercisePlanPostsButton);

    JButton seeExerciseRecordPostsButton = new JButton("운동 기록 보기");
    seeExerciseRecordPostsButton.addActionListener(event -> {
      seeExerciseRecordPostsFrame = new SeeExerciseRecordPostsFrame(
          exerciseRecordPosts
      );
    });
    buttonsPanel.add(seeExerciseRecordPostsButton);

    JButton seeOtherExercisePlanPostsButton = new JButton("다른 사람의 운동 기록 보기");
    seeOtherExercisePlanPostsButton.addActionListener(event -> {

    });
    buttonsPanel.add(seeOtherExercisePlanPostsButton);

    this.add(buttonsPanel);

    this.setVisible(true);
  }
}
