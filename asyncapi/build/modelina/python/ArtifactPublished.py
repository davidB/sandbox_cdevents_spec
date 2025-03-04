from __future__ import annotations
from typing import Dict, Optional, Any, Union
from pydantic import BaseModel, Field

class ArtifactPublished(BaseModel): 
  kind: str = Field()
