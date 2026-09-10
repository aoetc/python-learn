#!/bin/bash
# Keep /etc/hosts writable by aoetc for Watt Toolkit.
# Watt often replaces the file and drops ACLs; re-apply when needed.
set -e
HOSTS="/etc/hosts"
USER_NAME="aoetc"
# Drop old ACL entries for this user (ignore errors), then grant read+write
/bin/chmod -a "user:${USER_NAME}:allow read,write" "$HOSTS" 2>/dev/null || true
/bin/chmod -a "user:${USER_NAME}:allow write" "$HOSTS" 2>/dev/null || true
/bin/chmod -a "user:${USER_NAME}:allow read" "$HOSTS" 2>/dev/null || true
/bin/chmod +a "user:${USER_NAME}:allow read,write" "$HOSTS"
