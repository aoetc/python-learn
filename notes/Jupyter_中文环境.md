# Jupyter 中文环境（本仓库）

最后更新：2026-11-05

## 已装好什么

- 虚拟环境：`.venv`（Python 3.13）
- JupyterLab + Notebook + ipykernel
- 中文语言包：`jupyterlab-language-pack-zh-CN`
- 数据课常用库：matplotlib / pandas / numpy
- 内核名：`Python（python-learn · 数可视）`

## 界面改成中文（已默认）

- 用户设置：`~/.jupyter/lab/user-settings/@jupyterlab/translation-extension/plugin.jupyterlab-settings` → `"locale": "zh_CN"`
- 环境覆盖：`.venv/share/jupyter/lab/settings/overrides.json`

若浏览器里仍是英文：右上角 **Settings → Language → 中文 (简体)**，刷新页面。

说明：语言包目前最新是 4.5，Lab 是 4.6；多数菜单已是中文，个别新按钮可能仍英文，属正常。

## 三种用法

### A. 桌面软件（推荐你这种「要下载软件」的用法）

已用 Homebrew 装好：**应用程序 → JupyterLab**（`/Applications/JupyterLab.app`）。

已写好绑定（改完后请**完全退出 App 再打开一次**）：
- Desktop 自带环境：`~/Library/jupyterlab-desktop/jlab_server`（含中文语言包、matplotlib、pandas）
- 全局 / 项目 `pythonPath` 已指向上述 `jlab_server/bin/python`
- 中文：Desktop 配置目录里 `locale: zh_CN`

1. 完全退出 JupyterLab（菜单 Quit）后重新打开
2. 打开文件夹选 `python-learn`，再开 `exercises/dataviz/00_环境自检.ipynb`
3. 若仍英文：Settings → Language → **中文 (简体)**，刷新

也可：`open /Applications/JupyterLab.app`  
或：`~/.local/bin/jlab /Users/aoetc/Developer/python-learn`

说明：Cursor / 终端继续用本仓库 `.venv`；**桌面 App 默认用 jlab_server**（两者库都齐，别混着用混了就看标题栏路径）。

### B. 终端启动（浏览器打开，不用另装 App）

```bash
cd /Users/aoetc/Developer/python-learn
source .venv/bin/activate
jupyter lab
```

### C. Cursor 里直接开 `.ipynb`

1. 安装推荐扩展：`ms-toolsai.jupyter`（扩展面板搜 Jupyter）
2. 打开 `exercises/dataviz/00_环境自检.ipynb`
3. 右上角选内核：**Python（python-learn · 数可视）**
4. 依次运行单元格

Cursor 里菜单语言跟编辑器走（不一定是中文）；**跑代码的环境**仍是上面的 `.venv`。

## 画图中文

已写入 `~/.ipython/profile_default/startup/00-matplotlib-zh.py`（PingFang SC 等）。  
Notebook 里标题写中文一般不会再出现方框；若仍方框，在单元格里再跑一次：

```python
import matplotlib.pyplot as plt
plt.rcParams["font.sans-serif"] = ["PingFang SC", "Heiti SC", "Arial Unicode MS"]
plt.rcParams["axes.unicode_minus"] = False
```

## 双机

`.venv` 和 `~/.jupyter` **不会进 Git**。换电脑要重新：

```bash
python3 -m venv .venv
source .venv/bin/activate
pip install jupyterlab notebook ipykernel jupyterlab-language-pack-zh-CN matplotlib pandas numpy
python -m ipykernel install --user --name python-learn --display-name "Python（python-learn · 数可视）"
```

然后按上文再写一次 locale 设置（或跟 AI 说「按 notes/Jupyter_中文环境.md 配一遍」）。
