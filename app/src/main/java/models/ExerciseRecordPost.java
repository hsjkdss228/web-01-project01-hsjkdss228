package models;

public class ExerciseRecordPost {
  private ExercisePlanPost exercisePlanPost;

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
}
