#!/bin/bash
set -e
if [ "$(id -u)" -ne 0 ]; then
  echo "请用: sudo $0"
  exit 1
fi

# Apple Silicon Mac 常没有 /usr/local/bin，先建好；脚本放 /usr/local/bin
mkdir -p /usr/local/bin
install -m 755 /Users/aoetc/Developer/python-learn/scripts/fix-hosts-acl.sh /usr/local/bin/fix-hosts-acl.sh

/usr/local/bin/fix-hosts-acl.sh
echo "当前 hosts ACL："
/bin/ls -le /etc/hosts

PLIST="/Library/LaunchDaemons/com.aoetc.fix-hosts-acl.plist"
cat > "$PLIST" <<'PLIST'
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
  <key>Label</key>
  <string>com.aoetc.fix-hosts-acl</string>
  <key>ProgramArguments</key>
  <array>
    <string>/usr/local/bin/fix-hosts-acl.sh</string>
  </array>
  <key>RunAtLoad</key>
  <true/>
  <key>WatchPaths</key>
  <array>
    <string>/etc/hosts</string>
  </array>
  <key>StartInterval</key>
  <integer>600</integer>
  <key>StandardOutPath</key>
  <string>/tmp/fix-hosts-acl.log</string>
  <key>StandardErrorPath</key>
  <string>/tmp/fix-hosts-acl.err</string>
</dict>
</plist>
PLIST

chown root:wheel "$PLIST"
chmod 644 "$PLIST"
launchctl bootout system/com.aoetc.fix-hosts-acl 2>/dev/null || true
if launchctl bootstrap system "$PLIST" 2>/tmp/hosts-acl-boot.err; then
  echo "daemon: bootstrap ok"
else
  echo "bootstrap 备选 load..."
  launchctl load -w "$PLIST" 2>/tmp/hosts-acl-load.err || true
  cat /tmp/hosts-acl-boot.err 2>/dev/null || true
fi
launchctl kickstart -k system/com.aoetc.fix-hosts-acl 2>/dev/null || true

echo ""
echo "✅ 已安装：开机执行 + hosts 被改写时自动补权限 + 每 10 分钟兜底"
echo "验证: ls -le /etc/hosts"
