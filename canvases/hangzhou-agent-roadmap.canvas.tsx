import {
  Button,
  Callout,
  Card,
  CardBody,
  CardHeader,
  Checkbox,
  Divider,
  Grid,
  H1,
  H2,
  H3,
  Link,
  Pill,
  Row,
  Stack,
  Stat,
  Table,
  Text,
  TodoList,
  UsageBar,
  useCanvasState,
  useHostTheme,
} from "cursor/canvas";
import type { TodoItem } from "cursor/canvas";

type TabId =
  | "start"
  | "overview"
  | "timeline"
  | "jd"
  | "days90"
  | "market"
  | "finance";

const TABS: { id: TabId; label: string }[] = [
  { id: "start", label: "小白今日" },
  { id: "overview", label: "总览" },
  { id: "timeline", label: "学期时间线" },
  { id: "market", label: "【更新】市场校准" },
  { id: "jd", label: "JD 对照" },
  { id: "days90", label: "前 90 天" },
  { id: "finance", label: "金融怎么放" },
];

const GITHUB_STEPS: { id: string; label: string }[] = [
  { id: "gh-account", label: "1. 浏览器打开 github.com 注册并验证邮箱" },
  { id: "gh-desktop", label: "2. 安装 GitHub Desktop（Windows 图形界面，比命令行先学这个）" },
  { id: "gh-signin", label: "3. Desktop 里 Sign in to GitHub.com" },
  { id: "gh-repo", label: "4. New repository：名字 python-learn，勾选 README，建在本机文件夹" },
  { id: "gh-cursor", label: "5. Cursor 里 File → Open Folder，打开这个文件夹" },
  { id: "gh-commit", label: "6. 改一个文件 → Desktop 左侧看到变化 → 写说明 → Commit" },
  { id: "gh-publish", label: "7. Publish repository（公开即可，方便以后给面试官看）" },
];

const DAY_SCRIPT: {
  id: string;
  day: string;
  when: string;
  minutes: string;
  liao: string;
  doNow: string;
  git: string;
}[] = [
  {
    id: "d1",
    day: "第 1 天",
    when: "9/1 或你开始的第一天",
    minutes: "60",
    liao: "先不看教程。只办 GitHub。",
    doNow: "注册 GitHub，装 GitHub Desktop，登录成功。",
    git: "没有代码也没关系，账号能登录就算完成。",
  },
  {
    id: "d2",
    day: "第 2 天",
    when: "次日",
    minutes: "60",
    liao: "仍不看廖雪峰。",
    doNow: "Desktop 新建仓库 python-learn（带 README）。用 Cursor 打开该文件夹，在 README 里用中文写：我是谁、我在学 Python。",
    git: "Commit：Add README intro。先不要 Publish 也行。",
  },
  {
    id: "d3",
    day: "第 3 天",
    when: "次日",
    minutes: "45",
    liao: "仍不看新章节。",
    doNow: "Publish 到 GitHub 网站。浏览器打开你的仓库页面，确认能看到 README。",
    git: "记住三件事：改文件 → Commit（拍照存档）→ Push/Publish（上传网站）。",
  },
  {
    id: "d4",
    day: "第 4 天",
    when: "开始廖雪峰",
    minutes: "90",
    liao: "安装 Python + Python 解释器 + 第一个 Python 程序",
    doNow: "按教程装 Python 3，勾选 Add python.exe to PATH。在 Cursor 新建 hello.py，打印一行字，运行成功。",
    git: "Commit：Add hello.py。",
  },
  {
    id: "d5",
    day: "第 5 天",
    when: "平日晚上",
    minutes: "90",
    liao: "使用文本编辑器 + 输入和输出",
    doNow: "写 input_demo.py：用 input() 问名字，print 出来。例题必须自己敲，不要只看。",
    git: "Commit：Add input demo。",
  },
  {
    id: "d6",
    day: "第 6 天",
    when: "平日晚上",
    minutes: "90",
    liao: "数据类型和变量 + 字符串和编码（编码看不懂就跳过，先会用字符串）",
    doNow: "练习：整数除法、余数、字符串拼接。对照你学过的 C：Python 不用声明类型。",
    git: "Commit：Add variables notes.py（把练习写在文件里）。",
  },
  {
    id: "d7",
    day: "第 7 天",
    when: "周末可拉长",
    minutes: "90",
    liao: "使用 list 和 tuple + 条件判断",
    doNow: "写 grade.py：输入分数，打印及格/不及格。再用 list 存 3 个分数求平均。",
    git: "Commit。本周复习：打开 GitHub 网站看 7 天提交记录。",
  },
  {
    id: "d8",
    day: "第 8 天",
    when: "平日晚上",
    minutes: "90+30 算法",
    liao: "循环（for/while）+ 使用 dict 和 set；模式匹配跳过",
    doNow: "dict 练习：名字→分数。算法开始：力扣 1. 两数之和（暴力双重循环即可）。",
    git: "Commit。算法题写在 algo/。",
  },
  {
    id: "d9",
    day: "第 9 天",
    when: "平日晚上",
    minutes: "90",
    liao: "调用函数 + 定义函数（递归先跳过）",
    doNow: "写两个函数：celsius_to_f 和 is_pass(score)。",
    git: "Commit。",
  },
  {
    id: "d10",
    day: "第 10 天",
    when: "平日晚上",
    minutes: "90",
    liao: "函数的参数（默认参数看懂即可）",
    doNow: "只做 notes/lesson10 测验 + exercises/lesson10（含 grade 改成函数）。批改完再做力扣有效括号。不要另写一份 py。",
    git: "Commit 测验和练习。",
  },
  {
    id: "d11",
    day: "第 11 天",
    when: "平日晚上",
    minutes: "90",
    liao: "使用模块 + 安装第三方模块（pip、venv）",
    doNow: "按 notes/lesson11_实操_模块与venv.md：写 greet_mod + use_greet；根目录建 .venv 并 pip install requests。Anaconda 不装。",
    git: "加 .gitignore（.venv/、__pycache__/）。Commit 练习，不要提交 .venv。",
  },
  {
    id: "d12",
    day: "第 12 天",
    when: "平日晚上",
    minutes: "90",
    liao: "错误处理（try/except）",
    doNow: "input 转 int，输错了不要闪退。算法：二分查找。",
    git: "Commit。",
  },
  {
    id: "d13",
    day: "第 13 天",
    when: "平日晚上",
    minutes: "90",
    liao: "IO 编程：文件读写 + 操作文件和目录",
    doNow: "读写 notes.txt。再试 csv：一行 date,amount。",
    git: "样例可提交；不要提交真实账单。",
  },
  {
    id: "d14",
    day: "第 14 天",
    when: "周末复盘",
    minutes: "120",
    liao: "不学新章。整理文件夹：notes/、exercises/、algo/。",
    doNow: "能独立：打开 Cursor、改代码、Commit、网站看到更新。",
    git: "Commit：Organize folders。",
  },
  {
    id: "d15",
    day: "第 15–16 天",
    when: "第 3 周",
    minutes: "每天 90",
    liao: "面向对象：类和实例（访问限制、多态可略读）",
    doNow: "写 LedgerEntry 类：日期、金额。算法继续哈希题。",
    git: "每天至少 1 次 Commit。",
  },
  {
    id: "d16",
    day: "第 17–21 天",
    when: "第 3 周末到第 4 周",
    minutes: "每天 90",
    liao: "跳过函数式/元类/线程/GUI/Web/异步。JSON 要看。",
    doNow: "开始 dca-ledger：add 命令把一行写进 CSV。",
    git: "可仍在 python-learn，或新建 dca-ledger。",
  },
];

