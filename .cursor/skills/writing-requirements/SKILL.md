---
name: writing-requirements
description: Write individual requirements that are clear, testable, and unambiguous using EARS templates and quality checklists. Use when drafting or improving shall-statements and functional requirements.
intent: >-
  Write excellent individual requirements using proven sentence patterns (EARS templates), shall/should/will conventions, and a quality self-check against the ten characteristics of excellent requirements. Covers positive vs. negative requirements, ambiguity avoidance with a TBD watchlist, and verifiability checks. Use this when you need to draft new requirements or improve existing ones that are vague, untestable, or ambiguous.
type: component
theme: re-artifacts
best_for:
  - "Drafting clear, testable functional requirements from scratch"
  - "Improving vague or ambiguous existing requirements"
  - "Applying EARS sentence patterns to standardize requirement language"
scenarios:
  - "I have a feature idea but need to turn it into a proper shall-statement"
  - "Reviewers flagged my requirements as vague or untestable -- I need to rewrite them"
  - "I want a checklist to verify my requirements meet quality standards before review"
estimated_time: "5-15 min per requirement"
---


## Purpose
Write individual requirements that are clear, testable, and unambiguous. A well-written requirement communicates one capability or constraint in a way that developers can implement, testers can verify, and stakeholders can confirm matches their intent.

This is not about organizing requirements into documents (see `skills/srs-document/SKILL.md`) or validating them with stakeholders (see `skills/requirements-validation-process/SKILL.md`). This is about the craft of writing a single requirement well.

## Key Concepts

### The Ten Characteristics of Excellent Requirements
Every individual requirement should be:

| Characteristic | Definition | Test |
|---------------|-----------|------|
| **Correct** | Accurately represents a stakeholder need | Stakeholder confirms it |
| **Feasible** | Can be implemented within known constraints | Development confirms it |
| **Necessary** | Traces to a business need or stakeholder request | Has a traceable origin |
| **Prioritized** | Has a relative importance assigned | Ranked by stakeholders |
| **Unambiguous** | Has exactly one interpretation | Two readers agree on meaning |
| **Verifiable** | Can be tested or demonstrated | A test case can be written for it |
| **Complete** | Contains all needed information | No TBDs or missing details |
| **Consistent** | Does not contradict other requirements | No conflicts found |
| **Modifiable** | Can be changed without ripple effects | Singular, non-redundant |
| **Traceable** | Has a unique ID and known origin | Forward and backward links exist |

### Shall / Should / Will Conventions
Use these keywords with specific meaning:

- **Shall** -- A binding requirement. The system *must* do this. "The system shall display the chemical name and CAS number on the inventory detail screen."
- **Should** -- A desired goal, not mandatory. "The system should display search results within 2 seconds." (Performance target, not hard limit.)
- **Will** -- A statement of fact about the environment or a declaration of purpose. "The ChemTrack system will replace the existing spreadsheet-based inventory process."

**Rule of thumb:** If it must be tested and verified, use "shall." If it is aspirational, use "should." If it describes context, use "will."

### Why This Works
Requirements written with these conventions and patterns have measurable benefits:
- **Reduced rework** -- Clear requirements reduce misinterpretation, which causes 40-50% of defects (Wiegers & Beatty, 2013)
- **Testability** -- EARS patterns force you to state the trigger and expected behavior, making test cases straightforward
- **Consistency** -- A standard vocabulary prevents arguments about what "shall" vs. "should" means

### EARS Templates (Easy Approach to Requirements Syntax)
Five sentence patterns that cover most requirement types:

**1. Ubiquitous (always active)**
```
The [system] shall [action].
```
Example: "The ChemTrack system shall maintain an audit log of all inventory changes."

**2. Event-Driven (triggered by an event)**
```
When [trigger], the [system] shall [action].
```
Example: "When a chemical quantity falls below the reorder threshold, ChemTrack shall send an email notification to the procurement manager."

**3. Unwanted Behavior (handling failure)**
```
If [unwanted condition], then the [system] shall [action].
```
Example: "If the barcode scanner fails to read a chemical label, then ChemTrack shall allow manual entry of the chemical identifier."

