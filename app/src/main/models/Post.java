package models;

public class Post {
  private String writer = "작성자명";
  private String title = "제목";
  private String date = "운동한 날짜";
  private String exerciseType = "유산소 운동 종류";
  private String exerciseTime = "운동한 시간";
  private String exerciseDistance = "운동 거리";
  private String description = "상세 설명";

  public Post() {

  }

  public String writer() {
    return writer;
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

  public String exerciseDistance() {
    return exerciseDistance;
  }

  public String description() {
    return description;
  }
}
