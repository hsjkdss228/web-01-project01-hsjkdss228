package models;

public class ExerciseRecordPost {
  private ExercisePlanPost exercisePlanPost;

  private int uniqueNumber;
  private boolean deleted;

  private boolean achievedExerciseTime;
  private boolean visitedAllStopoverPoints;
  private boolean achievedExerciseDistance;
  private boolean finalResult;
  private String description;

  private boolean isPublicPost;

  public ExerciseRecordPost(
      ExercisePlanPost exercisePlanPost,
      boolean achievedExerciseTime, boolean visitedAllStopoverPoints,
      boolean achievedExerciseDistance, boolean finalResult,
      String description, boolean isPublicPost) {
    this.exercisePlanPost = exercisePlanPost;

    this.uniqueNumber = this.exercisePlanPost.uniqueNumber();
    this.deleted = false;

    this.achievedExerciseTime = achievedExerciseTime;
    this.visitedAllStopoverPoints = visitedAllStopoverPoints;
    this.achievedExerciseDistance = achievedExerciseDistance;
    this.finalResult = finalResult;
    this.description = description;

    this.isPublicPost = isPublicPost;
  }

  public ExerciseRecordPost(
      ExercisePlanPost exercisePlanPost, int uniqueNumber, boolean deleted,
      boolean achievedExerciseTime, boolean visitedAllStopoverPoints,
      boolean achievedExerciseDistance, boolean finalResult,
      String description, boolean isPublicPost) {
    this.exercisePlanPost = exercisePlanPost;

    this.uniqueNumber = uniqueNumber;
    this.deleted = deleted;

    this.achievedExerciseTime = achievedExerciseTime;
    this.visitedAllStopoverPoints = visitedAllStopoverPoints;
    this.achievedExerciseDistance = achievedExerciseDistance;
    this.finalResult = finalResult;
    this.description = description;

    this.isPublicPost = isPublicPost;
  }

  public ExercisePlanPost exercisePlanPost() {
    return exercisePlanPost;
  }

  public int uniqueNumber() {
    return uniqueNumber;
  }

  public boolean deleted() {
    return deleted;
  }

  public boolean achievedExerciseTime() {
    return achievedExerciseTime;
  }

  public boolean visitedAllStopoverPoints() {
    return visitedAllStopoverPoints;
  }

  public boolean achievedExerciseDistance() {
    return achievedExerciseDistance;
  }

  public boolean finalResult() {
    return finalResult;
  }

  public String description() {
    return description;
  }

  public boolean isPublicPost() {
    return isPublicPost;
  }
}
