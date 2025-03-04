from __future__ import annotations
from typing import Any, Dict
from . import ArtifactDeleted
class Artifact: 
  def __init__(self, input: Dict):
    if 'predicate' in input:
      self._predicate: Any | ArtifactDeleted.ArtifactDeleted = input['predicate']

  @property
  def predicate(self) -> Any | ArtifactDeleted.ArtifactDeleted:
    return self._predicate
  @predicate.setter
  def predicate(self, predicate: Any | ArtifactDeleted.ArtifactDeleted):
    self._predicate = predicate
