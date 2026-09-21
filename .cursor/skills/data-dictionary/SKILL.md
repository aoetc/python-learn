---
name: data-dictionary
description: Define data elements, structures, and compositions using formal data dictionary notation. Use when documenting the data model to eliminate ambiguity about what each data item means, contains, and how it relates to other data.
intent: >-
  Create a structured data dictionary that formally defines every data element referenced in requirements, including primitive types, composite structures, repeating groups, and valid values. Use this to eliminate the ambiguity that comes from undefined terms like "customer information" or "order details," to detect missing requirements by analyzing data flows, and to provide developers with precise data specifications. Includes CRUD matrix analysis for completeness checking.
type: component
theme: re-artifacts
best_for:
  - "Defining data elements referenced in requirements"
  - "Detecting missing requirements through data flow analysis"
  - "Eliminating ambiguity about data item meanings and formats"
scenarios:
  - "Requirements mention 'customer record' but nobody has defined what fields it contains"
  - "I need to verify we have requirements for creating, reading, updating, and deleting every data entity"
estimated_time: "30-60 min for initial dictionary; ongoing maintenance"
---


## Purpose
Create a structured data dictionary that formally defines every data element referenced in requirements: primitive types, composite structures, repeating groups, and valid values. Use this to eliminate ambiguity, detect missing requirements, and provide developers with precise data specifications.

This is not a database schema -- it is a requirements-level definition of what data means and how it is structured, independent of implementation technology.

## Key Concepts

### Data Dictionary Notation

| Symbol | Meaning | Example |
|--------|---------|---------|
| `=` | is composed of | `customer = name + address + phone` |
| `+` | and (sequence) | `name = first_name + last_name` |
| `[a | b]` | either a or b (selection) | `payment = [credit_card | bank_transfer | cash]` |
| `{x}` | zero or more of x (repetition) | `order = header + {line_item}` |
| `N{x}M` | N to M occurrences of x | `phone_list = 1{phone_number}3` |
| `(x)` | optional | `name = first_name + (middle_name) + last_name` |
| `"x"` | literal value | `country_code = "US"` |
| `*x*` | comment | `*ISO 8601 date format*` |

### Data Element Types

**Primitive:** An atomic data element that cannot be decomposed further.
```
CAS_number = *Chemical Abstracts Service registry number*
             string, format: NNN-NN-N, where N is a digit
```

**Structure:** A composite of other elements in a fixed sequence.
```
chemical_record = chemical_name + CAS_number + quantity + 
                  storage_location + expiration_date +
                  (SDS_link) + date_added + added_by
```

**Repeating Group:** A collection of zero or more instances.
```
chemical_inventory = {chemical_record}
experiment_chemicals = 1{chemical_record}50
```

### CRUD Matrix
A CRUD (Create, Read, Update, Delete) matrix cross-references data entities with system functions to detect missing requirements:

|                     | Chemical | Alert | Report | User |
|---------------------|----------|-------|--------|------|
| Add Chemical        | C        |       |        |      |
| Search Catalog      | R        |       |        |      |
| Update Quantity     | U        |       |        |      |
| Dispose Chemical    | D        | D     |        |      |
| Generate Alert      | R        | C     |        |      |
| Generate Report     | R        | R     | C      |      |
| Manage Users        |          |       |        | CRUD |

**Analysis rules:**
- Every entity should have all four CRUD operations (or documented reasons why not)
- An entity that is Created but never Read is suspicious (why store it?)
- An entity that is Read but never Created means it comes from outside the system
- Empty rows or columns indicate missing features or entities

### Anti-Patterns
- **Undefined Composites** -- Requirements reference "customer information" without defining what fields it includes
- **Implicit Assumptions** -- "Name" -- first name? Full name? Family name first?
- **No Valid Values** -- "Status" -- what are the possible values? What transitions are allowed?

## Application

Use `template.md` for the fill-in structure.

### Step 1: Inventory Data References

