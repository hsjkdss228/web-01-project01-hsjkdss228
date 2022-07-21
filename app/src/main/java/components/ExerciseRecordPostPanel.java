package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExerciseRecordPostPanel extends JPanel {
  public ExerciseRecordPostPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts, ExerciseRecordPost exerciseRecordPost) {
    this.setLayout(new GridLayout(0, 1));

    JButton backButton = new JButton("뒤로가기");
    backButton.addActionListener(event -> {
      JPanel seeExerciseRecordPostsPanel = new SeeExerciseRecordPostsPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(seeExerciseRecordPostsPanel);
    });
    this.add(backButton);

    JPanel titlePanel = new JPanel();
    JLabel titleLabel = new JLabel(exerciseRecordPost.exercisePlanPost().title() + " 운동 결과");
    titlePanel.add(titleLabel);
    this.add(titlePanel);

    JPanel datePanel = new JPanel();
    JLabel dateLabel = new JLabel("운동 계획 날짜: " + exerciseRecordPost.exercisePlanPost().date());
    datePanel.add(dateLabel);
    this.add(datePanel);

    JPanel exerciseTypePanel = new JPanel();
    JLabel exerciseTypeLabel = new JLabel("운동 종류: " + exerciseRecordPost.exercisePlanPost().exerciseType());
    exerciseTypePanel.add(exerciseTypeLabel);
    this.add(exerciseTypePanel);

    JPanel exerciseTimeAchievementPanel = new JPanel();
    exerciseTimeAchievementPanel.setLayout(new GridLayout(0, 1));
    JLabel exerciseTimeLabel = new JLabel("목표 운동 시간: " + exerciseRecordPost.exercisePlanPost().exerciseTime());
    exerciseTimeAchievementPanel.add(exerciseTimeLabel);
    JLabel exerciseTimeAchievementLabel = new JLabel("달성 여부: "
        + (exerciseRecordPost.achievedExerciseTime() ? "달성" : "실패"));
    exerciseTimeAchievementPanel.add(exerciseTimeAchievementLabel);
    this.add(exerciseTimeAchievementPanel);

    JPanel stopoverPointsAchievementPanel = new JPanel();
    stopoverPointsAchievementPanel.setLayout(new GridLayout(0, 1));

    JLabel stopoverPointsLabel = new JLabel("목표 경유 장소 달성 여부");
    stopoverPointsAchievementPanel.add(stopoverPointsLabel);

    for (int i = 0; i < exerciseRecordPost.exercisePlanPost().stopoverPoints().size(); i += 1) {
      JPanel stopoverPointAchievementPanel = new JPanel();
      stopoverPointAchievementPanel.setLayout(new GridLayout(0, 1));

      String stopoverPoint = exerciseRecordPost.exercisePlanPost().stopoverPoints().get(i);
      boolean visitedStopoverPoint = exerciseRecordPost.visitedStopoverPoints().get(i);

      JLabel stopoverPointAchievementLabel = new JLabel(
          "경유지 " + (i + 1) + ": " + stopoverPoint + ", "
              + (visitedStopoverPoint ? "달성" : "실패")
      );
      stopoverPointAchievementPanel.add(stopoverPointAchievementLabel);

      stopoverPointsAchievementPanel.add(stopoverPointAchievementPanel);
    }

    this.add(stopoverPointsAchievementPanel);

    JPanel exerciseDistanceAchievementPanel = new JPanel();
    exerciseDistanceAchievementPanel.setLayout(new GridLayout(0, 1));
    JLabel exerciseDistanceLabel = new JLabel("목표 운동 거리: " + exerciseRecordPost.exercisePlanPost().exerciseDistance());
    exerciseDistanceAchievementPanel.add(exerciseDistanceLabel);
    JLabel exerciseDistanceAchievementLabel = new JLabel("달성 여부: "
        + (exerciseRecordPost.achievedExerciseDistance() ? "달성" : "실패"));
    exerciseDistanceAchievementPanel.add(exerciseDistanceAchievementLabel);
    this.add(exerciseDistanceAchievementPanel);

    JPanel finalResultPanel = new JPanel();
    JLabel finalResultLabel = new JLabel("종합 목표 달성 여부: "
        + (exerciseRecordPost.finalResult() ? "달성" : "실패"));
    finalResultPanel.add(finalResultLabel);
    this.add(finalResultPanel);

    JPanel descriptionPanel = new JPanel();
    descriptionPanel.add(new JLabel("상세 설명: "));
    JTextArea descriptionTextArea = new JTextArea(exerciseRecordPost.description());
    descriptionTextArea.setColumns(20);
    descriptionTextArea.setRows(2);
    descriptionTextArea.setLineWrap(true);
    descriptionTextArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
    scrollPane.createVerticalScrollBar();
    descriptionPanel.add(scrollPane);
    this.add(descriptionPanel);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 3));
    JButton modifyButton = new JButton("수정하기");
    modifyButton.addActionListener(event -> {
      JPanel editExerciseRecordPostPanel = new EditExerciseRecordPostPanel(
          exercisePlanPosts, exerciseRecordPosts, exerciseRecordPost,
          EditExerciseRecordPostPanel.MODIFICATION
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(editExerciseRecordPostPanel);
    });
    buttonsPanel.add(modifyButton);
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.addActionListener(event -> {
      for (ExerciseRecordPost found : exerciseRecordPosts) {
        if (found.uniqueNumber() == exerciseRecordPost.uniqueNumber()) {
          found.delete();
          break;
        }
      }

      NotificationDialog dialog = new NotificationDialog();

      JPanel seeExerciseRecordPostsPanel = new SeeExerciseRecordPostsPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().showContentPanel(seeExerciseRecordPostsPanel);

      dialog.showDialog("운동 계획 삭제가 완료되었습니다.");
    });
    buttonsPanel.add(deleteButton);
    this.add(buttonsPanel);

    this.setVisible(true);
  }
}
