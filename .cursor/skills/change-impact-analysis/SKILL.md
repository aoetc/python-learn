---
name: change-impact-analysis
description: Assess the implications, affected work products, and effort for a proposed requirements change. Use when a change request arrives and you need to determine whether to approve, defer, or reject it.
intent: >-
  Guide requirements engineers through a structured three-step impact analysis for proposed requirements changes. Covers the implications checklist, identification of all affected work products, and estimation of schedule and cost impact. Includes the 18 standard change request attributes from Wiegers. Use this when a change request arrives and the change control board needs a thorough assessment before making an approve/defer/reject decision.
type: component
theme: re-artifacts
best_for:
  - "Assessing the full impact of a proposed change before committing to it"
  - "Preparing change request packages for the change control board"
  - "Identifying all work products affected by a requirements change"
scenarios:
  - "A stakeholder wants to add a new feature mid-sprint -- I need to assess the ripple effects"
  - "The change control board needs a formal impact analysis before approving a change request"
  - "A regulatory change affects our requirements -- I need to know what else it touches"
estimated_time: "30-60 min per change request"
---


## Purpose
Guide requirements engineers through a structured impact analysis for proposed requirements changes. This is the analytical backbone of change control -- without it, change decisions are based on gut feeling, and scope creep proceeds unchecked.

This is not a bureaucratic form-filling exercise. It is a systematic assessment that ensures every change decision is informed by an understanding of what the change will really cost, what it will affect, and what risks it introduces.

## Key Concepts

### Three-Step Impact Analysis

Wiegers defines a three-step procedure for analyzing any proposed change:

1. **Implications analysis** -- What are the direct and indirect consequences of this change?
2. **Affected work products** -- Which documents, designs, code modules, and test cases must be modified?
3. **Effort estimation** -- How much work is required, and what is the schedule and cost impact?

### Change Request Attributes (18 Fields)

A complete change request record contains:

| # | Attribute | Description |
|---|-----------|-------------|
| 1 | Change request ID | Unique identifier (CR-001) |
| 2 | Date submitted | When the request was filed |
| 3 | Requester | Who submitted the request |
| 4 | Change type | Enhancement, defect correction, constraint change, interface change |
| 5 | Description | What change is being requested |
| 6 | Rationale | Why this change is needed |
| 7 | Priority | Urgency of the change (Critical/High/Medium/Low) |
| 8 | Requirements affected | Which requirements are directly changed |
| 9 | Other work products affected | Designs, code, tests, user docs, training materials |
| 10 | Implications | Side effects, ripple effects, new risks |
| 11 | Estimated effort | Person-hours or story points to implement |
| 12 | Estimated schedule impact | Days or sprints added to the timeline |
| 13 | Estimated cost impact | Dollar cost or budget percentage |
| 14 | Risks introduced | New technical or business risks |
| 15 | Dependencies | Other changes or features this depends on |
| 16 | Alternatives considered | Other ways to address the underlying need |
| 17 | Status | Submitted, Under Review, Approved, Rejected, Deferred, Implemented |
| 18 | Resolution and rationale | Final decision and reasoning |

### Implications Checklist

For each proposed change, systematically evaluate:

- [ ] Does this change conflict with any existing requirement?
- [ ] Does this change affect any quality attribute (performance, security, usability)?
- [ ] Does this change require changes to the system architecture?
- [ ] Does this change affect interfaces with external systems?
- [ ] Does this change alter business rules already documented?
- [ ] Does this change introduce new regulatory or compliance obligations?
- [ ] Does this change affect user documentation or training materials?
- [ ] Does this change invalidate any existing test cases?
- [ ] Does this change affect requirements already implemented and deployed?
- [ ] Does this change create a dependency on another incomplete feature?

### Why This Works
- **Prevents hidden costs** -- Many changes look small but have large ripple effects. The three-step process surfaces these before committing.
- **Supports informed decisions** -- The change control board sees full implications, not just the requester's optimistic framing.
- **Creates traceability** -- The 18 attributes provide a complete record for audits and retrospectives.
- **Enables comparison** -- When multiple changes compete for limited capacity, impact analyses provide a basis for comparison.

### Anti-Patterns
- **Rubber Stamp CCB** -- The change control board approves everything without reviewing impact analysis. Changes accumulate faster than capacity.
- **Gold-Plated Analysis** -- Spending 8 hours analyzing a 2-hour change. Scale the analysis to the size and risk of the change.
- **Missing Traceability** -- Impact analysis done without a traceability matrix. Affected work products are guessed rather than traced.

## Application

Use `template.md` for the full change impact analysis form.

### Step 1: Receive and Log the Change Request

When a change request arrives:
1. Assign a unique CR identifier
2. Record the requester, date, and description
3. Classify the change type (enhancement, defect, constraint, interface)
4. Assign an initial priority based on requester input (will be validated later)

For ChemTrack: A lab director requests adding barcode scanning capability for chemical containers (CR-007).

### Step 2: Perform Implications Analysis

Walk through the implications checklist for the proposed change:

```
Change: Add barcode scanning for chemical containers (CR-007)

- Conflicts with existing requirements? No
- Affects quality attributes? Yes -- Performance (scanning latency),
  Usability (new hardware interaction pattern)
- Requires architecture changes? Yes -- new hardware interface layer,
  camera/scanner API integration
- Affects external interfaces? Yes -- barcode scanner hardware API
- Alters business rules? No
- New regulatory obligations? Potentially -- barcode format must comply
  with GHS labeling standards
- Affects user documentation? Yes -- new workflow for scanning
- Invalidates test cases? No existing tests affected
- Affects deployed requirements? No
- Creates new dependency? Yes -- depends on barcode hardware procurement
```

### Step 3: Identify Affected Work Products

