from __future__ import annotations
from typing import Any, Dict, Optional, Union
from pydantic import BaseModel, Field
from . import ArtifactDeleted
class Artifact(BaseModel): 
  predicate: Optional[Union[Any, ArtifactDeleted.ArtifactDeleted]] = Field(default=None)
