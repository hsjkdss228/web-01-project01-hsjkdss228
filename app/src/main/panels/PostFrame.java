package panels;

import models.Post;

import javax.swing.*;
import java.awt.*;

public class PostFrame extends JFrame {
  public PostFrame(Post post) {
    this.setSize(500, 500);
    this.setLocation(700, 70);
    this.setLayout(new GridLayout(0, 1));

    JLabel writerTextField = new JLabel(post.writer());
    this.add(writerTextField);

    JLabel titleLabel = new JLabel(post.title());
    this.add(titleLabel);

    JLabel dateLabel = new JLabel(post.date());
    this.add(dateLabel);

    JLabel exerciseTypeLabel = new JLabel(post.exerciseType());
    this.add(exerciseTypeLabel);

    JLabel exerciseTimeLabel = new JLabel(post.exerciseTime());
    this.add(exerciseTimeLabel);

    JLabel exerciseDistanceLabel = new JLabel(post.exerciseDistance());
    this.add(exerciseDistanceLabel);

    JTextArea descriptionTextArea = new JTextArea(post.description());
    descriptionTextArea.setEditable(false);
    this.add(descriptionTextArea);
  }
}
