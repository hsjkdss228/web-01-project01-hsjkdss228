package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ExerciseRecordPostEditorPanel extends JPanel {
  public static final int CREATION = 1;
  public static final int MODIFICATION = 2;

  List<ExercisePlanPost> exercisePlanPosts;
  List<ExerciseRecordPost> exerciseRecordPosts;

  NotificationDialog dialog = new NotificationDialog();

  private JPanel headerPanel;
  private JPanel editorPanel;

  private ButtonGroup exerciseTimeAchievementCheckButtonGroup;
  private List<ButtonGroup> stopoverPointsAchievementCheckButtonGroups;
  private ButtonGroup exerciseDistanceAchievementCheckButtonGroup;
  private ButtonGroup finalResultCheckButtonGroup;
  private JTextArea descriptionTextArea;

  public ExerciseRecordPostEditorPanel(
      List<ExercisePlanPost> exercisePlanPosts, ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts, int creation) {
    this.exercisePlanPosts = exercisePlanPosts;
    this.exerciseRecordPosts = exerciseRecordPosts;

    this.setLayout(new BorderLayout());

    initHeaderPanel(exercisePlanPosts, exercisePlanPost, exerciseRecordPosts);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(1, 3));
//    mainPanel.add(new JPanel());

    editorPanel = new JPanel();
//    editorPanel.setLayout(new GridLayout(0, 1));

    createSubjectPanel(exercisePlanPost.title() + " 결과 기록하기"
        + " (" + exercisePlanPost.date() + ", "
        + exercisePlanPost.exerciseType() + ")");
    createDescriptionOfPlanPanel(exercisePlanPost.description());

    createExerciseTimeAchievementCheckPanel(
        "<목표 운동 시간>", exercisePlanPost.exerciseTime()
    );
    createStopoverPointsAchievementCheckPanel(exercisePlanPost.stopoverPoints());
    createExerciseDistanceAchievementCheckPanel(
        "<목표 운동 거리>", exercisePlanPost.exerciseDistance()
    );
    createFinalResultCheckPanel(
        "<최종 결과>"
    );
    createDescriptionPanel("");
    createButtonsPanel(creation, exercisePlanPost, null, exercisePlanPosts, exerciseRecordPosts);

    mainPanel.add(editorPanel);
//    mainPanel.add(new JPanel());

    this.add(mainPanel);
  }

  public ExerciseRecordPostEditorPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts,
      ExerciseRecordPost exerciseRecordPost, int modification) {
    this.exerciseRecordPosts = exerciseRecordPosts;

    this.setLayout(new BorderLayout());

    initHeaderPanel(exercisePlanPosts, exerciseRecordPost, exerciseRecordPosts);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(1, 3));
//    mainPanel.add(new JPanel());

    editorPanel = new JPanel();
//    editorPanel.setLayout(new GridLayout(0, 1));

    createSubjectPanel(exerciseRecordPost.exercisePlanPost().title() + " 결과 기록하기"
        + " (" + exerciseRecordPost.exercisePlanPost().date() + ", "
        + exerciseRecordPost.exercisePlanPost().exerciseType() + ")");
    createDescriptionOfPlanPanel(exerciseRecordPost.exercisePlanPost().description());

    createExerciseTimeAchievementCheckPanel(
        "<목표 운동 시간>", exerciseRecordPost.exercisePlanPost().exerciseTime()
    );
    createStopoverPointsAchievementCheckPanel(
        exerciseRecordPost.exercisePlanPost().stopoverPoints()
    );
    createExerciseDistanceAchievementCheckPanel(
        "<목표 운동 거리>", exerciseRecordPost.exercisePlanPost().exerciseDistance()
    );
    createFinalResultCheckPanel(
        "<최종 결과>"
    );
    createDescriptionPanel(exerciseRecordPost.description());
    createButtonsPanel(modification, null, exerciseRecordPost, exercisePlanPosts, exerciseRecordPosts);

    mainPanel.add(editorPanel);
