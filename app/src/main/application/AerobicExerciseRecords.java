package application;

import models.Post;
import panels.PostFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AerobicExerciseRecords {
  private JFrame mainFrame;
  private JPanel contentPanel;

  public static void main(String[] args) {
    AerobicExerciseRecords application = new AerobicExerciseRecords();
    application.run();
  }

  public void run() {
    mainFrame = new JFrame("우리 운동합시다!");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(500, 500);
    mainFrame.setLocation(75, 70);

    contentPanel = new JPanel();

    Post post = new Post();

    JPanel postTitlesPanel = new JPanel();

    JLabel titleThumbnailLabel = new JLabel(post.title());
    titleThumbnailLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JFrame postFrame = new PostFrame(post);

        postFrame.setVisible(true);
      }
    });

    postTitlesPanel.add(titleThumbnailLabel);

    contentPanel.add(postTitlesPanel);

    mainFrame.add(contentPanel);

    mainFrame.setVisible(true);
  }
}