const LIAO_SKIP = [
  ["函数式编程整章", "实习前用不到，以后再看"],
  ["面向对象高级（slots/元类）", "过深"],
  ["进程和线程、异步 IO", "阶段 A 不做"],
  ["图形界面、邮件、TCP/UDP", "不做"],
  ["Web 框架", "Agent 岗不靠这个入门"],
  ["递归、模式匹配", "第一遍跳过，以免卡住"],
];

const WEEKLY_SEGMENTS = [
  { id: "python", value: 7, color: "blue" as const },
  { id: "algo", value: 3, color: "purple" as const },
  { id: "docs", value: 2, color: "green" as const },
  { id: "finance", value: 2, color: "orange" as const },
];

const PHASES = [
  {
    id: "A",
    when: "2026.9–11",
    name: "Python 先于一切",
    exit: "CLI 小工具上 GitHub",
    intern: "不投 Agent 岗；算法不断档",
  },
  {
    id: "B",
    when: "2026.12–2027.3",
    name: "最小 Agent 闭环",
    exit: "工具+RAG+评测；【更新】LangChain/Dify 跑通一次；2–3 Skill",
    intern: "开始准备简历",
  },
  {
    id: "C",
    when: "2027.3–5",
    name: "投递窗口",
    exit: "日常/暑假实习面试",
    intern: "可早于暑假上车",
  },
  {
    id: "D",
    when: "2027.6–8",
    name: "第一段实习",
    exit: "脱敏复盘 + 导师评价",
    intern: "【更新】优先恒生/同花顺/杭州 AI 创业",
  },
  {
    id: "E",
    when: "2027.9–2028.6",
    name: "加深 + 二段实习 + 笔试",
    exit: "编排/Memory；【更新】笔试选择+编程接到位",
    intern: "【更新】冲蚂蚁/淘天/阿里云/字节",
  },
  {
    id: "F",
    when: "2028.7–2029.6",
    name: "秋招收口",
    exit: "杭州 Agent 应用正式岗",
    intern: "2028.8–10 秋招主战场",
  },
];

