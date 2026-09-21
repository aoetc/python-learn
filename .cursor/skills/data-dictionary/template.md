# Data Dictionary Template

Use this template to document data elements, structures, and CRUD analysis.

## Template

```markdown
# Data Dictionary: [Project Name]

**Version:** [x.y]
**Date:** [YYYY-MM-DD]

---

## Primitive Data Elements

### [Element Name]
- **Type:** [string / integer / decimal / date / boolean / enumeration]
- **Format:** [Pattern, length, precision]
- **Valid Values:** [Range, enumeration, or constraint]
- **Default:** [Default value, if any]
- **Example:** [Representative value]
- **Notes:** [Additional context, source of truth, update frequency]

*(Repeat for each primitive)*

---

## Data Structures

### [Structure Name]
```
[structure_name] = [element1] + [element2] + ([optional_element]) + {repeating_element}
```
- **Description:** [What this structure represents]
- **Used in:** [Which features, use cases, or reports reference this structure]

*(Repeat for each structure)*

---

## Enumerations

### [Enumeration Name]
| Value | Display Label | Description |
|-------|--------------|-------------|
| [value] | [label] | [what this value means] |

*(Repeat for each enumeration)*

---

## CRUD Matrix

|                     | [Entity 1] | [Entity 2] | [Entity 3] |
|---------------------|-----------|-----------|-----------|
| [Function/UC 1]     | C/R/U/D   |           |           |
| [Function/UC 2]     |           | C/R/U/D   |           |

### CRUD Analysis Findings
- [Entity with missing operations and explanation]
- [Function with no data access and explanation]
```

## Notes
- Notation: `=` (composed of), `+` (and), `[a|b]` (selection), `{x}` (repetition), `(x)` (optional)
- Every data term used in requirements must have an entry here.
- Review the CRUD matrix for empty rows (unused functions) and columns (unmanaged entities).
