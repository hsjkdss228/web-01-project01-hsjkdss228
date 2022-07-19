package frames;

import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditExerciseRecordPostFrame extends JFrame {
  public static final int CREATION = 1;
  public static final int MODIFICATION = 2;

  List<ExercisePlanPost> exercisePlanPosts;
  List<ExerciseRecordPost> exerciseRecordPosts;
  
  private ButtonGroup exerciseTimeAchievementCheckButtonGroup;
  private ButtonGroup stopoverPointsAchievementCheckButtonGroup;
  private ButtonGroup exerciseDistanceAchievementCheckButtonGroup;
  private ButtonGroup finalResultCheckButtonGroup;
  private JTextArea descriptionTextArea;
  private ButtonGroup privacyStateCheckButtonGroup;

  public EditExerciseRecordPostFrame(
      List<ExercisePlanPost> exercisePlanPosts, ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts, int mode) {
    this.exercisePlanPosts = exercisePlanPosts;
    this.exerciseRecordPosts = exerciseRecordPosts;

    this.setSize(500, 500);
    this.setLocation(200, 150);
    this.setLayout(new GridLayout(0, 1));

    this.add(new JLabel(exercisePlanPost.title() + " 결과 기록하기"));
    this.add(new JLabel("날짜: " + exercisePlanPost.date()));
    this.add(new JLabel("운동 종류: " + exercisePlanPost.exerciseType()));
    createExerciseTimeAchievementCheckPanel(exercisePlanPost.exerciseTime());
    createStopoverPointsAchievementCheckPanel(exercisePlanPost.stopoverPoints());
    createExerciseDistanceAchievementsCheckPanel(exercisePlanPost.exerciseDistance());
    createFinalResultCheckPanel();
    createDescriptionPanel("");
    createPrivacyStateCheckPanel();
    createButtonsPanel(mode, exercisePlanPost, null);

    this.setVisible(true);
  }

  public EditExerciseRecordPostFrame(
      List<ExerciseRecordPost> exerciseRecordPosts,
      ExerciseRecordPost exerciseRecordPost, int mode) {
    this.exerciseRecordPosts = exerciseRecordPosts;

    this.setSize(500, 500);
    this.setLocation(200, 150);
    this.setLayout(new GridLayout(0, 1));

    this.add(new JLabel(exerciseRecordPost.exercisePlanPost().title() + " 결과 기록하기"));
    this.add(new JLabel("날짜: " + exerciseRecordPost.exercisePlanPost().date()));
    this.add(new JLabel("운동 종류: " + exerciseRecordPost.exercisePlanPost().exerciseType()));
    createExerciseTimeAchievementCheckPanel(exerciseRecordPost.exercisePlanPost().exerciseTime());
    createStopoverPointsAchievementCheckPanel(exerciseRecordPost.exercisePlanPost().stopoverPoints());
    createExerciseDistanceAchievementsCheckPanel(exerciseRecordPost.exercisePlanPost().exerciseDistance());
    createFinalResultCheckPanel();
    createDescriptionPanel(exerciseRecordPost.description());
    createPrivacyStateCheckPanel();
    createButtonsPanel(mode, null, exerciseRecordPost);

    this.setVisible(true);

  }

  public void createExerciseTimeAchievementCheckPanel(String exerciseTime) {
    JPanel exerciseTimeAchievementCheckPanel = new JPanel();
    exerciseTimeAchievementCheckPanel.add(new JLabel("목표 운동 시간: " + exerciseTime));
    exerciseTimeAchievementCheckButtonGroup = new ButtonGroup();
    JRadioButton achievedRadioButton = new JRadioButton("달성");
    achievedRadioButton.setActionCommand("달성");
    exerciseTimeAchievementCheckButtonGroup.add(achievedRadioButton);
    exerciseTimeAchievementCheckPanel.add(achievedRadioButton);
    JRadioButton notAchievedRadioButton = new JRadioButton("실패");
    notAchievedRadioButton.setActionCommand("실패");
    exerciseTimeAchievementCheckButtonGroup.add(notAchievedRadioButton);
    exerciseTimeAchievementCheckPanel.add(notAchievedRadioButton);
    this.add(exerciseTimeAchievementCheckPanel);
  }

  public void createStopoverPointsAchievementCheckPanel(String stopoverPoints) {
    JPanel stopoverPointsAchievementCheckPanel = new JPanel();
    stopoverPointsAchievementCheckPanel.add(new JLabel("목표 경유 장소: " + stopoverPoints));
    stopoverPointsAchievementCheckButtonGroup = new ButtonGroup();
    JRadioButton achievedRadioButton = new JRadioButton("달성");
    achievedRadioButton.setActionCommand("달성");
    stopoverPointsAchievementCheckButtonGroup.add(achievedRadioButton);
    stopoverPointsAchievementCheckPanel.add(achievedRadioButton);
    JRadioButton notAchievedRadioButton = new JRadioButton("실패");
    notAchievedRadioButton.setActionCommand("실패");
    stopoverPointsAchievementCheckButtonGroup.add(notAchievedRadioButton);
    stopoverPointsAchievementCheckPanel.add(notAchievedRadioButton);
    this.add(stopoverPointsAchievementCheckPanel);
  }

  public void createExerciseDistanceAchievementsCheckPanel(String exerciseDistance) {
    JPanel exerciseDistanceAchievementCheckPanel = new JPanel();
    exerciseDistanceAchievementCheckPanel.add(new JLabel("목표 운동 거리: " + exerciseDistance));
    exerciseDistanceAchievementCheckButtonGroup = new ButtonGroup();
    JRadioButton achievedRadioButton = new JRadioButton("달성");
    achievedRadioButton.setActionCommand("달성");
    exerciseDistanceAchievementCheckButtonGroup.add(achievedRadioButton);
    exerciseDistanceAchievementCheckPanel.add(achievedRadioButton);
    JRadioButton notAchievedRadioButton = new JRadioButton("실패");
    notAchievedRadioButton.setActionCommand("실패");
    exerciseDistanceAchievementCheckButtonGroup.add(notAchievedRadioButton);
    exerciseDistanceAchievementCheckPanel.add(notAchievedRadioButton);
    this.add(exerciseDistanceAchievementCheckPanel);
  }

  public void createFinalResultCheckPanel() {
    JPanel finalResultCheckPanel = new JPanel();
    finalResultCheckPanel.add(new JLabel("최종 결과: "));
    finalResultCheckButtonGroup = new ButtonGroup();
    JRadioButton achievedRadioButton = new JRadioButton("달성");
    achievedRadioButton.setActionCommand("달성");
    finalResultCheckButtonGroup.add(achievedRadioButton);
    finalResultCheckPanel.add(achievedRadioButton);
    JRadioButton notAchievedRadioButton = new JRadioButton("실패");
    notAchievedRadioButton.setActionCommand("실패");
    finalResultCheckButtonGroup.add(notAchievedRadioButton);
    finalResultCheckPanel.add(notAchievedRadioButton);
    this.add(finalResultCheckPanel);
  }

  public void createDescriptionPanel(String description) {
    JPanel descriptionPanel = new JPanel();
    descriptionPanel.add(new JLabel("상세 설명: "));
    descriptionTextArea = new JTextArea(description);
    descriptionTextArea.setColumns(20);
    descriptionTextArea.setRows(2);
    descriptionTextArea.setLineWrap(true);
    descriptionTextArea.setEditable(true);
    JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
    scrollPane.createVerticalScrollBar();
    descriptionPanel.add(scrollPane);
    this.add(descriptionPanel);
  }

  public void createPrivacyStateCheckPanel() {
    JPanel privacyStateCheckPanel = new JPanel();
    privacyStateCheckPanel.add(new JLabel("공개 여부: "));
    privacyStateCheckButtonGroup = new ButtonGroup();
    JRadioButton setPublicRadioButton = new JRadioButton("공개");
    setPublicRadioButton.setActionCommand("공개");
    privacyStateCheckButtonGroup.add(setPublicRadioButton);
    privacyStateCheckPanel.add(setPublicRadioButton);
    JRadioButton setPrivateRadioButton = new JRadioButton("비공개");
    setPrivateRadioButton.setActionCommand("비공개");
    privacyStateCheckButtonGroup.add(setPrivateRadioButton);
    privacyStateCheckPanel.add(setPrivateRadioButton);
    this.add(privacyStateCheckPanel);
  }

  public void createButtonsPanel(int mode, ExercisePlanPost exercisePlanPost, ExerciseRecordPost toBeModified) {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BorderLayout());
    JButton cancelButton = new JButton("취소");
    cancelButton.addActionListener(event -> {
      this.dispose();
    });
    buttonsPanel.add(cancelButton, BorderLayout.WEST);
    JButton registerButton = new JButton("등록하기");
    registerButton.addActionListener(event -> {
      if (mode == EditExerciseRecordPostFrame.CREATION) {
        boolean achievedExerciseTime = exerciseTimeAchievementCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        boolean visitedAllStopoverPoints = stopoverPointsAchievementCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        boolean achievedExerciseDistance = exerciseDistanceAchievementCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        boolean finalResult = finalResultCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        String description = descriptionTextArea.getText();
        boolean isPublicPost = privacyStateCheckButtonGroup
            .getSelection().getActionCommand().equals("공개");

        ExerciseRecordPost exerciseRecordPost = new ExerciseRecordPost(
            exercisePlanPost, achievedExerciseTime, visitedAllStopoverPoints,
            achievedExerciseDistance, finalResult, description,
            isPublicPost
        );

        exerciseRecordPosts.add(exerciseRecordPost);

        for (ExercisePlanPost found : exercisePlanPosts) {
          if (found.uniqueNumber() == exercisePlanPost.uniqueNumber()) {
            found.delete();
            break;
          }
        }
      }

      if (mode == EditExerciseRecordPostFrame.MODIFICATION) {
        boolean achievedExerciseTime = exerciseTimeAchievementCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        boolean visitedAllStopoverPoints = stopoverPointsAchievementCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        boolean achievedExerciseDistance = exerciseDistanceAchievementCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        boolean finalResult = finalResultCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        String description = descriptionTextArea.getText();
        boolean isPublicPost = privacyStateCheckButtonGroup
            .getSelection().getActionCommand().equals("공개");

        for (ExerciseRecordPost found : exerciseRecordPosts) {
          if (found.uniqueNumber() == toBeModified.uniqueNumber()) {
            found.modifyAchievedExerciseTime(achievedExerciseTime);
            found.modifyVisitedAllStopoverPoints(visitedAllStopoverPoints);
            found.modifyAchievedExerciseDistance(achievedExerciseDistance);
            found.modifyFinalResult(finalResult);
            found.modifyDescription(description);
            found.modifyPrivacyOfPost(isPublicPost);
            break;
          }
        }
      }

      this.dispose();
    });
    buttonsPanel.add(registerButton, BorderLayout.EAST);

    this.add(buttonsPanel);
  }
}
