package frames;

import models.ExercisePlanPost;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CreateExercisePlanPostFrame extends JFrame {
  public CreateExercisePlanPostFrame(List<ExercisePlanPost> exercisePlanPosts) {
    this.setSize(500, 500);
    this.setLocation(200, 150);
    this.setLayout(new GridLayout(0, 1));

    JPanel titlePanel = new JPanel();
    titlePanel.add(new JLabel("제목: "));
    JTextField titleTextField = new JTextField(15);
    titlePanel.add(titleTextField);
    this.add(titlePanel);

    JPanel datePanel = new JPanel();
    datePanel.add(new JLabel("날짜: "));
    JTextField dateTextField = new JTextField(15);
    datePanel.add(dateTextField);
    this.add(datePanel);

    JPanel exerciseTypePanel = new JPanel();
    exerciseTypePanel.add(new JLabel("운동 종류: "));
    JTextField exerciseTypeTextField = new JTextField(15);
    exerciseTypePanel.add(exerciseTypeTextField);
    this.add(exerciseTypePanel);

    JPanel exerciseTimePanel = new JPanel();
    exerciseTimePanel.add(new JLabel("목표 운동 시간: "));
    JTextField exerciseTimeTextField = new JTextField(15);
    exerciseTimePanel.add(exerciseTimeTextField);
    this.add(exerciseTimePanel);

    JPanel stopoverPointsPanel = new JPanel();
    stopoverPointsPanel.add(new JLabel("목표 경유 장소: "));
    JTextField stopoverPointsTextField = new JTextField(15);
    stopoverPointsPanel.add(stopoverPointsTextField);
    this.add(stopoverPointsPanel);

    JPanel exerciseDistancePanel = new JPanel();
    exerciseDistancePanel.add(new JLabel("목표 운동 거리: "));
    JTextField exerciseDistanceTextField = new JTextField(15);
    exerciseDistancePanel.add(exerciseDistanceTextField);
    this.add(exerciseDistancePanel);

    JPanel descriptionPanel = new JPanel();
    descriptionPanel.add(new JLabel("상세 설명: "));
    JTextArea descriptionTextArea = new JTextArea();
    descriptionTextArea.setColumns(20);
    descriptionTextArea.setRows(3);
    descriptionTextArea.setLineWrap(true);
    descriptionTextArea.setEditable(true);
    JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
    scrollPane.createVerticalScrollBar();
    descriptionPanel.add(scrollPane);
    this.add(descriptionPanel);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BorderLayout());
    JButton cancelButton = new JButton("취소");
    cancelButton.addActionListener(event -> {

    });
    buttonsPanel.add(cancelButton, BorderLayout.WEST);
    JButton registerButton = new JButton("등록하기");
    registerButton.addActionListener(event -> {

    });
    buttonsPanel.add(registerButton, BorderLayout.EAST);
    this.add(buttonsPanel);

    this.setVisible(true);
  }
}
