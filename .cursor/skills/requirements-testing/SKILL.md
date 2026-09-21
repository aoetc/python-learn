---
name: requirements-testing
description: Derive test cases from requirements, use cases, and business rules to verify testability and completeness. Use when you need to validate that requirements are verifiable and to plan acceptance testing early.
intent: >-
  Derive test cases directly from requirements documents before any code is written. Use this to verify that every requirement is testable, to expose ambiguous or incomplete requirements through the discipline of writing concrete test steps, and to produce an early acceptance test plan. Includes techniques for deriving tests from use cases, functional requirements, business rules, and quality attributes. Ensures that fit criteria are defined for every requirement.
type: component
theme: re-artifacts
best_for:
  - "Verifying that requirements are testable before development begins"
  - "Deriving acceptance test cases from use cases and functional requirements"
  - "Exposing ambiguous or incomplete requirements through test case writing"
scenarios:
  - "I need to verify requirements are complete and testable before handing them to developers"
  - "The QA team wants to start acceptance test planning but development has not begun"
  - "Requirements contain vague terms like 'fast' and 'user-friendly' that need fit criteria"
estimated_time: "30-60 min per use case or requirement group"
---


## Purpose
Derive test cases directly from requirements before code is written. Use this to verify that every requirement is testable, expose requirements that are too vague to test, and produce an early acceptance test plan that aligns development with stakeholder expectations.

This is not a software testing methodology -- it is a requirements quality technique. The act of writing tests from requirements reveals defects in the requirements themselves: ambiguity, incompleteness, and untestable statements.

## Key Concepts

### Testability as a Quality Attribute

A requirement is testable if and only if there exists a finite, cost-effective process to determine whether the implemented system satisfies it.

**Testable:**
```
The system shall display search results within 3 seconds for
queries returning up to 1000 chemical records.
```

**Not testable:**
```
The system shall display search results quickly.
```

The difference is a **fit criterion** -- a quantified, measurable threshold that defines what "quickly" means.

### Fit Criteria

Every requirement needs a fit criterion that makes it objectively verifiable:

| Requirement Type | Fit Criterion Example |
|-----------------|---------------------|
| Performance | Response time <= 3 seconds for 95% of queries |
| Usability | New users complete core task within 5 minutes without help |
| Reliability | System uptime >= 99.5% measured monthly |
| Capacity | Support 500 concurrent users with no degradation |
| Functional | Chemical added to inventory appears in search results within 1 minute |

### Test Case Derivation Sources

| Source | Derivation Method |
|--------|------------------|
| Use cases | One test per main flow + one per alternate/exception flow |
| Functional requirements | One or more tests per "shall" statement |
| Business rules | One test per rule outcome + boundary tests |
| State models | One test per valid transition + one per invalid transition |
| Data dictionary | Boundary value tests for each constrained field |
| Quality attributes | Measurable tests against fit criteria |

### Writing Tests Before Code

Conceptual testing (writing tests from requirements, before code) serves several purposes:
1. **Validates testability** -- If you cannot write a test, the requirement is defective
2. **Exposes ambiguity** -- Writing concrete test steps forces you to resolve vague terms
3. **Discovers missing requirements** -- Test scenarios reveal conditions the requirements did not address
4. **Creates acceptance criteria** -- Tests become the definition of "done" for each requirement

### Why This Works

Writing test cases forces a level of precision that requirements writing alone does not demand. When you try to write "Given [precondition], When [action], Then [expected result]," you discover that the requirement did not specify the precondition, the action is ambiguous, or the expected result is undefined.

### Anti-Patterns
- **Untestable Requirements** -- Requirements containing "appropriate," "user-friendly," "fast," "intuitive" with no fit criteria
- **Tests After Code** -- Writing tests only after implementation, which validates implementation rather than requirements
- **Happy Path Only** -- Deriving tests only from main use case flows, ignoring exception and error cases
- **Missing Boundary Tests** -- Testing only typical values, not boundary and invalid values

## Application

Use `template.md` for the fill-in structure.

### Step 1: Inventory Requirements to Test

Gather all testable sources:
- Functional requirements ("shall" statements)
- Use cases (main, alternate, and exception flows)
- Business rules
- Quality attribute requirements
- Data constraints from the data dictionary (`skills/data-dictionary/SKILL.md`)

### Step 2: Assign Fit Criteria to Vague Requirements

For every requirement that contains an unmeasurable term, define a fit criterion:

| Original Requirement | Problem | Fit Criterion |
|---------------------|---------|---------------|
| "System shall be fast" | "Fast" is subjective | "Search results display within 3 seconds for up to 1000 records" |
| "System shall be easy to use" | "Easy" is subjective | "New user completes Add Chemical task within 5 minutes without training" |
| "System shall handle large volumes" | "Large" is undefined | "System supports 10,000 chemical records with no performance degradation" |

### Step 3: Derive Tests from Use Cases

For each use case, generate tests:

**Main flow test:** Execute the use case steps as described. Verify all postconditions.

**Alternate flow tests:** One test per alternate flow. Verify the alternate postconditions.

**Exception flow tests:** One test per exception flow. Verify error handling and recovery.

**Boundary tests:** For each input in the use case, test boundary values.

### Step 4: Derive Tests from Functional Requirements

