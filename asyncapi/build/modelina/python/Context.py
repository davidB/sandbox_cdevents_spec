from __future__ import annotations
from typing import Dict, Optional, Any, Union
from pydantic import BaseModel, Field

class Context(BaseModel): 
  version: str = Field()
  id: str = Field()
  source: str = Field()
  timestamp: str = Field(description='''Scalar string in the format specified in [RFC 3339](https://datatracker.ietf.org/doc/html/rfc3339)
  ''')
  schema_uri: Optional[str] = Field(default=None)
  chain_id: Optional[str] = Field(default=None)
