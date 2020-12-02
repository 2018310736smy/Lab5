# Lab5
实验五 模拟学生作业处理

# 实验目的：
1.掌握字符串String及其方法的使用

2.掌握文件的读取/写入方法

3.掌握异常处理结构

# 实验内容：
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。

文件A包括两部分内容：

一是学生的基本信息；
二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：

1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”

2.允许提供输入参数，统计古诗中某个字或词出现的次数

3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A

4.考虑操作中可能出现的异常，在程序中设计异常处理程序

输入：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续>

输出：
汉皇重色思倾国，御宇多年求不得。
杨家有女初长成，养在深闺人未识。
天生丽质难自弃，一朝选在君王侧。
回眸一笑百媚生，六宫粉黛无颜色。
春寒赐浴华清池，温泉水滑洗凝脂。
侍儿扶起娇无力，始是新承恩泽时。
云鬓花颜金步摇，芙蓉帐暖度春宵。
春宵苦短日高起，从此君王不早朝。
…………

# 实验要求：
1.设计学生类（可利用之前的）；

2.采用交互式方式实例化某学生；

3.设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。

# 实验代码：

>实现古诗整理的功能

    public static String addFh(String content){
        String result = "";
        int i=1;
        char[]  chars = content.toCharArray();
        for(char hz:chars){
            result = result +hz;
            if(i%7==0&&i%14!=0){
                result = result +"，";
            }
            if(i%14==0){
                result = result +"。\n\r";
            }
            i++;
        }
        return result;
    }
    
>实现提供参数，统计古诗中某个字或词出现的次数

    public static void searchStr(String str,String outputFileContent){     //获取字符串的长度
        int strlen=outputFileContent.length();                             //把需要查找的元素都替换为空
        String afterstr=outputFileContent.replaceAll(str,"");              //获取替换后的字符串的长度
        int afterlen=afterstr.length();                                    //要被查找的元素的个数=原长度-替换后的长度
        int endlen=strlen-afterlen;
        System.out.println("字符"+str+"出现次数为："+endlen);
    }
    
>写入学生信息并将学生信息和古诗保存在文件中

   public static void main(String[] args) {
        Student student = new Student("1","张三","男");
        System.out.println("学生信息："+student.toString());
        File file = new File("D:/java/4/src/inputFileContent.txt");
        String inputFileContent = txt2String(file);
        System.out.println(inputFileContent);
        String outputFileContent =  outputFileContent = student.toString() + "\r\n" +addFh(inputFileContent);
        System.out.println(outputFileContent);

# 运行结果截图：


# 实验感想：
通过本次实验我掌握了Java的文件处理和String的用法。