const JD_ROWS: {
  clause: string;
  kind: string;
  when: string;
  proof: string;
  checkId: string;
}[] = [
  {
    clause: "计算机/软工/AI 相关",
    kind: "硬门槛",
    when: "课业全程",
    proof: "专业在读即可，成绩别挂科",
    checkId: "jd-major",
  },
  {
    clause: "熟练 Python",
    kind: "硬门槛",
    when: "阶段 A",
    proof: "独立写 CLI、会 venv/Git、作业自己能改",
    checkId: "jd-python",
  },
  {
    clause: "独立完成至少一个 LLM/Agent 小项目",
    kind: "硬门槛",
    when: "阶段 B",
    proof: "GitHub README 一页讲清架构 + 可跑",
    checkId: "jd-project",
  },
  {
    clause: "能讲 Context / Skills / Subagent / Memory / MCP",
    kind: "硬门槛",
    when: "阶段 B",
    proof: "自己画流程图，面试能口头走一遍",
    checkId: "jd-concepts",
  },
  {
    clause: "Tool / MCP 生成与调试",
    kind: "职责",
    when: "B → D",
    proof: "项目里至少 2 个真实工具；实习再碰 MCP",
    checkId: "jd-tools",
  },
  {
    clause: "Skills 写法、Prompt 迭代【更新】",
    kind: "职责",
    when: "B → D",
    proof: "2–3 个公开 Skill（SKILL.md）+ 前后对比",
    checkId: "jd-skills",
  },
  {
    clause: "Subagent 调试",
    kind: "职责",
    when: "E 或实习",
    proof: "二段实习或大三编排实验",
    checkId: "jd-subagent",
  },
  {
    clause: "Context Engineering 与 Memory",
    kind: "职责",
    when: "B 概念 / E 实验",
    proof: "写入 vs 召回对比表，或压缩前后评测",
    checkId: "jd-memory",
  },
  {
    clause: "BadCase 与评测集",
    kind: "职责",
    when: "阶段 B 起",
    proof: "固定 10 题评测表，失败原因分类",
    checkId: "jd-eval",
  },
  {
    clause: "【更新】LangChain 或 Dify 跑通过",
    kind: "加分",
    when: "阶段 B",
    proof: "简历一句 + 能讲「用它做了什么 / 为何不全靠它」",
    checkId: "jd-framework",
  },
  {
    clause: "【更新】Java 能写简单后端接口",
    kind: "硬门槛",
    when: "课内→E（跟课表）",
    proof: "课设或小 Demo：HTTP+JSON；不深 JVM",
    checkId: "jd-java",
  },
  {
    clause: "【更新】Linux + Git + SQL",
    kind: "硬门槛",
    when: "E 笔试专项加码",
    proof: "笔试/上机不慌；恒生等 JD 点名",
    checkId: "jd-linux-sql",
  },
  {
    clause: "【更新】SFT/LoRA 常识（非训练）",
    kind: "加分",
    when: "阶段 E · 2–3 小时",
    proof: "能口述：微调是什么、何时用、与 RAG 怎么选",
    checkId: "jd-lora",
  },
  {
    clause: "日常用 Cursor / Claude Code 写代码",
    kind: "加分",
    when: "现在开始",
    proof: "能讲一次长任务：哪步会烂、你怎么接管",
    checkId: "jd-cursor",
  },
  {
    clause: "用 Agent 跑完长链路任务并有洞察",
    kind: "加分",
    when: "A–B 用课业/项目练",
    proof: "重构作业、调研、或投研 Agent",
    checkId: "jd-longchain",
  },
];

