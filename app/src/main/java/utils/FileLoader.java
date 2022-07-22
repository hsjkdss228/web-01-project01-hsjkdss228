package utils;

import models.ExercisePlanPost;
import models.ExerciseRecordPost;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileLoader {
  public int loadCurrentUniqueNumberCount() throws FileNotFoundException {
    File file = new File("data/posts/unique-number-count.csv");

    Scanner scanner = new Scanner(file);

    return scanner.nextInt();
  }

  public List<ExercisePlanPost> loadExercisePlanPosts() throws FileNotFoundException {
    File file = new File("data/posts/exercise-plan-posts.csv");

    Scanner scanner = new Scanner(file);

    List<ExercisePlanPost> exercisePlanPosts = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      String[] components = line.split(",");

      int uniqueNumber = Integer.parseInt(components[0]);
      boolean deleted = Boolean.parseBoolean(components[1]);

      String title = components[2];
      String date = components[3];
      String exerciseType = components[4];
      String exerciseTime = components[5];

      List<String> stopoverPoints = new ArrayList<>(
          Arrays.stream(components[6].split("/")).toList()
      );

      String exerciseDistance = components[7];
      String description = components[8];

      ExercisePlanPost exercisePlanPost = new ExercisePlanPost(
          uniqueNumber, deleted,
          title, date, exerciseType, exerciseTime,
          stopoverPoints, exerciseDistance, description
      );

      exercisePlanPosts.add(exercisePlanPost);
    }

    return exercisePlanPosts;
  }

  public List<ExerciseRecordPost> loadExerciseRecordPosts(
      List<ExercisePlanPost> exercisePlanPosts) throws FileNotFoundException {
    File file = new File("data/posts/exercise-record-posts.csv");

    Scanner scanner = new Scanner(file);

    List<ExerciseRecordPost> exerciseRecordPosts = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      String[] components = line.split(",");

      int uniqueNumber = Integer.parseInt(components[0]);

      ExercisePlanPost exercisePlanPost = null;
      for (ExercisePlanPost found : exercisePlanPosts) {
        if (found.uniqueNumber() == uniqueNumber) {
          exercisePlanPost = found;
        }
      }

      boolean deleted = Boolean.parseBoolean(components[1]);

      boolean achievedExerciseTime = Boolean.parseBoolean(components[2]);

      String[] visitedStopoverPointsBeforeCasting = components[3].split("/");

      List<Boolean> visitedStopoverPoints = new ArrayList<>();

      for (String visitedStopoverPoint : visitedStopoverPointsBeforeCasting) {
        visitedStopoverPoints.add(Boolean.parseBoolean(visitedStopoverPoint));
      }

      boolean achievedExerciseDistance = Boolean.parseBoolean(components[4]);
      boolean finalResult = Boolean.parseBoolean(components[5]);
      String description = components[6];

      ExerciseRecordPost exerciseRecordPost = new ExerciseRecordPost(
          exercisePlanPost, uniqueNumber, deleted,
          achievedExerciseTime, visitedStopoverPoints, achievedExerciseDistance,
          finalResult, description
      );

      exerciseRecordPosts.add(exerciseRecordPost);
    }

    return exerciseRecordPosts;
  }

  public void saveCurrentUniqueNumberCount() throws IOException {
    FileWriter fileWriter = new FileWriter("data/posts/unique-number-count.csv");

    String uniqueNumberCount = Integer.toString(UniqueNumberManager.uniqueNumberCount());

    fileWriter.write(uniqueNumberCount + "\n");

    fileWriter.close();
  }

  public void saveExercisePlanPosts(
      List<ExercisePlanPost> exercisePlanPosts) throws IOException {
    FileWriter fileWriter = new FileWriter("data/posts/exercise-plan-posts.csv");

    for (ExercisePlanPost exercisePlanPost : exercisePlanPosts) {
      String line = exercisePlanPost.uniqueNumber() + ","
          + exercisePlanPost.deleted() + ","
          + exercisePlanPost.title() + ","
          + exercisePlanPost.date() + ","
          + exercisePlanPost.exerciseType() + ","
          + exercisePlanPost.exerciseTime() + ","

          + String.join("/", exercisePlanPost.stopoverPoints()) + ","

          + exercisePlanPost.exerciseDistance() + ","
          + exercisePlanPost.description() + "\n";

      fileWriter.write(line);
    }

    fileWriter.close();
  }

  public void saveExerciseRecordPosts
      (List<ExerciseRecordPost> exerciseRecordPosts) throws IOException {
    FileWriter fileWriter = new FileWriter("data/posts/exercise-record-posts.csv");

    for (ExerciseRecordPost exerciseRecordPost : exerciseRecordPosts) {
      List<Boolean> visitedStopoverPoints = exerciseRecordPost.visitedStopoverPoints();

      String visitedStopoverPointsAfterJoining = "";

      for (Boolean visitedStopoverPoint : visitedStopoverPoints) {
        visitedStopoverPointsAfterJoining += visitedStopoverPoint + "/";
      }

      visitedStopoverPointsAfterJoining = visitedStopoverPointsAfterJoining.substring(
          0, visitedStopoverPointsAfterJoining.length() - 1
      );

      String line = exerciseRecordPost.uniqueNumber() + ","
          + exerciseRecordPost.deleted() + ","
          + exerciseRecordPost.achievedExerciseTime() + ","
          + visitedStopoverPointsAfterJoining + ","
          + exerciseRecordPost.achievedExerciseDistance() + ","
          + exerciseRecordPost.finalResult() + ","
          + exerciseRecordPost.description() + "\n";

      fileWriter.write(line);
    }

    fileWriter.close();
  }
}
