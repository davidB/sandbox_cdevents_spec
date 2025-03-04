from __future__ import annotations
from typing import Dict

class Context: 
  def __init__(self, input: Dict):
    self._version: str = input['version']
    self._id: str = input['id']
    self._source: str = input['source']
    self._timestamp: str = input['timestamp']
    if 'schema_uri' in input:
      self._schema_uri: str = input['schema_uri']
    if 'chain_id' in input:
      self._chain_id: str = input['chain_id']

  @property
  def version(self) -> str:
    return self._version
  @version.setter
  def version(self, version: str):
    self._version = version

  @property
  def id(self) -> str:
    return self._id
  @id.setter
  def id(self, id: str):
    self._id = id

  @property
  def source(self) -> str:
    return self._source
  @source.setter
  def source(self, source: str):
    self._source = source

  @property
  def timestamp(self) -> str:
    return self._timestamp
  @timestamp.setter
  def timestamp(self, timestamp: str):
    self._timestamp = timestamp

  @property
  def schema_uri(self) -> str:
    return self._schema_uri
  @schema_uri.setter
  def schema_uri(self, schema_uri: str):
    self._schema_uri = schema_uri

  @property
  def chain_id(self) -> str:
    return self._chain_id
  @chain_id.setter
  def chain_id(self, chain_id: str):
    self._chain_id = chain_id
