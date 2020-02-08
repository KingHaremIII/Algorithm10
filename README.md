# 程序员常用10种算法 #

----------


- 二分查找算法（非递归）
- 分治算法
- 动态规划算法
- KMP算法
- 贪心算法
- 普利姆算法
- 克鲁斯卡尔算法
- 迪杰斯特拉算法
- 弗洛伊德算法
- 马踏棋盘算法


----------

## 二分查找算法（非递归） ##
二分查找法只适用于有序数列中查找。

非递归：使用while语句，将左右边界不断更新。

	/*
	initialize the bound and mid point.
	*/
	int left = 0;
	int right = array.length - 1;
	int mid = (int) ((left + right) / 2);;
	/*
	update the bound and mid point.
	*/
	while((target!=array[mid])&&((right-left)>1)) {
	    if (target < array[mid]) {
	        right = mid;
	    } else {
	        left = mid;
	    }
	    mid = (int) ((left + right) / 2);
	}
	/*
	judge whether satisfied or not found.
	*/
	if (target == array[mid]) {
	    index = mid;
	} else {
	    if (target == array[left])
	        index = left;
	    else if (target == array[right])
	        index = right;
	}

## 分治算法 ##
分治算法时很多高效算法的基础，如：


- 二分搜索
- 大整数乘法
- 棋盘覆盖
- 合并排序
- 快速拍寻
- 线性时间选择
- 最接近点对问题
- 循环赛日程表
- 汉诺塔

### 步骤 ###
1. 分解：将原问题分解为若干个规模较小、相互独立，与原问题形式相同的子问题；
2. 解决：若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题；
3. 合并：将各个子问题的解合并为原问题的解。

### 实例：汉诺塔 ###
思路分析

1. 只有一个盘：A->C
2. 有两个盘：A->B，A->C，B->C
3. 有多个盘：
1) 将最下面以上的盘看作一个盘
2) 将合并的盘和最下面的盘按照2. 处理

> Core Code

	public static void Move(int num, char a, char b, char c) {
		if (num == 1) {
		    System.out.println("第1个盘： "+a+"==>"+c);
		} else {
		    // move all plans exclude the largest one in a to b, using c.
		    Move(num-1, a, c, b);
		    System.out.println("第"+num+"个盘： "+a+"==>"+c);
		    // move all plans exclude the largest one in b to c, using a.
		    Move(num-1, b, a, c);
		}
    }

## 动态规划问题 ##
### 核心思想 ###
将大问题划分为小问题进行解决，进而一步步获取最优解的处理算法。
> **与分治区别**：分解出的子问题往往不是相互独立的（即下一个子阶段的求解是建立在上一个阶段的解的基础上，进而进一步求解）。

### 典型问题：背包问题 ###
#### 分类： ####
1. 01背包问题：物品不可重复。
2. 完全背包问题：可以装任意数量同样物品。

#### 填表法 ####


### Core Code ###
> 变量定义

	// create a 2D array with expanded size due to the 0 column and row. 
	int[][] dp = new int[listWeight.size()+1][bagv+1];
	// set maxtmp, x and y to record the current max and its cooridnation. 
	int maxtmp = 0;
	int x;
	int y;
	// create a array to record whether certain thing is put into the bag or not.
    	int[] item;

> 填表寻找最优解

	public void findMax() {
		for (int i = 1; i < listWeight.length; i++) {
		    for (int j = 1; j <= bagV; j++) {
		        // the current thing cannot be put into the bag.
		        if (j < listWeight[i])
		            dp[i][j] = dp[i - 1][j];
		        // check whether it is valuable to be put into the bag.
		        else
		            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - listWeight[i]] + listValue[i]);

		        // check out whether it is a better one.
		        if (maxtmp < dp[i][j]) {
		            maxtmp = dp[i][j];
		            x = i;
		            y = j;
		        }
		    }
		}
    }
	
> 回溯求解最优组合

	dp[i][j] == 1) dp[i - 1][j]    ---->   item[i] is not accounted.
	         == 2) dp[i-1][j-listWeight[i]]+listValue[i]    ---->    item[i] is accounted.
	1）
	item[i] = 0;
	findWhat(i - 1, j);
	2）
	item[i] = 1;
	findWhat(i - 1, j - listWeight[i]);

