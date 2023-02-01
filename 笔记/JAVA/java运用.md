# 包的使用

### 注意

不同包之间的类只有public的才能导入使用，且只有类中public的成员才可以访问。

### 可在不同包下创建相同类名

在调用多种相同类名的时候，可以先导包，也可以直接输入完整的包名加类名（输入路径的标准/参考是啥？）。

如：

![](https://raw.githubusercontent.com/SilentChildh/PicGo-img-bed/master/202301121156451.png)



### 命名

1. 通常只使用小写字母
1. 通常每个包的名字只使用1个单词
1. 域名倒置
    通常使用组织的网络域名的逆序,例如:
    如果域名为javagroup.com,包可以命名为:com.javagroup.mypackage
    目前我们能使用的包名前缀只有 "com" 和 "cn"           
1. 包名的后续部分依不同机构各自内部的规范不同而不同.这类命名规范可能以特定
    目录名的组成来区分部门、项目、机器或注册名
    例:com.javagroup.research.powerproject
               项目名        部门名
1. . 父包和子包之间使用"."分隔          





 

![image-20230107221524270](https://raw.githubusercontent.com/SilentChildh/PicGo-img-bed/master/202301121157325.png)

### 常用的自定义包名

1. dao: 数据处理包。
    1. 数据库相关操作 数据访问。
    2. 数据访问层：就是用来访问数据库实现数据的持久化（把内存中的数据永久保存到硬盘中 ）。
2. domain（entity）: 实体类包
3. service: 业务处理包. 
    1. 在此层做相应的业务逻辑处理。
4. util: 工具包. utility应用程序
5. test: 测试包. 
6. web：一般 存放 servlet 和 filter 。
7. impl：
    1. impl是implement的简写，换言之，放置的应该是接口的实现类。
    2. 一般三层开发中，service层和dao层都会有接口及其实现类，为了项目能更好的管理和开发，一般将接口放一个包，实现类放置在这个包的子包中。

### 导包

![image-20230107221635060](https://raw.githubusercontent.com/SilentChildh/PicGo-img-bed/master/202301121156769.png)

java.util.Arrays

- arrays.sort(),排序数组。
- arrays.binarySearch(),二分查找。

java.lang（默认包）

- 基础数据类型的对象.parse基础数据类型(字符串类型引用),返回引用中对应数值的基础数据类型数值，如：

```java
String b = "8";
int s = Integer.parseInt(b);//s == 8;
```

Java.lang.Object(默认)

- 引用名.hashcode(),用于返回对象的哈希值，哈希值与地址挂钩.在集合中如果需要的话也得重写。
- 引用名.getClass(),返回引用对象运行类型，（返回字符串：class 全类名）
- getClass()，返回当前类的运行类型


java.util.Scanner

- 导入Scanner类
- scanner.next();在碰到空格时便会结束接收。可以用nextLine()接收整行数据。

java.lang.System

- System.CurrentTimeMillis(),返回毫秒级的当前时间（long类型）





![image-20230107221025595](https://raw.githubusercontent.com/SilentChildh/PicGo-img-bed/master/202301221000165.png)

### 细节

![image-20230107221556508](https://raw.githubusercontent.com/SilentChildh/PicGo-img-bed/master/202301221000087.png)



# 包装类Wrapper

| 八种包装类型 | 对应的基本数据类型 |
| ------------ | ------------------ |
| Boolean      | boolean            |
| Character    | char               |
| Integer      | int                |
| Byte         | byte               |
| Short        | short              |
| Long         | long               |
| Float        | float              |
| Double       | double             |

## 继承关系

除了Boolean和Character，其他的包装类都继承了Number类，同时所有包装类还继承了Comparable接口和Object类

## 包装类与基本数据类型转换

装箱：基本类型--->包装类型

拆箱：包装类型-->基本类型



jdk5以前，只能手动装箱和手动拆箱

装箱方式：`Integer integer = new Integer(n1);`或者`Integer integer = Integer.valueOf(n1);`

拆箱方式：`int n2 = integer.intValue();`



jdk5以后可以自动装箱和自动拆箱

装箱方式：`Integer integer = n1;`

拆箱方式：`int n2 = integer;`

### 底层

装箱：Integer integer = n1; ------>Integer.valueOf(n1);---->new Integer(n1) 或者 是已经创建好的对象（具体看源码）;

拆箱：int n2 = integer;------------->integer.intValue();



包装类与String类转换

```java
//包装类---->String
Integer integer = 10;
//方式1
String str1 = integer + "";
//方式2
String str2 = integer.toString();
//方式3
String str3 = String.valueOf(integer);


//String----->包装类
String str = "123";
//方式1
Integer integer1 = Interger.parseInt(str);//Interger.parseInt(str)返回的是一个int类型，所以此处还用了自动装箱
//方式2
Integer integer2 = new Integer(str);//构造器
```

## 关于值、地址比较

例子可看这篇[博客](https://blog.csdn.net/tataoto/article/details/123610355?ops_request_misc=&request_id=&biz_id=102&utm_term=%E5%8C%85%E8%A3%85%E7%B1%BB%E5%92%8C%E5%9F%BA%E6%9C%AC%E7%B1%BB%E5%9E%8B%E6%AF%94%E8%BE%83%E5%80%BC&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-1-123610355.142^v71^js_top,201^v4^add_ask&spm=1018.2226.3001.4187)。可搭配源码、断点来了解。

值比较重点是自动拆箱和重写equals方法。

地址比较重点是cache数组。





## Integer常用成员

| 成员                                | 作用                   |
| ----------------------------------- | ---------------------- |
| Integer.MAX_VALUE                   | 返回最大值             |
| Integer.MIN_VALUE                   | 返回最小值             |
|                                     |                        |
| integer.toString()//普通方法        | 对象值转为字符串       |
| Interger.parseInt(String)//静态方法 | 字符串转为对象值       |
|                                     |                        |
| Integer.valueOf(int)//静态方法      | 装箱。基本值转为对象值 |
| integer.intValue()//普通方法        | 拆箱。对象值转为基础值 |
|                                     |                        |

## Character常用成员

| 成员                               | 作用     |
| ---------------------------------- | -------- |
| Character.isDigit('a')//静态       | 判断数字 |
| Character.isLetter('a')//静态      | 判断字母 |
| Character.isUpperCase('a')//静态   | 判断大写 |
| Character.isLowerCase('a')//静态   | 判断小写 |
|                                    |          |
| Character.isWhiteSpace)('a')//静态 | 判断空格 |
| Character.toUpperCase('a')//静态   | 转成大写 |
| Character.toLowerCase('a')//静态   | 转成小写 |
|                                    |          |



## 包装类的其他方法

有需要时查源码



# String类

## 创建String对象

### 直接赋值

String  str = "string";

1. 先检查常量池中是否存在"string"这个数据，如果有，那么str指向该地址。
2. 如果没有，那么在常量池中创建string这个数据，然后str再指向该地址。



### 利用构造器

String str = new String("string");

1. 在堆区创建一个空间，str指向堆区的这个地址。
2. 堆区中其实是保存了一个value属性，该属性指向常量池的地址。
3. 检查常量池是否存在string这个数据，
    1. 如果有，那么value直接指向该地址；
    2. 如果没有，那么在常量池中创建string这个数据，str再指向该地址。



## 特性

final类，不可再继承。

value数组被final修饰，所以由String 创建的字符序列内容不可变动，将一直保留在常量池中。

每次修改实际上是修改value指向的地址。

字符统一用unicode编码，一个字符两字节



创建时注意的事项

指向常量池的引用相加

```java
//假设常量池中没有数据
String str1 = "string1";//此时创建一个string1这个数据
str1 = "string";//此时又创建了一个string2这个数据。
//string1和string2都存放于常量池中，str1的变化是：一开始指向string1的地址，后来指向string2的地址
```

~~~java
//假设常量池中没有数据
String str2 = "string1" + "string2";//此时只创建了一个string1string2这个数据。
//即等价于 String str2 = "string1string2";
//因为会做优化，先组合起来，判断常量池中是否存在这个数据，没有就创建，然后str2指向该地址。
~~~

只要出现一个在堆中以value来指向常量池的引用相加

~~~java
String str1 = "string1";
String str2 = "string2";
String str3 = str1 + "string2";
/*
	底层原理：
	1. StringBuilder str = new StringBuilder();//先创建一个StringBuilder对象
	2. str.append(str1);
	3. str.append("string2");
	4. 最后执行str.toString()返回一个存储在堆区的字符串对象，
		赋值给str3
	*/
~~~

## 常用方法

| 成员                                                     | 作用                                                         |
| -------------------------------------------------------- | ------------------------------------------------------------ |
| string.equals(String)//普通                              | 判断相等，区分大小写                                         |
| string.equalsIgnoreCase(String)//普通                    | 判断相等，忽略大小写                                         |
| string.length)()//普通                                   | 返回字符串长度                                               |
| string.indexOf(String/**int（传入一个字符实参）**)//普通 | 找第一次出现的索引值，不存在返回-1                           |
| string.lastIndexOf(String/int(传入一个字符实参))//普通   | 从右往左找                                                   |
| string.substring(前索引值)//普通                         | 获取包括索引值以后的子串（左闭）                             |
| string.substring(前索引值, 后索引值)//普通               | 获取左闭右开的子串                                           |
| string.charAt(int)//普通                                 | 获取索引位置字符                                             |
|                                                          |                                                              |
| string.toUpperCase()//普通                               | 转换成大写                                                   |
| string.toLowerCase()//普通                               | 转换成小写                                                   |
| string.concat(String)//普通                              | 拼接字符串                                                   |
| string.replace(目标String, 指定String)//普通             | 将目标字符串替换为指定字符串                                 |
| string.split(指定String)//普通                           | 以字符串中的指定字符串为分隔界限，返回String数组             |
| string.compareTo(String)//普通                           | 比较字符串大小。（按字典序排序）1. 字符串长度相同时，返回字符大小差值。2.长度不同时，返回长度差值。 |
| string.toCharArray()//普通                               | 返回char数组                                                 |
| String.format()//静态                                    | 和printf差不多，返回String字符串                             |
|                                                          |                                                              |
| string.intern()//普通                                    | 返回常量池中字符串的地址                                     |



# StringBuffer类

## 特性

是一个final类，不可被继承

value数组不被final修饰，是可变的字符序列，可对字符串中的内容修改。

用value数组指向存放字符数组地址，该字符数组是在堆区的，而不是在常量区。所以可以不断在原来的数组上修改内容（空间不足再扩容），而不像String中每次修改实际上是变换指向的地址。

## 构造器

默认构造的value数组大小是16字节

1. StringBuffer();
2. StringBuffer(int Capacity);//指定数组大小
3. StringBuffer(String str)//指定一个字符串，大小 = str.length() + 16



## String与StringBuffer转换

String------>StringBuffer

~~~java
//方式1
StringBuffer str1 = new StringBuffer(String s);//构造器
//方式2
StringBuffer str2 = str1.append(String s);//StringBuffer的append(String str)方法

~~~

StringBuffer--------->String

~~~java
//方式1
String str1 = new String(StringBuffer s);//构造器
//方式2
StringBuffer str = ...;
String str2 = str.topString();//利用StringBuffer的toString()方法
~~~

## 常见方法

| 成员                                                      | 作用                     |
| --------------------------------------------------------- | ------------------------ |
| stringBuffer.append(String s);//普通                      | 拼接/追加字符串          |
| stringBuffer.delete(int start, int end);//普通            | 左闭右开山删除           |
| stringBuffer.replace(int start, int end, String s);//普通 | 左闭右开替换为指定字符串 |
| stringBuffer.indexOf(String s);//普通                     | 返回索引值，没有就返回-1 |
| stringBuffer.lastIndexOf(String s)//普通                  | 从右往左                 |
| stringBuffer.insert(String s)//普通                       | 索引值位置插入字符串     |
|                                                           |                          |
|                                                           |                          |
|                                                           |                          |

# StringBuilder类

## 特性

几乎和StringBuffer一样。StringBuilder被设计为StringBuffer的简易替换。当单线程时好用。

但是不是线程安全的。

## 常用方法

与StringBuffer一致。

主要的方法是使用append和insert





# 三种String比较

1. StringBuilder与StringBuffer十分类似，均是可变序列，且方法差不多
2. String是不可变序列。



## 使用

1. 字符串序列较少修改，被多个对象引用，使用String

2. 字符串大量修改

    1. 且单线程，使用StringBuilder
    2. 且多线程，使用StringBuffer

    





# Math类

Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。



| 常用成员（都是静态）                          | 作用                                      |
| --------------------------------------------- | ----------------------------------------- |
| Math.abs(int/long/float/double)               | 对应类型绝对值                            |
| Math.pow(double, double)                      | double类型乘方                            |
| Math.ceil(double)                             | double类型向上取整                        |
| Math.floor(double)                            | double类型向下取整                        |
| Math.floor(参数+0.5)                          | 四舍五入                                  |
| Math.round(float/double)                      | int/longd类型，四舍五入                   |
| Math.sqrt(double)                             | double类型，开方                          |
| Math.random()                                 | double类型，0 <= x < 1 之间的一个随机小数 |
| Math.log10(double)                            | double类型，返回对应log值                 |
| Math.min(int, int)//也可对比long/float/double | 返回最小值                                |
| Math.max(int, int)//也可对比long/float/double | 返回最大值                                |
|                                               |                                           |
|                                               |                                           |
|                                               |                                           |
|                                               |                                           |



# Arrays类

管理数组的方法

| 常用方法（静态）                 | 作用                                                     |
| -------------------------------- | -------------------------------------------------------- |
| Arrays.toString(arr)             | 返回数组的字符串形式，具体看源码                         |
| Arrays.sort(arr)                 | 升序排序                                                 |
| Arrays.sort(arr, compare)        | 自定义排序                                               |
| Arrays.binarySearch(arr,  value) | 返回目标的索引值，没找到返回（-(expected position + 1)） |
| Arrays.copyOf(arr, length)       | 返回数组                                                 |
| Arrays.fill(arr, value)          | 进行填充覆盖操作                                         |
| Arrays.equals(arr1, arr2)        | 返回boolean值，判断是否内容相同                          |
| Arrays.asList(可变参数)          | 返回List                                                 |
|                                  |                                                          |
|                                  |                                                          |
|                                  |                                                          |
|                                  |                                                          |
|                                  |                                                          |
|                                  |                                                          |



# System类

| 常用方法                                       | 作用                                                         |
| ---------------------------------------------- | ------------------------------------------------------------ |
| exit(0)                                        | 正常结束程序                                                 |
| System.arraycopy(src, pos, dsrc, dpos, length) | 将src从pos的位置开始的length个值复制给dsrc从dpos位置开始的位置 |
| System.currentTimeMillis()                     | 返回从1970.1.1 00:00:00到现在的毫秒时间（long）              |
| System.gc()                                    | 垃圾回收机制                                                 |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |



# Big类

- BigInteger类用于保存大整型数据
- BigDecimal类用于保存高精度数据

两个类都存在乘除加减的成员方法

| 常用成员                                                | 作用                        |
| ------------------------------------------------------- | --------------------------- |
| BigInteger/BigDecimal(String s)//构造器                 | 创建对象                    |
| bigInteger/bigDecimal.add(Big类)                        | 加                          |
| bigInteger/bigDecimal.subtract(Big类)                   | 减                          |
| bigInteger/bigDecimal.multiply(Big类)                   | 乘                          |
|                                                         |                             |
| bigInteger.divide(BigInteger)                           | 大整数除                    |
| bigDecimal.divide(BigDecimal)                           | 高精度除,无限循环时抛出异常 |
| bigDecimal.divide(BigDecimal, BigDecimal.ROUND_CEILING) | 高精度除，以分子精度为准    |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |

# 日期类

## 第一代

![](https://img-blog.csdnimg.cn/0e08fa504c7f40a8aa907edfe43256ae.png)

~~~java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Date01 {
    public static void main(String[] args) throws ParseException {
        //老韩解读
        //1. 获取当前系统时间
        //2. 这里的Date 类是在java.util包
        //3. 默认输出的日期格式是国外的方式, 因此通常需要对格式进行转换
        Date d1 = new Date(); //获取当前系统时间
        System.out.println("当前日期=" + d1);
        Date d2 = new Date(9234567); //通过指定毫秒数得到时间
        System.out.println("d2=" + d2); //获取某个时间对应的毫秒数

        //老韩解读
        //1. 创建 SimpleDateFormat对象，可以指定相应的格式
        //2. 这里的格式使用的字母是规定好，不能乱写
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(d1); // format:将日期转换成指定格式的字符串
        System.out.println("当前日期=" + format);

        //老韩解读
        //1. 可以把一个格式化的String 转成对应的 Date
        //2. 得到Date 仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
        //3. 在把String -> Date ， 使用的 sdf 格式需要和你给的String的格式一样，否则会抛出转换异常
        String s = "1996年01月01日 10:20:30 星期一";
        Date parse = sdf.parse(s);
        System.out.println("parse=" + sdf.format(parse));
    }
}
~~~

|                                                       |                                                      |
| ----------------------------------------------------- | ---------------------------------------------------- |
| Date()//构造器                                        | 获取当前系统时间                                     |
| Date(9234567)//构造器                                 | 通过指定毫秒数得到时间                               |
|                                                       |                                                      |
| SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E")//构造器 | 创建指定格式d的对象                                  |
| simpleDateFormat.format(Date)                         | 将Date转换成指定格式的String                         |
| simpleDateFormat.parse(s)                             | 格式化的String （即符合格式的String）转成对应的 Date |
|                                                       |                                                      |
|                                                       |                                                      |
|                                                       |                                                      |
|                                                       |                                                      |
|                                                       |                                                      |



## 第二代

~~~java
import java.util.Calendar;
public class Calendar_ {
    public static void main(String[] args) {
        //老韩解读
        //1. Calendar是一个抽象类， 并且构造器是private
        //2. 可以通过 getInstance() 来获取实例
        //3. 提供大量的方法和字段提供给程序员
        //4. Calendar没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)
        //5. 如果我们需要按照 24小时进制来获取时间， Calendar.HOUR ==改成=> Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance(); //创建日历类对象//比较简单，自由
        System.out.println("c=" + c);
        //2.获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        // 这里为什么要 + 1, 因为Calendar 返回月时候，是按照 0 开始编号
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //Calender 没有专门的格式化方法，所以需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) );
    }
}
~~~

|                                     |                |
| ----------------------------------- | -------------- |
| Calendar.getInstance()              | 创建日历类对象 |
|                                     |                |
| calendar.get(Calendar.YEAR)         | 年             |
| calendar.get(Calendar.MONTH) + 1)   | 月             |
| calendar.get(Calendar.DAY_OF_MONTH) | 日             |
|                                     |                |
| calendar.get(Calendar.HOUR)         | 12小时制       |
| calendar.get(Calendar.HOUR_OF_DAY)  | 24小时制       |
| calendar.get(Calendar.MINUTE)       | 分             |
| calendar.get(Calendar.SECOND)       | 秒             |
|                                     |                |
|                                     |                |
|                                     |                |
|                                     |                |



## 第三代

![](https://img-blog.csdnimg.cn/ff36463c50f94200a80d1e7e4b436950.png)

~~~java
package com.hspedu.date_;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
public class LocalDate_ {
    public static void main(String[] args) {
        //第三代日期
        //老韩解读
        //1. 使用now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
        System.out.println(ldt);
        
        //2. 使用DateTimeFormatter 对象来进行格式化
        // 创建 DateTimeFormatter对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println("格式化的日期=" + format);
        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());

        LocalDate now = LocalDate.now(); //可以获取年月日
        LocalTime now2 = LocalTime.now();//获取到时分秒

        //提供 plus 和 minus方法可以对当前时间进行加或者减
        //看看890天后，是什么时候 把 年月日-时分秒
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println("890天后=" + dateTimeFormatter.format(localDateTime));

        //看看在 3456分钟前是什么时候，把 年月日-时分秒输出
        LocalDateTime localDateTime2 = ldt.minusMinutes(3456);
        System.out.println("3456分钟前 日期=" + dateTimeFormatter.format(localDateTime2));
    }
}
~~~

|                                                    |                                       |
| -------------------------------------------------- | ------------------------------------- |
| LocalDateTime.now()                                | 返回对象                              |
| LocalDate.now()                                    | 返回对象                              |
| LocalTime.now()                                    | 返回对象                              |
|                                                    |                                       |
| DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") | 返回指定格式DateTimeFormatter对象     |
|                                                    |                                       |
| dateTimeFormatter.format(LocalDateTime ldt)        | 将LocalDateTime转换成指定格式的String |
|                                                    |                                       |
| local类引用.getYear()                              | 年                                    |
| local类引用.getMonth()                             | 月(letter)                            |
| local类引用.getMonthValue()                        | 月(digit)                             |
| local类引用.getDayOfMonth()                        | 日                                    |
|                                                    |                                       |
| local类引用.getHour()                              | 时                                    |
| local类引用.getMinute()                            | 分                                    |
| local类引用.getSecond()                            | 秒                                    |
|                                                    |                                       |
| local类引用.plusDays(long)                         | 添加日/周/月/年/时/分/秒              |
| local类引用.minusDays(long)                        | 减少日/周/月/年/时/分/秒              |
|                                                    |                                       |
|                                                    |                                       |
|                                                    |                                       |
|                                                    |                                       |

## 时间戳与Date

![](https://img-blog.csdnimg.cn/9184ec46cceb41188fed980c46c5009c.png)

|                          |                         |
| ------------------------ | ----------------------- |
| Instant.now()//静态      | 创建对象                |
|                          |                         |
| Date.from(Instant)//静态 | 返回对象Instant--->Date |
| date.toInstant()//普通   | 返回对象Date--->Instant |



# 集合

## 好处

- 动态保存任意多个对象
- 提供一系列操作对象的方法
- 简洁明了

## Collection接口

## 特点

- 其下的实现子类可以存放多个Object对象
- 有些可存放重复元素，有些不可以
- Collection没有直接的实现子类，都是通过子接口Link和Set实现的

## 常用方法

| 方法(普通)             | 作用                    |
| ---------------------- | ----------------------- |
| 引用.add()             | 添加元素                |
| 引用.remove(Object)    | 删除元素boolean         |
| 引用.contains(Object)  | 判断元素是否存在boolean |
| 引用.size()            | 返回大小int             |
| 引用.isEmpty()         | 判断是否为空boolean     |
| 引用.clear()           | 清空void                |
| 引用.addAll(集合)      | 添加元素                |
| 引用.containsAll(集合) | 判断多个元素存在        |
| 引用.removeAll(集合)   | 删除多个元素boolean     |
|                        |                         |
|                        |                         |
|                        |                         |
|                        |                         |
|                        |                         |



## 遍历方式

### 迭代器

认识：

- 在Iterable接口中。
- Iterator不存放元素，只用于遍历。

常用方法：

~~~java
Iterator it = 集合引用.iterator();//获取对应迭代器，一开始指向-1的索引位置
it.hasNext();//返回boolean，判断是否还有下一个元素
Oject obj = it.next();//迭代器向下移动，并返回下一个元素的对象
~~~

### 遍历方式1

idea快捷键：itit

~~~java
while(it.hasNext()) {
    Object obj = it.next();
    //.......
}
~~~

### 遍历方式2

增强for，底层也是迭代器的运用

idea快捷键：大写i，

~~~java
for(Object obj : 引用) {
	//.....
}
~~~

### 遍历方式3

~~~java
for(int i = 0; i < 引用.size(); i++) {
	//...
}
~~~

# List接口

## 认识

1. List集合中，元素可重复
2. 每个元素具有索引值，可用get(索引)访问。
3. 常用的实现类有：Vector、ArrayList、LinkedList

## 常用方法

| 方法                                | 作用                                                         |
| ----------------------------------- | ------------------------------------------------------------ |
| add(int index, Object ele)          | 在索引位置添加元素boolean                                    |
| addAll(int index, Collection eles)  | 在索引位置添加元素boolean                                    |
| get(Object obj)                     | 获取索引位置的对象                                           |
| indexOf(Object obj)                 | 第一次查找到对象的索引值                                     |
| lastIndexOf(Object obj)             | 从右往左                                                     |
| remove(int index)                   | 删除索引位置的元素，并返回对象                               |
| set(int index, Object obj)          | 替换索引位置的元素                                           |
| subList(int fromIndex, int toIndex) | 获取左闭右开的子集合（对它返回的子集合操作或对原集合操作，两个集合会互相影响，还容易出异常） |
|                                     |                                                              |
|                                     |                                                              |
|                                     |                                                              |
|                                     |                                                              |
|                                     |                                                              |
|                                     |                                                              |



## 三种List实现类

1. 可以加入所有元素，包括null
2. ArrayList是由数组实现的
3. ArrayList与Vector几乎相同，但ArrayList线程不安全，效率高；Vector用于多线程。

## ArrayList

1. 其中维护了一个 `transient Object[] elementData`数组，transient修饰代表该属性不会被序列化
2. 构造器：无参时容量为0，第一次添加时，扩容为10；有参时，可指定容量大小。当容量不足时，扩容为原容量的1.5倍。
3. 不安全，效率高

## Vector

1. 其中维护了一个`protected Objectp[] elementData`数组。
2. 构造器，无参时容量为10；有参时，可指定容量大小。容量不足时，扩容为原容量的2倍。
3. 安全，效率低



## LinkedList

1. 实现了双向链表和双向队列
2. 线程不安全





# Set接口

## 认识

1. 无索引
2. 能存放任何元素，但无重复元素
3. 常用实现类：HashSet、TreeSet

## 常用方法

除去索引操作不提供get、set方法，其他与Link差不多

## HashSet

### 底层

首先，HashSet实际上是调用HashMap

数据结构 = 数组 + 链表 + 红黑树

添加操作add(Object obj)的底层机制：

1. 在添加元素时，
    1. 得到对象哈希值
    2. 解决碰撞
    3. 转换为索引值
2. 判断table表在索引位置是否存在元素
    1. 没有，则直接添加
    2. 有，则调用equals()比较.（equals可重写，即自由决定比较标准）
        1. 相同，则放弃添加
        2. 不相同，则在该结构上继续按equals()对比，直到最后一个都不相同则添加

数据结构的机制：表头即table数组，每个数组的元素都可以存放HashMap.Node结点类。一开始，每个结点后面由链表连接，后面由红黑树连接。

每添加一个元素后，该HashMap对象中的大小size就自增。当size到达临界值threshold时，就开始令table数组扩容，并且临界值也随之变化。当链表结点超过8个，且size超过64时，结构由链表变为红黑树。

第一次进行添加操作时，size大小为0，table数组默认扩容为16，loadFactor加载因子是0.75，threshold默认是12（loadFactor * 16）。数组扩容是原容量的2倍。

当到达临界值12时，便会扩容为16 * 2 = 32，threshold变为（0.75 * 32） = 24。扩容以此类推。

## LinkedHashSet

HashSet的子类，底层调用LinkedHashMap

数据结构 = 数组 + 双向链表

底层机制和HashSet差不多。可以存放LinkedHashMapEntry类结点，该类继承HashMap.Node类。



# Map接口

## 认识

1. Map 中的 key 和  value 可以是任何引用类型的数据，会封装到HashMap$Node 对象中
2. Map 中的 key 不允许重复，原因和HashSet 一样。当有相同的key时 , 就等价于替换.
3. Map 中的 value 可以重复
4. Map 的key 可以为 null, value 也可以为null ，注意 key 为null,只能有一个，value 为null ,可以多个
5. 常用String类作为Map的 key
6. key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到对应的 value
7. 最常用：HashMap、Hashable、Properties

## 储存键值对

一对k-v放在HashMap.Node里；HashMap.Node implements Map.Entry；

在Map中，将键值对HashMap.Node放在Map.Entry接口里，Map.Entry接口又放在HashMap.EntrySet集合里。之所以要这样处理，是因为在Map.Entry接口方便遍历。K getKey(); V getValue();

并且key值还保存在了HashMap.KeySet类中；value值还存在HashMap.Values类中.其实在这两类中，都是指向HashMap.Node

~~~java
Map map = new HashMap();
map.put("no1", "韩顺平");//k-v
map.put("no2", "张无忌");//k-v
map.put(new Car(), new Person());//k-v
//System.out.println(map.getClass()); //HashMap


Set set = map.entrySet();
System.out.println(set.getClass());// HashMap$EntrySet
for (Object obj : set) {
    //System.out.println(obj.getClass()); //HashMap$Node
    //为了从 HashMap$Node 取出k-v
    //先做一个向下转型Object ----> Map.Entry, 而不是HashMap.Node ---> Map.Entry
    Map.Entry entry = (Map.Entry) obj;
    //System.out.println(entry.getClass()); //HashMap$Node
    System.out.println(entry.getKey() + "-" + entry.getValue() );
}


Set set1 = map.keySet();
System.out.println(set1.getClass());//class java.util.HashMap$KeySet
Collection values = map.values();
System.out.println(values.getClass());//class java.util.HashMap$Values
~~~

## Map接口常用方法

| 方法（普通）   |                  |
| -------------- | ---------------- |
| put(K, V)      | 添加键值对       |
| remove(K)      | 删除键值对       |
| get(K)         | 返回value        |
| size()         | 返回大小         |
| isEmpty()      | 判断为空         |
| clear()        | 清空             |
| containsKey(K) | 查找Key，boolean |
|                |                  |
|                |                  |

## Map接口遍历方式



| 涉及方法                 | 作用                               |
| ------------------------ | ---------------------------------- |
| map.keySet()             | 返回key的Set集合                   |
| map.values()             | 返回value的Collection集合          |
| map.entrySet()           | 返回含有键值对的Set集合            |
|                          |                                    |
| 引用集合.iterator()      | 返回对应集合的迭代器               |
| iterator.hasNext()       | 判断是否有下一个元素               |
| iterator.next()          | 迭代器移动到下一个元素，并返回元素 |
|                          |                                    |
| map.get(K)               | 返回对应key的value                 |
| 默认toString()           | 打印信息                           |
|                          |                                    |
| Map.Entry引用.getKey()   | 返回key                            |
| Map.Entry引用.getValue() | 返回value                          |

~~~java
//利用map.keySet()获得key集合，进行遍历。
//方法主要是迭代器方法和Map接口的get(K)
        Set keyset = map.keySet();
        //System.out.println(keyset.getClass());//HashMap$KeySet
        System.out.println("-----第一种方式-------");
        for (Object key : keyset) {
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println("----第二种方式--------");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

//利用map.values()获得value集合，进行遍历
//方法主要是迭代器方法
        Collection values = map.values();
        //System.out.println(keyset.getClass());//HashMap$Values
        System.out.println("---第一种方式----");
        for (Object value : values) {
            System.out.println(value);
        }
        System.out.println("---第二种方式----");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            System.out.println(value);
        }

//利用map.EntrySet()获得Set集合，进行遍历
//方法主要是Map.Entry接口的getKey和getValue方法，再加上迭代器
        Set entrySet = map.entrySet();// EntrySet<Map.Entry<K,V>>
        System.out.println("----第一种方式----");
        for (Object entry : entrySet) {
            //将entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        System.out.println("----第二种方式----");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object entry =  iterator3.next();
            //System.out.println(next.getClass());//HashMap$Node -实现-> Map.Entry (getKey,getValue)
            //向下转型 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}
~~~

HashMap.Node是访问权限的原因，不可以向下转型为Node，因此只能转为Map.Entry.

Map.Entry其实就只是一个接口，一个工具，一个中转站，用于衔接Node、Object以及k-v内的对象，



## HashMap

1. 从线程不安全
2. 使用频率最高的Map接口类
3. 使用方法与上述一致
4. 效率比Hashtable高

## Hashtable

1. 键值不许为null
2. 使用方法与上述一致
3. 线程安全
4. 效率比HashMap低

### 底层

底层存在Hashtable$Entry[] table数组，初始化大小为11，扩容机制为 原数组容量 * 2 + 1

临界值threshold初始值为8，每次扩容更新为loadfactor * 数组容量大小

加载因子loadfactor为0.75

## Properties

1. 继承Hashtable
2. 用法与Hashtable类似
3. 可用于xxx.properties文件（配置文件）中，将文件数据加载到Properties对象中进行操作。

注意一个方法：`properties.getProperty(Key)`，如果value值得类型不是Stirng，则返回null



# 集合的选择

![](https://img-blog.csdnimg.cn/839b8e61efc344cbb581d9a043d8f839.png)



# TreeSet与TreeMap

## TreeSet

1. 使用TreeSet 提供的一个构造器，可以传入一个比较器(匿名内部类)指定排序规则
    1. 构造器把传入的比较器对象，赋给了 TreeSet的底层的 TreeMap的属性this.comparator
    2. 如果比较器相等，即返回0。那么这个Key就没有加入，即不会替换key的值





# Collections工具



| 常用方法（静态）                                    | 作用                          |
| --------------------------------------------------- | ----------------------------- |
| sort(List)//可加比较器                              | 排序                          |
| reverse(List)                                       | 翻转                          |
| shuffle(List)                                       | 随机排序                      |
| swap(List, int ,int)                                | 交换                          |
| max(Collection)//可加比较器                         | 集合中最大值                  |
| min(Collection)//可加比较器                         | 集合中最小值                  |
| frequency(Collection, Object)                       | 集合中对象出现次数            |
| copy(List dest, List src)                           | 复制，要保证dest容量>=src容量 |
| replaceAll(List list, Object oldVal, Object newVal) | 替换List集合中的值            |
|                                                     |                               |
|                                                     |                               |
|                                                     |                               |
|                                                     |                               |
|                                                     |                               |

# 泛型

## 认识

1.  编译时检查了元素的类型，提高了安全性
2.  泛型又称参数化类型
3.  类声明、成员声明时，只需要泛化类型。
4.  实例化时指定具体的类型。
5.  使代码简洁、健壮，在编译时无异常，那么运行时就不会出现ClassCastEception

## 作用

通过标识符，表示属性、方法的返回值、参数的类型。

## 理解重点

是在编译阶段进行安全检查。即只在编译阶段起作用的一种技术。

只要编译阶段通过了，那么运行阶段就不会出错。

由于只是只对编译阶段的技术，所以看似编译时规定了不同的类型，但实际上运行时属于同一（泛型）类型。

## 泛型类、接口

### 语法

`interface 接口 <E, R> {}` 或`class 类名 <E, R> {}`

### 使用位置

**一般都用在类声明。**

进而通过类声明时提供的泛型来运用在类成员内部。

### 类型确定时机

在实例化时，决定泛型类型。



## 泛型方法

### 语法

`public <E, R> void/E methon (E e, R r) {}`。

### 使用位置

**一般泛型都用在形参上。**

有时候还可以在返回类型上。

### 类型确定时机

在调用方法时，由传入的实参决定泛型类型。





## 注意

1. 静态属性不可以使用泛型
2. 静态方法可以使用泛型方法
3. 使用泛型的数组，不可以在声明时指定大小



1. 在实例化时，即new时，右边<>内默认以以左边<>为准

    即`List<String> list = new ArrayList<>();`

2. 不确定泛型，即不填<>时，默认为Object。

    如：`List list = new ArrayList();`，此时默认泛型类型是Object

3. <>内可以是任意大写字母。<>内传入的一定是引用类型。



- 使用自定义泛型时，继承接口或者实现接口时，都要确定泛型类型（沿用泛型字母或者指定类型）。否则默认是Object，且会警告：Raw use of parameterized class



## 关于上下界

首先介绍通配符`?`

- <?>: 支持任意泛型类型。
- 可以理解为是对已经是**泛型的类/接口**做的一个修饰功能。
- 用法：将泛型字符替换为`?`即可。将来就可以传入任意类型的引用类型。

1. <>创建实例时，左右<>内本身是不存在继承关系的，如：不能传入左父右子。

2. 可以通过通配符方式达到“继承效果”。

    在声明泛型类、接口、泛型方法时，运用下列**限定上下界**的用法：

    1. <? extends A>:向下兼容
    2. <? super A>:向上兼容

    此时在创建实例，或者调用方法时，<>内就可以存在继承关系



运用到通配符（包括上下界）的实际位置一般在各种声明位置（包括方法形参）上。而不在实际使用位置上。



## 关于泛型的原则

1. 能用泛型方法尽量使用
2. 静态方法想使用泛型，就必须是泛型方法。

# IO操作

## 简单的文件操作

### 创建文件对象

~~~java
new File(String pathname);//根据路径
new File(File parent, String child);//根据父目录文件 + 子路径
new FIle(String parent, String child);//根据父目录 + 子路径
~~~

### 创建新文件

创建时，需抛出异常

~~~java
file.createNewFile();//根据文件对象创建新文件
~~~

### 获取文件信息

~~~java
file.getName();//获取文件名称
file.getAbsolutePath();//获取文件的绝对路径
file.getParent();//获取文件的父级目录
file.length();//获取文件的字节大小
file.exists();//文件是否存在
file.isFile();//是否是文件
file.isDirectory();//是否是目录
~~~



### 创建目录和文件删除

~~~java
mkdir();//创建一级目录
mkdirs();//创建多级目录
delete();//删除 空目录 或 文件
~~~

## IO流

## 分类

按数据单位：字节流的二进制文件和字符流的文本文件

按数据流的流向：输入流和输出流

流的角色：节点流和处理流/包装流

![](https://img-blog.csdnimg.cn/01399f5e466147a69952416b3e7cf020.png)

### InputStream

是所有字节输入流的超类

其下的常用子类为：文件输入流`FileInputStream`、缓冲字节输入流`BufferedInputStream`(`FiltereInputStream`的子类)、对象字节流`ObjectInputStream`



## 节点流与处理流

节点流：可以从特定的数据源读写数据

处理流：也称包装流。是连接在已存在的流之上的流，为程序提供更强大的读写功能。

![](https://img-blog.csdnimg.cn/9a6c1b8cc592494c8f02ba47ac0d9041.png)

## 访问文件的节点流

### FileInputStream

~~~java
new FileInputStream(String/File);//创建对象

int readData = 0;
while((readData = fileInputStream.read()) != -1) {//循环读取，直到文件末尾，然后返回-1
    //读取的数据在readData中
}
//利用read(byte[] b)，提高读取效率
int readLen = 0;
byte[] buf = new buf[8];//指定一次读取的字符数量
while((readLen = fileInputStream.read(buf) != -1) {//返回读取到的字符数量
    //读取的数据在buf数组中
    //System.out.print(new String(buf, 0, readLen));//打印读入数据
    
}

fileInputStream.close();//关闭文件资源

~~~



### FileOututStrream

~~~java
new FileOutputStream(Strint/File, boolean);//创建对象，以及是否追加（true），覆盖（false）

fileOutputStream,write(int);//写入一个字符
fileOutputStream.write(byte[] b, int, int);//写入字符串，指定写入起始偏移量和长度
//可通过String中的getByte()成员方法将字符串转换为byte数组。
fileOutoutStram.write(byte[] b/string.getByte());//写入字符串

close();
~~~

### FileIn与FileOut的搭配

~~~java
package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Stream {
    public static void main(String[] args) {
        String srcPath = "e:/Git";
        String destPath = "e:/Git/Github";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);

            byte[] buf = new byte[1024];
            int readLen = 0;
            while((readLen = fileInputStream.read(buf)) != -1) {
                //在循环写入时，一定是三个参数
                //因为循环读取时，byte数组并不是清空再接收，而是数据覆盖
                //所以在最后可能会出现数据量小于数组容量的情况，那么实际上接收的是数组的前半段，而后半段是上一轮接收过的数据
                fileOutputStream.write(buf, 0, readLen);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(fileInputStream != null) fileInputStream.close();
                if(fileOutputStream != null) fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
~~~

### FileReader

~~~java
new FileReader(String/File);//创建对象

read();//读取字符
read(char[]);//读取字符串，返回字符长度
//相关API
new String(char[]);
new String(char[], int ,int);//指定起始偏移量和长度

//循环读取的模板与InputStream一致
//单个字符则用int readData接收
//字符串则用 char[] buf数组接收。System.out.print(new String(buf, 0, readLen));

close();
~~~

### FileWriter

~~~java
new FileWriter(String/File, boolean);//创建对象，是否追加

write(int);//写入单个字符
write(char[]);
write(char[], int, int);
write(String);
write(String, int ,int);
//相关API
string.toCharArray();//字符串转换为字符数组

close();
~~~





## 缓冲流

### 特点

处理流连接在已存在的流之上的流。

处理流可以消除不同流之间的差异，同时也提供了更方便的方法完成读写功能

处理流使用了修饰器设计模式，不会数据源相连。

### 性能

1. 增加缓冲
2. 提供一次性输入输出大数据

### BufferedReader

内含Read属性，用于接收其他流。

~~~java
new BufferedReader(new FileInputStream(String/File));

String line;//按行接收数据,效率高

while((line = bufferedReader.readLine()) != null) {//按行读取，不包括换行符，末尾时返回null
    System.out.println(line);
}

bufferedReader.close();//关闭处理流，自动关闭被包装的流
~~~

### BufferedWriter

~~~java
new BufferedWriter(new FileOutputStream(String/File, boolean));

write(String);
newLine();//根据操作系统添加换行符

close();
~~~

### Buffered读写示例

~~~java
import java.io.*;
public class BufferedCopy_ {
    public static void main(String[] args) {
        String srcFilePath = "e:\\a.java";
        String destFilePath = "e:\\a2.java";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            //说明: readLine 读取一行内容，但是没有换行
            while ((line = br.readLine()) != null) {
                //每读取一行，就写入
                bw.write(line);
                //插入一个换行
                bw.newLine();
            }
            System.out.println("拷贝完毕...");
        } 
        catch (IOException e) {
            
        } 
        finally {
            //关闭流
            try {
                if(br != null) br.close();
                if(bw != null) bw.close();
            } 
            catch (IOException e) {
                
            }
        }
    }
}
~~~

### BufferedInputStream与BufferedOutputStream

内含缓冲数组

~~~java
package com;
import java.io.*;
public class BufferedCopy02 {
    public static void main(String[] args) {
        String srcFilePath = "e:\\a.java";
        String destFilePath = "e:\\a3.java";

        //创建BufferedOutputStream对象BufferedInputStream对象
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //因为 FileInputStream  是 InputStream 子类
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            //循环的读取文件，并写入到 destFilePath
            byte[] buff = new byte[1024];
            int readLen = 0;
            //当返回 -1 时，就表示文件读取完毕
            while ((readLen = bis.read(buff)) != -1) {
                bos.write(buff, 0, readLen);
            }
            System.out.println("文件拷贝完毕~~~");
        } 
        catch (IOException e) {
        } 
        finally {
            //关闭流 , 关闭外层的处理流即可，底层会去关闭节点流
            try {
                if(bis != null) bis.close();
                if(bos != null) bos.close();
            catch (IOException e) {
            }
        }
    }
}
~~~

### 总结

二进制文件的读写操作继承于父类，主要的提升是缓冲的存在。

文本文件的读写操作主要的提升是提供了额外功能：按行读取和添加换行符的操作。

## 对象流

关于序列化详解的[文章](https://www.cnblogs.com/9dragon/p/10901448.html)

### 序列化与反序列化

序列化就是保存数据时，保存数据的值和类型

反序列化就是恢复数据时，恢复数据的值和类型



### 序列化机制

通过实现`Serializable`或`Externalizable`接口来成为可序列化。

一般用`Serializable`接口实现，因为这个接口中不需要重写方法，而另一个需要重写方法。

### ObjectOutputStream

提供序列化功能

~~~java
new ObjectOutputStream(new FileOutputStream(String/File, boolean));

writeInt(100);
writeBoolean(true);
writeDouble(3.14);
writeChar('H');
writeUTF("hello");
writeObject(自定义对象);

close();
~~~





### ObjectInputStream

提供反序列化功能

~~~java
new ObjectInputStream(new FileInputStream(String/File));

readInt();
readBoolean();
readDouble();
readChar();
readUTF();
readObject();

close();
~~~

### 序列化与反序列化方法的执行顺序

针对Serializable

1. `writeResolve()`，任意目标对象替换序列化对象

2. `writeObject()`，序列化对象

3. `readObejct()`，反序列化对象

4. `readReplace()`，任意目标对象替换反序列化对象

    1. 如在单例模式中，就可以用到该方法。防止反序列化对单例的破坏。

    

    



### 注意事项

使用：

1. 读写的顺序要一致
2. 序列化和反序列化对象需要实现`Serializable`接口
3. 序列化对象中，默认将所有属性进行序列化。除了`static`和`transient`修饰的成员
    1. **序列化保存的是对象的状态**，静态变量属于类的状态，因此 序列化并不保存静态变量。

4. 序列化对象中，其中用于接收其他类对象的属性，所接收的类也得实现`Serializable`
5. 序列化也具备继承性。父类是可序列化，那么子类也可序列化

细节：

1. 反序列化得到的对象不是通过构造器得到的，而是由jvm生成
2. 已自定义序列化版本号，在序列化后，修改源码
    1. 源码新增成员，那么反序列化时，该成员赋上默认值
    2. 源码减少成员，那么反序列化时，忽略该成员



1. 序列化版本号JVM会帮我们默认生成，我们也可以自己指定或者使用IDE进行自动生成。
2. 如果我们让JVM为我们默认生成，如果我们对序列化对应的模板类进行更改，序列号也会随着发生改变。
3. “改变”包括方法签名、修饰符、字段、类名、继承关系等结构上的变化。
    1. 如果内容（方法的内容、属性的默认值等）、顺序（声明的顺序）、空格的修改并不会新生成序列号（已经经过实验）。
    2. 只有当影响到class文件本身结构发生的变化的修改，才会使得生成一个新的版本号

### java序列化算法

1. 所有保存到磁盘的对象都有一个<u>序列化版本号</u>
2. 当程序试图序列化一个对象时，会先检查此对象是否已经序列化过，只有此对象从未（在此虚拟机）被序列化过，才会将此对象序列化为字节序列输出。
3. 如果此对象已经序列化过，则直接输出编号即可。

- 如果序列化一个可变对象（对象内的内容可更改）后，更改了对象内容，再次序列化，并不会再次将此对象转换为字节序列，而只是保存序列化编号。

![](https://img2018.cnblogs.com/blog/1603499/201905/1603499-20190521180352659-740977206.jpg)



### 建议

- 程序创建的每个JavaBean类都实现Serializeable接口。
- 序列化类中建议建议添加序列化版本号`private static final long serialVersionUID`，提高版本兼容性
    - 自定义了序列号版本号后，就不会出现序列化算法导致的问题——成员的值修改后反序列化无效、成员类型修改后反序列化失败。因为自定义后，class文件中版本号一定是一致的。

### java序列化原理

序列化只保存对象的类型信息和属性类型和属性值，三部分数据。

1. Java序列化的顺序首先按照从子类到父类的顺序，将类型的元信息、属性类型的元信息进行序列化。(针对数据类型)
2. 然后按照从父类到子类的顺序，将成员的字面量进行序列化。如果遇到引用类型，则会进入新的层次的递归。直到所有字面量数据被保存起来。(针对数据的值)



1. 序列化流中本质上是没有保存任何引用数据的，都是字面量数据。
2. 因此当进行反序列化化时，其实本质上是为空对象进行字面量赋值，如果涉及引用变量则递归进行字面量赋值。



### java反序列化原理？？？？？？？？？？？？？？？？？？？？？？？？？？？？

反序列化时，必须有序列化对象的class文件，因为需要用到反射。

反序列化过程：

1. 读出序列化的数据到ObjectStreamClass类型的desc对象中
2. 通过反射，获取对应的对象
3. 再调用native方法，将desc赋值给对应的对象。
4. 最后返回实例

### 对于Serializable的继承性

- 由于Serializable对象完全以它存储的二进制位为基础来构造，并不会调用任何构造函数，因此Serializable类无需默认构造函数。
- 一种情况除外：父类没有实现serializable但是子类实现了，如果此时父类如果没有定义默认构造函数，就会报错。因为反序列化时，往往是从超类对象开始构造，
    1. 此时字节流中是没有存放任何父类信息的。因为序列化时，未保存父类信息。
    2. 但是反序列化创建对象时，必须拿到父类继承下来的属性。因此反序列化时会调用父类的默认构造方法拿到这部分。
    3. 这时就会反射调用空参构造器先拿到一个空对象，然后再慢慢地为填充成员注入值（可以类比Spring Bean的创建过程）

## 标准输入输出流

~~~java

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
public class InputAndOutput {
    public static void main(String[] args) {
        //System 类 的 public final static InputStream in = null;
        // System.in 编译类型   InputStream
        // System.in 运行类型   BufferedInputStream
        // 表示的是标准输入 键盘
        System.out.println(System.in.getClass());

        //老韩解读
        //1. public final static PrintStream out = null;
        //2. 编译类型 PrintStream
        //3. 运行类型 PrintStream
        //4. 表示标准输出 显示器
        System.out.println(System.out.getClass());
        System.out.println("hello");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容");
        String next = scanner.next();
        System.out.println("next=" + next);
        
        
        
        //我们可以去修改打印流输出的位置/设备
        System.setOut(new PrintStream("e:\\f1.txt"));//此时输出到制定文件中
        System.out.println("hello");
    }
}
~~~

## 打印流

只有输出流，

~~~java
package com.hspedu.printstream;
import java.io.IOException;
import java.io.PrintStream;
/**
 * 演示PrintStream （字节打印流/输出流）
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //在默认情况下，PrintStream 输出数据的位置是 标准输出，即显示器
        out.print("john, hello");
        //因为print底层使用的是write(), 所以我们可以直接调用write进行打印/输出，本质是一样的
        out.write("韩顺平,你好".getBytes());
        out.close();
    }
}
~~~

~~~java
package com.hspedu.transformation;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 演示 PrintWriter 使用方式
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\f2.txt"));
        printWriter.print("hello");
        printWriter.close();//flush + 关闭流, 才会将数据写入到文件..
    }
}
~~~



## 转换流

~~~java
BufferedReader bufRead = new InputStreamReader(new FileInputStreasm(String/File), "utf-8");
String s = bufRead.readLine();
bufRead,close();

BUfferedWriter bufWrite = new OutputStreamWriter(new FileOutputStream(String/File),"utf-8");
bufWrite.write("hello");
bufWrtite.close();
~~~

## Properties

是专门用于读写配置文件的集合类

配置文件格式：`键=值`。其中键值对之间没有空格，值不需要引号，默认类型String。

~~~java
new Properties();//创建对象

properties.load(Reader/InputStream);//加载配置文件到properties对象

list(PrintStream/PrintWriter);//指定显示数据的设备位置

getProperty(key);
seteProperty(key, value);//key存在时，替换value

store(Writer/OutputStream, String);//保存对象中的数据到配置文件中，其中String作为标注放在配置文件开头

~~~

~~~java
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来读取mysql.properties 文件
        //1. 创建Properties 对象
        Properties properties = new Properties();
        //2. 加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3. 把k-v显示控制台
        properties.list(System.out);
        //4. 根据key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码是=" + pwd);
    }
}
~~~

