package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EditExerciseRecordPostPanel extends JPanel {
  public static final int CREATION = 1;
  public static final int MODIFICATION = 2;

  List<ExercisePlanPost> exercisePlanPosts;
  List<ExerciseRecordPost> exerciseRecordPosts;

  private ButtonGroup exerciseTimeAchievementCheckButtonGroup;
  private List<ButtonGroup> stopoverPointsAchievementCheckButtonGroups;
  private ButtonGroup exerciseDistanceAchievementCheckButtonGroup;
  private ButtonGroup finalResultCheckButtonGroup;
  private JTextArea descriptionTextArea;
  private ButtonGroup privacyStateCheckButtonGroup;

  public EditExerciseRecordPostPanel(
      List<ExercisePlanPost> exercisePlanPosts, ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts, int mode) {
    this.exercisePlanPosts = exercisePlanPosts;
    this.exerciseRecordPosts = exerciseRecordPosts;

    this.setLayout(new GridLayout(0, 1));

    JButton backButton = new JButton("뒤로가기");
    backButton.addActionListener(event -> {
      JPanel exercisePlanPostPanel = new ExercisePlanPostPanel(
          exercisePlanPosts, exercisePlanPost, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(exercisePlanPostPanel);
    });
    this.add(backButton);
    this.add(new JLabel(exercisePlanPost.title() + " 결과 기록하기"));
    this.add(new JLabel("날짜: " + exercisePlanPost.date()));
    this.add(new JLabel("운동 종류: " + exercisePlanPost.exerciseType()));
    createExerciseTimeAchievementCheckPanel(exercisePlanPost.exerciseTime());
    createStopoverPointsAchievementCheckPanel(exercisePlanPost.stopoverPoints());
    createExerciseDistanceAchievementsCheckPanel(exercisePlanPost.exerciseDistance());
    createFinalResultCheckPanel();
    createDescriptionPanel("");
    createPrivacyStateCheckPanel();
    createButtonsPanel(mode, exercisePlanPost, null, exercisePlanPosts, exerciseRecordPosts);

    this.setVisible(true);
  }

  public EditExerciseRecordPostPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts,
      ExerciseRecordPost exerciseRecordPost, int mode) {
    this.exerciseRecordPosts = exerciseRecordPosts;

    this.setLayout(new GridLayout(0, 1));

    JButton backButton = new JButton("뒤로가기");
    backButton.addActionListener(event -> {
      JPanel exerciseRecordPostPanel = new ExerciseRecordPostPanel(
          exercisePlanPosts, exerciseRecordPosts, exerciseRecordPost
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(exerciseRecordPostPanel);
    });
    this.add(backButton);
    this.add(new JLabel(exerciseRecordPost.exercisePlanPost().title() + " 결과 기록하기"));
    this.add(new JLabel("날짜: " + exerciseRecordPost.exercisePlanPost().date()));
    this.add(new JLabel("운동 종류: " + exerciseRecordPost.exercisePlanPost().exerciseType()));
    createExerciseTimeAchievementCheckPanel(exerciseRecordPost.exercisePlanPost().exerciseTime());
    createStopoverPointsAchievementCheckPanel(exerciseRecordPost.exercisePlanPost().stopoverPoints());
    createExerciseDistanceAchievementsCheckPanel(exerciseRecordPost.exercisePlanPost().exerciseDistance());
    createFinalResultCheckPanel();
    createDescriptionPanel(exerciseRecordPost.description());
    createPrivacyStateCheckPanel();
    createButtonsPanel(mode, null, exerciseRecordPost, exercisePlanPosts, exerciseRecordPosts);

//    restoreCheckButtonGroup(exerciseTimeAchievementCheckButtonGroup, exerciseRecordPost.achievedExerciseTime());
//    restoreCheckButtonGroup(stopoverPointsAchievementCheckButtonGroup, exerciseRecordPost.visitedAllStopoverPoints());
//    restoreCheckButtonGroup(exerciseDistanceAchievementCheckButtonGroup, exerciseRecordPost.achievedExerciseDistance());
//    restoreCheckButtonGroup(finalResultCheckButtonGroup, exerciseRecordPost.finalResult());
//    restoreCheckButtonGroup(privacyStateCheckButtonGroup, exerciseRecordPost.isPublicPost());
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

  public void createStopoverPointsAchievementCheckPanel(List<String> stopoverPoints) {
    JPanel stopoverPointsAchievementCheckPanel = new JPanel();

    stopoverPointsAchievementCheckPanel.add(new JLabel("목표 경유 장소 리스트"));

    stopoverPointsAchievementCheckButtonGroups = new ArrayList<>();

    for (String stopoverPoint : stopoverPoints) {
      JPanel stopoverPointPanel = new JPanel();
      stopoverPointPanel.setLayout(new GridLayout(0, 1));

      stopoverPointPanel.add(new JLabel("경유지 "
          + (stopoverPoints.indexOf(stopoverPoint) + 1)
          + ": " + stopoverPoint));

      ButtonGroup stopoverPointsAchievementCheckButtonGroup = new ButtonGroup();

      JRadioButton achievedRadioButton = new JRadioButton("달성");
      achievedRadioButton.setActionCommand("달성");

      stopoverPointsAchievementCheckButtonGroup.add(achievedRadioButton);
      stopoverPointPanel.add(achievedRadioButton);

      JRadioButton notAchievedRadioButton = new JRadioButton("실패");
      notAchievedRadioButton.setActionCommand("실패");

      stopoverPointsAchievementCheckButtonGroup.add(notAchievedRadioButton);
      stopoverPointPanel.add(notAchievedRadioButton);

      stopoverPointsAchievementCheckButtonGroups.add(
          stopoverPointsAchievementCheckButtonGroup
      );
      stopoverPointsAchievementCheckPanel.add(stopoverPointPanel);
    }

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

  public void createButtonsPanel(
      int mode, ExercisePlanPost exercisePlanPost, ExerciseRecordPost toBeModified,
      List<ExercisePlanPost> exercisePlanPosts, List<ExerciseRecordPost> exerciseRecordPosts) {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BorderLayout());
    JButton cancelButton = new JButton("초기화");
    cancelButton.addActionListener(event -> {
//      if (mode == EditExerciseRecordPostPanel.CREATION) {
      exerciseTimeAchievementCheckButtonGroup.clearSelection();

      for (ButtonGroup stopoverPointsAchievementCheckButtonGroup
          : stopoverPointsAchievementCheckButtonGroups) {
        stopoverPointsAchievementCheckButtonGroup.clearSelection();
      }

      exerciseDistanceAchievementCheckButtonGroup.clearSelection();
      finalResultCheckButtonGroup.clearSelection();
      descriptionTextArea.setText("");
      privacyStateCheckButtonGroup.clearSelection();
//      }

      if (mode == EditExerciseRecordPostPanel.MODIFICATION) {
//        restoreCheckButtonGroup(exerciseTimeAchievementCheckButtonGroup, toBeModified.achievedExerciseTime());
//        restoreCheckButtonGroup(stopoverPointsAchievementCheckButtonGroup, toBeModified.visitedAllStopoverPoints());
//        restoreCheckButtonGroup(exerciseDistanceAchievementCheckButtonGroup, toBeModified.achievedExerciseDistance());
//        restoreCheckButtonGroup(finalResultCheckButtonGroup, toBeModified.finalResult());
        descriptionTextArea.setText(toBeModified.description());
//        restoreCheckButtonGroup(privacyStateCheckButtonGroup, toBeModified.isPublicPost());
      }
    });
    buttonsPanel.add(cancelButton, BorderLayout.WEST);

    JButton registerButton = new JButton("등록하기");
    registerButton.addActionListener(event -> {
      if (mode == EditExerciseRecordPostPanel.CREATION) {
        boolean achievedExerciseTime = exerciseTimeAchievementCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");

        List<Boolean> visitedStopoverPoints = new ArrayList<>();

        for (ButtonGroup stopoverPointsAchievementCheckButtonGroup
            : stopoverPointsAchievementCheckButtonGroups) {
          Boolean visitedStopoverPoint = stopoverPointsAchievementCheckButtonGroup
              .getSelection().getActionCommand().equals("달성");

          visitedStopoverPoints.add(visitedStopoverPoint);
        }

        boolean achievedExerciseDistance = exerciseDistanceAchievementCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        boolean finalResult = finalResultCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");
        String description = descriptionTextArea.getText();
        boolean isPublicPost = privacyStateCheckButtonGroup
            .getSelection().getActionCommand().equals("공개");

        ExerciseRecordPost exerciseRecordPost = new ExerciseRecordPost(
            exercisePlanPost, achievedExerciseTime, visitedStopoverPoints,
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

        JPanel mainMenuPanel = new MainMenuPanel(exercisePlanPosts, exerciseRecordPosts);
        AerobicExerciseRecords.mainFrame().showContentPanel(mainMenuPanel);
      }

      if (mode == EditExerciseRecordPostPanel.MODIFICATION) {
        boolean achievedExerciseTime = exerciseTimeAchievementCheckButtonGroup
            .getSelection().getActionCommand().equals("달성");

        List<Boolean> visitedStopoverPoints = new ArrayList<>();

        for (ButtonGroup stopoverPointsAchievementCheckButtonGroup
            : stopoverPointsAchievementCheckButtonGroups) {
          Boolean visitedStopoverPoint = stopoverPointsAchievementCheckButtonGroup
              .getSelection().getActionCommand().equals("달성");

          visitedStopoverPoints.add(visitedStopoverPoint);
        }

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
            found.modifyVisitedStopoverPoints(visitedStopoverPoints);
            found.modifyAchievedExerciseDistance(achievedExerciseDistance);
            found.modifyFinalResult(finalResult);
            found.modifyDescription(description);
            found.modifyPrivacyOfPost(isPublicPost);
            break;
          }
        }

        JPanel seeExerciseRecordPostsPanel = new SeeExerciseRecordPostsPanel(
            exercisePlanPosts, exerciseRecordPosts
        );
        AerobicExerciseRecords.mainFrame().showContentPanel(seeExerciseRecordPostsPanel);
      }
    });
    buttonsPanel.add(registerButton, BorderLayout.EAST);

    this.add(buttonsPanel);
  }

//  public void restoreCheckButtonGroup(ButtonGroup buttonGroup, boolean checked) {
//    Enumeration<AbstractButton> elements = buttonGroup.getElements();
//
//    AbstractButton achievedRadioButton = elements.nextElement();
//    System.out.println(achievedRadioButton.getActionCommand());
//    AbstractButton notAchievedRadioButton = elements.nextElement();
//    System.out.println(notAchievedRadioButton.getActionCommand());
//    System.out.println(checked);
//
//    buttonGroup.remove(achievedRadioButton);
//    buttonGroup.remove(notAchievedRadioButton);
//    if (achievedRadioButton.getActionCommand().equals("달성")
//        || achievedRadioButton.getActionCommand().equals("공개")
//        && checked) {
//      JRadioButton newAchievedRadioButton = new JRadioButton("달성");
//      achievedRadioButton.setActionCommand("달성");
//      achievedRadioButton.setSelected()
//      exerciseDistanceAchievementCheckButtonGroup.add(achievedRadioButton);
//      return;
//    }
//
//  }
}