*注意判断 j-listWeight[i] 是否大于0*




## KMP算法 ##
利用之前判断过的信息，通过一个*next*数组，保存模式串中前后最长公共子序列的长度，每次回溯时，通过*next*数组找到前面匹配过的位置，省去了大量的计算时间。

> 部分搜索词

**前缀**：一个字符串的除最后一个字符的部分或者其子前串。
**后缀**：一个字符串除第一个字符的部分或其子后串。
**前缀后缀公共最长子序列**：前后缀最长公共部分。其长度称为**共有匹配值**。
**建立部分匹配表**

    匹配字符串	A    B    C    A
    部分匹配值   0    0    0    1
    

> 移动公式

移动位数 = 已匹配的字符数 - 对应的部分匹配值。

> Core Code

	// the current position matched.
	if (origin.get(i).equals(target.get(j)))
	...
    // not matched
	else {
	// poll i return to the start (not string start)
	i = i -j;
		// need KMP
		 if (j>0) {
			 i = i + j - partMatchTable[j - 1];
		 } else {    // normal move
			 i = i + 1;
		 }
		 j = 0;
	 }

## 贪心算法 ##
每一步都采取最优，从而希望结果最优。

### 应用场景：集合覆盖问题 ###
利用最少的广播台，让所有地区都可以接受到信号：

    广播台				覆盖地区
    K1				“北京”，“上海”，“天津”
    K2				“广州”，“北京”，“深圳”
    K3				“成都“，”上海“，”杭州“
    K4				”上海“，”天津“
    K5				”杭州“，”大连“
    
> 步骤

1. 遍历所有剩余电台，挑选覆盖未覆盖地区最多的一个；
2. 将电台加入列表，更新未覆盖地区。
3. 重复直到所有地区覆盖。

----------
*special prerequist HEAD*

## *最小生成树（Minimun Cost Spanning Tree, MST）* ##
给定一个带权的无向连通图，如何选取一颗生成树，使得树上所有**边上权**的总和为最小，这叫最小生成树。

*special prerequist END*

----------


## 普利姆算法 ##
> 适合边稠密度高的连通网，时间复杂度`O(n^2)`

用于解决**最小生成树**问题，另一种算法是Kruskal算法，见下一节。

在包含n个顶点的连通图中，找出只有n-1条边包含所有n个顶点的连通子图，也就是**极小连通子图**。

### 应用场景：修路问题 ###
7个村庄之间是否要修路，以保证所有村庄连通，但总修路长度最短。
> 思路：尽可能选择少的路线，并且每条路线最小，保证总里程数最小。

### 步骤 ###
1. 集合V表示未访问顶点，U表示已访问节点，E表示所有路线，D表示已使用路线；G(V, E)表示连通网，T(U, D)表示最小生成树;
2. 从某一顶点开始，每次加入U和V之间的最小边，并且将访问到的新节点从V移到U，记录新使用的路线到D；
3. 重复知道访问到所有节点。

### Core Code ###
> how to extend the MST

	// search for routes of each connected vertexes
	for (int i=0;i<visited.length;i++) {
		// check out whether it is a connected vertex or not. 
        if (visited[i]==1) {
			// record every new route of vertex<i>. 
            for (int j=0;j<visited.length;j++) {
                if (visited[j]==0) {
                    tmp[i][j] = AdjacencyMatrix[i][j];
                }
            }
        }
    }
	
	// int[][] tmp is a matrix recording all candidates of new routes. 

	// VertexOfMin(int[][]) search for the minimun value and return the coordination. 
    int[] xy = VertexOfMin(tmp);
	// set the minimun route to MST. 
    mst[xy[0]][xy[1]] = AdjacencyMatrix[xy[0]][xy[1]];
	// mark the newly connected vertex. 
    visited[xy[1]] = 1;

## 克鲁斯卡尔算法 ##
> 适合边稠密度低的连通网，时间复杂度`O(nlogn)`

### 基本思路 ###
按照权值从小到大的顺序选取n-1条边，并保证不构成回路。
### 具体做法 ###
首先构造一个只含n个顶点的森林，然后依权值从小到大从连通网选择边到森林里来，并使森林不产生回路，直到森林成为树。
> 当新加入的边的两个顶点都指向同一个终点时构成回路。

