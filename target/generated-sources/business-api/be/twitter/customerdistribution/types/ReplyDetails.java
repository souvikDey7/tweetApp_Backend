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
 * ReplyDetails
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-25T17:08:44.791029500+05:30[Asia/Calcutta]")

public class ReplyDetails   {
  @JsonProperty("_id")
  private String id;

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("reply")
  private String reply;

  public ReplyDetails id(String id) {
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

  public ReplyDetails userId(String userId) {
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

  public ReplyDetails reply(String reply) {
    this.reply = reply;
    return this;
  }

  /**
   * Get reply
   * @return reply
  */
  @ApiModelProperty(value = "")


  public String getReply() {
    return reply;
  }

  public void setReply(String reply) {
    this.reply = reply;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReplyDetails replyDetails = (ReplyDetails) o;
    return Objects.equals(this.id, replyDetails.id) &&
        Objects.equals(this.userId, replyDetails.userId) &&
        Objects.equals(this.reply, replyDetails.reply);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, reply);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplyDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    reply: ").append(toIndentedString(reply)).append("\n");
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

