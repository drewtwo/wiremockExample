# WireMock Bug Demonstration

This repository demonstrates a critical bug/inconsistency in WireMock's mapping file format handling.

## The Issue

WireMock has an inconsistency in how it processes mapping files. There are two conflicting format specifications:

### Incorrect Format (with 'mappings' array wrapper)
Some documentation and examples show mappings wrapped in a `mappings` array:

```json
{
  "mappings": [
    {
      "request": { ... },
      "response": { ... }
    }
  ]
}
```

### Correct Format (direct mapping)
The actual correct format for individual mapping files is a direct mapping object without the wrapper:

```json
{
  "request": { ... },
  "response": { ... }
}
```

## Files in This Repository

- **getSearchRequest.json**: Demonstrates the **INCORRECT** format with the `mappings` array wrapper. This file will NOT work as expected with WireMock.
- **getBadLimitRequest.json**: Demonstrates the **CORRECT** format with direct mapping. This file works properly with WireMock.

## Why This Matters

When using WireMock's file-based stub mapping feature, each JSON file in the `mappings` directory should contain a single mapping object, NOT an array of mappings. The `mappings` array wrapper is only used in the main WireMock configuration file or when importing multiple mappings at once, not in individual mapping files.

## How to Reproduce

1. Start WireMock with the standalone JAR
2. Attempt to use the getSearchRequest.json mapping - it will fail to load correctly
3. Use the getBadLimitRequest.json mapping - it will work as expected

This demonstrates the need for clearer documentation and potentially better error handling in WireMock to catch this common mistake.
