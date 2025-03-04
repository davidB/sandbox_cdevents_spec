package cdevents;

import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
public class ArtifactDeleted {
  @Size(min=1)
  @JsonProperty("user")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String user;

  public String getUser() { return this.user; }
  public void setUser(String user) { this.user = user; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtifactDeleted self = (ArtifactDeleted) o;
      return 
        Objects.equals(this.user, self.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)user);
  }

  @Override
  public String toString() {
    return "class ArtifactDeleted {\n" +   
      "    user: " + toIndentedString(user) + "\n" +
    "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}