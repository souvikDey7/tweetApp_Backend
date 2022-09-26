package be.twitter.customerdistribution.types;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PostDetails
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-25T17:08:44.791029500+05:30[Asia/Calcutta]")

public class PostDetails   {
  @JsonProperty("_id")
  private String id;

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("postData")
  private String postData;

  @JsonProperty("like")
  private Integer like;

  @JsonProperty("time")
  private String time;

  public PostDetails id(String id) {
    this.id = id;
    return this;
  }

  /**
   * post id
   * @return id
  */
  @ApiModelProperty(value = "post id")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PostDetails userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @ApiModelProperty(value = "")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public PostDetails postData(String postData) {
    this.postData = postData;
    return this;
  }

  /**
   * Get postData
   * @return postData
  */
  @ApiModelProperty(value = "")


  public String getPostData() {
    return postData;
  }

  public void setPostData(String postData) {
    this.postData = postData;
  }

  public PostDetails like(Integer like) {
    this.like = like;
    return this;
  }

  /**
   * Get like
   * @return like
  */
  @ApiModelProperty(value = "")


  public Integer getLike() {
    return like;
  }

  public void setLike(Integer like) {
    this.like = like;
  }

  public PostDetails time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  */
  @ApiModelProperty(value = "")


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostDetails postDetails = (PostDetails) o;
    return Objects.equals(this.id, postDetails.id) &&
        Objects.equals(this.userId, postDetails.userId) &&
        Objects.equals(this.postData, postDetails.postData) &&
        Objects.equals(this.like, postDetails.like) &&
        Objects.equals(this.time, postDetails.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, postData, like, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    postData: ").append(toIndentedString(postData)).append("\n");
    sb.append("    like: ").append(toIndentedString(like)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

