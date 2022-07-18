package application;

import frames.MainFrame;
import models.ExercisePlanPost;
import utils.FileLoader;
import utils.UniqueNumberManager;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AerobicExerciseRecords {
  private List<ExercisePlanPost> exercisePlanPosts = new ArrayList<>();

  private FileLoader fileLoader;

  private JFrame mainFrame;

  public AerobicExerciseRecords() throws FileNotFoundException {
    fileLoader = new FileLoader();

    UniqueNumberManager.setUniqueNumberCount(fileLoader.loadCurrentUniqueNumberCount());

    System.out.println(UniqueNumberManager.uniqueNumberCount());

    exercisePlanPosts = fileLoader.loadExercisePlanPosts();
  }

  public static void main(String[] args) throws FileNotFoundException {
    AerobicExerciseRecords application = new AerobicExerciseRecords();
    application.run();
  }

  public void run() {
    mainFrame = new MainFrame(exercisePlanPosts, fileLoader);
  }
}
