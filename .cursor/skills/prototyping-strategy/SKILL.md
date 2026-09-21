---
name: prototyping-strategy
description: Select the right prototyping approach based on project risks, requirements uncertainty, and stakeholder needs. Use when deciding what to prototype, at what fidelity, and how to evaluate the results.
intent: >-
  Guide requirements engineers in selecting the most effective prototyping approach by asking adaptive questions about the purpose of the prototype, desired fidelity level, lifecycle intent, and evaluation method. Use this when requirements are unclear, UI design is uncertain, technical feasibility is in question, or stakeholders need something tangible to react to. Outputs a recommended prototyping approach with scope definition and an evaluation plan.
type: interactive
theme: re-process
best_for:
  - "Choosing the right fidelity and scope for a prototype"
  - "Reducing risk when requirements are uncertain or stakeholders disagree"
  - "Planning prototype evaluation to maximize learning"
scenarios:
  - "Users cannot articulate what they need and we need something concrete to show them"
  - "There is technical uncertainty about whether a feature is feasible"
  - "Stakeholders disagree about the UI approach and we need to resolve it quickly"
estimated_time: "15-20 min for strategy selection; prototype execution time varies"
---


## Purpose
Guide the selection of the most effective prototyping approach for a given project situation. Use this when requirements are unclear, feasibility is uncertain, or stakeholders need something tangible to react to. The output is a recommended prototyping approach with scope, fidelity, lifecycle, and evaluation plan.

This is not a prototyping tutorial -- it is a decision framework for choosing what to prototype, how, and how to evaluate the results. For UI flow modeling that informs prototyping, see `skills/dialog-map/SKILL.md`.

## Key Concepts

### Prototype Dimensions

**Horizontal (Breadth) vs. Vertical (Depth):**

| Dimension | What It Shows | Best For |
|-----------|-------------|---------|
| Horizontal (mock-up) | Many features at the surface level; navigation and layout | Validating UI flow, screen inventory, user workflows |
| Vertical (proof-of-concept) | One feature implemented deeply, end to end | Validating technical feasibility, performance, integration |

**Fidelity Levels:**

| Fidelity | Tools | Interaction Level | Cost |
|----------|-------|------------------|------|
| Paper | Paper, whiteboard, sticky notes | None (facilitator simulates) | Very low |
| Low-fidelity | Wireframing tools (Balsamiq, Figma lo-fi) | Clickable but no real data | Low |
| Medium-fidelity | Design tools with interactions | Clickable with simulated data | Moderate |
| High-fidelity | Code-based or advanced design tools | Functional with real or realistic data | High |

**Lifecycle Intent:**

| Intent | Description | When to Use |
|--------|-------------|-------------|
| Throwaway (exploratory) | Built to learn, then discarded | Exploring uncertain requirements, evaluating alternatives |
| Evolutionary | Built to evolve into the production system | Requirements are fairly stable, architecture is proven |

### Wizard of Oz Technique

A human behind the scenes simulates system responses that have not been built yet. The user interacts with a real-looking interface while a person manually provides the "system" responses.

**When to use:** When building the actual backend is expensive but you need user feedback on the interaction. Useful for AI/ML features, complex search, or recommendation engines.

**ChemTrack example:** A paper prototype of the "Smart Chemical Suggestion" feature where a facilitator manually looks up similar chemicals and presents them as if the system generated the suggestions.

### Prototype Evaluation

A prototype is only useful if you evaluate it systematically:
- **Think-aloud protocol:** User narrates their thought process while using the prototype
- **Task completion:** Give users specific tasks and observe success/failure
- **Comparison evaluation:** Show two prototype versions and ask users to compare
- **Questionnaire follow-up:** Structured feedback after the session

### Why This Works

Prototyping reduces risk by making the abstract concrete. Stakeholders can react to something visible far more effectively than to written requirements. The key is choosing the right prototype for the right risk at the right time.

### Anti-Patterns
- **Prototype Everything** -- Building high-fidelity prototypes for well-understood features wastes effort
- **Ship the Prototype** -- Treating a throwaway prototype as production code leads to technical debt
- **No Evaluation Plan** -- Building a prototype without a plan for what you want to learn from it
- **Gold-Plating** -- Adding visual polish to a prototype meant to validate navigation flow

## Application

### Interactive Selection Process

**Question 1: What is the primary purpose of this prototype?**

1. **Clarify requirements** -- Users cannot articulate needs; need something to react to
2. **Explore feasibility** -- Technical uncertainty about whether an approach will work
3. **Evaluate UI design** -- Validate navigation, layout, and workflows with users
4. **Demonstrate to stakeholders** -- Build shared understanding or gain approval

---

**Question 2: What fidelity level is appropriate?**

1. **Paper** -- Earliest stage, maximum flexibility, minimal investment
2. **Low-fidelity** -- Clickable wireframes, enough to test navigation flow
3. **Medium-fidelity** -- Realistic appearance with simulated data
4. **High-fidelity** -- Near-production look and feel, functional interactions

---

**Question 3: What is the lifecycle intent?**

1. **Throwaway** -- Learn and discard; do not constrain the final design
2. **Evolutionary** -- This prototype will grow into the real system

---

**Question 4: How will you evaluate the prototype?**

1. **Think-aloud usability sessions** -- Observe users narrating their experience
2. **Task-based evaluation** -- Measure task completion success and time
3. **Stakeholder review meeting** -- Walkthrough with decision-makers
4. **A/B comparison** -- Compare two alternatives with user panel

---

### Recommendation Logic

