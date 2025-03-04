from __future__ import annotations
from typing import Any, Dict
from . import TestcaseKind
class Testcase: 
  def __init__(self, input: Dict):
    self._id: Any = input['id']
    if 'version' in input:
      self._version: str = input['version']
    if 'name' in input:
      self._name: str = input['name']
    if 'kind' in input:
      self._kind: TestcaseKind.TestcaseKind = TestcaseKind.TestcaseKind(input['kind'])
    if 'uri' in input:
      self._uri: Any = input['uri']

  @property
  def id(self) -> Any:
    return self._id
  @id.setter
  def id(self, id: Any):
    self._id = id

  @property
  def version(self) -> str:
    return self._version
  @version.setter
  def version(self, version: str):
    self._version = version

  @property
  def name(self) -> str:
    return self._name
  @name.setter
  def name(self, name: str):
    self._name = name

  @property
  def kind(self) -> TestcaseKind.TestcaseKind:
    return self._kind
  @kind.setter
  def kind(self, kind: TestcaseKind.TestcaseKind):
    self._kind = kind

  @property
  def uri(self) -> Any:
    return self._uri
  @uri.setter
  def uri(self, uri: Any):
    self._uri = uri