For each "shall" statement:
```
Given: [Precondition -- the system state before the test]
When:  [Action -- what the user or system does]
Then:  [Expected Result -- the observable outcome]
```

Generate at minimum:
- One positive test (requirement is satisfied)
- One negative test (what happens when the condition is not met)
- Boundary tests for any numeric, date, or string constraints

### Step 5: Derive Tests from Business Rules

For each business rule (`skills/business-rule/SKILL.md`):
- Test each outcome of the rule
- Test boundary conditions for all thresholds
- Test combinations if multiple conditions interact (use decision tables from `skills/decision-table/SKILL.md`)

### Step 6: Compile Acceptance Test Plan

Organize derived tests into an acceptance test plan:
1. Group tests by feature or use case
2. Assign priority (critical path tests first)
3. Identify test data requirements
4. Identify environment requirements
5. Define pass/fail criteria for the overall system

### Step 7: Validate Requirements Through Tests

Review the test suite to find requirements issues:
- [ ] Every requirement has at least one test case
- [ ] Every test case has concrete expected results (no "system behaves appropriately")
- [ ] Boundary values are tested for all constrained inputs
- [ ] Exception flows have corresponding test cases
- [ ] Quality attributes have measurable fit criteria with corresponding tests
- [ ] Any requirement that cannot be tested is flagged for rewriting

---

## Examples

See `examples/sample.md` for complete test case derivations for ChemTrack.

Mini example:

```markdown
## Requirement: CT-FR-12
"The system shall prevent users from assigning a chemical to an experiment
if the chemical's expiration date is earlier than the experiment's start date."

### Test Cases:

**TC-12.1: Expired chemical blocked (positive test)**
- Given: Chemical "Acetone" expires 2026-01-15; Experiment starts 2026-02-01
- When: User assigns Acetone to the experiment
- Then: System rejects with message "Chemical expires before experiment start date"

**TC-12.2: Valid chemical accepted (negative test for the rule)**
- Given: Chemical "Acetone" expires 2026-06-15; Experiment starts 2026-02-01
- When: User assigns Acetone to the experiment
- Then: System accepts the assignment

**TC-12.3: Same-day boundary**
- Given: Chemical "Acetone" expires 2026-02-01; Experiment starts 2026-02-01
- When: User assigns Acetone to the experiment
- Then: [REQUIREMENT GAP: Does "earlier than" include same day?]
```

Note how TC-12.3 exposes a missing requirement -- the original requirement does not specify whether "earlier than" includes the exact same day.

## Common Pitfalls

### Pitfall 1: Untestable Requirements Accepted
**Symptom:** Requirements like "the system shall be user-friendly" are approved without fit criteria.

**Consequence:** No way to verify the requirement. Acceptance testing becomes subjective. Disputes about whether the requirement is met.

**Fix:** Every requirement must have a fit criterion. If stakeholders cannot define "user-friendly" in measurable terms, facilitate a discussion to establish specific, testable criteria.

---

### Pitfall 2: Tests Only for Happy Path
**Symptom:** Test cases cover the main flow of each use case but ignore alternate and exception flows.

**Consequence:** Error handling, edge cases, and recovery paths are untested. These are where most production defects occur.

**Fix:** Derive at least one test per alternate flow and one per exception flow. Use state models (`skills/state-modeling/SKILL.md`) to identify error transitions.

---

### Pitfall 3: No Boundary Testing
**Symptom:** Tests use only typical mid-range values (e.g., quantity = 5) and never test boundaries (0, 1, maximum, maximum+1).

**Consequence:** Off-by-one errors, overflow conditions, and empty-set cases go undetected until production.

**Fix:** For every constrained field in the data dictionary, generate boundary tests: minimum, minimum-1, maximum, maximum+1, zero, empty, null.

---

### Pitfall 4: Tests Written After Development
**Symptom:** Test cases are written after the code is complete, based on what the system does rather than what it should do.

**Consequence:** Tests validate the implementation, not the requirements. Requirements defects are coded into the system and verified by the tests.

**Fix:** Write conceptual test cases during requirements analysis, before development. Use test-writing as a requirements validation technique.

## References

### Related Skills
- `skills/use-case/SKILL.md` -- Use cases are a primary source for test case derivation
- `skills/business-rule/SKILL.md` -- Business rules generate rule-outcome test cases
- `skills/decision-table/SKILL.md` -- Decision tables ensure coverage of all condition combinations
- `skills/specification-review-checklist/SKILL.md` -- Testability is a key quality attribute checked during reviews
- `skills/acceptance-criteria/SKILL.md` -- Acceptance criteria and fit criteria are complementary

### External Frameworks
- Karl Wiegers & Joy Beatty, *Software Requirements, Third Edition* (2013) -- Chapter 17: Beyond Requirements Development (conceptual testing)
- Glenford Myers, *The Art of Software Testing* (2011) -- Boundary value analysis and equivalence partitioning
- Volere Requirements Specification Template -- Fit criteria methodology

---

**Skill type:** Component
**Dependencies:** References `skills/use-case/SKILL.md`, `skills/business-rule/SKILL.md`, `skills/decision-table/SKILL.md`
**Used by:** `skills/requirements-validation-process/SKILL.md`, `skills/acceptance-criteria/SKILL.md`
