# Requirements Test Case Derivation Template

Use this template to derive test cases from requirements before development begins.

## Template

```markdown
# Requirements Test Cases: [Project Name / Feature Area]

**Version:** [x.y]
**Date:** [YYYY-MM-DD]
**Source Documents:** [SRS version, Use Case document version]

---

## Fit Criteria Review

| Requirement ID | Original Text | Problem | Fit Criterion Added |
|---------------|--------------|---------|-------------------|
| [ID] | "[vague text]" | [Why untestable] | "[measurable criterion]" |

---

## Test Cases from Use Cases

### Use Case: [UC-ID] [Name]

| Test ID | Flow | Given | When | Then |
|---------|------|-------|------|------|
| [TC-id] | Main | [Precondition] | [Action] | [Expected result] |
| [TC-id] | Alternate: [name] | [Precondition] | [Trigger] | [Expected result] |
| [TC-id] | Exception: [name] | [Precondition] | [Trigger] | [Error handling] |

---

## Test Cases from Functional Requirements

### Requirement: [ID] "[text]"

| Test ID | Type | Given | When | Then |
|---------|------|-------|------|------|
| [TC-id] | Positive | [Precondition] | [Valid action] | [Success] |
| [TC-id] | Negative | [Precondition] | [Invalid action] | [Rejection] |
| [TC-id] | Boundary | [Precondition] | [Boundary value] | [Behavior] |

---

## Requirements Gaps Found

| Gap ID | Source | Description | Suggested Resolution |
|--------|--------|-------------|---------------------|
| [GAP-n] | [TC-id] | [What is missing] | [Proposed fix] |

---

## Acceptance Test Summary

| Feature / UC | Total Tests | Critical | High | Medium | Low |
|-------------|------------|----------|------|--------|-----|
| [Feature] | [n] | [n] | [n] | [n] | [n] |
```

## Notes
- Write test cases from requirements, not from code or design.
- Every gap found is a requirements defect. Route it back to the author.
- Boundary tests are especially valuable for constrained data dictionary fields.