**4. State-Driven (while in a state)**
```
While [state], the [system] shall [action].
```
Example: "While a chemical is marked as hazardous, ChemTrack shall display a warning icon next to the chemical name in all views."

**5. Optional Feature**
```
Where [feature is included], the [system] shall [action].
```
Example: "Where the GHS labeling module is installed, ChemTrack shall generate GHS-compliant safety labels for all chemicals."

### Ambiguous Terms -- The TBD Watchlist
These words signal vague requirements. Replace or quantify them:

| Ambiguous Term | Problem | Fix |
|---------------|---------|-----|
| adequate | Adequate by whose standard? | Specify the standard or threshold |
| appropriate | Who decides what is appropriate? | State the criteria |
| as needed | When is it needed? | Define the trigger condition |
| but not limited to | Unbounded scope | List all items or set boundaries |
| easy to use | Subjective | Define measurable usability criteria |
| efficient | Compared to what? | Quantify (e.g., "within 3 seconds") |
| flexible | How flexible? | Specify the dimensions of change |
| minimize / maximize | To what degree? | Give a numeric threshold |
| reasonable | By whose judgment? | Specify the criteria |
| sufficient | Sufficient for what? | Define the quantity or capacity |
| user-friendly | Subjective | Define task completion metrics |

### Anti-Patterns

- **The Compound Requirement** -- "The system shall validate the CAS number AND display the SDS link AND log the access." Three requirements forced into one. Split them.
- **The Design Masquerading as a Requirement** -- "The system shall use a PostgreSQL database to store chemical records." That is implementation. The requirement is: "The system shall persistently store all chemical inventory records."
- **The Untestable Aspiration** -- "The system shall be reliable." How reliable? "The system shall achieve 99.5% uptime measured monthly." Now it is testable.
- **The Negative Hole** -- "The system shall not allow unauthorized access." True, but too broad. Specify what authorization means and which access points are controlled.

## Application

Use `template.md` for the fill-in structure.

### Step 1: Identify the Requirement Source

Before writing, know where the requirement comes from:
- A stakeholder interview (see `skills/elicitation-interview/SKILL.md`)
- An observation session (see `skills/observation-analysis/SKILL.md`)
- A business rule (see `skills/business-rule/SKILL.md`)
- A use case step (see `skills/use-case/SKILL.md`)

Record the source for traceability.

### Step 2: Choose the EARS Pattern

Match the requirement to its pattern:
- Does this describe something always true? --> **Ubiquitous**
- Is it triggered by an event? --> **Event-Driven**
- Does it handle a failure or error? --> **Unwanted Behavior**
- Is it active only in a particular state? --> **State-Driven**
- Is it part of an optional feature? --> **Optional Feature**

### Step 3: Draft the Requirement

Write the requirement using the chosen EARS template. Include:
1. A unique identifier (e.g., CT.INV.003)
2. The EARS-patterned sentence
3. A rationale or source reference

**Example draft:**
```
CT.INV.003: When the lab technician submits a new chemical entry,
ChemTrack shall validate the CAS number against the PubChem database
and display "Valid" or "Invalid CAS Number" within 3 seconds.

Source: Interview with Lab Manager, 2024-01-15
Rationale: Prevents data entry errors that caused 12% inventory
discrepancies in 2023.
```

### Step 4: Apply the Quality Checklist

Run through each characteristic:
- [ ] **Correct** -- Does this match the stakeholder's actual need?
- [ ] **Feasible** -- Can the team implement this? Is PubChem API available?
- [ ] **Necessary** -- Does this trace to a user need or business goal?
- [ ] **Prioritized** -- Is this High / Medium / Low?
- [ ] **Unambiguous** -- Would two developers interpret this the same way?
- [ ] **Verifiable** -- Can I write a test case? (Yes: "Submit valid CAS, expect Valid; submit invalid CAS, expect Invalid CAS Number")
- [ ] **Complete** -- Any TBDs or missing info? (What happens if PubChem is unreachable?)
- [ ] **Consistent** -- Does this conflict with any other requirement?
- [ ] **Modifiable** -- Is this a single atomic requirement?
- [ ] **Traceable** -- Does it have an ID and a source?

