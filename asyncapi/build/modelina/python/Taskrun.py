from __future__ import annotations
from typing import Any, Dict
from . import TaskrunStarted
class Taskrun: 
  def __init__(self, input: Dict):
    if 'predicate' in input:
      self._predicate: TaskrunStarted.TaskrunStarted = input['predicate']

  @property
  def predicate(self) -> TaskrunStarted.TaskrunStarted:
    return self._predicate
  @predicate.setter
  def predicate(self, predicate: TaskrunStarted.TaskrunStarted):
    self._predicate = predicate
