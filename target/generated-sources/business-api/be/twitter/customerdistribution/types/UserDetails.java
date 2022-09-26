package be.twitter.customerdistribution.types;

import java.util.Objects;
import be.twitter.customerdistribution.types.Credential;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserDetails
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-25T17:08:44.791029500+05:30[Asia/Calcutta]")

public class UserDetails   {
  @JsonProperty("First Name")
  private String firstName;

  @JsonProperty("last name")
  private String lastName;

  @JsonProperty("Email")
  private String email;

  @JsonProperty("ContactNumber")
  private Integer contactNumber;

  @JsonProperty("cridential")
  private Credential cridential;

  public UserDetails firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserDetails lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserDetails email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserDetails contactNumber(Integer contactNumber) {
    this.contactNumber = contactNumber;
    return this;
  }

  /**
   * Get contactNumber
   * @return contactNumber
  */
  @ApiModelProperty(value = "")


  public Integer getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(Integer contactNumber) {
    this.contactNumber = contactNumber;
  }

  public UserDetails cridential(Credential cridential) {
    this.cridential = cridential;
    return this;
  }

  /**
   * Get cridential
   * @return cridential
  */
  @ApiModelProperty(value = "")

  @Valid

  public Credential getCridential() {
    return cridential;
  }

  public void setCridential(Credential cridential) {
    this.cridential = cridential;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDetails userDetails = (UserDetails) o;
    return Objects.equals(this.firstName, userDetails.firstName) &&
        Objects.equals(this.lastName, userDetails.lastName) &&
        Objects.equals(this.email, userDetails.email) &&
        Objects.equals(this.contactNumber, userDetails.contactNumber) &&
        Objects.equals(this.cridential, userDetails.cridential);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email, contactNumber, cridential);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDetails {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    contactNumber: ").append(toIndentedString(contactNumber)).append("\n");
    sb.append("    cridential: ").append(toIndentedString(cridential)).append("\n");
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

