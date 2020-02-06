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

## 普利姆算法 ##


## 克鲁斯卡尔算法 ##


## 迪杰斯特拉算法 ##


## 弗洛伊德算法 ##


## 马踏棋盘算法 ##