Scan through your requirements, use cases, and user stories. Every noun that represents data is a candidate for the data dictionary:
- Inputs users provide
- Outputs the system displays
- Data the system stores
- Data exchanged with external systems

### Step 2: Define Primitives

For each atomic data element:
```markdown
### [Element Name]
- **Type:** [string / integer / decimal / date / boolean / enumeration]
- **Format:** [Pattern, length, precision]
- **Valid Values:** [Range, enumeration, or constraint]
- **Default:** [Default value, if any]
- **Example:** [Representative value]
- **Notes:** [Additional context]
```

### Step 3: Define Structures

Use the composition notation to build up from primitives:
```
address = street_line_1 + (street_line_2) + city + state_code + 
          postal_code + country_code
```

### Step 4: Define Repeating Groups and Selections

```
order = order_header + 1{order_line}999
payment_method = [credit_card | debit_card | bank_transfer | purchase_order]
```

### Step 5: Build CRUD Matrix

1. List all data entities (rows)
2. List all system functions or use cases (columns)
3. For each cell, mark C, R, U, D as applicable
4. Analyze for gaps

### Step 6: Validate

- [ ] Every data element in requirements has a dictionary entry
- [ ] Every structure is decomposed to primitives
- [ ] Valid values and formats are specified for all primitives
- [ ] CRUD matrix has no unexplained empty cells
- [ ] Dictionary entries are consistent (same element defined the same way everywhere)

---

## Examples

See `examples/sample.md` for a complete data dictionary excerpt.

Mini example:

```
chemical_name = string, 1-200 characters, must match an entry in
                PubChem database or be manually verified by EHS officer

CAS_number = string, format: NNN-NN-N where N = digit
             *Chemical Abstracts Service registry number, globally unique*
             Example: "7732-18-5" (water)

quantity = decimal(10,2), >= 0, unit specified by quantity_unit
quantity_unit = ["mL" | "L" | "g" | "kg" | "units"]

chemical_record = chemical_name + CAS_number + quantity + quantity_unit +
                  storage_location + expiration_date + hazard_class +
                  (SDS_link) + date_added + added_by
```

## Common Pitfalls

### Pitfall 1: Skipping the Data Dictionary
**Symptom:** Requirements use terms like "customer data," "order information," or "report fields" without definition.

**Consequence:** Developers define data structures based on assumptions. Different developers make different assumptions. Data inconsistencies in production.

**Fix:** Every composite term in requirements must decompose to defined primitives in the data dictionary.

---

### Pitfall 2: Incomplete Valid Values
**Symptom:** "Status" field defined as "string" with no enumeration of possible values.

**Consequence:** Developers and testers invent their own status values. The database has "Active," "active," "ACTIVE," and "A."

**Fix:** Define enumerations explicitly: `status = ["Active" | "Inactive" | "Pending" | "Suspended"]`.

---

### Pitfall 3: CRUD Matrix Not Built
**Symptom:** Requirements seem complete but there is no Create operation for a key entity.

**Consequence:** During testing, someone asks "How does this data get into the system?" and nobody knows.

**Fix:** Build the CRUD matrix early. It reliably exposes missing requirements before development starts.

## References

### Related Skills
- `skills/srs-document/SKILL.md` -- Data dictionary is Section 4 of the SRS
- `skills/context-diagram/SKILL.md` -- Data flows in context diagrams reference dictionary entries
- `skills/requirements-analysis-process/SKILL.md` -- Data analysis is part of the analysis process

### External Frameworks
- Tom DeMarco, *Structured Analysis and System Specification* (1979) -- Data dictionary notation
- Karl Wiegers & Joy Beatty, *Software Requirements, Third Edition* (2013) -- Chapter 13: A Picture Is Worth 1024 Words (data modeling)
- Peter Chen, "The Entity-Relationship Model" (1976) -- Entity-relationship modeling

---

**Skill type:** Component
**Dependencies:** None
**Used by:** `skills/srs-document/SKILL.md`, `skills/requirements-analysis-process/SKILL.md`