### Core Code ###
> implements <Interface> Comparable for <class> Edge

	public class Edge implements Comparable<Edge> {
		...

		@Override
		public int compareTo(Edge edge) {
        	return this.weight - edge.weight;
    	}
	}

> search new route to the forest until the forest becomes into a tree

	// MSTCompleted() is a member method of <class> Forest, which is used to judge if the forest becomes into a tree. 
	while(!forest.MSTCompleted()) {
        int i=0;
		// search for useful shoertest route. 
		// the edgeList, list of edges, is sorted. 
        for (;i<edgeList.size();i++) {
			// judge whether recurrent exists or not. 
            if (judge(edgeList.get(i)))
                break;
        }
        forest.addEdge(edgeList.get(i));
        edgeList.remove(i);
        Collections.sort(edgeList);
    }

----------
*special prerequist HEAD*

## *最短路径问题* ##
给定带权有向图G和源点v，求v到G中其他顶点的最短路径。

*special prerequist END*

----------

## 迪杰斯特拉算法 ##
迪杰斯特拉算法是典型的最短路径算法，用于从一个结点到其他结点的最短路径。**主要特点**是，以起始点为中心向外层扩散（广度优先），直到扩展到终点为止。

### 步骤 ###
1. 设置源点v，可见顶点集合V{v1, v2, ..., vn}，源点到V中各点距离Dis{d1, d2, ..., dn}；
2. 选择Dis中最小加入路径，再从Dis移除，同时移除对应vi；
3. 对vi广度优先，扩展可见点集合V=V + {dk, dl, dm, ...}，更新Dis：`dj' = min(dj, di+dij), when vi also connects to vj and the previous node of vj should be updated to vi`。
4. 重复2-3直到找不到可见点。

### Core Code ###
	// cnt is the nubmer of searched node. 
	while (cnt < nodeNum) {
		int i = search(currentPoint, adjacencyMatrix);

	    // newly connected node.
	    if (previousVector[i] == -1) {
		// increment the number of nodes in route.
		cnt++;
		previousVector[i] = currentPoint;
	    }
	    else if (previousVector[i] != -2) {
		if (adjacencyMatrix[previousVector[i]][i] > adjacencyMatrix[currentPoint][i]+adjacencyMatrix[previousVector[i]][currentPoint]) {
		    adjacencyMatrix[previousVector[i]][i] = adjacencyMatrix[currentPoint][i]+adjacencyMatrix[previousVector[i]][currentPoint];
		    previousVector[i] = currentPoint;
		}
	    }
	    else {
		if (adjacencyMatrix[startPoint][i] > adjacencyMatrix[currentPoint][i]+adjacencyMatrix[startPoint][currentPoint]) {
		    adjacencyMatrix[startPoint][i] = adjacencyMatrix[currentPoint][i]+adjacencyMatrix[startPoint][currentPoint];
		    previousVector[i] = currentPoint;
		}
	    }
	    currentPoint = i;
	}

## 弗洛伊德算法 ##
弗洛伊德算法求解**每一个**结点到其他结点的最短路径。

### 步骤 ###
对邻接矩阵进行更新：

    d[i][j] = min(d[i][j], d[i][k]+d[k][j])

### Core Code ###
    for (int k=0;k<nodeNum;k++)
        for (int i = 0;i < nodeNum;i++)
			for (int j = 0; j < nodeNum; j++)
				if (AdjacencyMatrix[i][j] > AdjacencyMatrix[i][k] + AdjacencyMatrix[k][j])
					AdjacencyMatrix[i][j] = AdjacencyMatrix[i][k] + AdjacencyMatrix[k][j];


## 马踏棋盘算法 ##
DFS的一个应用

### 步骤 ###
1. 对当前位置计算所有可走点，如果走不通就回溯；
2. 根据行走策略走一个可走点；
3. 重复1-2直到走完所有点。

### 优化 ###
贪心算法：对所有可走点下一步可走点数目进行非递减排序，走下一步可走点数目最少的。 *====>* `减少回溯`




