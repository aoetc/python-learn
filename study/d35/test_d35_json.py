"""第 35 天验收测试。判分归机器，讲评归教练。
不要修改本文件；过了才有资格讨论"写得地不地道"。
"""
from __future__ import annotations

import importlib
import json
import sys
from pathlib import Path

import pytest

requests = pytest.importorskip("requests")

HERE = Path(__file__).resolve().parent
if str(HERE) not in sys.path:
    sys.path.insert(0, str(HERE))

PAYLOAD = {
    "name": "python-learn",
    "stargazers_count": 42,
    "description": "learning repo",
}


def load():
    """每个用例独立导入，避免收集阶段就炸掉。"""
    return importlib.import_module("d35_json")


class FakeResponse:
    def __init__(self, status_code=200, payload=None, bad_json=False):
        self.status_code = status_code
        self._payload = payload
        self._bad_json = bad_json

    def json(self):
        if self._bad_json:
            raise ValueError("Expecting value: line 1 column 1 (char 0)")
        return self._payload


@pytest.fixture
def calls(monkeypatch):
    """替换 requests.get，记录调用参数。"""
    recorded = {}

    def fake_get(url, **kwargs):
        recorded["url"] = url
        recorded["kwargs"] = kwargs
        return FakeResponse(200, PAYLOAD)

    monkeypatch.setattr(requests, "get", fake_get)
    return recorded


def test_get_json_returns_dict(calls):
    mod = load()
    data = mod.get_json("https://example.com/api.json")
    assert isinstance(data, dict)
    assert data["name"] == "python-learn"


def test_get_json_passes_timeout(calls):
    mod = load()
    mod.get_json("https://example.com/api.json", timeout=2.5)
    assert calls["kwargs"].get("timeout") == 2.5


def test_non_200_raises(monkeypatch):
    mod = load()
    monkeypatch.setattr(requests, "get", lambda url, **kw: FakeResponse(500, {}))
    with pytest.raises(RuntimeError):
        mod.get_json("https://example.com/api.json")


def test_bad_json_raises(monkeypatch):
    mod = load()
    monkeypatch.setattr(requests, "get", lambda url, **kw: FakeResponse(200, None, bad_json=True))
    with pytest.raises(RuntimeError):
        mod.get_json("https://example.com/api.json")


def test_network_error_raises(monkeypatch):
    mod = load()

    def boom(url, **kw):
        raise requests.Timeout("timed out")

    monkeypatch.setattr(requests, "get", boom)
    with pytest.raises(RuntimeError):
        mod.get_json("https://example.com/api.json")


def test_main_success(calls, capsys):
    mod = load()
    rc = mod.main([]) if "argv" in mod.main.__code__.co_varnames else mod.main()
    out = capsys.readouterr().out
    assert rc == 0
    lines = [ln for ln in out.splitlines() if ln.strip()]
    assert len(lines) >= 2, f"至少要打印 2 个字段，实际 {lines!r}"


def test_main_failure(monkeypatch, capsys):
    mod = load()

    def boom(url, **kw):
        raise requests.ConnectionError("no network")

    monkeypatch.setattr(requests, "get", boom)
    rc = mod.main([]) if "argv" in mod.main.__code__.co_varnames else mod.main()
    captured = capsys.readouterr()
    assert rc == 1
    assert captured.err.strip(), "失败时必须在 stderr 说明原因"
    assert captured.out.strip() == "", "失败时不要在 stdout 打印半截结果"


def test_no_hardcoded_secret():
    """静态检查：不许把 key 写进代码。"""
    src = (HERE / "d35_json.py").read_text(encoding="utf-8")
    lowered = src.lower()
    for bad in ("sk-", "api_key=", "apikey=", "token="):
        assert bad not in lowered, f"疑似硬编码密钥：{bad}"
