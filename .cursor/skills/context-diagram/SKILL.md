---
name: context-diagram
description: Create system context diagrams that define the boundary between the system and its external entities. Use when establishing scope, identifying interfaces, and ensuring all external interactions are captured in requirements.
intent: >-
  Create context diagrams that show the system as a single process with all external entities (users, systems, devices) and the data flows between them. Use this to establish a clear system boundary, identify all external interfaces that need requirements, and provide a visual scope definition that stakeholders can review quickly. The context diagram is the highest level of a data flow diagram and is the single most effective tool for preventing scope ambiguity.
type: component
theme: re-artifacts
best_for:
  - "Defining system boundaries and external interfaces"
  - "Identifying all data flows into and out of the system"
  - "Visual scope definition for stakeholder alignment"
scenarios:
  - "I need to show stakeholders exactly what is inside and outside the system boundary"
  - "We keep discovering new interfaces mid-project -- I need a complete picture up front"
estimated_time: "30-45 min"
---


## Purpose
Create context diagrams that show the system as a single process with all external entities and data flows. Use this to establish a clear system boundary, identify all external interfaces, and provide a visual scope definition for stakeholder alignment.

This is the highest level of a data flow diagram (DFD Level 0). The system is one bubble. Everything else is external. Every arrow is a data flow that needs requirements.

## Key Concepts

### Context Diagram Elements

| Element | Symbol | Represents |
|---------|--------|-----------|
| System | Single circle/bubble | The system being built (only one) |
| External Entity (Terminator) | Rectangle | Users, external systems, devices, organizations |
| Data Flow | Labeled arrow | Data moving between system and external entity |

### Rules
1. The system is always ONE bubble -- do not decompose it in the context diagram
2. External entities are outside the system boundary -- you do not build them
3. Every data flow has a name describing what data moves (not how)
4. Data flows are directional -- arrows point in the direction data moves
5. No data flows between external entities (if two external entities exchange data without your system, it is not in scope)

### From Context Diagram to Requirements
Every element generates requirements:
- **Each external entity** -> User class or interface specification needed
- **Each incoming data flow** -> Input validation, data format, and processing requirements
- **Each outgoing data flow** -> Output content, format, timing, and destination requirements
- **The system boundary** -> Scope definition (what is inside, what is outside)

### Beyond Context Diagrams: The DFD Hierarchy
- **Ecosystem Map** -- Shows all systems and their interactions, not just yours. Useful for enterprise context before narrowing to your system boundary.
- **Level 0 DFD** -- Decomposes the single system bubble into major processes and internal data stores. Each major function becomes its own bubble, with data flows between them. This is your next step after the context diagram is validated.
- **Level 1+ DFDs** -- Further decompose individual Level 0 processes into sub-processes. Continue until each process is simple enough to specify directly as requirements.

**Connection between levels:** Every data flow entering/leaving the context diagram must appear as a data flow entering/leaving the Level 0 DFD. This is called "balancing" — the external interfaces must be consistent across levels.

### Elicitation Questions for Context Diagrams
When building a context diagram, ask stakeholders:
- "Who will use this system directly?" (identifies user entities)
- "What other systems does this interact with?" (identifies system entities)
- "What data comes IN from outside?" (identifies incoming flows)
- "What data goes OUT to the outside world?" (identifies outgoing flows)
- "Does this system connect to any hardware devices?" (identifies device entities)
- "What regulatory bodies or external organizations need information from this system?" (identifies organizational entities)
- "Is there anything outside the system that triggers activity inside it?" (identifies event-driven flows)

### Anti-Patterns
- **Multiple System Bubbles** -- The context diagram has only ONE system. If you are drawing multiple systems, you are drawing an ecosystem map.
- **Process Decomposition** -- Showing internal processes in the context diagram. Save decomposition for the Level 0 DFD.
- **Vague Data Flows** -- Arrows labeled "data" or "information." Name the actual data: "prescription_details," "compliance_report."

## Application

### Step 1: Place the System

Draw a single circle in the center and label it with the system name.

### Step 2: Identify External Entities

From your stakeholder analysis, list everyone and everything that interacts with the system:
- **Users** -- All user classes from stakeholder analysis
- **External Systems** -- APIs, databases, services the system integrates with
- **Hardware Devices** -- Printers, scanners, sensors
- **Organizations** -- Regulatory bodies, partner companies, payment processors

Place each as a rectangle around the system bubble.

### Step 3: Draw Data Flows

For each external entity, ask:
- "What data does this entity send TO the system?" (incoming arrow)
- "What data does the system send TO this entity?" (outgoing arrow)

Label each arrow with the data's name. Use noun phrases: "chemical_record," "expiration_alert," "compliance_report."

### Step 4: Validate

- [ ] Only one system bubble exists
- [ ] Every external entity has at least one data flow
- [ ] Every data flow has a descriptive label (not "data" or "info")
- [ ] No data flows exist between external entities (those are out of scope)
- [ ] All user classes from stakeholder analysis are represented
- [ ] All external system integrations are represented
- [ ] Walk through with stakeholders: "Is anything missing?"

