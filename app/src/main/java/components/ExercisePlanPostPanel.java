package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExercisePlanPostPanel extends JPanel {
  public ExercisePlanPostPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    this.setLayout(new GridLayout(0, 1));

    JButton backButton = new JButton("뒤로가기");
    backButton.addActionListener(event -> {
      JPanel seeExercisePlanPostsPanel = new SeeExercisePlanPostsPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().replaceContentPanel(seeExercisePlanPostsPanel);
    });
    this.add(backButton);

    JLabel titleLabel = new JLabel(exercisePlanPost.title());
    this.add(titleLabel);

    JLabel dateLabel = new JLabel(exercisePlanPost.date());
    this.add(dateLabel);

    JLabel exerciseTypeLabel = new JLabel(exercisePlanPost.exerciseType());
    this.add(exerciseTypeLabel);

    JLabel exerciseTimeLabel = new JLabel(exercisePlanPost.exerciseTime());
    this.add(exerciseTimeLabel);

    JPanel stopoverPointsPanel = new JPanel();
    stopoverPointsPanel.setLayout(new GridLayout(0, 1));
    for (String stopoverPoint : exercisePlanPost.stopoverPoints()) {
      JLabel stopoverPointLabel = new JLabel("경유지 "
          + (exercisePlanPost.stopoverPoints().indexOf(stopoverPoint) + 1)
          + ": " + stopoverPoint);
      stopoverPointsPanel.add(stopoverPointLabel);
    }
    this.add(stopoverPointsPanel);

    JLabel exerciseDistanceLabel = new JLabel(exercisePlanPost.exerciseDistance());
    this.add(exerciseDistanceLabel);

    JPanel descriptionPanel = new JPanel();
    descriptionPanel.add(new JLabel("상세 설명: "));
    JTextArea descriptionTextArea = new JTextArea(exercisePlanPost.description());
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
      JPanel editExercisePlanPostPanel = new ExercisePlanPostEditorPanel(
          exercisePlanPosts, exercisePlanPost, exerciseRecordPosts, ExercisePlanPostEditorPanel.MODIFICATION
      );
      AerobicExerciseRecords.mainFrame().replaceContentPanel(editExercisePlanPostPanel);
    });
    buttonsPanel.add(modifyButton);

    JButton deleteButton = new JButton("삭제하기");
    deleteButton.addActionListener(event -> {
      for (ExercisePlanPost found : exercisePlanPosts) {
        if (found.uniqueNumber() == exercisePlanPost.uniqueNumber()) {
          found.delete();
          break;
        }
      }

      NotificationDialog dialog = new NotificationDialog();

      JPanel seeExercisePlanPostsPanel = new SeeExercisePlanPostsPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().replaceContentPanel(seeExercisePlanPostsPanel);

      dialog.showDialog("운동 계획 삭제가 완료되었습니다.");
    });
    buttonsPanel.add(deleteButton);

    JButton createExerciseRecordPostButton = new JButton("결과 기록하기");
    createExerciseRecordPostButton.addActionListener(event -> {
      JPanel exerciseRecordPostEditorPanel = new ExerciseRecordPostEditorPanel(
        exercisePlanPosts, exercisePlanPost, exerciseRecordPosts, ExerciseRecordPostEditorPanel.CREATION
      );
      AerobicExerciseRecords.mainFrame().replaceContentPanel(exerciseRecordPostEditorPanel);
    });
    buttonsPanel.add(createExerciseRecordPostButton);
    this.add(buttonsPanel);
  }
}
