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
 * Post
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-25T17:08:44.791029500+05:30[Asia/Calcutta]")

public class Post   {
  @JsonProperty("post")
  private String post;

  public Post post(String post) {
    this.post = post;
    return this;
  }

  /**
   * Get post
   * @return post
  */
  @ApiModelProperty(value = "")


  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Post post = (Post) o;
    return Objects.equals(this.post, post.post);
  }

  @Override
  public int hashCode() {
    return Objects.hash(post);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Post {\n");
    
    sb.append("    post: ").append(toIndentedString(post)).append("\n");
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

