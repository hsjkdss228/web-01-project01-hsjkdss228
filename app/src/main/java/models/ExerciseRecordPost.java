package models;

import java.util.List;

public class ExerciseRecordPost {
  private ExercisePlanPost exercisePlanPost;

  private int uniqueNumber;
  private boolean deleted;

  private boolean achievedExerciseTime;
  private List<Boolean> visitedStopoverPoints;
  private boolean achievedExerciseDistance;
  private boolean finalResult;
  private String description;

  private boolean isPublicPost;

  public ExerciseRecordPost(
      ExercisePlanPost exercisePlanPost,
      boolean achievedExerciseTime, List<Boolean> visitedStopoverPoints,
      boolean achievedExerciseDistance, boolean finalResult,
      String description, boolean isPublicPost) {
    this.exercisePlanPost = exercisePlanPost;

    this.uniqueNumber = this.exercisePlanPost.uniqueNumber();
    this.deleted = false;

    this.achievedExerciseTime = achievedExerciseTime;
    this.visitedStopoverPoints = visitedStopoverPoints;
    this.achievedExerciseDistance = achievedExerciseDistance;
    this.finalResult = finalResult;
    this.description = description;

    this.isPublicPost = isPublicPost;
  }

  public ExerciseRecordPost(
      ExercisePlanPost exercisePlanPost, int uniqueNumber, boolean deleted,
      boolean achievedExerciseTime, List<Boolean> visitedStopoverPoints,
      boolean achievedExerciseDistance, boolean finalResult,
      String description, boolean isPublicPost) {
    this.exercisePlanPost = exercisePlanPost;

    this.uniqueNumber = uniqueNumber;
    this.deleted = deleted;

    this.achievedExerciseTime = achievedExerciseTime;
    this.visitedStopoverPoints = visitedStopoverPoints;
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

  public List<Boolean> visitedStopoverPoints() {
    return visitedStopoverPoints;
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

  public void delete() {
    deleted = true;
  }

  public void modifyAchievedExerciseTime(boolean achievedExerciseTime) {
    this.achievedExerciseTime = achievedExerciseTime;
  }

  public void modifyVisitedStopoverPoints(List<Boolean> visitedStopoverPoints) {
    this.visitedStopoverPoints = visitedStopoverPoints;
  }

  public void modifyAchievedExerciseDistance(boolean achievedExerciseDistance) {
    this.achievedExerciseDistance = achievedExerciseDistance;
  }

  public void modifyFinalResult(boolean finalResult) {
    this.finalResult = finalResult;
  }

  public void modifyDescription(String description) {
    this.description = description;
  }

  public void modifyPrivacyOfPost(boolean isPublicPost) {
    this.isPublicPost = isPublicPost;
  }
}
