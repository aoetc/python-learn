# 简答11：不同包

**结论：先看类是否可见；类可见后，一般只能直接访问 public 成员。**

`TestStudent_xueyuan` 在 `teststudentpackage`，用 `import studentpackage.*;`

| 代码 | 结果 | 原因 |
|------|------|------|
| `Student s1 = new Student()` | 可以 | `Student` 是 **public class** |
| `s1.id = ...` | 可以 | public 成员 |
| `s1.name = ...` | **不行** | protected，异包且非子类 |
| `s1.sex = ...` | **不行** | private |
| `s1.age = ...` | **不行** | 默认只同包 |
| `XueYuan xy1 = new XueYuan()` | **不行** | `XueYuan` 是**默认类**，异包看不见 |

交作业：说明哪些行编译失败即可。
