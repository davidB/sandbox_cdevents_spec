from __future__ import annotations
from typing import Dict

class ArtifactDeleted: 
  def __init__(self, input: Dict):
    if 'user' in input:
      self._user: str = input['user']

  @property
  def user(self) -> str:
    return self._user
  @user.setter
  def user(self, user: str):
    self._user = user
