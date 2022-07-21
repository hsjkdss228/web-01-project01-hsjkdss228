package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ExercisePlanPostEditorPanel extends JPanel {
  public static final int CREATION = 1;
  public static final int MODIFICATION = 2;

  List<ExercisePlanPost> exercisePlanPosts;

  NotificationDialog dialog = new NotificationDialog();

  private JPanel headerPanel;
  private JPanel editorPanel;
  private JPanel exerciseTypePanel;

  private JTextField titleTextField;
  private JTextField dateTextField;
  private ButtonGroup exerciseTypeButtonGroup;
  private JTextField exerciseTimeTextField;
  private JTextField stopoverPointsTextField;
  private List<String> stopoverPoints;
  private JPanel addedStopoverPointsPanel;
  private JTextField exerciseDistanceTextField;
  private JTextArea descriptionTextArea;

  public ExercisePlanPostEditorPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts,
      int creation) {
    this.exercisePlanPosts = exercisePlanPosts;

    this.setLayout(new BorderLayout());

    initHeaderPanel(exercisePlanPosts, exerciseRecordPosts);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(1, 3));
    mainPanel.add(new JPanel());

    editorPanel = new JPanel();
    editorPanel.setLayout(new GridLayout(0, 1));

    createTitlePanel("");
    createDatePanel("");
    createExerciseTypePanel();
    createExerciseTimePanel("");
    createStopoverPointsPanel(ExercisePlanPostEditorPanel.CREATION, null);
    createDistancePanel("");
    createDescriptionPanel("");
    createButtonsPanel(creation, null, exerciseRecordPosts);

    mainPanel.add(editorPanel);
    mainPanel.add(new JPanel());

    this.add(mainPanel);
  }

  public ExercisePlanPostEditorPanel(
      List<ExercisePlanPost> exercisePlanPosts, ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts, int modification) {
    this.exercisePlanPosts = exercisePlanPosts;

    this.setLayout(new BorderLayout());

    initHeaderPanel(exercisePlanPosts, exerciseRecordPosts);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(1, 3));
    mainPanel.add(new JPanel());

    editorPanel = new JPanel();
    editorPanel.setLayout(new GridLayout(0, 1));

    createTitlePanel(exercisePlanPost.title());
    createDatePanel(exercisePlanPost.date());
    createExerciseTypePanel();
    createExerciseTimePanel(exercisePlanPost.exerciseTime());
    createStopoverPointsPanel(
        ExercisePlanPostEditorPanel.MODIFICATION, exercisePlanPost.stopoverPoints()
    );
    createDistancePanel(exercisePlanPost.exerciseDistance());
    createDescriptionPanel(exercisePlanPost.description());
    createButtonsPanel(modification, exercisePlanPost, exerciseRecordPosts);

    mainPanel.add(editorPanel);
    mainPanel.add(new JPanel());

    this.add(mainPanel);
  }

  public void initHeaderPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    headerPanel = new JPanel();
    headerPanel.setLayout(new BorderLayout());

    createGoBackButton(exercisePlanPosts, exerciseRecordPosts);

    this.add(headerPanel, BorderLayout.PAGE_START);
  }

  public void createGoBackButton(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JButton goBackButton = new JButton("뒤로가기");

    goBackButton.addActionListener(event -> {
      JPanel mainMenuPanel = new MainMenuPanel(exercisePlanPosts, exerciseRecordPosts);
      AerobicExerciseRecords.mainFrame().replaceContentPanel(mainMenuPanel);
    });

    headerPanel.add(goBackButton, BorderLayout.WEST);
  }

  public void createTitlePanel(String text) {
    JPanel titlePanel = new JPanel();

    titlePanel.add(new JLabel("제목: "));

    titleTextField = new JTextField(text, 25);

    titlePanel.add(titleTextField);

    editorPanel.add(titlePanel);
  }

  public void createDatePanel(String text) {
    JPanel datePanel = new JPanel();

    datePanel.add(new JLabel("날짜: "));

    dateTextField = new JTextField(text, 25);

    datePanel.add(dateTextField);

    editorPanel.add(datePanel);
  }

  public void createExerciseTypePanel() {
    exerciseTypePanel = new JPanel();

    exerciseTypePanel.add(new JLabel("운동 종류: "));

    exerciseTypeButtonGroup = new ButtonGroup();

    createExerciseTypeButton("걷기");
    createExerciseTypeButton("달리기");
    createExerciseTypeButton("자전거");
    createExerciseTypeButton("등산");

    editorPanel.add(exerciseTypePanel);
  }

  public void createExerciseTypeButton(String type) {
    JRadioButton radioButton = new JRadioButton(type);

    radioButton.setActionCommand(type);

    exerciseTypeButtonGroup.add(radioButton);
    exerciseTypePanel.add(radioButton);
  }

  public void createExerciseTimePanel(String text) {
    JPanel exerciseTimePanel = new JPanel();

    exerciseTimePanel.add(new JLabel("목표 운동 시간: "));

    exerciseTimeTextField = new JTextField(text, 25);

    exerciseTimePanel.add(exerciseTimeTextField);

    editorPanel.add(exerciseTimePanel);
  }

  public void createStopoverPointsPanel(int mode, List<String> existingStopoverPoints) {
    stopoverPoints = mode == ExercisePlanPostEditorPanel.CREATION
        ? new ArrayList<>()
        : new ArrayList<>(existingStopoverPoints);

    JPanel stopoverPointsPanel = new JPanel();
    stopoverPointsPanel.setLayout(new BorderLayout());

    JPanel inputStopoverPointPanel = new JPanel();
    addedStopoverPointsPanel = new JPanel();

    inputStopoverPointPanel.add(new JLabel("목표 경유 장소: "));

    stopoverPointsTextField = new JTextField(20);
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

    editorPanel.add(stopoverPointsPanel);
  }

  public void updateAddedStopoverPointsPanel() {
    addedStopoverPointsPanel.removeAll();

    for (String stopoverPoint : stopoverPoints) {
      JPanel stopoverPointPanel = new JPanel();

      stopoverPointPanel.add(new JLabel(stopoverPoint));

      JButton deleteButton = new JButton("X");
      deleteButton.setSize(5, 5);
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

    exerciseDistanceTextField = new JTextField(text, 25);

    exerciseDistancePanel.add(exerciseDistanceTextField);

    editorPanel.add(exerciseDistancePanel);
  }

  public void createDescriptionPanel(String text) {
    JPanel descriptionPanel = new JPanel();

    descriptionPanel.add(new JLabel("상세 설명: "));

    descriptionTextArea = new JTextArea(text);
    descriptionTextArea.setColumns(30);
    descriptionTextArea.setRows(5);

    descriptionTextArea.setLineWrap(true);
    descriptionTextArea.setEditable(true);

    JScrollPane scrollPane = new JScrollPane(descriptionTextArea);

    scrollPane.createVerticalScrollBar();

    descriptionPanel.add(scrollPane);
    editorPanel.add(descriptionPanel);
  }

  public void createButtonsPanel(int mode, ExercisePlanPost toBeModified,
                                 List<ExerciseRecordPost> exerciseRecordPosts) {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 0));

    JButton cancelButton = new JButton("초기화");
    cancelButton.addActionListener(event -> {
      if (mode == ExercisePlanPostEditorPanel.CREATION) {
        initInputControlsBlank();
      }

      if (mode == ExercisePlanPostEditorPanel.MODIFICATION) {
        initInputControlsBeforeModified(toBeModified);
      }

      dialog.showDialog("초기화 되었습니다.");
    });

    buttonsPanel.add(cancelButton);

    JButton registerButton = new JButton("등록하기");
    registerButton.addActionListener(event -> {
      if (foundIllegalConditionInInputs()) {
        dialog.showDialog("입력되지 않은 값이 있습니다.");
        return;
      }

      if (mode == ExercisePlanPostEditorPanel.CREATION) {
        exercisePlanPosts.add(createNewExercisePlanPost());
      }

      if (mode == ExercisePlanPostEditorPanel.MODIFICATION) {
        modifyExercisePlanPost(toBeModified);
      }

      JPanel mainMenuPanel = new MainMenuPanel(exercisePlanPosts, exerciseRecordPosts);
      AerobicExerciseRecords.mainFrame().replaceContentPanel(mainMenuPanel);

      dialog.showDialog("운동 계획 작성이 완료되었습니다.");
    });
    buttonsPanel.add(registerButton);
    editorPanel.add(buttonsPanel);
  }

  public void initInputControlsBlank() {
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

  public void initInputControlsBeforeModified(ExercisePlanPost toBeModified) {
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

  private boolean foundIllegalConditionInInputs() {
    return titleTextField.getText().equals("")
        || dateTextField.getText().equals("")
        || notSelectedExerciseType()
        || exerciseTimeTextField.getText().equals("")
        || notAddedStopoverPoints()
        || exerciseDistanceTextField.getText().equals("")
        || descriptionTextArea.getText().equals("");
  }

  public boolean notSelectedExerciseType() {
    Enumeration<AbstractButton> buttons = exerciseTypeButtonGroup.getElements();

    while (buttons.hasMoreElements()) {
      AbstractButton button = buttons.nextElement();

      if (button.isSelected()) {
        return false;
      }
    }

    return true;
  }

  public boolean notAddedStopoverPoints() {
    return stopoverPoints.isEmpty();
  }

  public ExercisePlanPost createNewExercisePlanPost() {
    return new ExercisePlanPost(
        titleTextField.getText(),
        dateTextField.getText(),
        exerciseTypeButtonGroup.getSelection().getActionCommand(),
        exerciseTimeTextField.getText(),
        stopoverPoints,
        exerciseDistanceTextField.getText(),
        descriptionTextArea.getText()
    );
  }

  public void modifyExercisePlanPost(ExercisePlanPost toBeModified) {
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
}
