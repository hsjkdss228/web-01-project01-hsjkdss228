package frames;

import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExerciseRecordPostFrame extends JFrame {
  public ExerciseRecordPostFrame(
      List<ExerciseRecordPost> exerciseRecordPosts, ExerciseRecordPost exerciseRecordPost) {
    this.setSize(500, 500);
    this.setLocation(700, 70);
    this.setLayout(new GridLayout(0, 1));

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
    JLabel stopoverPointsLabel = new JLabel("목표 경유 장소: " + exerciseRecordPost.exercisePlanPost().stopoverPoints());
    stopoverPointsAchievementPanel.add(stopoverPointsLabel);
    JLabel stopoverPointsAchievementLabel = new JLabel("달성 여부: "
        + (exerciseRecordPost.visitedAllStopoverPoints() ? "달성" : "실패"));
    stopoverPointsAchievementPanel.add(stopoverPointsAchievementLabel);
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
      EditExerciseRecordPostFrame editExerciseRecordPostFrame = new EditExerciseRecordPostFrame(
          exerciseRecordPosts, exerciseRecordPost, EditExerciseRecordPostFrame.MODIFICATION
      );

      this.dispose();
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

      this.dispose();
    });
    buttonsPanel.add(deleteButton);
    this.add(buttonsPanel);

    this.setVisible(true);
  }
}
