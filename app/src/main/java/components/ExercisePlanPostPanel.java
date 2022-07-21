package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExercisePlanPostPanel extends JPanel {
  private ExercisePlanPost exercisePlanPost;

  private JPanel headerPanel;
  private JPanel contentsOfPostPanel;

  public ExercisePlanPostPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    this.exercisePlanPost = exercisePlanPost;

    this.setLayout(new BorderLayout());

    initHeaderPanel(exercisePlanPosts, exerciseRecordPosts);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(1, 3));
    mainPanel.add(new JPanel());

    contentsOfPostPanel = new JPanel();
    contentsOfPostPanel.setLayout(new GridLayout(0, 1));

    createTitlePanel();
    createDatePanel();
    createExerciseTypePanel();
    createExerciseTimePanel();
    createStopoverPointsPanel();
    createExerciseDistancePanel();
    createDescriptionPanel();
    createButtonsPanel(
        exercisePlanPosts, exercisePlanPost, exerciseRecordPosts
    );

    mainPanel.add(contentsOfPostPanel);
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
      JPanel seeExercisePlanPostsPanel = new ExercisePlanPostsBoardPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().replaceContentPanel(seeExercisePlanPostsPanel);
    });

    headerPanel.add(goBackButton, BorderLayout.WEST);
  }

  public void createTitlePanel() {
    JPanel titlePanel = new JPanel();
    titlePanel.setLayout(new GridLayout(0, 1));

    titlePanel.add(new JLabel("<운동 계획 제목>"));

    JLabel titleLabel = new JLabel(this.exercisePlanPost.title());
    titleLabel.setFont(new Font("", Font.PLAIN, 25));
    titleLabel.setHorizontalAlignment(JLabel.CENTER);

    titlePanel.add(titleLabel);

    contentsOfPostPanel.add(titlePanel);
  }

  public void createDatePanel() {
    JPanel datePanel = new JPanel();
    datePanel.setLayout(new GridLayout(0, 1));

    datePanel.add(new JLabel("<운동 계획 날짜>"));

    JLabel dateLabel = new JLabel(this.exercisePlanPost.date());
    dateLabel.setFont(new Font("", Font.PLAIN, 25));
    dateLabel.setHorizontalAlignment(JLabel.CENTER);

    datePanel.add(dateLabel);

    contentsOfPostPanel.add(datePanel);
  }

  public void createExerciseTypePanel() {
    JPanel exerciseTypePanel = new JPanel();
    exerciseTypePanel.setLayout(new GridLayout(0, 1));

    exerciseTypePanel.add(new JLabel("<운동 종류>"));

    JLabel exerciseTypeLabel = new JLabel(this.exercisePlanPost.exerciseType());
    exerciseTypeLabel.setFont(new Font("", Font.PLAIN, 25));
    exerciseTypeLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseTypePanel.add(exerciseTypeLabel);

    contentsOfPostPanel.add(exerciseTypePanel);
  }

  public void createExerciseTimePanel() {
    JPanel exerciseTimePanel = new JPanel();
    exerciseTimePanel.setLayout(new GridLayout(0, 1));

    exerciseTimePanel.add(new JLabel("<목표 운동 시간>"));

    JLabel exerciseTimeLabel = new JLabel(this.exercisePlanPost.exerciseTime());
    exerciseTimeLabel.setFont(new Font("", Font.PLAIN, 25));
    exerciseTimeLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseTimePanel.add(exerciseTimeLabel);

    contentsOfPostPanel.add(exerciseTimePanel);
  }

  public void createStopoverPointsPanel() {
    JPanel stopoverPointsPanel = new JPanel();
    stopoverPointsPanel.setLayout(new GridLayout(0, 1));

    stopoverPointsPanel.add(new JLabel("<목표 경유 장소>"));

    JPanel stopoverPointPanel = new JPanel();

    for (String stopoverPoint : this.exercisePlanPost.stopoverPoints()) {
      JLabel stopoverPointLabel = new JLabel("경유지 "
          + (this.exercisePlanPost.stopoverPoints().indexOf(stopoverPoint) + 1)
          + ": " + stopoverPoint + "      ");
      stopoverPointLabel.setFont(new Font("", Font.PLAIN, 15));

      stopoverPointPanel.add(stopoverPointLabel);
    }
    stopoverPointsPanel.add(stopoverPointPanel);

    contentsOfPostPanel.add(stopoverPointsPanel);
  }

  public void createExerciseDistancePanel() {
    JPanel exerciseDistancePanel = new JPanel();
    exerciseDistancePanel.setLayout(new GridLayout(0, 1));

    exerciseDistancePanel.add(new JLabel("<목표 운동 거리>"));

    JLabel exerciseDistanceLabel = new JLabel(this.exercisePlanPost.exerciseDistance());
    exerciseDistanceLabel.setFont(new Font("", Font.PLAIN, 25));
    exerciseDistanceLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseDistancePanel.add(exerciseDistanceLabel);

    contentsOfPostPanel.add(exerciseDistancePanel);
  }

  public void createDescriptionPanel() {
    JPanel descriptionPanel = new JPanel();
    descriptionPanel.setLayout(new GridLayout(0, 1));

    descriptionPanel.add(new JLabel("<상세 설명>"));

    JTextArea descriptionTextArea = new JTextArea(this.exercisePlanPost.description());

    descriptionTextArea.setColumns(30);
    descriptionTextArea.setRows(5);
    descriptionTextArea.setLineWrap(true);
    descriptionTextArea.setEditable(false);

    JScrollPane scrollPane = new JScrollPane(descriptionTextArea);

    scrollPane.createVerticalScrollBar();

    descriptionPanel.add(scrollPane);

    contentsOfPostPanel.add(descriptionPanel);
  }

  public void createButtonsPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 3));

    buttonsPanel.add(createModifyButton(
        exercisePlanPosts, exercisePlanPost, exerciseRecordPosts
    ));

    buttonsPanel.add(createDeleteButton(
        exercisePlanPosts, exerciseRecordPosts
    ));

    buttonsPanel.add(createExerciseRecordPostButton(
        exercisePlanPosts, exercisePlanPost, exerciseRecordPosts
    ));

    contentsOfPostPanel.add(buttonsPanel);
  }

  public JButton createModifyButton(
      List<ExercisePlanPost> exercisePlanPosts,
      ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.addActionListener(event -> {
      JPanel exercisePlanPostEditorPanel = new ExercisePlanPostEditorPanel(
          exercisePlanPosts, exercisePlanPost, exerciseRecordPosts,
          ExercisePlanPostEditorPanel.MODIFICATION
      );
      AerobicExerciseRecords.mainFrame().replaceContentPanel(exercisePlanPostEditorPanel);
    });

    return modifyButton;
  }

  public JButton createDeleteButton(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.addActionListener(event -> {
      deleteFoundPost(exercisePlanPosts, exercisePlanPost);

      NotificationDialog dialog = new NotificationDialog();

      JPanel exercisePlanPostsBoardPanel = new ExercisePlanPostsBoardPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().replaceContentPanel(exercisePlanPostsBoardPanel);

      dialog.showDialog("운동 계획 삭제가 완료되었습니다.");
    });

    return deleteButton;
  }

  private JButton createExerciseRecordPostButton(
      List<ExercisePlanPost> exercisePlanPosts,
      ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JButton createExerciseRecordPostButton = new JButton("결과 기록하기");

    createExerciseRecordPostButton.addActionListener(event -> {
      JPanel exerciseRecordPostEditorPanel = new ExerciseRecordPostEditorPanel(
          exercisePlanPosts, exercisePlanPost, exerciseRecordPosts,
          ExerciseRecordPostEditorPanel.CREATION
      );
      AerobicExerciseRecords.mainFrame().replaceContentPanel(exerciseRecordPostEditorPanel);
    });

    return createExerciseRecordPostButton;
  }

  public void deleteFoundPost(
      List<ExercisePlanPost> exercisePlanPosts,
      ExercisePlanPost exercisePlanPost) {
    for (ExercisePlanPost found : exercisePlanPosts) {
      if (found.uniqueNumber() == exercisePlanPost.uniqueNumber()) {
        found.delete();
        break;
      }
    }
  }
}
