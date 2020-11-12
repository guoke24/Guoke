# Guoke系列的主工程

## 说明

目前，完成了组件化的第一步，引入了 GuokeUI 组件，并调用其中的类成功。


### git 引入子模块

- git submodule init 初始化
- git submodule add url 引入组件
- git submodule foreach git pull 拉去组件的最新代码

### 主工程 引入子模块

- setting.gradle

```
include ':guokeui'
project(':guokeui').projectDir = new File("GuokeUI\\guokeui")
```

- app/build.gradle

```
api project(':guokeui')
```