from enum import Enum

class TriggerKind(Enum): 
  MANUAL = "manual"
  PIPELINE = "pipeline"
  EVENT = "event"
  SCHEDULE = "schedule"
  OTHER = "other"