### Step 5: Derive Requirements

For each data flow, systematically create requirements:

**Incoming flows** (external entity → system):
- What data elements are included? (Reference `skills/data-dictionary/SKILL.md`)
- What format and validation rules apply?
- What triggers the data flow? (User action, scheduled event, external signal?)
- What error handling is needed if the data is invalid or unavailable?

**Outgoing flows** (system → external entity):
- What content is included in the output?
- What format does the receiver expect?
- What triggers the output? (User request, system event, schedule?)
- What timeliness requirements exist? (Real-time, batch, on-demand?)

**Example derivation from ChemTrack context diagram:**

| Data Flow | Direction | Derived Requirements |
|-----------|-----------|---------------------|
| chemical_record | Technician → System | REQ-101: System shall accept chemical records including name, CAS number, quantity, location, and expiration date |
| expiration_alert | System → Technician | REQ-102: System shall notify lab technicians 30 days before chemical expiration via email |
| compliance_report | System → EHS Officer | REQ-103: System shall generate monthly compliance reports in PDF format per EPA guidelines |
| CAS_lookup_request | System → PubChem API | REQ-104: System shall validate CAS numbers against the PubChem database during chemical registration |

### Step 6: Connect to Level 0 DFD (Optional Next Step)

Once the context diagram is validated, decompose the system bubble:
1. Identify 5-9 major processes inside the system
2. Identify internal data stores (databases, files)
3. Show data flows between processes and between processes and data stores
4. Verify **balancing**: every external data flow from the context diagram must appear at the Level 0 boundary

---

## Examples

See `examples/sample.md` for a complete context diagram example.

Mini example (text representation):

```
[Lab Technician] --chemical_record--> (ChemTrack) --expiration_alert--> [Lab Technician]
[EHS Officer] --report_request--> (ChemTrack) --compliance_report--> [EHS Officer]
[PubChem API] --CAS_validation_result--> (ChemTrack) --CAS_lookup_request--> [PubChem API]
[Label Printer] <--print_label-- (ChemTrack)
[University SSO] --auth_token--> (ChemTrack) --auth_request--> [University SSO]
```

## Common Pitfalls

### Pitfall 1: Missing External Entities
**Symptom:** Context diagram shows users but not the external systems the software integrates with.

**Consequence:** Interface requirements for APIs, databases, and hardware are discovered late.

**Fix:** Systematically review: users, external systems, hardware devices, regulatory bodies, partner organizations. Ask: "Does the system exchange data with anything else?"

---

### Pitfall 2: Data Flows Without Names
**Symptom:** Arrows between entities and system with no labels.

**Consequence:** Nobody knows what data is exchanged. Requirements cannot be derived from the diagram.

**Fix:** Every arrow must have a descriptive noun-phrase label. If you cannot name it, you do not understand the interaction well enough.

---

### Pitfall 3: Decomposing the System
**Symptom:** The context diagram shows internal subsystems, databases, and processing steps.

**Consequence:** The diagram is too detailed to serve as a scope communication tool. Stakeholders cannot see the boundary.

**Fix:** Keep the system as ONE bubble. Decompose in the Level 0 DFD, not the context diagram.

---

### Pitfall 4: Forgetting Bidirectional Flows
**Symptom:** An external entity only has arrows in one direction (e.g., user sends data but never receives anything back).

**Consequence:** Output requirements for that entity are missing — no confirmations, reports, or alerts.

**Fix:** For each entity, explicitly ask both: "What does it send?" and "What does it receive?" Most entities have bidirectional flows.

---

### Pitfall 5: Not Updating After Elicitation
**Symptom:** Context diagram drawn once during project kickoff, never revised.

**Consequence:** New external entities and data flows discovered during elicitation are not captured, leading to scope gaps.

**Fix:** Treat the context diagram as a living artifact. Update it whenever new external interfaces are discovered. Re-validate with stakeholders after major elicitation rounds.

## References

### Related Skills
- `skills/vision-and-scope/SKILL.md` -- Context diagram is a key scope visualization
- `skills/srs-document/SKILL.md` -- Context diagram appears in Section 2.1 (Product Perspective)
- `skills/data-dictionary/SKILL.md` -- Data flows reference data dictionary entries
- `skills/stakeholder-analysis/SKILL.md` -- External entities come from stakeholder analysis

### External Frameworks
- Tom DeMarco, *Structured Analysis and System Specification* (1979) -- Data flow diagrams
- Karl Wiegers & Joy Beatty, *Software Requirements, Third Edition* (2013) -- Chapter 5, 12

---

**Skill type:** Component
**Dependencies:** References `skills/stakeholder-analysis/SKILL.md`
**Used by:** `skills/vision-and-scope/SKILL.md`, `skills/srs-document/SKILL.md`
