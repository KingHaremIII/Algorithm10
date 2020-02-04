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


## 动态规划算法 ##


## KMP算法 ##


## 贪心算法 ##


## 普利姆算法 ##


## 克鲁斯卡尔算法 ##


## 迪杰斯特拉算法 ##


## 弗洛伊德算法 ##


## 马踏棋盘算法 ##





