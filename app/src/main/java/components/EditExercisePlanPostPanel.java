package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EditExercisePlanPostPanel extends JPanel {
  public static final int CREATION = 1;
  public static final int MODIFICATION = 2;

  List<ExercisePlanPost> exercisePlanPosts;

  private JTextField titleTextField;
  private JTextField dateTextField;
  private ButtonGroup exerciseTypeButtonGroup;
  private JTextField exerciseTimeTextField;

  private JTextField stopoverPointsTextField;
  private List<String> stopoverPoints;
  private JPanel addedStopoverPointsPanel;

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
    createExerciseTypePanel();
    createExerciseTimePanel("");
    createStopoverPointsPanel(EditExercisePlanPostPanel.CREATION, null);
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
    createExerciseTypePanel();
    createExerciseTimePanel(exercisePlanPost.exerciseTime());
    createStopoverPointsPanel(
        EditExercisePlanPostPanel.MODIFICATION, exercisePlanPost.stopoverPoints()
    );
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

  public void createExerciseTypePanel() {
    JPanel exerciseTypePanel = new JPanel();
    exerciseTypePanel.add(new JLabel("운동 종류: "));

    exerciseTypeButtonGroup = new ButtonGroup();

    JRadioButton walkingButton = new JRadioButton("걷기");
    walkingButton.setActionCommand("걷기");
    exerciseTypeButtonGroup.add(walkingButton);
    exerciseTypePanel.add(walkingButton);

    JRadioButton runningButton = new JRadioButton("달리기");
    runningButton.setActionCommand("달리기");
    exerciseTypeButtonGroup.add(runningButton);
    exerciseTypePanel.add(runningButton);

    JRadioButton cyclingButton = new JRadioButton("자전거");
    cyclingButton.setActionCommand("자전거");
    exerciseTypeButtonGroup.add(cyclingButton);
    exerciseTypePanel.add(cyclingButton);

    JRadioButton climbingButton = new JRadioButton("등산");
    climbingButton.setActionCommand("등산");
    exerciseTypeButtonGroup.add(climbingButton);
    exerciseTypePanel.add(climbingButton);

    this.add(exerciseTypePanel);
  }

  public void createExerciseTimePanel(String text) {
    JPanel exerciseTimePanel = new JPanel();
    exerciseTimePanel.add(new JLabel("목표 운동 시간: "));
    exerciseTimeTextField = new JTextField(text, 15);
    exerciseTimePanel.add(exerciseTimeTextField);
    this.add(exerciseTimePanel);
  }

  public void createStopoverPointsPanel(int mode, List<String> existingStopoverPoints) {
    stopoverPoints = mode == EditExercisePlanPostPanel.CREATION
        ? new ArrayList<>()
        : new ArrayList<>(existingStopoverPoints);

    JPanel stopoverPointsPanel = new JPanel();
    stopoverPointsPanel.setLayout(new BorderLayout());

    JPanel inputStopoverPointPanel = new JPanel();
    addedStopoverPointsPanel = new JPanel();

    inputStopoverPointPanel.add(new JLabel("목표 경유 장소: "));

    stopoverPointsTextField = new JTextField(15);
    inputStopoverPointPanel.add(stopoverPointsTextField);

    JButton addStopoverPointButton = new JButton("추가");
    addStopoverPointButton.addActionListener(event -> {
      stopoverPoints.add(stopoverPointsTextField.getText());
      stopoverPointsTextField.setText("");

      updateAddedStopoverPointsPanel();
    });
    inputStopoverPointPanel.add(addStopoverPointButton);

    stopoverPointsPanel.add(inputStopoverPointPanel, BorderLayout.PAGE_START);

    updateAddedStopoverPointsPanel();

    stopoverPointsPanel.add(addedStopoverPointsPanel);

    this.add(stopoverPointsPanel);
  }

  public void updateAddedStopoverPointsPanel() {
    addedStopoverPointsPanel.removeAll();

    for (String stopoverPoint : stopoverPoints) {
      JPanel stopoverPointPanel = new JPanel();
      stopoverPointPanel.add(new JLabel(stopoverPoint));
      JButton deleteButton = new JButton("X");
      deleteButton.addActionListener(event -> {
        stopoverPoints.remove(stopoverPoint);
        updateAddedStopoverPointsPanel();
      });
      stopoverPointPanel.add(deleteButton);
      addedStopoverPointsPanel.add(stopoverPointPanel);
    }

    addedStopoverPointsPanel.setVisible(false);
    addedStopoverPointsPanel.setVisible(true);
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
        exerciseTypeButtonGroup.clearSelection();
        exerciseTimeTextField.setText("");

        stopoverPointsTextField.setText("");
        stopoverPoints = new ArrayList<>();
        updateAddedStopoverPointsPanel();

        exerciseDistanceTextField.setText("");
        descriptionTextArea.setText("");
      }

      if (mode == EditExercisePlanPostPanel.MODIFICATION) {
        //TODO: 수정 모드에서 초기화 버튼 누르면 운동 타입이 원래 선택되어 있던 것으로
        // 리셋해줄 수 있었으면 좋겠음, 근데 ㄱㄴ? editor랑 modifier를 분리해야 할 수도?
        titleTextField.setText(toBeModified.title());
        dateTextField.setText(toBeModified.date());
        exerciseTypeButtonGroup.clearSelection();
        exerciseTimeTextField.setText(toBeModified.exerciseTime());

        stopoverPointsTextField.setText("");
        stopoverPoints = toBeModified.stopoverPoints();
        updateAddedStopoverPointsPanel();

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
            exerciseTypeButtonGroup.getSelection().getActionCommand(),
            exerciseTimeTextField.getText(),
            stopoverPoints,
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
            found.modifyExerciseType(
                exerciseTypeButtonGroup.getSelection().getActionCommand()
            );
            found.modifyExerciseTime(exerciseTimeTextField.getText());
            found.modifyStopoverPoints(stopoverPoints);
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
