package frames;

import models.ExercisePlanPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditExercisePlanPostFrame extends JFrame {
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

  public EditExercisePlanPostFrame(List<ExercisePlanPost> exercisePlanPosts, int mode) {
    this.exercisePlanPosts = exercisePlanPosts;

    this.setSize(500, 500);
    this.setLocation(200, 150);
    this.setLayout(new GridLayout(0, 1));

    createTitlePanel("");
    createDatePanel("");
    createExerciseTypePanel("");
    createExerciseTimePanel("");
    createStopoverPointPanel("");
    createDistancePanel("");
    createDescriptionPanel("");
    createButtonsPanel();

    this.setVisible(true);
  }

  public EditExercisePlanPostFrame(
      List<ExercisePlanPost> exercisePlanPosts, ExercisePlanPost exercisePlanPost, int mode) {
    this.exercisePlanPosts = exercisePlanPosts;

    this.setSize(500, 500);
    this.setLocation(200, 150);
    this.setLayout(new GridLayout(0, 1));

    createTitlePanel(exercisePlanPost.title());
    createDatePanel(exercisePlanPost.date());
    createExerciseTypePanel(exercisePlanPost.exerciseType());
    createExerciseTimePanel(exercisePlanPost.exerciseTime());
    createStopoverPointPanel(exercisePlanPost.stopoverPoints());
    createDistancePanel(exercisePlanPost.exerciseDistance());
    createDescriptionPanel(exercisePlanPost.description());
    createButtonsPanel();

    this.setVisible(true);
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

  public void createButtonsPanel() {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BorderLayout());
    JButton cancelButton = new JButton("취소");
    cancelButton.addActionListener(event -> {
      this.dispose();
    });
    buttonsPanel.add(cancelButton, BorderLayout.WEST);
    JButton registerButton = new JButton("등록하기");
    registerButton.addActionListener(event -> {
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

      this.dispose();
    });
    buttonsPanel.add(registerButton, BorderLayout.EAST);
    this.add(buttonsPanel);
  }
}
