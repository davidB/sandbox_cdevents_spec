from __future__ import annotations
from typing import Any, Dict
from . import TriggerKind
class Trigger: 
  def __init__(self, input: Dict):
    if 'kind' in input:
      self._kind: TriggerKind.TriggerKind = TriggerKind.TriggerKind(input['kind'])
    if 'uri' in input:
      self._uri: Any = input['uri']
    if 'additional_properties' in input:
      self._additional_properties: dict[str, Any] = input['additional_properties']

  @property
  def kind(self) -> TriggerKind.TriggerKind:
    return self._kind
  @kind.setter
  def kind(self, kind: TriggerKind.TriggerKind):
    self._kind = kind

  @property
  def uri(self) -> Any:
    return self._uri
  @uri.setter
  def uri(self, uri: Any):
    self._uri = uri

  @property
  def additional_properties(self) -> dict[str, Any]:
    return self._additional_properties
  @additional_properties.setter
  def additional_properties(self, additional_properties: dict[str, Any]):
    self._additional_properties = additional_properties
