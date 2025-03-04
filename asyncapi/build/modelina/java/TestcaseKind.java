package cdevents;

import com.fasterxml.jackson.annotation.*;
public enum TestcaseKind {
  PERFORMANCE((String)"performance"), FUNCTIONAL((String)"functional"), UNIT((String)"unit"), SECURITY((String)"security"), COMPLIANCE((String)"compliance"), INTEGRATION((String)"integration"), E2E((String)"e2e"), OTHER((String)"other");

  private String value;

  TestcaseKind(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static TestcaseKind fromValue(String value) {
    for (TestcaseKind e : TestcaseKind.values()) {
      if (e.value.equals(value)) {
        return e;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}