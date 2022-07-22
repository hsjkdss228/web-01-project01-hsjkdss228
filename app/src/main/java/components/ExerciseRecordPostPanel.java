package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExerciseRecordPostPanel extends JPanel {
  private ExerciseRecordPost exerciseRecordPost;

  private JPanel headerPanel;
  private JPanel contentsOfPostPanel;

  public ExerciseRecordPostPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts,
      ExerciseRecordPost exerciseRecordPost) {
    this.exerciseRecordPost = exerciseRecordPost;

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
    createFinalResultPanel();
    createDescriptionPanel();
    createButtonsPanel(
        exercisePlanPosts, exerciseRecordPost, exerciseRecordPosts
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
      JPanel seeExerciseRecordPostsPanel = new ExerciseRecordPostsBoardPanel(
          exercisePlanPosts, exerciseRecordPosts
      );

      AerobicExerciseRecords.mainFrame().replaceContentPanel(seeExerciseRecordPostsPanel);
    });

    headerPanel.add(goBackButton, BorderLayout.WEST);
  }

  public void createTitlePanel() {
    JPanel titlePanel = new JPanel();
    titlePanel.setLayout(new GridLayout(0, 1));

    JLabel titleLabel = new JLabel(
        this.exerciseRecordPost.exercisePlanPost().title() + " 결과 기록"
    );
    titleLabel.setFont(new Font("", Font.PLAIN, 25));
    titleLabel.setHorizontalAlignment(JLabel.CENTER);

    titlePanel.add(titleLabel);

    contentsOfPostPanel.add(titlePanel);
  }

  public void createDatePanel() {
    JPanel datePanel = new JPanel();
    datePanel.setLayout(new GridLayout(0, 1));

    datePanel.add(new JLabel("<운동 계획 날짜>"));

    JLabel dateLabel = new JLabel(
        this.exerciseRecordPost.exercisePlanPost().date()
    );
    dateLabel.setFont(new Font("", Font.PLAIN, 25));
    dateLabel.setHorizontalAlignment(JLabel.CENTER);

    datePanel.add(dateLabel);

    contentsOfPostPanel.add(datePanel);
  }

  public void createExerciseTypePanel() {
    JPanel exerciseTypePanel = new JPanel();
    exerciseTypePanel.setLayout(new GridLayout(0, 1));

    exerciseTypePanel.add(new JLabel("<운동 종류>"));

    JLabel exerciseTypeLabel = new JLabel(
        this.exerciseRecordPost.exercisePlanPost().exerciseType()
    );
    exerciseTypeLabel.setFont(new Font("", Font.PLAIN, 25));
    exerciseTypeLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseTypePanel.add(exerciseTypeLabel);

    contentsOfPostPanel.add(exerciseTypePanel);
  }

  public void createExerciseTimePanel() {
    JPanel exerciseTimeAchievementPanel = new JPanel();
    exerciseTimeAchievementPanel.setLayout(new GridLayout(0, 1));

    exerciseTimeAchievementPanel.add(new JLabel("<목표 운동 시간>"));

    JLabel exerciseTimeLabel = new JLabel(this.exerciseRecordPost.exercisePlanPost().exerciseTime());
    exerciseTimeLabel.setFont(new Font("", Font.PLAIN, 25));
    exerciseTimeLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseTimeAchievementPanel.add(exerciseTimeLabel);

    JLabel exerciseTimeAchievementLabel = new JLabel("달성 여부: "
        + (exerciseRecordPost.achievedExerciseTime() ? "달성" : "실패")
        + "    ");
    exerciseTimeAchievementLabel.setFont(new Font("", Font.ITALIC, 15));
    exerciseTimeAchievementLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseTimeAchievementPanel.add(exerciseTimeAchievementLabel);

    contentsOfPostPanel.add(exerciseTimeAchievementPanel);
  }

  public void createStopoverPointsPanel() {
    JPanel stopoverPointsAchievementPanel = new JPanel();
    stopoverPointsAchievementPanel.setLayout(new GridLayout(0, 1));

    stopoverPointsAchievementPanel.add(new JLabel("<목표 경유 장소>"));

    JPanel stopoverPointsPanel = new JPanel();

    for (int i = 0; i < exerciseRecordPost.exercisePlanPost().stopoverPoints().size(); i += 1) {
      String stopoverPoint = exerciseRecordPost.exercisePlanPost().stopoverPoints().get(i);
      boolean visitedStopoverPoint = exerciseRecordPost.visitedStopoverPoints().get(i);

      JLabel stopoverPointAchievementLabel = new JLabel(
          "경유지 " + (i + 1) + ": " + stopoverPoint + ", "
              + (visitedStopoverPoint ? "달성" : "실패")
      );
      stopoverPointAchievementLabel.setFont(new Font("", Font.ITALIC, 15));

      stopoverPointsPanel.add(stopoverPointAchievementLabel);

    }
    stopoverPointsAchievementPanel.add(stopoverPointsPanel);

    contentsOfPostPanel.add(stopoverPointsPanel);
  }

  public void createExerciseDistancePanel() {
    JPanel exerciseDistanceAchievementPanel = new JPanel();
    exerciseDistanceAchievementPanel.setLayout(new GridLayout(0, 1));

    exerciseDistanceAchievementPanel.add(new JLabel("<목표 운동 거리>"));

    JLabel exerciseDistanceLabel = new JLabel(this.exerciseRecordPost.exercisePlanPost().exerciseDistance());
    exerciseDistanceLabel.setFont(new Font("", Font.PLAIN, 25));
    exerciseDistanceLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseDistanceAchievementPanel.add(exerciseDistanceLabel);

    JLabel exerciseDistanceAchievementLabel = new JLabel("달성 여부: "
        + (exerciseRecordPost.achievedExerciseDistance() ? "달성" : "실패"));
    exerciseDistanceAchievementLabel.setFont(new Font("", Font.ITALIC, 15));
    exerciseDistanceAchievementLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseDistanceAchievementPanel.add(exerciseDistanceAchievementLabel);

    contentsOfPostPanel.add(exerciseDistanceAchievementPanel);
  }

  public void createFinalResultPanel() {
    JPanel finalResultPanel = new JPanel();
    finalResultPanel.setLayout(new GridLayout(0, 1));

    finalResultPanel.add(new JLabel("<종합 목표 달성 여부>"));

    JLabel finalResultLabel = new JLabel(
        exerciseRecordPost.finalResult() ? "달성" : "실패"
    );
    finalResultLabel.setFont(new Font("", Font.ITALIC, 15));
    finalResultLabel.setHorizontalAlignment(JLabel.CENTER);

    finalResultPanel.add(finalResultLabel);

    contentsOfPostPanel.add(finalResultPanel);
  }

  public void createDescriptionPanel() {
    JPanel descriptionPanel = new JPanel();
    descriptionPanel.setLayout(new GridLayout(0, 1));

    descriptionPanel.add(new JLabel("<상세 설명>"));

    JTextArea descriptionTextArea = new JTextArea(this.exerciseRecordPost.description());

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
      ExerciseRecordPost exerciseRecordPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2));

    buttonsPanel.add(createModifyButton(
        exercisePlanPosts, exerciseRecordPost, exerciseRecordPosts
    ));

    buttonsPanel.add(createDeleteButton(
        exercisePlanPosts, exerciseRecordPosts
    ));

    contentsOfPostPanel.add(buttonsPanel);
  }

  public JButton createModifyButton(
      List<ExercisePlanPost> exercisePlanPosts,
      ExerciseRecordPost exerciseRecordPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.addActionListener(event -> {
      JPanel editExerciseRecordPostPanel = new ExerciseRecordPostEditorPanel(
          exercisePlanPosts, exerciseRecordPosts, exerciseRecordPost,
          ExerciseRecordPostEditorPanel.MODIFICATION
      );

      AerobicExerciseRecords.mainFrame().replaceContentPanel(editExerciseRecordPostPanel);
    });

    return modifyButton;
  }

  public JButton createDeleteButton(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.addActionListener(event -> {
      deleteFoundPost(exerciseRecordPosts, exerciseRecordPost);

      NotificationDialog dialog = new NotificationDialog();

      JPanel exerciseRecordPostsBoardPanel = new ExerciseRecordPostsBoardPanel(
          exercisePlanPosts, exerciseRecordPosts
      );

      AerobicExerciseRecords.mainFrame().replaceContentPanel(exerciseRecordPostsBoardPanel);

      dialog.showDialog("운동 기록 삭제가 완료되었습니다.");
    });

    return deleteButton;
  }

  public void deleteFoundPost(
      List<ExerciseRecordPost> exerciseRecordPosts,
      ExerciseRecordPost exerciseRecordPost) {
    for (ExerciseRecordPost found : exerciseRecordPosts) {
      if (found.uniqueNumber() == exerciseRecordPost.uniqueNumber()) {
        found.delete();
        break;
      }
    }
  }
}
