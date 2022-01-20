# Compiler
Compiler Mx*

Codegen:
先进行IR中Phi指令的消除，通过在中间添加Block来消除
之后进行ASM基本结构的建立，把IR变成ASM,把寄存器变成虚拟寄存器
对于函数的参数使用栈帧进行维护，函数运行过程中的产生的临时寄存器在寄存器分配阶段加入栈帧
寄存器分配暴力分配
ref: https://zhuanlan.zhihu.com/p/111028312