//    mainPanel.add(new JPanel());

    this.add(mainPanel);
  }

  public void initHeaderPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    headerPanel = new JPanel();
    headerPanel.setLayout(new BorderLayout());

    createGoBackButton(
        exercisePlanPosts, exercisePlanPost, exerciseRecordPosts
    );

    this.add(headerPanel, BorderLayout.PAGE_START);
  }

  public void createGoBackButton(
      List<ExercisePlanPost> exercisePlanPosts,
      ExercisePlanPost exercisePlanPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JButton goBackButton = new JButton("뒤로가기");

    goBackButton.addActionListener(event -> {
      JPanel exercisePlanPostPanel = new ExercisePlanPostPanel(
          exercisePlanPosts, exercisePlanPost, exerciseRecordPosts
      );

      AerobicExerciseRecords.mainFrame().replaceContentPanel(exercisePlanPostPanel);
    });

    headerPanel.add(goBackButton, BorderLayout.WEST);
  }

  public void initHeaderPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      ExerciseRecordPost exerciseRecordPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    headerPanel = new JPanel();
    headerPanel.setLayout(new BorderLayout());

    createGoBackButton(
        exercisePlanPosts, exerciseRecordPost, exerciseRecordPosts
    );

    this.add(headerPanel, BorderLayout.PAGE_START);
  }

  public void createGoBackButton(
      List<ExercisePlanPost> exercisePlanPosts,
      ExerciseRecordPost exerciseRecordPost,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JButton goBackButton = new JButton("뒤로가기");

    goBackButton.addActionListener(event -> {
      JPanel exerciseRecordPostPanel = new ExerciseRecordPostPanel(
          exercisePlanPosts, exerciseRecordPosts, exerciseRecordPost
      );

      AerobicExerciseRecords.mainFrame().replaceContentPanel(exerciseRecordPostPanel);
    });

    headerPanel.add(goBackButton, BorderLayout.WEST);
  }

  public void createSubjectPanel(String subject) {
    JPanel subjectPanel = new JPanel();

    JLabel subjectLabel = new JLabel(subject);

    subjectLabel.setFont(new Font("", Font.ITALIC, 20));

    subjectPanel.add(subjectLabel);

    editorPanel.add(subjectPanel);
  }

  private void createDescriptionOfPlanPanel(String text) {
    JPanel descriptionPanel = new JPanel();
    descriptionPanel.setLayout(new GridLayout(0, 1));

    descriptionPanel.add(new JLabel("<계획 상세 설명>"));

    JTextArea planDescriptionTextArea = new JTextArea(text);
    planDescriptionTextArea.setColumns(30);
    planDescriptionTextArea.setRows(5);
    planDescriptionTextArea.setLineWrap(true);
    planDescriptionTextArea.setEditable(false);

    JScrollPane scrollPane = new JScrollPane(planDescriptionTextArea);

    scrollPane.createVerticalScrollBar();

    descriptionPanel.add(scrollPane);

    editorPanel.add(descriptionPanel);
  }

  public void createExerciseTimeAchievementCheckPanel(
      String type, String value) {
    JPanel exerciseTimePanel = new JPanel();
    exerciseTimePanel.setLayout(new GridLayout(0, 1));

    exerciseTimePanel.add(new JLabel(type));

    JPanel exerciseTimeAchievementCheckPanel = new JPanel();
    JLabel exerciseTimeLabel = new JLabel(
        value + "      "
    );
    exerciseTimeLabel.setFont(new Font("", Font.PLAIN, 12));
    exerciseTimeLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseTimeAchievementCheckPanel.add(exerciseTimeLabel);

    exerciseTimeAchievementCheckButtonGroup = new ButtonGroup();

    JRadioButton achievedRadioButton = new JRadioButton("달성");
    achievedRadioButton.setFont(new Font("", Font.PLAIN, 12));
    achievedRadioButton.setActionCommand("달성");
    exerciseTimeAchievementCheckButtonGroup.add(achievedRadioButton);
    exerciseTimeAchievementCheckPanel.add(achievedRadioButton);

    JRadioButton notAchievedRadioButton = new JRadioButton("실패");
    notAchievedRadioButton.setFont(new Font("", Font.PLAIN, 12));
    notAchievedRadioButton.setActionCommand("실패");
    exerciseTimeAchievementCheckButtonGroup.add(notAchievedRadioButton);
    exerciseTimeAchievementCheckPanel.add(notAchievedRadioButton);

    exerciseTimePanel.add(exerciseTimeAchievementCheckPanel);

    editorPanel.add(exerciseTimePanel);
  }

  public void createStopoverPointsAchievementCheckPanel(List<String> stopoverPoints) {
    JPanel stopoverPointsPanel = new JPanel();
    stopoverPointsPanel.setLayout(new GridLayout(0, 1));

    stopoverPointsPanel.add(new JLabel("<목표 경유 장소 리스트>"));

    stopoverPointsAchievementCheckButtonGroups = new ArrayList<>();

    JPanel stopoverPointsAchievementCheckPanel = new JPanel();

    for (String stopoverPoint : stopoverPoints) {
      JPanel stopoverPointPanel = new JPanel();
      stopoverPointPanel.setLayout(new GridLayout(0, 1));

      JLabel pointLabel = new JLabel(
//          "경유지 " + (stopoverPoints.indexOf(stopoverPoint) + 1) + ": " +
          stopoverPoint);
      pointLabel.setFont(new Font("", Font.PLAIN, 10));
      stopoverPointPanel.add(pointLabel);

      ButtonGroup stopoverPointsAchievementCheckButtonGroup = new ButtonGroup();

      JRadioButton achievedRadioButton = new JRadioButton("달성");
      achievedRadioButton.setFont(new Font("", Font.PLAIN, 10));
      achievedRadioButton.setActionCommand("달성");

      stopoverPointsAchievementCheckButtonGroup.add(achievedRadioButton);
      stopoverPointPanel.add(achievedRadioButton);

      JRadioButton notAchievedRadioButton = new JRadioButton("실패");
      notAchievedRadioButton.setFont(new Font("", Font.PLAIN, 10));
      notAchievedRadioButton.setActionCommand("실패");

      stopoverPointsAchievementCheckButtonGroup.add(notAchievedRadioButton);
      stopoverPointPanel.add(notAchievedRadioButton);

      stopoverPointsAchievementCheckButtonGroups.add(
          stopoverPointsAchievementCheckButtonGroup
      );
      stopoverPointsAchievementCheckPanel.add(stopoverPointPanel);
    }

    stopoverPointsPanel.add(stopoverPointsAchievementCheckPanel);

    editorPanel.add(stopoverPointsPanel);
  }

  public void createExerciseDistanceAchievementCheckPanel(
      String type, String value) {
    JPanel exerciseDistancePanel = new JPanel();
    exerciseDistancePanel.setLayout(new GridLayout(0, 1));

    exerciseDistancePanel.add(new JLabel(type));

    JPanel exerciseDistanceAchievementCheckPanel = new JPanel();
    JLabel exerciseDistanceLabel = new JLabel(
        value + "      "
    );
    exerciseDistanceLabel.setFont(new Font("", Font.PLAIN, 12));
    exerciseDistanceLabel.setHorizontalAlignment(JLabel.CENTER);

    exerciseDistanceAchievementCheckPanel.add(exerciseDistanceLabel);

    exerciseDistanceAchievementCheckButtonGroup = new ButtonGroup();

    JRadioButton achievedRadioButton = new JRadioButton("달성");
    achievedRadioButton.setFont(new Font("", Font.PLAIN, 12));
    achievedRadioButton.setActionCommand("달성");
    exerciseDistanceAchievementCheckButtonGroup.add(achievedRadioButton);
    exerciseDistanceAchievementCheckPanel.add(achievedRadioButton);

    JRadioButton notAchievedRadioButton = new JRadioButton("실패");
    notAchievedRadioButton.setFont(new Font("", Font.PLAIN, 12));
    notAchievedRadioButton.setActionCommand("실패");
    exerciseDistanceAchievementCheckButtonGroup.add(notAchievedRadioButton);
    exerciseDistanceAchievementCheckPanel.add(notAchievedRadioButton);

    exerciseDistancePanel.add(exerciseDistanceAchievementCheckPanel);

    editorPanel.add(exerciseDistancePanel);
  }

  public void createFinalResultCheckPanel(
      String type) {
    JPanel finalResultPanel = new JPanel();
    finalResultPanel.setLayout(new GridLayout(0, 1));

    finalResultPanel.add(new JLabel(type));

    JPanel finalResultCheckPanel = new JPanel();

    finalResultCheckButtonGroup = new ButtonGroup();

    JRadioButton achievedRadioButton = new JRadioButton("달성");
    achievedRadioButton.setFont(new Font("", Font.PLAIN, 12));
    achievedRadioButton.setActionCommand("달성");
    finalResultCheckButtonGroup.add(achievedRadioButton);
    finalResultCheckPanel.add(achievedRadioButton);

    JRadioButton notAchievedRadioButton = new JRadioButton("실패");
    notAchievedRadioButton.setFont(new Font("", Font.PLAIN, 12));
    notAchievedRadioButton.setActionCommand("실패");
    finalResultCheckButtonGroup.add(notAchievedRadioButton);
    finalResultCheckPanel.add(notAchievedRadioButton);

    finalResultPanel.add(finalResultCheckPanel);

    editorPanel.add(finalResultPanel);
  }

  public void createDescriptionPanel(String description) {
    JPanel descriptionPanel = new JPanel();
    descriptionPanel.setLayout(new GridLayout(0, 1));

    descriptionPanel.add(new JLabel("<기록 상세 설명>"));

    descriptionTextArea = new JTextArea(description);
    descriptionTextArea.setColumns(30);
    descriptionTextArea.setRows(5);
    descriptionTextArea.setLineWrap(true);
    descriptionTextArea.setEditable(true);

    JScrollPane scrollPane = new JScrollPane(descriptionTextArea);

    scrollPane.createVerticalScrollBar();

    descriptionPanel.add(scrollPane);

    editorPanel.add(descriptionPanel);
  }

  public void createButtonsPanel(
      int mode, ExercisePlanPost exercisePlanPost, ExerciseRecordPost toBeModified,
      List<ExercisePlanPost> exercisePlanPosts, List<ExerciseRecordPost> exerciseRecordPosts) {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BorderLayout());

    JButton cancelButton = new JButton("초기화");

    cancelButton.addActionListener(event -> {
      exerciseTimeAchievementCheckButtonGroup.clearSelection();

      for (ButtonGroup stopoverPointsAchievementCheckButtonGroup
          : stopoverPointsAchievementCheckButtonGroups) {
        stopoverPointsAchievementCheckButtonGroup.clearSelection();
      }

      exerciseDistanceAchievementCheckButtonGroup.clearSelection();
      finalResultCheckButtonGroup.clearSelection();
      descriptionTextArea.setText("");

      if (mode == ExerciseRecordPostEditorPanel.MODIFICATION) {
        descriptionTextArea.setText(toBeModified.description());
      }

      dialog.showDialog("초기화 되었습니다.");
    });

    buttonsPanel.add(cancelButton, BorderLayout.WEST);

    JButton registerButton = new JButton("등록하기");

    registerButton.addActionListener(event -> {
      if (notSelectedButtonGroup(exerciseTimeAchievementCheckButtonGroup)
          || notSelectedButtonGroup(exerciseDistanceAchievementCheckButtonGroup)
          || notSelectedButtonGroups(stopoverPointsAchievementCheckButtonGroups)
          || notSelectedButtonGroup(finalResultCheckButtonGroup)
          || descriptionTextArea.getText().equals("")) {
        dialog.showDialog("입력되지 않은 값이 있습니다.");
        return;
      }

      if (mode == ExerciseRecordPostEditorPanel.CREATION) {
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

        ExerciseRecordPost exerciseRecordPost = new ExerciseRecordPost(
            exercisePlanPost, achievedExerciseTime, visitedStopoverPoints,
            achievedExerciseDistance, finalResult, description
        );

        exerciseRecordPosts.add(exerciseRecordPost);

        for (ExercisePlanPost found : exercisePlanPosts) {
          if (found.uniqueNumber() == exercisePlanPost.uniqueNumber()) {
            found.delete();
            break;
          }
        }
      }

      if (mode == ExerciseRecordPostEditorPanel.MODIFICATION) {
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

        for (ExerciseRecordPost found : exerciseRecordPosts) {
          if (found.uniqueNumber() == toBeModified.uniqueNumber()) {
            found.modifyAchievedExerciseTime(achievedExerciseTime);
            found.modifyVisitedStopoverPoints(visitedStopoverPoints);
            found.modifyAchievedExerciseDistance(achievedExerciseDistance);
            found.modifyFinalResult(finalResult);
            found.modifyDescription(description);
            break;
          }
        }
      }

      JPanel seeExerciseRecordPostsPanel = new ExerciseRecordPostsBoardPanel(
          exercisePlanPosts, exerciseRecordPosts
      );
      AerobicExerciseRecords.mainFrame().replaceContentPanel(seeExerciseRecordPostsPanel);

      dialog.showDialog("운동 기록 작성이 완료되었습니다.");
    });
    buttonsPanel.add(registerButton, BorderLayout.EAST);

    editorPanel.add(buttonsPanel);
  }

  public boolean notSelectedButtonGroup(ButtonGroup buttonGroup) {
    Enumeration<AbstractButton> buttons = buttonGroup.getElements();

    while (buttons.hasMoreElements()) {
      AbstractButton button = buttons.nextElement();

      if (button.isSelected()) {
        return false;
      }
    }

    return true;
  }

  public boolean notSelectedButtonGroups(List<ButtonGroup> buttonGroups) {
    for (ButtonGroup buttonGroup : buttonGroups) {
      if (notSelectedButtonGroup(buttonGroup)) {
        return true;
      }
    }

    return false;
  }
}
