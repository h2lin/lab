单调栈使用场景：
  - 通常是一维数组，要寻找任一个元素的**右边或者左边第一个比自己大或者小的元素的位置**，此时我们就要想到可以用单调栈了。
  
单调栈用法及注意事项：
  - 单调栈里存放的元素是什么：存放元素的下标i即可，如需使用对应元素，直接T\[i\]获取。
  - 单调栈里元素是递增还是递减：根据实际情况确定。注意：顺序为从栈头到栈底的顺序。
  - 最后做好三种情况判断即可：当前元素比栈顶元素大、等于、小。

