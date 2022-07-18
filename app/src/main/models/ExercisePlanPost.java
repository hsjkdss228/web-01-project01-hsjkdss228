package models;

import utils.UniqueNumberManager;

public class ExercisePlanPost {
  private int uniqueNumber;
  private boolean deleted;

  private String title = "제목";
  private String date = "운동한 날짜";
  private String exerciseType = "유산소 운동 종류";
  private String exerciseTime = "운동한 시간";
  private String stopoverPoints = "경유지";
  private String exerciseDistance = "운동 거리";
  private String description = "상세 설명";

  public ExercisePlanPost() {
    this.uniqueNumber = UniqueNumberManager.makeUniqueNumber();
    this.deleted = false;
  }

  public ExercisePlanPost(String title, String date, String exerciseType, String exerciseTime,
                          String stopoverPoints, String exerciseDistance, String description) {
    this.uniqueNumber = UniqueNumberManager.makeUniqueNumber();
    this.deleted = false;

    this.title = title;
    this.date = date;
    this.exerciseType = exerciseType;
    this.exerciseTime = exerciseTime;
    this.stopoverPoints = stopoverPoints;
    this.exerciseDistance = exerciseDistance;
    this.description = description;
  }

  public ExercisePlanPost(int uniqueNumber, boolean deleted, String title, String date,
                          String exerciseType,  String exerciseTime, String stopoverPoints,
                          String exerciseDistance, String description) {
    this.uniqueNumber = uniqueNumber;
    this.deleted = deleted;

    this.title = title;
    this.date = date;
    this.exerciseType = exerciseType;
    this.exerciseTime = exerciseTime;
    this.stopoverPoints = stopoverPoints;
    this.exerciseDistance = exerciseDistance;
    this.description = description;
  }

  public int uniqueNumber() {
    return uniqueNumber;
  }

  public boolean deleted() {
    return deleted;
  }

  public String title() {
    return title;
  }

  public String date() {
    return date;
  }

  public String exerciseType() {
    return exerciseType;
  }

  public String exerciseTime() {
    return exerciseTime;
  }

  public String stopoverPoints() {
    return stopoverPoints;
  }

  public String exerciseDistance() {
    return exerciseDistance;
  }

  public String description() {
    return description;
  }

  public void modifyTitle(String title) {
    this.title = title;
  }

  public void modifyDate(String date) {
    this.date = date;
  }

  public void modifyExerciseType(String exerciseType) {
    this.exerciseType = exerciseType;
  }

  public void modifyExerciseTime(String exerciseTime) {
    this.exerciseTime = exerciseTime;
  }

  public void modifyStopoverPoints(String stopoverPoints) {
    this.stopoverPoints = stopoverPoints;
  }

  public void modifyExerciseDistance(String exerciseDistance) {
    this.exerciseDistance = exerciseDistance;
  }

  public void modifyDescription(String description) {
    this.description = description;
  }

  public void delete() {
    this.deleted = true;
  }
}