const WEEK_PLAN: {
  id: string;
  week: string;
  dates: string;
  python: string;
  algo: string;
  ship: string;
}[] = [
  {
    id: "w1",
    week: "W1",
    dates: "9/1–9/7",
    python: "类型、if/for、list/dict；对照 C：没有指针，赋值是引用",
    algo: "两数之和、有效括号（各 1 题，先暴力）",
    ship: "装好 Python、Git、Cursor；建仓库 README",
  },
  {
    id: "w2",
    week: "W2",
    dates: "9/8–9/14",
    python: "函数、模块、`if __name__`、venv、pip",
    algo: "二分查找、移除元素",
    ship: "用 venv 跑通课内第一份 Python 作业",
  },
  {
    id: "w3",
    week: "W3",
    dates: "9/15–9/21",
    python: "读写文本、JSON、CSV；异常 try/except",
    algo: "哈希：字母异位词、存在重复元素",
    ship: "脚本：读一份 CSV 打印行数与列名",
  },
  {
    id: "w4",
    week: "W4",
    dates: "9/22–9/28",
    python: "pathlib、argparse；Git add/commit/log/diff",
    algo: "栈队列入门 1–2 题",
    ship: "每天至少 1 次有意义的 commit",
  },
  {
    id: "w5",
    week: "W5",
    dates: "9/29–10/5",
    python: "class、dataclass、类型标注；包结构",
    algo: "数组双指针",
    ship: "把 CSV 脚本改成函数 + assert",
  },
  {
    id: "w6",
    week: "W6",
    dates: "10/6–10/12",
    python: "requests 调公开 JSON API；超时与错误处理",
    algo: "滑动窗口思路题 1 道",
    ship: "CLI 子命令：add 追加一行 CSV",
  },
  {
    id: "w7",
    week: "W7",
    dates: "10/13–10/19",
    python: "项目骨架：src/、tests/、requirements.txt",
    algo: "复习 W1–W4 错题",
    ship: "dca-ledger：list 按日期列出",
  },
  {
    id: "w8",
    week: "W8",
    dates: "10/20–10/26",
    python: "分组统计：按月、按标的求和",
    algo: "前缀和或哈希计数 2 题",
    ship: "summary 输出月度投入与累计",
  },
  {
    id: "w9",
    week: "W9",
    dates: "10/27–11/2",
    python: "README 写法；.gitignore；不提交 venv",
    algo: "爬楼梯（简单 DP）",
    ship: "样例 data/sample.csv + 使用说明",
  },
  {
    id: "w10",
    week: "W10",
    dates: "11/3–11/9",
    python: "自己走一遍：克隆、venv、跑命令、修一个 bug",
    algo: "模拟 45 分钟：3 道简单题计时",
    ship: "GitHub 公开；阶段 A 出口完成",
  },
];

const SKILL_CHECKS: { id: string; label: string }[] = [
  { id: "sk-py-syntax", label: "能不看文档写出 for/dict/函数" },
  { id: "sk-venv", label: "会创建 venv 并 freeze 依赖" },
  { id: "sk-git", label: "会 commit，能用 git diff 讲改了什么" },
  { id: "sk-csv", label: "会读写 CSV/JSON 并处理坏行" },
  { id: "sk-cli", label: "会用 argparse 做子命令" },
  { id: "sk-cursor", label: "Cursor 生成的代码自己审过再提交" },
  { id: "sk-algo12", label: "累计做完至少 12 道简单题并复盘错题" },
  { id: "sk-ship", label: "dca-ledger 已公开且别人按 README 能跑" },
];

const DEFAULT_WEEK_TODOS: TodoItem[] = WEEK_PLAN.map((w) => ({
  id: w.id,
  content: `${w.week} ${w.dates} · ${w.ship}`,
  status: "pending",
}));

export default function HangzhouAgentRoadmap() {
  const [tab, setTab] = useCanvasState<TabId>("home-tab", "start");
  const [checks, setChecks] = useCanvasState<Record<string, boolean>>(
    "checks",
    {},
  );
  const [weekTodos, setWeekTodos] = useCanvasState(
    "week-todos",
    DEFAULT_WEEK_TODOS,
  );

  const ghDone = GITHUB_STEPS.filter((s) => checks[s.id]).length;
  const jdDone = JD_ROWS.filter((r) => checks[r.checkId]).length;
  const skillDone = SKILL_CHECKS.filter((s) => checks[s.id]).length;
  const weeksDone = weekTodos.filter((t) => t.status === "completed").length;

  function toggleCheck(id: string, value: boolean) {
    setChecks((prev) => ({ ...prev, [id]: value }));
  }

  return (
    <Stack gap={20}>
      <Stack gap={8}>
        <H1>杭州 Agent 开发工程师 · 大二到毕业</H1>
        <Text tone="secondary">
          2026-09 市场校准版。框架保留；【更新】见「市场校准」页。完整文档也在仓库
          notes/roadmap_杭州Agent_2026市场校准版.md。每天约 2 小时。
        </Text>
      </Stack>

      {tab !== "start" && (
        <Grid columns={4} gap={12}>
          <Stat
            value={`${ghDone}/${GITHUB_STEPS.length}`}
            label="GitHub 起步步骤"
            tone={ghDone === GITHUB_STEPS.length ? "success" : "info"}
          />
          <Stat value="2027 暑假" label="最晚第一段实习" tone="warning" />
          <Stat value={`${weeksDone}/10`} label="前 90 天周次完成" />
          <Stat
            value={`${jdDone}/${JD_ROWS.length}`}
            label="JD 条款已对齐"
          />
        </Grid>
      )}

      <Row gap={8} wrap>
        {TABS.map((t) => (
          <span key={t.id}>
            <Pill active={tab === t.id} onClick={() => setTab(t.id)}>
              {t.label}
            </Pill>
          </span>
        ))}
      </Row>

      {tab === "start" && (
        <BeginnerStart checks={checks} onToggle={toggleCheck} />
      )}
      {tab === "overview" && <Overview checks={checks} onToggle={toggleCheck} />}
      {tab === "timeline" && <Timeline />}
      {tab === "market" && <MarketCalibrate />}
      {tab === "jd" && <JdMap checks={checks} onToggle={toggleCheck} />}
      {tab === "days90" && (
        <Days90
          checks={checks}
          onToggle={toggleCheck}
          skillDone={skillDone}
          weekTodos={weekTodos}
          setWeekTodos={setWeekTodos}
        />
      )}
      {tab === "finance" && <Finance />}

      <Text size="small" tone="tertiary">
        学期中课外约 12–14 小时（≈每天 2 小时）；考试周减半。不要同时开
        PyTorch 训练、前端全栈、量化高频。
      </Text>
    </Stack>
  );
}

