package components;

import application.AerobicExerciseRecords;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ExerciseRecordPostsBoardPanel extends JPanel {
  private JPanel headerPanel;
  private JPanel postsPanel;

  public ExerciseRecordPostsBoardPanel(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    this.setLayout(new BorderLayout());

    initHeaderPanel(exercisePlanPosts, exerciseRecordPosts);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(1, 3));
    mainPanel.add(new JPanel());

    postsPanel = new JPanel();

    createPostThumbnailPanels(exercisePlanPosts, exerciseRecordPosts);

    mainPanel.add(postsPanel);
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

  private void createPostThumbnailPanels(
      List<ExercisePlanPost> exercisePlanPosts,
      List<ExerciseRecordPost> exerciseRecordPosts) {
    JPanel postThumbnailsPanel = new JPanel();
    postThumbnailsPanel.setLayout(new GridLayout(0, 1));

    JLabel subjectLabel = new JLabel("운동 기록 보기");
    subjectLabel.setHorizontalAlignment(JLabel.CENTER);
    subjectLabel.setFont(new Font("", Font.ITALIC, 30));
    postThumbnailsPanel.add(subjectLabel);
    postThumbnailsPanel.add(new JLabel());

    for (ExerciseRecordPost exerciseRecordPost : exerciseRecordPosts) {
      if (!exerciseRecordPost.deleted()) {
        JPanel postThumbnailPanel = new JPanel();
        postThumbnailPanel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent event) {
            JPanel exerciseRecordPostPanel = new ExerciseRecordPostPanel(
                exercisePlanPosts, exerciseRecordPosts, exerciseRecordPost
            );

            AerobicExerciseRecords.mainFrame().replaceContentPanel(exerciseRecordPostPanel);
          }
        });

        switch (exerciseRecordPost.exercisePlanPost().exerciseType()) {
          case "걷기" -> postThumbnailPanel.add(new JLabel(
              new ImageIcon("data/icons/walking-icon.png")
          ));
          case "달리기" -> postThumbnailPanel.add(new JLabel(
              new ImageIcon("data/icons/running-icon.png")
          ));
          case "자전거" -> postThumbnailPanel.add(new JLabel(
              new ImageIcon("data/icons/cycling-icon.png")
          ));
          case "등산" -> postThumbnailPanel.add(new JLabel(
              new ImageIcon("data/icons/hiking-icon.png")
          ));
        }

        JLabel postThumbnailTitleLabel = new JLabel(
            "    " + exerciseRecordPost.exercisePlanPost().title()
                + "    " + (exerciseRecordPost.finalResult() ? "성공" : "실패")
                + "    " + exerciseRecordPost.exercisePlanPost().date()
        );
        postThumbnailTitleLabel.setFont(new Font("", Font.PLAIN, 25));
        postThumbnailPanel.add(postThumbnailTitleLabel);

        postThumbnailsPanel.add(postThumbnailPanel);
      }
    }

    postsPanel.add(postThumbnailsPanel);
  }
}
