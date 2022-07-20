package application;

import components.MainFrame;
import models.ExercisePlanPost;
import models.ExerciseRecordPost;
import utils.FileLoader;
import utils.UniqueNumberManager;

import java.io.FileNotFoundException;
import java.util.List;

public class AerobicExerciseRecords {
  private List<ExercisePlanPost> exercisePlanPosts;
  private List<ExerciseRecordPost> exerciseRecordPosts;

  private FileLoader fileLoader;

  private static MainFrame mainFrame;

  public static void main(String[] args) throws FileNotFoundException {
    AerobicExerciseRecords application = new AerobicExerciseRecords();
    application.run();
  }

  public AerobicExerciseRecords() throws FileNotFoundException {
    fileLoader = new FileLoader();

    UniqueNumberManager.setUniqueNumberCount(fileLoader.loadCurrentUniqueNumberCount());

    exercisePlanPosts = fileLoader.loadExercisePlanPosts();
    exerciseRecordPosts = fileLoader.loadExerciseRecordPosts(exercisePlanPosts);
  }

  public void run() {
    mainFrame = new MainFrame(exercisePlanPosts, exerciseRecordPosts, fileLoader);
  }

  public static MainFrame mainFrame() {
    return mainFrame;
  }
}
