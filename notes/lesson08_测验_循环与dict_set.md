# 第 8 天测验：循环 + dict / set

学完廖雪峰 **5.6 循环**、**5.7 使用 dict 和 set** 后做。  
**5.5 模式匹配先跳过。** 编程题在 `exercises/lesson08/`。

造容器先记：list=`[]`，tuple=`()`，dict=`{键: 值}`，set=`{值, 值}`。  
变量后面的 `[]`（如 `a[0]`、`d["李宏"]`）是**取值**，不是在造 list。

---

## 一、选择题（每题单选）

**1.** `scores = [90, 90, 85]` 是否合法？B

- A. 不合法，list 不能重复
- B. 合法，list 可以重复
- C. 必须改成 set
- D. 必须改成 tuple

**2.** 下面哪个是 dict？B

- A. `{"李宏", "王五"}`
- B. `{"李宏": 90, "王五": 85}`
- C. `["李宏", 90]`
- D. `("李宏", 90)`

**3.** `names = {"李宏", "李宏", "王五"}`，`len(names)` 是？A-B

- A. `3`
- B. `2`
- C. `1`
- D. 报错

**4.** `grade = {"李宏": 90, "王五": 85}`，`grade["李宏"]` 的值是？B

- A. `"李宏"`
- B. `90`
- C. `0`
- D. 报错

**5.** 空的 `{}` 是什么？存疑,不清楚{}是空的代指什么，但是（）应该是空tuple，[]不知道这个是否代表着空list---B

- A. 空 set
- B. 空 dict
- C. 空 list
- D. 空 tuple

**6.** 下面这段循环会打印几次 `hi`？B

```python
for i in range(3):
    print("hi")
```

- A. 2 次
- B. 3 次（`i` 为 0、1、2）
- C. 4 次
- D. 只打印一次

**7.** `subjects = ["Python", "数学"]`，打印每个科目，推荐写法是？C-A

- A. `for s in subjects: print(s)`
- B. `print(subjects(0))`
- C. `match subjects: ...`
- D. `subjects.append("英语")` 就会自动打印

**8.** dict 和 set 的主要区别是？B

- A. 一个省空间，一个省时间
- B. dict 是键对应值；set 只有一堆不重复的值，没有对应关系
- C. set 可以重复，dict 不能
- D. 它们完全一样，只是括号不同

**9.** `point = (3, 4)`，取第一个数应写成？B

- A. `point(0)`
- B. `point[0]`
- C. `point{0}`
- D. `point.0`

**10.** `grade = {"李宏": 90}`，把李宏的分数改成 95，应写成？B

- A. `grade.append(95)`
- B. `grade["李宏"] = 95`
- C. `grade.add(95)`
- D. `grade = 95`

---

## 二、判断题（对 / 错）

**1.** list 和 tuple 都可以有重复元素。对

**2.** dict 的**键**不能重复；**值**可以重复（两个人都可以是 90 分）。对

**3.** `grade["李宏"]` 里的 `[]` 表示正在创建一个 list。对，但是可能也要查找‘李宏’的分数

**4.** 空 set 要写成 `set()`，不能写成 `{}`。错-对

**5.** `for` 循环体必须缩进。其实我一直不懂缩进到底是社么意思，意义是什么。我觉得这一题答案是错-对

**6.** `"李宏" in grade` 可以判断 dict 里有没有这个键。对

**7.** set 适合「按名字查分数」。错 

**8.** `range(3)` 产生的是 1、2、3。错0.1.2

---

## 三、编程题（IDE 打开 `exercises/lesson08/`）

| 文件 | 练什么 |
|------|--------|
| `ex01_for_list.py` | for 遍历 list |
| `ex02_dict_grade.py` | dict 存姓名和分数、按键取值 |
| `ex03_set_unique.py` | set 去重 |
| `ex04_for_dict.py` | 加分：for 遍历 dict |

做完把选择题、判断题答案和编程题发我改。参考答案在文末，**做完再看**。

---

## 参考答案（做完再看）

<details>
<summary>选择题</summary>

1. B  2. B  3. B  4. B  5. B  6. B  7. A  8. B  9. B  10. B

</details>

<details>
<summary>判断题</summary>

1. 对  2. 对  3. 错  4. 对  5. 对  6. 对  7. 错  8. 错

</details>
