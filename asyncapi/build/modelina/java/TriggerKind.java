package cdevents;

import com.fasterxml.jackson.annotation.*;
public enum TriggerKind {
  MANUAL((String)"manual"), PIPELINE((String)"pipeline"), EVENT((String)"event"), SCHEDULE((String)"schedule"), OTHER((String)"other");

  private String value;

  TriggerKind(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static TriggerKind fromValue(String value) {
    for (TriggerKind e : TriggerKind.values()) {
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