### Step 5: Rewrite Positive Where Possible

Prefer positive requirements over negative ones:
- **Negative:** "The system shall not allow chemicals without a CAS number to be saved."
- **Positive:** "The system shall require a valid CAS number before saving a chemical record."

Negative requirements are acceptable for security and safety constraints: "The system shall not display chemical quantities to users without the Inventory Viewer role."

### Step 6: Peer Review the Requirement

Have at least one other person read the requirement and answer:
- "What does this requirement mean to you?" (Tests ambiguity)
- "How would you test this?" (Tests verifiability)
- "Is anything missing?" (Tests completeness)

---

## Examples

See `examples/sample.md` for complete requirement writing examples.

Mini example excerpt:

```markdown
**Before (weak):**
CT.RPT.001: The system shall generate appropriate reports.

**After (strong):**
CT.RPT.001: When the lab manager selects "Monthly Inventory Report,"
ChemTrack shall generate a PDF report listing all chemicals grouped
by storage location, showing chemical name, CAS number, quantity,
and expiration date, sorted by expiration date ascending.
```

## Common Pitfalls

### Pitfall 1: Compound Requirements
**Symptom:** A single requirement contains "and" joining multiple distinct behaviors.

**Consequence:** Partial implementation goes undetected. Testers must create multiple test cases for one requirement ID.

**Fix:** Split into separate requirements. Each requirement should be independently implementable and testable.

---

### Pitfall 2: Missing Trigger or Context
**Symptom:** "The system shall display an error message." When? Under what condition?

**Consequence:** Developers guess the trigger. Different developers guess differently.

**Fix:** Use EARS event-driven or state-driven patterns to specify the trigger explicitly.

---

### Pitfall 3: Ambiguous Adjectives
**Symptom:** "The system shall provide fast search results" or "The system shall have a clean interface."

**Consequence:** No objective way to verify. Arguments during acceptance testing.

**Fix:** Replace with measurable criteria. Consult the TBD Watchlist and quantify every adjective.

---

### Pitfall 4: Implementation Prescription
**Symptom:** "The system shall use REST APIs" or "The system shall store data in MongoDB."

**Consequence:** Constrains design prematurely. If technology changes, requirements must be rewritten.

**Fix:** State the need, not the solution. "The system shall expose chemical data to authorized external systems via a documented API."

---

### Pitfall 5: Copy-Paste Inconsistency
**Symptom:** The same concept is described differently in different requirements (e.g., "chemical record" vs. "inventory item" vs. "substance entry").

**Consequence:** Readers wonder if these are the same thing or different things.

**Fix:** Maintain a glossary (see `skills/data-dictionary/SKILL.md`). Use terms consistently.

## References

### Related Skills
- `skills/srs-document/SKILL.md` -- Organizing requirements into a specification document
- `skills/acceptance-criteria/SKILL.md` -- Writing testable acceptance criteria for each requirement
- `skills/business-rule/SKILL.md` -- Documenting business rules referenced by requirements
- `skills/data-dictionary/SKILL.md` -- Maintaining consistent terminology across requirements
- `skills/requirements-review-advisor/SKILL.md` -- Reviewing requirements for quality

### External Frameworks
- Karl Wiegers & Joy Beatty, *Software Requirements, Third Edition* (2013) -- Chapter 11: Writing Excellent Requirements
- Alistair Mavin et al., "Easy Approach to Requirements Syntax (EARS)" (2009) -- EARS templates
- IEEE 29148:2018 -- Systems and software engineering -- Life cycle processes -- Requirements engineering

---

**Skill type:** Component
**Dependencies:** None
**Used by:** `skills/srs-document/SKILL.md`, `skills/requirements-review-advisor/SKILL.md`, `skills/requirements-analysis-process/SKILL.md`