function BeginnerStart({
  checks,
  onToggle,
}: {
  checks: Record<string, boolean>;
  onToggle: (id: string, value: boolean) => void;
}) {
  const weekday = new Date().getDay();
  const isSunday = weekday === 0;
  const resumeFrom = DAY_SCRIPT.findIndex((d) => d.id === "d9");
  const nextOpen =
    DAY_SCRIPT.find(
      (d, i) => i >= resumeFrom && !checks[`day-${d.id}`],
    ) ??
    DAY_SCRIPT.find((d) => !checks[`day-${d.id}`]) ??
    DAY_SCRIPT[DAY_SCRIPT.length - 1];
  const [picked, setPicked] = useCanvasState<string | null>("today-day", null);
  const dayId = picked ?? nextOpen.id;
  const focus = DAY_SCRIPT.find((d) => d.id === dayId) ?? nextOpen;
  const dayDone = DAY_SCRIPT.filter((d) => checks[`day-${d.id}`]).length;
  const ghLeft = GITHUB_STEPS.filter((s) => !checks[s.id]);

  const liaoId = `part-${focus.id}-liao`;
  const doId = `part-${focus.id}-do`;
  const gitId = `part-${focus.id}-git`;
  const reviewId = "sunday-review";

  return (
    <Stack gap={16}>
      {isSunday ? (
        <Callout tone="warning" title="今天周日：先复习，不学新章">
          错题笔记不是每天必看，只在周日（或一次测验连错好几题时）翻。今天打开
          notes/复习_错题与存疑.md，口述卡住的那几条。力扣新题今天别开。
        </Callout>
      ) : (
        <Callout tone="info">
          教程：
          <Link href="https://www.liaoxuefeng.com/wiki/1016959663602400">
            廖雪峰 Python
          </Link>
          。递归、模式匹配第一遍跳过。
        </Callout>
      )}

      <H2>今日要完成</H2>
      <Card>
        <CardHeader
          trailing={<Pill size="sm" active>{isSunday ? "复习日" : `${focus.minutes} 分钟`}</Pill>}
        >
          {isSunday
            ? `复习日 · 进度停在 ${focus.day}`
            : `${focus.day} · 打开电脑就做这些`}
        </CardHeader>
        <CardBody>
          <Stack gap={10}>
            {isSunday && (
              <Checkbox
                checked={!!checks[reviewId]}
                onChange={(v) => onToggle(reviewId, v)}
                label="（仅周日）错题笔记过一遍，能口述 5～8 句"
              />
            )}
            <Checkbox
              checked={!!checks[liaoId]}
              onChange={(v) => onToggle(liaoId, v)}
              label={`看：${focus.liao}`}
            />
            <Checkbox
              checked={!!checks[doId]}
              onChange={(v) => onToggle(doId, v)}
              label={`做：${focus.doNow}`}
            />
            <Checkbox
              checked={!!checks[gitId]}
              onChange={(v) => onToggle(gitId, v)}
              label={`Git：${focus.git}`}
            />
            <Divider />
            <Checkbox
              checked={!!checks[`day-${focus.id}`]}
              onChange={(v) => onToggle(`day-${focus.id}`, v)}
              label={`${focus.day} 整块完成（勾了下次自动跳下一天）`}
            />
          </Stack>
        </CardBody>
      </Card>

      <Text tone="secondary">
        未勾完的天会自动顶上来。已完成 {dayDone}/{DAY_SCRIPT.length}。点错天才改选：
      </Text>
      <Row gap={8} wrap>
        {DAY_SCRIPT.map((d) => (
          <span key={d.id}>
            <Pill
              active={dayId === d.id}
              onClick={() => setPicked(d.id)}
            >
              {checks[`day-${d.id}`] ? `${d.day} ✓` : d.day}
            </Pill>
          </span>
        ))}
      </Row>

      <H3>每天固定流程（≈2 小时）</H3>
      <Table
        headers={["时段", "做什么", "多久"]}
        rows={[
          ["先看本页「今日要完成」", "按勾选做，做完打勾", "1 分钟"],
          ["接着", "廖雪峰/项目：看 + 自己敲", "70 分钟"],
          ["最后", "GitHub Desktop Commit + Push", "10 分钟"],
          ["周二四六", "力扣 1 道（写入 algo/）", "30–40 分钟"],
          ["周日", "只复习，不学新章", "40 分钟"],
        ]}
      />

      {ghLeft.length > 0 && (
        <Stack gap={6}>
          <H3>GitHub 起步（还没勾完的）</H3>
          {ghLeft.map((s) => (
            <div key={s.id}>
              <Checkbox
                checked={false}
                onChange={(v) => onToggle(s.id, v)}
                label={s.label}
              />
            </div>
          ))}
        </Stack>
      )}

      <H3>廖雪峰：第一遍跳过</H3>
      <Table headers={["跳过的章", "原因"]} rows={LIAO_SKIP} />
    </Stack>
  );
}

