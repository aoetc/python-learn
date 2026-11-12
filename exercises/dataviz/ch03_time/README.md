# 第3章 时间数据可视化 · 课件案例复刻

- 课件：`~/Downloads/第3章-时间数据.pdf`
- 实验文档：`~/Downloads/数据可视化-第3章实验.docx`
- 数据：`data/`
- Notebook：`第3章_时间数据_案例复刻.ipynb`

## 包含的案例

| 文件/章节 | 图表 | 库 |
|---|---|---|
| 案例 1 | 美国邮费阶梯图 | pyecharts |
| 案例 2 | 美国邮费折线图（固定 y 轴） | pyecharts |
| 案例 3 | 世界人口折线图 | matplotlib |
| 案例 4 | 美国失业率散点图 + 三次多项式拟合 | matplotlib |
| 案例 5 | FlowingData 订阅量散点图 | matplotlib |
| 案例 6 | 热狗大胃王柱形图 | pyecharts |
| 案例 7 | 热狗大胃王堆叠柱形图 | pyecharts |
| 实验 | 极坐标堆叠柱状图 2 种时间轴 | pyecharts |

实验的两张极坐标图会合并保存到 `output/polar_stacked.html`。

## 环境

- Python 3.13.15（仓库 `.venv`）
- 内核：`Python（python-learn · 数可视）`
- pyecharts 2.1.0、matplotlib 3.11.2、pandas 3.0.5

## 说明

课件默认从 `assets.pyecharts.org` 加载 ECharts，该域名当前网络不可达；Notebook 中把
`CurrentConfig.ONLINE_HOST` 改成了可访问的 `fastly.jsdelivr.net`。如果换网络后图表空白，
可以改回 `https://assets.pyecharts.org/assets/v6/`，或在有网环境下重新执行。
