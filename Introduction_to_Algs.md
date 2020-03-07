
## 摘要

&emsp;&emsp;本文是 CLRS 《算法导论》的学习笔记。


[CodeCogs - Latex](https://www.codecogs.com/latex/eqneditor.php?lang=zh-cn)

[算法导论 - B站](https://www.bilibili.com/video/av66468649?p=1)

[Introduction to Algorithms 讲义](https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/)


## CH2_算法基础

这一章以 Insertion Sort 和 Merge Sort 为例，讲解了两种典型的算法设计方法：“**增量式**”方法和“**分治法**”，并分析了两者的性能。

思考题中的 Bubble Sort 也是一种“**增量式**”算法。

思考题2-3 Horner's Law 也是一种“**迭代式**”算法，它也是一种“**降维**”算法：将幂运算降为“乘法和加分”。

$$P(x) = \sum_{k=0}^{n}a_kx^k = a_0 + x(a_1 + x(a_2 + ... + x(a_{n-1} + xa_n)...))$$

它的伪代码反映了迭代公式，从内到外

~~~
y = 0
for i = n downto 0
    y = a[i] + x * y
~~~

思考题2-4 求逆序对（inversion）：

1. 将“求逆序对”问题转化为“统计排序过程中交换的次数”


## CH6_堆排序

[HeapSort - GeeksForGeeks](https://www.geeksforgeeks.org/heap-sort/)

![enter image description here](https://note.youdao.com/yws/api/personal/file/F2E46218159D4ED98C319ECE43AF4126?method=download&shareKey=04ba488212c96f15ae07e9f37c3897f7)
1. 堆序性（大顶堆 vs. 小顶堆）
2. 调整的效率 $\Theta(lgN)$，相对普通数组（参考 INSERTION-SORT）的调整效率 O(N)要高
3. 堆排序本质上是利用“堆序性”（最大/最小元素在顶点）和堆的调整效率




[JAVA教程 - 使用 PriorityQueue](https://www.liaoxuefeng.com/wiki/1252599548343744/1265120632401152)

[PQ - GeeksForGeeks](https://www.geeksforgeeks.org/priority-queue-class-in-java-2/)

PQ 的插入操作类似 INSERTION-SORT，不同的是，它跳跃式（$i=parent(i)$）查找插入位置，相对 INSERTION-SORT 的效率要高，它的效率是 $\Theta(lgN)$


## CH7_快速排序

1. 轴点 pivot
2. 双指针，四个分区
3. LUG 版（Less-Unkonw-Greater）和 LGU 版本更容易理解（Pivot 在第4分区）

![enter image description here](https://note.youdao.com/yws/api/personal/file/BE5460665D88440BB0A8814BD3D22779?method=download&shareKey=04ba488212c96f15ae07e9f37c3897f7)
注意：轴点 pivot 是单独分区
![enter image description here](https://note.youdao.com/yws/api/personal/file/668B04AA31514526831C919A94558F23?method=download&shareKey=04ba488212c96f15ae07e9f37c3897f7)