function Overview({
  checks,
  onToggle,
}: {
  checks: Record<string, boolean>;
  onToggle: (id: string, value: boolean) => void;
}) {
  const theme = useHostTheme();
  return (
    <Stack gap={16}>
      <Callout tone="info">
        【更新】第一段实习优先恒生/同花顺/杭州创业；第二段再冲蚂蚁/淘天/阿里云/字节。蚂蚁星
        PlanA 了解即可。金融是加分项不是入场券。
      </Callout>

      <H2>学期中时间怎么切（每天 ≈2h）</H2>
      <UsageBar
        total={14}
        topLeftLabel="课外 14 小时/周"
        topRightLabel="Python/项目 7 · 算法 3 · Agent 文档 2 · 理财 2"
        segments={WEEKLY_SEGMENTS}
      />

      <H2>主路径</H2>
      <Table
        headers={["阶段", "窗口", "做什么", "出口"]}
        striped
        rows={PHASES.map((p) => [p.id, p.when, p.name, p.exit])}
      />

      <H2>现在不要做的三件事</H2>
      <Stack gap={6}>
        <Text>现在投大厂 Agent 实习：先用 A+B 换入场券。</Text>
        <Text>为理财考 CFA 或转专业：会挤掉项目和算法。</Text>
        <Text>只看课不上 GitHub：面试官要可跑链路和失败解释。</Text>
      </Stack>

      <H2>本学期纪律（可勾）</H2>
      <Stack gap={8}>
        <Checkbox
          checked={!!checks["habit-cursor"]}
          onChange={(v) => onToggle("habit-cursor", v)}
          label="Cursor 写的代码自己读 diff 再交"
        />
        <Checkbox
          checked={!!checks["habit-commit"]}
          onChange={(v) => onToggle("habit-commit", v)}
          label="学习日至少一次有说明的 git commit"
        />
        <Checkbox
          checked={!!checks["habit-algo"]}
          onChange={(v) => onToggle("habit-algo", v)}
          label="算法错题本：不会的隔一周再做"
        />
      </Stack>

      <Text size="small" tone="tertiary" style={{ color: theme.text.tertiary }}>
        完整校准说明见「市场校准」页签与仓库 notes/roadmap_杭州Agent_2026市场校准版.md。
      </Text>
    </Stack>
  );
}

function Timeline() {
  return (
    <Stack gap={16}>
      <H2>2026.9 – 2029.6</H2>
      <Table
        headers={["阶段", "时间", "目标", "实习策略"]}
        striped
        stickyHeader
        rows={PHASES.map((p) => [p.id, p.when, p.name, p.intern])}
        rowTone={["info", "info", "warning", "success", "info", "warning"]}
      />

      <H3>阶段 A · Python</H3>
      <Text>
        语法、venv、CSV/JSON、异常、Git。算法每周 3–4 题不断档。出口 dca-ledger；结束前检查：README
        三步能跑、.gitignore、venv 说明、至少一次跨机复现。
      </Text>

      <H3>阶段 B · 最小 Agent【更新】</H3>
      <Text>
        API → 工具 → RAG → 10 条 BadCase（须含工具失败类）。出口硬标准：参数校验或失败样例、挂了有重试/降级/人审、README
        可维护。LangChain/Dify 跑通一次能讲取舍。Skill 支线 2–3 个。证据合同：没证据不写「企业级/大幅提升」。
      </Text>

      <H3>阶段 C · 投递</H3>
      <Text>
        材料日历：2027.1 简历初稿 → 2 月 JD 对照表 → 3 月起双周投递表。三个故事须带证据。暑假仍是底线。
      </Text>

      <H3>阶段 D · 第一段实习【更新】</H3>
      <Text>
        恒生（Skills/评测）、同花顺（业务+工程）、杭州创业（能下场改）。结束交付：架构图 + ≥5 BadCase + 3
        个改过的坑。
      </Text>
      <H3>阶段 E · 大三【更新】</H3>
      <Text>
        二段冲刺：蚂蚁、淘天、阿里云、字节。课内 Java 对齐到「能写简单接口」。笔试专项：选择+编程；OS/网络/数据库；Linux/Git/SQL。SFT/LoRA
        只花 2–3 小时搞懂边界。技术加深只选一条编排或 Memory。
      </Text>

      <H3>阶段 F · 秋招</H3>
      <Text>
        2028.8–10 搜 Agent/大模型应用工程，地点杭州。作品集两个即可。
      </Text>
    </Stack>
  );
}

