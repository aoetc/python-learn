# Requirement Writing Template

Use this template to draft a single well-written requirement.

## Template

```markdown
## Requirement [ID]

**EARS Pattern:** [Ubiquitous | Event-Driven | Unwanted Behavior | State-Driven | Optional Feature]
**Priority:** [High / Medium / Low]
**Source:** [Stakeholder name, interview date, or document reference]
**Status:** [Draft / Reviewed / Approved]

### Requirement Statement

[Use the appropriate EARS pattern:]

- Ubiquitous: The [system] shall [action].
- Event-Driven: When [trigger], the [system] shall [action].
- Unwanted Behavior: If [unwanted condition], then the [system] shall [action].
- State-Driven: While [state], the [system] shall [action].
- Optional Feature: Where [feature], the [system] shall [action].

### Rationale
[Why is this requirement needed? What problem does it solve?]

### Fit Criterion / Verification Method
[How will you verify this requirement is correctly implemented?]

### Dependencies
- [Other requirement IDs this depends on]

### Quality Self-Check
- [ ] Correct -- Stakeholder confirms this matches their need
- [ ] Feasible -- Development confirms this can be built
- [ ] Necessary -- Traces to a business need
- [ ] Prioritized -- Has an assigned priority
- [ ] Unambiguous -- Two readers interpret it the same way
- [ ] Verifiable -- A test case can be written
- [ ] Complete -- No TBDs or missing information
- [ ] Consistent -- No conflicts with other requirements
- [ ] Modifiable -- Single atomic requirement, not compound
- [ ] Traceable -- Has a unique ID and a known source

### Notes
- [Open questions, constraints, or related information]
```

## Notes
- One requirement per template instance. Do not combine multiple behaviors.
- Always fill in the Rationale -- it helps reviewers understand the "why."
- The Fit Criterion is what makes a requirement verifiable. If you cannot write one, the requirement is too vague.
- Check every word against the TBD Watchlist (see SKILL.md) before submitting.
