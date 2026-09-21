# Change Impact Analysis Template

Use this template to assess the impact of a proposed requirements change before the CCB decision.

## Template

```markdown
# Change Impact Analysis

## Change Request Summary

| Attribute | Value |
|-----------|-------|
| **CR ID:** | [CR-XXX] |
| **Date Submitted:** | [YYYY-MM-DD] |
| **Requester:** | [Name and role] |
| **Change Type:** | [Enhancement / Defect / Constraint / Interface] |
| **Priority:** | [Critical / High / Medium / Low] |
| **Description:** | [What change is being requested] |
| **Rationale:** | [Why this change is needed] |

## Implications Checklist
- [ ] Conflicts with existing requirements?
- [ ] Affects quality attributes?
- [ ] Requires architecture changes?
- [ ] Affects external interfaces or business rules?
- [ ] Introduces regulatory obligations?
- [ ] Affects user docs, training, or test cases?
- [ ] Creates new dependencies?

## Affected Work Products

| Work Product | Specific Items | Nature of Change |
|-------------|---------------|-----------------|
| SRS | [Req IDs] | [Add / Modify / Delete] |
| Architecture | [Components] | [Description] |
| Test Plan | [Test cases] | [Add / Modify / Delete] |
| User Manual | [Sections] | [Description] |

## Effort and Schedule Estimate

| Task | Estimated Effort |
|------|-----------------|
| Requirements update | [hours] |
| Implementation | [hours] |
| Testing | [hours] |
| **Total** | **[hours]** |

- **Schedule impact:** [+X sprints/days] | **Cost impact:** [$X or budget %]

## Risks and Alternatives

| Risk | Likelihood | Impact | Mitigation |
|------|-----------|--------|------------|
| [Description] | [H/M/L] | [H/M/L] | [Strategy] |

| Alternative | Pros | Cons | Effort |
|------------|------|------|--------|
| [As proposed] | [Pros] | [Cons] | [Effort] |
| [Do nothing] | [Pros] | [Cons] | 0 |

## Recommendation and CCB Decision
**Recommendation:** [Approve / Defer / Reject]
**Rationale:** [Why]
**CCB Decision:** [Decision] on [Date] by [Names]
```

## Notes
- Scale the analysis to the change size. Always include at least one alternative.
- Effort estimates should include testing and documentation, not just coding.