Use the requirements traceability matrix (`skills/requirements-traceability/SKILL.md`) to trace from affected requirements to all downstream artifacts:

| Work Product | Specific Items Affected | Nature of Change |
|-------------|------------------------|-----------------|
| SRS | FR-01 (Chemical entry), NFR-03 (Performance) | Add scanning alternative to manual entry |
| Architecture | Component diagram, interface specification | Add scanner interface module |
| UI Design | Chemical entry screen mockups | Add scan button and feedback UI |
| Database | None | No schema changes |
| Test Plan | Integration test suite | Add barcode scanning test cases |
| User Manual | Chemical entry procedures section | Add scanning workflow |
| Training | Lab technician training module | Add scanning training content |

### Step 4: Estimate Effort, Schedule, and Cost

Break the implementation into tasks:

```
Task breakdown for CR-007:
- Requirements update:        4 hours
- Architecture update:        8 hours
- UI design update:           6 hours
- Scanner API integration:   24 hours
- Unit tests:                 8 hours
- Integration tests:         12 hours
- User documentation:         4 hours
- Training update:            4 hours
---------------------------------
Total estimated effort:      70 hours (~2 developer-weeks)

Schedule impact: +1 sprint if started now; +0 if deferred to Release 2
Cost impact: $8,400 development + $2,500 hardware (scanners for 5 labs)
```

### Step 5: Assess Risks and Alternatives

Document new risks introduced:
- Scanner hardware may not be compatible with all lab environments
- GHS barcode format compliance adds regulatory verification effort

Document alternatives considered:
- Manual keyboard entry with auto-complete (current approach) -- no cost, but slower
- Mobile phone camera scanning -- lower hardware cost but security concerns
- Defer to Release 2 -- no immediate schedule impact but delays benefit realization

### Step 6: Submit to Change Control Board

Package the complete analysis and present to the CCB with a recommendation:
- **Approve:** Benefits justify the cost and schedule impact
- **Defer:** Valuable but not urgent; schedule for a later release
- **Reject:** Costs outweigh benefits, or alternatives are superior

For CR-007, the recommendation might be: "Defer to Release 2. The manual workaround is adequate for Release 1. Hardware procurement lead time makes Release 1 inclusion risky."

---

## Examples

See `examples/sample.md` for a complete change impact analysis.

Mini example excerpt:

```markdown
## Change Request CR-007: Barcode Scanning

**Description:** Add barcode scanning for chemical container identification
**Requester:** Dr. James Lee (Lab Director)
**Priority:** Medium
**Estimated Effort:** 70 hours
**Schedule Impact:** +1 sprint if in Release 1
**Recommendation:** Defer to Release 2

**Rationale:** Manual entry with auto-complete provides adequate workaround.
Scanner hardware procurement adds 6-week lead time incompatible with
Release 1 timeline. No regulatory requirement for scanning.
```

## Common Pitfalls

### Pitfall 1: Analysis Paralysis
**Symptom:** Every change request, no matter how small, gets a full 18-field analysis with a 3-day turnaround.

**Consequence:** The change process becomes a bottleneck. Stakeholders bypass it or stop submitting changes.

**Fix:** Scale the analysis to the change. Minor changes (typo fixes, cosmetic adjustments) get a lightweight review. Major changes (new features, architecture changes) get the full analysis. Define thresholds in your change control policy.

---

### Pitfall 2: Missing Downstream Impacts
**Symptom:** Impact analysis covers requirements and code but misses documentation, training, test cases, or deployment procedures.

**Consequence:** The change is "done" in code but the test suite, user manual, and training materials are out of sync.

**Fix:** Use the affected work products checklist systematically. Include non-code artifacts: user docs, training, deployment scripts, configuration, help text.

---

### Pitfall 3: Optimistic Effort Estimates
**Symptom:** Effort estimates cover only the "happy path" implementation -- no time for testing, documentation, or integration.

**Consequence:** Changes take 2-3x longer than estimated. The schedule slips or quality suffers.

**Fix:** Use the task breakdown approach. Explicitly estimate testing, documentation, and integration effort separately from implementation.

---

### Pitfall 4: No Alternatives Analysis
**Symptom:** The impact analysis evaluates only the proposed change as stated, without considering alternative approaches.

**Consequence:** The CCB approves an expensive implementation when a simpler alternative would address the same underlying need.

**Fix:** Always document at least one alternative, even if it is "do nothing." This forces consideration of whether the proposed approach is the best way to meet the need.

---

### Pitfall 5: Change Requests Without Business Rationale
**Symptom:** Change requests describe what should change but not why.

**Consequence:** The CCB cannot evaluate whether the change is worthwhile because the business justification is missing.

**Fix:** Require a rationale field on every change request. "Why is this change needed?" and "What happens if we do not make this change?"

## References

### Related Skills
- `skills/requirements-traceability/SKILL.md` -- Traceability matrix is essential for identifying affected work products
- `skills/requirements-baselining/SKILL.md` -- Changes apply against a baselined set of requirements
- `skills/requirements-status-tracking/SKILL.md` -- Track the status of change requests through the approval lifecycle
- `skills/moscow-prioritization/SKILL.md` -- Reprioritize after significant changes are approved

### External Frameworks
- Karl Wiegers & Joy Beatty, *Software Requirements, Third Edition* (2013) -- Chapter 28: Change Happens
- IEEE 828-2012, *Standard for Configuration Management in Systems and Software Engineering*
- CMMI for Development, Version 1.3 -- Requirements Management process area

---

**Skill type:** Component
**Dependencies:** References `skills/requirements-traceability/SKILL.md`, `skills/requirements-baselining/SKILL.md`
**Used by:** `skills/requirements-baselining/SKILL.md`, `skills/requirements-status-tracking/SKILL.md`
