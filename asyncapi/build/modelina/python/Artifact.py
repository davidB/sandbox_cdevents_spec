from __future__ import annotations
from typing import Dict, Optional, Any, Union
from pydantic import BaseModel, Field
from . import ArtifactPublished
from . import ArtifactDeleted
class Artifact(BaseModel): 
  predicate: Optional[Union[ArtifactPublished.ArtifactPublished, ArtifactDeleted.ArtifactDeleted]] = Field(default=None)
