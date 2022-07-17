package application;

import models.Post;
import panels.PostFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class AerobicExerciseRecords {
  private JFrame mainFrame;
  private JPanel contentPanel;

  private List<Post> posts;

  public AerobicExerciseRecords() {
    posts = new ArrayList<>(List.of(
        new Post("작성자명 1", "제목 1", "운동한 날짜 1", "유산소 운동 종류 1",
            "운동한 시간 1", "운동 거리 1", "상세 설명 1"),
        new Post("작성자명 2", "제목 2", "운동한 날짜 2", "유산소 운동 종류 2",
            "운동한 시간 2", "운동 거리 2", "상세 설명 2"),
        new Post("작성자명 3", "제목 3", "운동한 날짜 3", "유산소 운동 종류 3",
            "운동한 시간 3", "운동 거리 3", "상세 설명 3")
    ));
  }

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

    JPanel postTitlesPanel = new JPanel();
    postTitlesPanel.setLayout(new GridLayout(0, 1));

    for (Post post : posts) {
      JLabel titleThumbnailLabel = new JLabel(post.title());
      titleThumbnailLabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          JFrame postFrame = new PostFrame(post);

          postFrame.setVisible(true);
        }
      });

      postTitlesPanel.add(titleThumbnailLabel);
    }

    contentPanel.add(postTitlesPanel);

    mainFrame.add(contentPanel);

    mainFrame.setVisible(true);
  }
}
