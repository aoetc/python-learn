# 简答10：同一个包、不同类

**结论：private 不可见，public / protected / 默认（包可见）都可以。**

题里 `TestStudent` 与 `Student` 都在 `studentpackage`：

| 访问 | 行 | 结果 |
|------|-----|------|
| `s1.id` | public | 可以 |
| `s1.name` | protected | 同包可以 |
| `s1.sex` | private | **编译错误** |
| `s1.age` | 默认 | 同包可以 |

交作业写法：贴两段代码，圈出 `s1.sex = 'M';` 不行，其余三行可以。
