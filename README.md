# Compiler
Compiler Mx*

Codegen:

先进行IR中Phi指令的消除，通过在中间添加Block来消除

之后进行ASM基本结构的建立，把IR变成ASM,把寄存器变成虚拟寄存器

对于函数的参数使用栈帧进行维护，函数运行过程中的产生的临时寄存器在寄存器分配阶段加入栈帧

寄存器分配暴力分配

ref: https://zhuanlan.zhihu.com/p/111028312

寄存器图染色：

1：完成ASMBuilder之后，对VirtualRegister进行liveness analysis，构造冲突图。

2：图染色，找到度数少于K的点删除，若剩下的图中度数都大于K，就随便找一个删除（最后有可能溢出，就找一个储存器储存），然后按照删除顺序的倒序访问染色，遇到染不了的就放到Memory里拆成生命周期短的寄存器，再进行一次迭代，反复迭代直到有合法染色方案则停止。
