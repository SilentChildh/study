# 关于Git的操作指令

| 命令                                     | 作用                                       |
| ---------------------------------------- | ------------------------------------------ |
| **git config --global user.name** 用户名 | 设置用户签名                               |
| git config --global user.email 邮箱      | 设置用户签名                               |
|                                          |                                            |
| **git init**                             | 初始化本地库                               |
|                                          |                                            |
| **git status**                           | 查看本地库状态                             |
|                                          |                                            |
| **git add** <File>                       | 工作区-->暂存区                            |
| **git -commit -m** '日志‘                | 暂存区-->本地库                            |
| **git commit -a -m** '日志'              | 工作区-->本地库                            |
|                                          |                                            |
| **git log**                              | 查看当前分支提交历史                       |
| **git reflog**                           | 查看命令历史                               |
|                                          |                                            |
| **git reset --hard** 哈希值              | 恢复至指定版本                             |
| **git reset --hard** HEAD^^^             | 恢复至上n个版本（n个^）                    |
| **git reset --hard** HEAD~n              | 恢复至上n个版本                            |
|                                          |                                            |
| **git reset --soft**                     | 仅仅在本地库移动 HEAD 指针                 |
| **git reset --mixed**                    | 在本地库移动 HEAD 指针，重置暂存区         |
| **git reset --hard**                     | 在本地库移动 HEAD 指针，重置暂存区和工作区 |
|                                          |                                            |
| **git diff**                             | 比较工作区和暂存区或本地库文件差异         |
| **git diff --cached**                    | 比较暂存区和本地库差异                     |
| **git diff** 哈希值/HEAD^^/HEAD~n        | 比较工作区和本地库中指定版本差异           |
|                                          |                                            |
| **git restore --staged** <file>          | 暂存区-->工作区                            |
| **git restore** <file>                   | 本地库-->工作区                            |
|                                          |                                            |