function MarketCalibrate() {
  return (
    <Stack gap={16}>
      <Callout tone="success">
        2026-09 真实 JD 调研（约 22 条）验证了原框架五条核心；本页只列增补与校准。
      </Callout>

      <H2>市场验证 · 保留不动</H2>
      <Table
        headers={["保留项", "市场信号"]}
        rows={[
          ["Python 优先", "10+ 家 JD 第一语言；蚂蚁/阿里/字节/恒生点名"],
          ["可跑 Agent 项目 + README", "蚂蚁：课程/开源/个人作品均可加分"],
          ["Tool/MCP、RAG、评测 BadCase", "阿里写完整 RAG + LLMOps 评测监控"],
          ["Cursor / Claude Code", "恒生智能体岗点名类工具"],
          ["中小/本地第一段实习", "恒生、同花顺招本科且在杭有 Agent 岗群"],
        ]}
      />

      <H2>【更新】必须补进计划</H2>
      <Table
        headers={["缺口", "写进哪", "做到什么程度"]}
        striped
        rows={[
          [
            "Java 第二语言",
            "课内→E",
            "跟课表（多在大二下/大三上）；能写 HTTP+JSON 接口；不深 JVM。Go 非主选",
          ],
          [
            "笔试专项",
            "E（2027.9 起）",
            "每周算法衔接到 2028.6 选择+编程；OS/网络/库选择；Linux/Git/SQL",
          ],
          [
            "LangChain/Dify",
            "B",
            "跑通一次 RAG/Agent；简历能讲取舍；不深挖全家桶",
          ],
          [
            "SFT/LoRA",
            "E",
            "2–3 小时常识：微调是什么、何时用、vs RAG；不训练",
          ],
          [
            "Skill 支线",
            "B",
            "2–3 个 SKILL.md 上 GitHub；公式用熟→修烂→公开；A 前不碰",
          ],
          [
            "B 出口硬标准 + 证据合同",
            "B→C",
            "工具失败样例、挂了怎么办、评测含工具失败；没证据不写企业级/大幅提升",
          ],
          [
            "投递材料日历",
            "C 前",
            "2027.1 简历初稿；2 月 JD 对照；3 月起双周投递表",
          ],
          [
            "D 结束三件套",
            "D",
            "架构图 + ≥5 BadCase + 3 个改过的坑（喂二段面试）",
          ],
        ]}
      />
      <H2>【更新】公司分层</H2>
      <Table
        headers={["层级", "目标"]}
        rows={[
          ["D 第一段优先", "恒生、同花顺、杭州 AI 创业"],
          ["E 第二段冲刺", "蚂蚁、淘天、阿里云、字节（应用/Agent）"],
          ["了解即可", "蚂蚁星 PlanA 等顶尖专项——不作为目标"],
        ]}
      />

      <H2>【更新】薪资锚点（防噪音）</H2>
      <Table
        headers={["锚点", "用法"]}
        rows={[
          ["阿里 Agent 实习约 450–600 元/天", "谈薪区间参考"],
          ["恒生本科校招约 8k–1.1 万", "本科对本科档"],
          ["杭州应届执行到位约 15k/月", "正常档，非天花板"],
          ["应届 85 万 / 实习日薪 5500", "营销号——忽略"],
        ]}
      />

      <H2>双非拓展（每天 2h）</H2>
      <Text>
        杭州双非软工更稳的路径是：本地金融科技第一段实习证明「能干活」→ 用项目+评测+Skill
        故事冲二段大厂应用岗。同花顺摘星/AIME 当加分通道，不硬赌。算法从阶段 A
        不断档，因为笔试往往早于面试。
      </Text>

      <Callout tone="warning">
        你现在仍在阶段 A：先函数 + 两数之和入库。不要提前开 LangChain / Skill / Java
        深造。
      </Callout>
    </Stack>
  );
}

