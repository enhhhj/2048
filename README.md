# 2048 JavaFX

一个使用 JavaFX 和 FXML 编写的桌面版 2048 游戏。项目包含多种游戏模式、图形化界面、分数记录和本地用户数据存储。

## 功能概览

- 2048 方块合并玩法
- Simple、Normal、Hell 三种模式入口
- 登录和注册界面
- 最高分与排行榜相关逻辑
- 撤回、结束游戏、特殊消除功能
- FXML 页面和图片资源驱动的桌面界面

## 技术栈

- Java
- JavaFX
- FXML
- Maven
- 本地序列化文件存储：`storage.dat`

## 目录结构

```text
.
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   ├── Main.java
│       │   ├── controller
│       │   └── model
│       └── resource
│           ├── *.fxml
│           └── images
└── README.md
```

说明：当前资源目录使用 `src/main/resource`。`pom.xml` 已显式配置 Maven 读取该目录，因此不需要手动移动资源文件即可运行。

## 环境要求

- JDK 17 或更高版本
- Maven 3.8 或更高版本
- 首次运行或构建时，Maven 会根据 `pom.xml` 从 Maven Central 下载 JavaFX、SQLite JDBC 和 Maven 插件依赖

本机如果没有把 Maven 加入 PATH，也可以直接使用 Maven 的完整路径，例如：

```sh
D:\apache-maven-3.9.6\bin\mvn.cmd -version
```

## 安装与运行

克隆仓库后进入项目目录：

```sh
cd 2048
```

启动 JavaFX 应用：

```sh
mvn javafx:run
```

如果 Maven 没有加入 PATH，可以在 Windows 上使用类似命令：

```sh
D:\apache-maven-3.9.6\bin\mvn.cmd javafx:run
```

应用启动后会打开 JavaFX 窗口，关闭窗口后命令才会结束。


## 已知整理点

- 当前 Java 包名仍是 `src.main.java`，可以运行但不够规范。后续如需进一步整理，建议统一改为类似 `com.example.game2048`。
- FXML 中部分图片路径写法不完全统一，若后续打包出现资源加载问题，可以继续统一为 classpath 资源路径。
- README 中尚未加入游戏截图，上传 GitHub 前建议补一张主界面截图。