**If clarify requirements + paper/low-fidelity + throwaway:**
- **Approach:** Paper prototype with facilitated walkthrough
- **Scope:** Horizontal -- cover the main screens and navigation paths
- **Evaluation:** Think-aloud sessions with 3-5 representative users
- **Output:** List of clarified requirements and open questions resolved
- **Time:** 1-2 days to build, 1 day to evaluate

**If clarify requirements + medium/high-fidelity + throwaway:**
- **Approach:** Clickable wireframe prototype
- **Scope:** Horizontal -- main workflows with simulated data
- **Evaluation:** Task-based evaluation with 5-8 users
- **Output:** Validated requirements with user feedback incorporated
- **Time:** 3-5 days to build, 1-2 days to evaluate

**If explore feasibility + any fidelity + throwaway:**
- **Approach:** Vertical proof-of-concept
- **Scope:** Deep -- one critical feature implemented end to end
- **Evaluation:** Technical review measuring performance, integration success, scalability
- **Output:** Feasibility assessment with go/no-go recommendation
- **Time:** 1-2 weeks depending on complexity

**If evaluate UI design + low/medium fidelity + throwaway:**
- **Approach:** Clickable horizontal prototype
- **Scope:** All primary screens and navigation paths from dialog map
- **Evaluation:** Task-based usability testing with think-aloud
- **Output:** Validated UI design with usability findings
- **Time:** 3-5 days to build, 2-3 days to evaluate

**If demonstrate to stakeholders + medium/high fidelity + evolutionary:**
- **Approach:** Functional prototype with realistic data
- **Scope:** Primary use cases fully functional
- **Evaluation:** Stakeholder review with structured feedback form
- **Output:** Stakeholder approval and prioritized change requests
- **Time:** 1-3 weeks to build, 1 day review session

**If Wizard of Oz is appropriate (complex logic not yet built):**
- **Approach:** Realistic interface with human-simulated backend
- **Scope:** The specific feature with uncertain user interaction patterns
- **Evaluation:** Think-aloud with users who do not know the backend is simulated
- **Output:** Validated interaction requirements and user expectations
- **Time:** 2-3 days setup, 1 day evaluation per user group

---

### Evaluation Script Template

For any prototype evaluation session:

```
1. Introduction (5 min)
   - Explain purpose: "We are testing the design, not you"
   - Describe think-aloud protocol (if applicable)
   - Clarify that the prototype is incomplete and that is expected

2. Background Questions (5 min)
   - Role and experience level
   - Current process for the task being prototyped
   - Key pain points with current approach

3. Task Scenarios (20-30 min)
   - Task 1: [Primary workflow task]
   - Task 2: [Secondary or alternate workflow]
   - Task 3: [Error recovery or edge case]
   Record: completion (yes/no), time, errors, user comments

4. Post-Task Questions (10 min)
   - What was easy? What was confusing?
   - What is missing?
   - How does this compare to your current process?
   - Rate overall usability (1-5 scale)

5. Debrief and Next Steps (5 min)
   - Summarize what you heard
   - Explain how feedback will be used
```

---

## Examples

See `examples/sample.md` for a complete prototyping strategy for ChemTrack.

## Common Pitfalls

### Pitfall 1: Shipping the Prototype
**Symptom:** Management sees the prototype working and says "Great, ship it."

**Consequence:** Throwaway code with no error handling, security, or scalability becomes the production system.

**Fix:** Label throwaway prototypes explicitly. Get agreement upfront that the prototype will be discarded. Document this in the project plan.

---

### Pitfall 2: No Evaluation Plan
**Symptom:** Prototype is built and shown to stakeholders informally with no structured evaluation.

**Consequence:** Vague feedback ("looks good") that does not improve requirements. No actionable findings.

**Fix:** Define the evaluation plan *before* building the prototype. Specify tasks, participants, and what success looks like.

---

### Pitfall 3: Wrong Fidelity for the Question
**Symptom:** High-fidelity prototype built to answer a navigation question that paper prototyping could have answered.

**Consequence:** Wasted effort. Users focus on visual details instead of the navigation question being tested.

**Fix:** Match fidelity to the question. Navigation and layout questions need low fidelity. Feasibility questions need high fidelity in the vertical slice.

---

### Pitfall 4: Prototype Scope Creep
**Symptom:** Prototype starts with 3 screens and grows to 30 as stakeholders request "just one more screen."

**Consequence:** Prototype becomes as expensive as the real system. Evaluation is delayed indefinitely.

**Fix:** Define scope upfront. List exactly which screens and features are in scope. Reject additions or start a new prototype cycle.

## References

### Related Skills
- `skills/dialog-map/SKILL.md` -- Dialog maps define the screen inventory and navigation that horizontal prototypes implement
- `skills/use-case/SKILL.md` -- Use cases provide the task scenarios for prototype evaluation
- `skills/elicitation-technique-selector/SKILL.md` -- Prototyping is one elicitation technique; this skill helps decide when to use it
- `skills/requirements-validation-process/SKILL.md` -- Prototyping is a form of requirements validation

### External Frameworks
- Karl Wiegers & Joy Beatty, *Software Requirements, Third Edition* (2013) -- Chapter 15: Risk Reduction Through Prototyping
- Jakob Nielsen, *Usability Engineering* (1993) -- Discount usability with paper prototypes
- Carolyn Snyder, *Paper Prototyping* (2003) -- Comprehensive paper prototyping methodology

---

**Skill type:** Interactive
**Dependencies:** References `skills/dialog-map/SKILL.md`, `skills/use-case/SKILL.md`
**Used by:** `skills/requirements-validation-process/SKILL.md`
