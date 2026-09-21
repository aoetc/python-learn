# Context Diagram Template

Use this template to create a system context diagram.

## Template

```markdown
# Context Diagram: [System Name]

**Date:** [YYYY-MM-DD]
**Author:** [Name]

---

## System
[System Name] -- [One-sentence description of what the system does]

## External Entities

| Entity | Type | Description |
|--------|------|-------------|
| [Name] | User / External System / Device / Organization | [What it is] |

## Data Flows

| From | To | Data Flow Name | Description |
|------|-----|---------------|-------------|
| [Entity/System] | [System/Entity] | [flow_name] | [What data is exchanged] |

## Diagram (Text Representation)

```
[Entity A] --data_flow_1--> (System) --data_flow_2--> [Entity B]
[Entity C] --data_flow_3--> (System)
(System) --data_flow_4--> [Entity D]
```

## Derived Requirements

| Data Flow | Incoming/Outgoing | Requirements to Define |
|-----------|------------------|----------------------|
| [flow_name] | Incoming | Format, validation rules, frequency |
| [flow_name] | Outgoing | Content, format, trigger, timing |
```

## Notes
- The system must be a single bubble -- do not decompose.
- Every external entity must have at least one data flow.
- Every data flow must have a descriptive name (noun phrase, not "data").
- No flows between external entities.
