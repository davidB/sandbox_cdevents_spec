from __future__ import annotations
from typing import Any, Dict
from . import TestcaserunStarted
class Testcaserun: 
  def __init__(self, input: Dict):
    if 'predicate' in input:
      self._predicate: TestcaserunStarted.TestcaserunStarted = input['predicate']

  @property
  def predicate(self) -> TestcaserunStarted.TestcaserunStarted:
    return self._predicate
  @predicate.setter
  def predicate(self, predicate: TestcaserunStarted.TestcaserunStarted):
    self._predicate = predicate
