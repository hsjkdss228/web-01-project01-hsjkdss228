package utils;

import models.ExercisePlanPost;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLoader {
  public List<ExercisePlanPost> loadPosts() throws FileNotFoundException {
    File file = new File("data/exercise-plan-posts.csv");

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
      String stopoverPoints = components[6];
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

  public int loadCurrentUniqueNumberCount() throws FileNotFoundException {
    File file = new File("data/unique-number-count.csv");

    Scanner scanner = new Scanner(file);

    return scanner.nextInt();
  }
}