function JdMap({
  checks,
  onToggle,
}: {
  checks: Record<string, boolean>;
  onToggle: (id: string, value: boolean) => void;
}) {
  return (
    <Stack gap={16}>
      <Callout tone="neutral">
        条款对齐 2026-09 市场调研 + 原 Boss/淘天公开要求。勾选 = 已能向面试官证明。
      </Callout>
      <Table
        headers={["条款", "类型", "何时对齐", "证明物", "完成"]}
        striped
        stickyHeader
        rows={JD_ROWS.map((r) => [
          r.clause,
          r.kind,
          r.when,
          r.proof,
          <Checkbox
            checked={!!checks[r.checkId]}
            onChange={(v) => onToggle(r.checkId, v)}
          />,
        ])}
      />
      <H3>面试三个故事（阶段 C 前背熟）</H3>
      <Text>1. 项目：用户、工具、失败过什么、你怎么改评测。</Text>
      <Text>2. 排障：报错或幻觉如何定位（日志、复现、缩小上下文）。</Text>
      <Text>3. 长任务：Cursor/Agent 卡在哪、你何时接手。——Skill 支线喂 2 和 3。</Text>
    </Stack>
  );
}

function Days90({
  checks,
  onToggle,
  skillDone,
  weekTodos,
  setWeekTodos,
}: {
  checks: Record<string, boolean>;
  onToggle: (id: string, value: boolean) => void;
  skillDone: number;
  weekTodos: TodoItem[];
  setWeekTodos: (
    action: TodoItem[] | ((prev: TodoItem[]) => TodoItem[]),
  ) => void;
}) {
  const current = weekTodos.find((t) => t.status !== "completed") ?? weekTodos[0];
  const detail = WEEK_PLAN.find((w) => w.id === current?.id) ?? WEEK_PLAN[0];

  return (
    <Stack gap={16}>
      <H2>2026.9–11 · 十周执行表</H2>
      <Text tone="secondary">
        当前焦点：{detail.week}（{detail.dates}）。技能 {skillDone}/{SKILL_CHECKS.length}。
      </Text>

      <Grid columns="1.1fr 0.9fr" gap={16}>
        <Stack gap={10}>
          <H3>本周焦点</H3>
          <Card>
            <CardHeader trailing={<Pill size="sm" active>{detail.week}</Pill>}>
              {detail.dates}
            </CardHeader>
            <CardBody>
              <Stack gap={8}>
                <Text weight="semibold">Python</Text>
                <Text>{detail.python}</Text>
                <Divider />
                <Text weight="semibold">算法（3–4 题）</Text>
                <Text>{detail.algo}</Text>
                <Divider />
                <Text weight="semibold">本周必须交出去的东西</Text>
                <Text>{detail.ship}</Text>
              </Stack>
            </CardBody>
          </Card>
          <TodoList
            todos={weekTodos}
            onTodoClick={(todo) => {
              setWeekTodos((prev) =>
                prev.map((t) =>
                  t.id === todo.id
                    ? {
                        ...t,
                        status:
                          t.status === "completed" ? "pending" : "completed",
                      }
                    : t,
                ),
              );
            }}
          />
        </Stack>

        <Stack gap={10}>
          <H3>第一个 GitHub 题目：dca-ledger</H3>
          <Text>
            本地定投 CSV 统计 CLI。练工程卫生，为阶段 B 留数据格式。
          </Text>
          <Table
            headers={["项", "约定"]}
            rows={[
              ["仓库名", "dca-ledger"],
              ["输入", "data/ledger.csv"],
              ["列", "date, symbol, amount_cny, note"],
              ["命令", "add / list / summary"],
              ["禁止", "提交 venv、密钥、真实隐私"],
            ]}
          />
          <H3>阶段 A 技能清单</H3>
          <Stack gap={6}>
            {SKILL_CHECKS.map((s) => (
              <div key={s.id}>
                <Checkbox
                  checked={!!checks[s.id]}
                  onChange={(v) => onToggle(s.id, v)}
                  label={s.label}
                />
              </div>
            ))}
          </Stack>
          <Button
            variant="secondary"
            onClick={() => setWeekTodos(DEFAULT_WEEK_TODOS)}
          >
            重置十周勾选
          </Button>
        </Stack>
      </Grid>

      <Callout tone="warning">
        11 月中旬出口：别人按 README 能跑 dca-ledger。未完成不要开始 LangChain；可延后一周，不要并行开
        Agent 框架。
      </Callout>
    </Stack>
  );
}

function Finance() {
  return (
    <Stack gap={16}>
      <H2>就业优先结论</H2>
      <Table
        headers={["做法", "建议"]}
        rows={[
          ["CFA、实盘当主业、量化竞赛", "不做求职主线"],
          ["CAPE 定投、VIX、估值分位", "个人素养 + Agent 业务场景"],
          ["蚂蚁", "智能体工程即可，金融证书非必须"],
          ["同花顺", "有投研 Agent 更加分；普通通道优先，摘星不硬赌"],
        ]}
      />
      <H3>阶段 B 的金融题材（不要提前做）</H3>
      <Text>
        投研助手：公开数据或手工 CSV → 工具解释 CAPE/波动 → 定投规则说明 + 局限性。面试讲工具与评测，少讲荐股。
      </Text>
    </Stack>
  );
}
