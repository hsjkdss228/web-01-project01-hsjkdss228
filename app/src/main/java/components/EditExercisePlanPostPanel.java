package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditExercisePlanPostPanel extends JPanel {
  public static final int CREATION = 1;
  public static final int MODIFICATION = 2;

  List<ExercisePlanPost> exercisePlanPosts;

  private JTextField titleTextField;
  private JTextField dateTextField;
  private JTextField exerciseTypeTextField;
  private JTextField exerciseTimeTextField;
  private JTextField stopoverPointsTextField;
  private JTextField exerciseDistanceTextField;
  private JTextArea descriptionTextArea;

  public EditExercisePlanPostPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts,
      int mode) {
    this.exercisePlanPosts = exercisePlanPosts;

    this.setLayout(new GridLayout(0, 1));

    JButton backButton = new JButton("뒤로가기");
    backButton.addActionListener(event -> {
      JPanel mainMenuPanel = new MainMenuPanel(exercisePlanPosts, exerciseRecordPosts);
      AerobicExerciseRecords.mainFrame().showContentPanel(mainMenuPanel);
    });
    this.add(backButton);
    createTitlePanel("");
    createDatePanel("");
    createExerciseTypePanel("");
    createExerciseTimePanel("");
    createStopoverPointPanel("");
    createDistancePanel("");
    createDescriptionPanel("");
    createButtonsPanel(mode, null, exerciseRecordPosts);
  }

  public EditExercisePlanPostPanel(
      List<ExercisePlanPost> exercisePlanPosts, ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts, int mode) {
    this.exercisePlanPosts = exercisePlanPosts;

    this.setLayout(new GridLayout(0, 1));

    JButton backButton = new JButton("뒤로가기");
    backButton.addActionListener(event -> {
      JPanel exercisePlanPostPanel = new ExercisePlanPostPanel(
          exercisePlanPosts, exercisePlanPost, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(exercisePlanPostPanel);
    });
    this.add(backButton);
    createTitlePanel(exercisePlanPost.title());
    createDatePanel(exercisePlanPost.date());
    createExerciseTypePanel(exercisePlanPost.exerciseType());
    createExerciseTimePanel(exercisePlanPost.exerciseTime());
    createStopoverPointPanel(exercisePlanPost.stopoverPoints());
    createDistancePanel(exercisePlanPost.exerciseDistance());
    createDescriptionPanel(exercisePlanPost.description());
    createButtonsPanel(mode, exercisePlanPost, exerciseRecordPosts);
  }

  public void createTitlePanel(String text) {
    JPanel titlePanel = new JPanel();
    titlePanel.add(new JLabel("제목: "));
    titleTextField = new JTextField(text, 15);
    titlePanel.add(titleTextField);
    this.add(titlePanel);
  }

  public void createDatePanel(String text) {
    JPanel datePanel = new JPanel();
    datePanel.add(new JLabel("날짜: "));
    dateTextField = new JTextField(text, 15);
    datePanel.add(dateTextField);
    this.add(datePanel);
  }

  public void createExerciseTypePanel(String text) {
    JPanel exerciseTypePanel = new JPanel();
    exerciseTypePanel.add(new JLabel("운동 종류: "));
    exerciseTypeTextField = new JTextField(text, 15);
    exerciseTypePanel.add(exerciseTypeTextField);
    this.add(exerciseTypePanel);
  }

  public void createExerciseTimePanel(String text) {
    JPanel exerciseTimePanel = new JPanel();
    exerciseTimePanel.add(new JLabel("목표 운동 시간: "));
    exerciseTimeTextField = new JTextField(text, 15);
    exerciseTimePanel.add(exerciseTimeTextField);
    this.add(exerciseTimePanel);
  }

  public void createStopoverPointPanel(String text) {
    JPanel stopoverPointsPanel = new JPanel();
    stopoverPointsPanel.add(new JLabel("목표 경유 장소: "));
    stopoverPointsTextField = new JTextField(text, 15);
    stopoverPointsPanel.add(stopoverPointsTextField);
    this.add(stopoverPointsPanel);
  }

  public void createDistancePanel(String text) {
    JPanel exerciseDistancePanel = new JPanel();
    exerciseDistancePanel.add(new JLabel("목표 운동 거리: "));
    exerciseDistanceTextField = new JTextField(text, 15);
    exerciseDistancePanel.add(exerciseDistanceTextField);
    this.add(exerciseDistancePanel);
  }

  public void createDescriptionPanel(String text) {
    JPanel descriptionPanel = new JPanel();
    descriptionPanel.add(new JLabel("상세 설명: "));
    descriptionTextArea = new JTextArea(text);
    descriptionTextArea.setColumns(20);
    descriptionTextArea.setRows(3);
    descriptionTextArea.setLineWrap(true);
    descriptionTextArea.setEditable(true);
    JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
    scrollPane.createVerticalScrollBar();
    descriptionPanel.add(scrollPane);
    this.add(descriptionPanel);
  }

  public void createButtonsPanel(int mode, ExercisePlanPost toBeModified,
                                 List<ExerciseRecordPost> exerciseRecordPosts) {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BorderLayout());
    JButton cancelButton = new JButton("초기화");
    cancelButton.addActionListener(event -> {
      if (mode == EditExercisePlanPostPanel.CREATION) {
        titleTextField.setText("");
        dateTextField.setText("");
        exerciseTypeTextField.setText("");
        exerciseTimeTextField.setText("");
        stopoverPointsTextField.setText("");
        exerciseDistanceTextField.setText("");
        descriptionTextArea.setText("");
      }

      if (mode == EditExercisePlanPostPanel.MODIFICATION) {
        titleTextField.setText(toBeModified.title());
        dateTextField.setText(toBeModified.date());
        exerciseTypeTextField.setText(toBeModified.exerciseType());
        exerciseTimeTextField.setText(toBeModified.exerciseTime());
        stopoverPointsTextField.setText(toBeModified.stopoverPoints());
        exerciseDistanceTextField.setText(toBeModified.exerciseDistance());
        descriptionTextArea.setText(toBeModified.description());
      }
    });
    buttonsPanel.add(cancelButton, BorderLayout.WEST);
    JButton registerButton = new JButton("등록하기");
    registerButton.addActionListener(event -> {
      if (mode == EditExercisePlanPostPanel.CREATION) {
        ExercisePlanPost exercisePlanPost = new ExercisePlanPost(
            titleTextField.getText(),
            dateTextField.getText(),
            exerciseTypeTextField.getText(),
            exerciseTimeTextField.getText(),
            stopoverPointsTextField.getText(),
            exerciseDistanceTextField.getText(),
            descriptionTextArea.getText()
        );
        exercisePlanPosts.add(exercisePlanPost);
      }

      if (mode == EditExercisePlanPostPanel.MODIFICATION) {
        for (ExercisePlanPost found : exercisePlanPosts) {
          if (found.uniqueNumber() == toBeModified.uniqueNumber()) {
            found.modifyTitle(titleTextField.getText());
            found.modifyDate(dateTextField.getText());
            found.modifyExerciseType(exerciseTypeTextField.getText());
            found.modifyExerciseTime(exerciseTimeTextField.getText());
            found.modifyStopoverPoints(stopoverPointsTextField.getText());
            found.modifyExerciseDistance(exerciseDistanceTextField.getText());
            found.modifyDescription(descriptionTextArea.getText());
            break;
          }
        }
      }

      JPanel mainMenuPanel = new MainMenuPanel(exercisePlanPosts, exerciseRecordPosts);
      AerobicExerciseRecords.mainFrame().showContentPanel(mainMenuPanel);
    });
    buttonsPanel.add(registerButton, BorderLayout.EAST);
    this.add(buttonsPanel);
  }
}
