from enum import Enum

class TestcaseKind(Enum): 
  PERFORMANCE = "performance"
  FUNCTIONAL = "functional"
  UNIT = "unit"
  SECURITY = "security"
  COMPLIANCE = "compliance"
  INTEGRATION = "integration"
  E2E = "e2e"
  OTHER = "other"