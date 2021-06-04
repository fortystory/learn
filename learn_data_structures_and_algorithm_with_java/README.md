
 - 这些代码是[慕课网](https://www.imooc.com/)`玩转数据结构`课程的练习

 结构:

```shell
.
├── .vscode                          # vs code 配置文件夹
│   └── settings.json                # vs code [Project Manager for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency) 插件配置文件
├── README.md                        # 本文档
├── lib                              # 
└── src                              # 源代码
    ├── Main.java                    #
    ├── algorithm                    # 算法文件夹
    ├── data_structures              # 数据结构文件夹
    │   ├── array                    # 数组
    │   │   └── Array.java           # 数组
    │   ├── linkedlist               # 链表
    │   │   └── LinkedList.java      # 链表
    │   ├── queue                    # 队列
    │   │   ├── ArrayQueue.java      # 数组队列 数组实现的队列
    │   │   ├── LinkedListQueue.java # 链表队列 链表实现的队列
    │   │   ├── LoopQueue.java       # 循环队列
    │   │   └── Queue.java           # 队列接口
    │   ├── stack                    # 栈
    │   │   ├── ArrayStack.java      # 数组栈 数组实现的栈
    │   │   ├── LinkedListStack.java # 链表栈 链表实现的栈
    │   │   └── Stack.java           # 栈接口
    │   └── tree                     # 树结构
    │       └── BST.java             # 二分搜索树
    ├── tests                        # 测试代码
    │   └── TestTree.java            # 测试树
    └── tools                        # 工具类
        └── Student.java             # 学生类 用来测试对泛型的支持
```